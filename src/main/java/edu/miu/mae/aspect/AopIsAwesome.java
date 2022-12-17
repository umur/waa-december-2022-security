package edu.miu.mae.aspect;

import edu.miu.mae.exceptions.AopIsAwesomeHeaderException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class AopIsAwesome {
    @Autowired
    HttpServletRequest request;

    @Pointcut("within(edu.miu.mae.service..*)")
    public void validateHeader() {}

    @Before("validateHeader()")
    public void validateAopIsAwesome(JoinPoint joinPoint) throws AopIsAwesomeHeaderException {
        String method = request.getMethod();
        if("POST".equals(method) && request.getHeader("AOP-IS-AWESOME")==null){
           throw  new AopIsAwesomeHeaderException("there is no AOP-IS-AWESOME header");
        }
    }
}
