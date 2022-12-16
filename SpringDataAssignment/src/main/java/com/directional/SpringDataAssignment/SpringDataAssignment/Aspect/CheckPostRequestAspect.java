package com.directional.SpringDataAssignment.SpringDataAssignment.Aspect;

import com.directional.SpringDataAssignment.SpringDataAssignment.Aspect.Execption.AopIsAwesomeHeaderException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Aspect
@Component
public class CheckPostRequestAspect {

    @Pointcut("within(com.directional.SpringDataAssignment.SpringDataAssignment.Controller.*)")
    public void a() {

    }

    @Before("a()")
    public void CheckIfPostExists(JoinPoint joinPoint) {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String header = request.getHeader("AOP-IS-AWESOME");
            var type = request.getMethod();

            if (header == null && type.equalsIgnoreCase("post")) {
                throw new AopIsAwesomeHeaderException("NoAopIsAwesomeEx");
            };
        } catch (AopIsAwesomeHeaderException exception) {
            System.out.println(exception.getMessage());
        }
    }

}
