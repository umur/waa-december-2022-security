package edu.miu.labthree.aspect.annotation;

import edu.miu.labthree.aspect.AopIsAwesomeHeaderException;
import edu.miu.labthree.service.ActivityLogService;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Aspect
@Component
public class PostRequestCheck {
    private final ActivityLogService activityLogService;

    public PostRequestCheck(ActivityLogService activityLogService) {
        this.activityLogService = activityLogService;
    }

    @Pointcut("@annotation(edu.miu.labthree.aspect.annotation.ExecutionTime)")
    public void b(){
    }

    @Around("b()")
    public void checkIfPostRequestExists(JoinPoint joinPoint) {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String header = request.getHeader("AOP-IS-AWESOME");
            var type = request.getMethod();

            if (header == null && type.equalsIgnoreCase("post")) {
                throw new AopIsAwesomeHeaderException("NoAopIsAwesomeEx");
            }
            ;
        } catch (AopIsAwesomeHeaderException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
