package miu.edu.springdata.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class WaaOffensiveWords {

    @Pointcut("within(miu.edu.springdata.service..*)")
    public void allService(){}

    @Before("allService()")
    public void OffensiveWordCatcher(JoinPoint joinpoint){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        System.out.println(joinpoint.getSignature().getName());
    }
}
