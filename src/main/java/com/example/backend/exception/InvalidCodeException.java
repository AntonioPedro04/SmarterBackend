package com.example.backend.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidCodeException extends RuntimeException{

    public InvalidCodeException(String message){
        super(message);
    }
}
