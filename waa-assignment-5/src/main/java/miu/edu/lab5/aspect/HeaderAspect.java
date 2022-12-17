package miu.edu.lab5.aspect;


import miu.edu.lab5.exception.AopIsAwesomeHeaderException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Aspect
@Component
public class HeaderAspect {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Pointcut("within(miu.edu.lab5.service..*)")
    public void checkHeaderPr(){}

    //@Before("checkHeaderPr()")
    public void checkHeader() throws AopIsAwesomeHeaderException {
        System.out.println("i am in heaser aspect " +Objects.isNull(httpServletRequest.getHeader("AOP-IS-AWESOME")));
        if(httpServletRequest.getMethod().toString().equalsIgnoreCase("POST")
        && Objects.isNull(httpServletRequest.getHeader("AOP-IS-AWESOME"))){
            throw new AopIsAwesomeHeaderException("AOP is awesome header is not present");
        }

    }

}
