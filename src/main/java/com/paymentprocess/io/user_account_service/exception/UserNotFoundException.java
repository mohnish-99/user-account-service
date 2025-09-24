package com.paymentprocess.io.user_account_service.exception;

public class UserNotFoundException extends RuntimeException{
    
    public UserNotFoundException(Long id){
        super("User not found with Id : "+id);
    }

        public UserNotFoundException(String message){
        super(message);
    }
}
