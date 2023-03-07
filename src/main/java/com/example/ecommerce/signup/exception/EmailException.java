package com.example.ecommerce.signup.exception;

public class EmailException extends Exception{
    private String exception;
    public EmailException(String exception){
        super(exception);
        this.exception = exception;
    }
    public EmailException(){}
}
