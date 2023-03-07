package com.example.ecommerce.signup.exception;

public class UserException extends Exception{
    private static final Long serialVersionUID = 1l;
    private String errorMessage;
    public UserException() {
    }

    public UserException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
