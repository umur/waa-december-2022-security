package com.w1d3.springdata.aspect;

import com.w1d3.springdata.exception.AopIsAwesomeHeaderException;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
@RequiredArgsConstructor
public class AopIsAwesomeAspect {
    private final HttpServletRequest request;
    @Pointcut("within(com.w1d3.springdata.service..*)")
    public void AopIsAwesomePointOut(){
    }

    @Before("AopIsAwesomePointOut()")
    public void IsAopAwesome(JoinPoint joinPoint) throws AopIsAwesomeHeaderException{
        System.out.println(request.getHeader("s"));
        if(request.getMethod().equalsIgnoreCase("POST")){
            if(request.getHeader("AOP-IS-AWESOME")==null){
                throw new AopIsAwesomeHeaderException("AOP-IS-AWESOME header not found");
            }
        }

    }
}
