package com.example.Groupwork4demo.exception;

import com.example.Groupwork4demo.config.ControllerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @Autowired
    MessageService messageService;


    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<GeneralExceptionResponse> handleException(Exception e) {
        GeneralExceptionResponse errorResponse = new GeneralExceptionResponse(e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR, ControllerInterceptor.getCurrentController());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @org.springframework.web.bind.annotation.ExceptionHandler(value = GeneralException.class)
    public ResponseEntity<GeneralExceptionResponse> generalException(GeneralException e) {
        return messageService.createErrorMessage(e.getExceptionKey(), e.getHttpStatus(), ControllerInterceptor.getCurrentController());
    }

}
