package com.example.backend.exception;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserAlreadyExistsException extends RuntimeException{


    private static final String msg = "User already exists in the database";

    public UserAlreadyExistsException()
    {
        super(msg);
    }
}
