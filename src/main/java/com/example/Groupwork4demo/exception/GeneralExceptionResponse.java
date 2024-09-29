package com.example.Groupwork4demo.exception;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class GeneralExceptionResponse {

    private String message;
    private HttpStatus httpStatus;
    private String exceptionPath;
    private LocalDateTime occurredOn;

    public GeneralExceptionResponse(String message, HttpStatus httpStatus, String exceptionPath) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.exceptionPath = exceptionPath;
        this.occurredOn = LocalDateTime.now();
    }
}
