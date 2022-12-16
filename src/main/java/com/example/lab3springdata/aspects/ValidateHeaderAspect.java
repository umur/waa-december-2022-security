//package com.example.lab3springdata.aspects;
//
//import com.example.lab3springdata.AopIsAwesomeHeaderException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.weaver.Advice;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.net.http.HttpHeaders;
//
//@Aspect
//@Component
//public class ValidateHeaderAspect {
//    @Autowired
//    HttpServletRequest request;
//
//
//    @Pointcut("execution(* com.example.lab3springdata.services.*.*(..))")
//    public void myPointcut(){}
//
//    @Before("myPointcut()")
//    public void checkHeader(JoinPoint jp) throws AopIsAwesomeHeaderException {
//       String header =  request.getHeader("AOP-IS-AWESOME");
//       if(header==null){
//            throw new AopIsAwesomeHeaderException("Header Missing");
//       }
//
//
//    }
//}
