package com.example.lab6.Aspects;


import com.example.lab6.Exception.AopIsAwesomeHeaderException;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class PostAspect {
    @Around("e@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String header = request.getHeader("AOP-IS-AWESOME");
        if (header == null) {
            throw new AopIsAwesomeHeaderException("Header is null or missing.");
        }
        var result = proceedingJoinPoint.proceed();
        return result;
    }
}
