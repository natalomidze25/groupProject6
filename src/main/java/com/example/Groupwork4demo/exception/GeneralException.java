package com.example.Groupwork4demo.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class GeneralException extends RuntimeException{
    private String exceptionKey;
    private HttpStatus httpStatus;

    public GeneralException(String exceptionKey, HttpStatus httpStatus) {
        this.exceptionKey = exceptionKey;
        this.httpStatus = httpStatus;
    }

}
