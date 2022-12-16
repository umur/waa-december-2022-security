package com.example.lab3springdata;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalErrorHandler {
    @ExceptionHandler(AopIsAwesomeHeaderException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String headerNotFound(Exception exception){
     String errMsg = exception.getMessage();
        if(errMsg == null || errMsg.isBlank())
            errMsg = exception.getCause().getMessage();
    return errMsg;
    }

}
