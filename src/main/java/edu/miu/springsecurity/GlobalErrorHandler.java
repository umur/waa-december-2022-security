package edu.miu.springsecurity;

import edu.miu.springsecurity.exception.AopIsAweSomeHeaderException;
import edu.miu.springsecurity.exception.ConcurrentRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler({AopIsAweSomeHeaderException.class, ConcurrentRequestException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    String HeaderNotFoundHandler(Exception exception){
        String message = exception.getMessage();
        if(message == null || message.isBlank())
            message = exception.getCause().getMessage();

        return message;
    }
}
