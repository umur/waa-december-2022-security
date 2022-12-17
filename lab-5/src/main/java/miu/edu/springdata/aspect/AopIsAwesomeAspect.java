package miu.edu.springdata.aspect;

import javax.servlet.http.HttpServletRequest;
import miu.edu.springdata.exception.AopIsAwesomeHeaderException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
//
//@Aspect
//@Component
public class AopIsAwesomeAspect {

//    @Pointcut("within(miu.edu.springdata.service..*)")
//    public void servicePackageAnnotation(){}
//
//    @Before("servicePackageAnnotation()")
//    public void checkAopIsAwesomeHeader(JoinPoint joinPoint) throws AopIsAwesomeHeaderException {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//
//        if(request.getMethod().equalsIgnoreCase("POST")){
//            String header = request.getHeader("AOP-IS-AWESOME");
//            System.out.println(header);
//            if(header == null){
//                throw new AopIsAwesomeHeaderException("AOP-IS-AWESOME header not found");
//            }
//        }
//    }
}
