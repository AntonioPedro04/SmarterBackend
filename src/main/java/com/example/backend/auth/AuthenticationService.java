package com.example.backend.auth;

import com.example.backend.config.auth.JwtService;
import com.example.backend.exception.InvalidCodeException;
import com.example.backend.exception.UserAlreadyExistsException;
import com.example.backend.model.entity.Code;
import com.example.backend.model.entity.Role;
import com.example.backend.model.entity.User;
import com.example.backend.repository.CodeRepository;
import com.example.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;

    private final CodeRepository codeRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .username(request.getUsername())
                .country(request.getCountry())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException();
        }

        if(codeRepository.findByValue(request.getCode()).isEmpty()){
            throw new InvalidCodeException("Invalid Code");
        }

        Code code = codeRepository.findByValue(request.getCode()).get();

        if(Objects.equals(code.getCurQuantity(), code.getMaxQuantity())){
            throw new InvalidCodeException("Expired Code");
        }

        Integer curQtd = code.getCurQuantity();

        code.setCurQuantity(++curQtd);

        user.setCode(code);

        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        var user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
