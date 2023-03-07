package com.example.ecommerce.signup.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;


//RestExceptionHandler is the controller for Exception class
@ControllerAdvice
public class RestExceptionHandler {

    //NotFoundException
    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorResponse> exceptionUserHandler(Exception e){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(e.getMessage());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
    }

    //Bad request for IdNotFoundException
    @ExceptionHandler(IdException.class)
    public ResponseEntity<ErrorResponse> exceptionHandlerIdNotPresent(Exception e){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(e.getMessage());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    //Bad request for general exceptions
    @ExceptionHandler(UnknownError.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception e){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(e.getMessage());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    //No content or no user found exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> noUserFound(Exception e){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(HttpStatus.NO_CONTENT.value());
        errorResponse.setMessage(e.getMessage());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NO_CONTENT);
    }

    //Email exception
    @ExceptionHandler(EmailException.class)
    public ResponseEntity<ErrorResponse> emailExceptionHandler(Exception e){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(e.getMessage());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
