package com.example.Groupwork4demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessageService {
    public ResponseEntity<GeneralExceptionResponse> createErrorMessage(String errorKey, HttpStatus httpStatus,String path) {
        GeneralExceptionResponse errorMessageDTO = new GeneralExceptionResponse();
        errorMessageDTO.setMessage(errorKey);
        errorMessageDTO.setHttpStatus(httpStatus);
        errorMessageDTO.setExceptionPath(path);
        errorMessageDTO.setOccurredOn(LocalDateTime.now());
        return new ResponseEntity<GeneralExceptionResponse>(errorMessageDTO, httpStatus);
    }


}
