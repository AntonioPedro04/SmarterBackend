package com.example.backend.controller;

import com.example.backend.model.dto.User.UserDTO;
import com.example.backend.model.entity.User;
import com.example.backend.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final ModelMapper modelMapper;

    @GetMapping("")
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/logged")
    public UserDTO getLoggedUser(HttpServletRequest request){
        String username = (String) request.getAttribute("username");
        User user = findUserByUsername(username);
        UserDTO userDTO = new UserDTO();
        modelMapper.map(user, userDTO);
        return userDTO; 
    }

    @GetMapping("/{username}")
    public User findUserByUsername(@PathVariable String username){
        return userService.findUserByUsername(username);
    }

}
