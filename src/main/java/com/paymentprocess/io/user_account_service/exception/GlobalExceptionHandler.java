package com.paymentprocess.io.user_account_service.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.paymentprocess.io.user_account_service.model.ErrorObject;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorObject> handleUserNotFoundException(UserNotFoundException ex){

        ErrorObject error = ErrorObject.builder()
                            .timestamp(LocalDateTime.now())
                            .error("User not found")
                            .message(ex.getMessage())
                            .build();

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);

    }
}
