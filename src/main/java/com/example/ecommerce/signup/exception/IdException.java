package com.example.ecommerce.signup.exception;

public class IdException extends Exception{
    private String errorMessage;

    public IdException() {
    }

    public IdException(String errorMessage) {
//      super(message);
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
