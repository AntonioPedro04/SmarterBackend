package com.example.backend.exception;

import com.example.backend.auth.AuthenticationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = { UserAlreadyExistsException.class })
    public ResponseEntity<Object> handleInvalidUserException(UserAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Error.builder().message(e.getMessage()).build());
    }

    @ExceptionHandler(value = { InvalidCodeException.class })
    public ResponseEntity<Object> handleInvalidCodeException(InvalidCodeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Error.builder().message(e.getMessage()).build());
    }

}