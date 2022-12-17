package miu.edu.lab5;

import miu.edu.lab5.exception.AopIsAwesomeHeaderException;
import miu.edu.lab5.exception.ConcurrentRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler({AopIsAwesomeHeaderException.class, ConcurrentRequestException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    String HeaderNotFoundHandler(Exception exception){
        String message = exception.getMessage();
        if(message == null || message.isBlank())
            message = exception.getCause().getMessage();

        return message;
    }
}