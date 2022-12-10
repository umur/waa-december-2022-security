package edu.miu.springsecurity.aspect;

import edu.miu.springsecurity.entity.ActivityLog;
import edu.miu.springsecurity.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
@RequiredArgsConstructor
public class LogAspect {

    private final ActivityLogService activityService;

    //define pointcut(WHICH)
    @Pointcut("@annotation(edu.miu.springsecurity.aspect.annotation.ExecutionTime)")
    public void myAnnotation(){

    }

    //apply pointcut(WHEN)
    @Around("myAnnotation()")
    public Object logExecutionTime(ProceedingJoinPoint jp) throws Throwable {
        //create stopwatch object
        long startTime = System.currentTimeMillis();
        var result = jp.proceed();
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        //create ActivityLog object
        ActivityLog activityLog = new ActivityLog();
        activityLog.setDate(LocalDateTime.now());
        activityLog.setOperation(jp.getSignature().getName());
        activityLog.setDuration(totalTime);

        activityService.save(activityLog);
        return result;
    }

    @Before("execution(* edu.miu.springsecurity.controller.*.*(..))")
    public void Before(JoinPoint jp){
        var args = jp.getArgs();
        var argList = "";
        for(int i = 0; i< args.length; i++){
            argList += "," + "arg"+ (i+1) + "=" + args[i];
        }
        if(argList.length() > 0)
            argList = "; arguments: " + argList.substring(1);

        System.out.println("REST API called. Controller: " + jp.getSignature().getDeclaringTypeName() +
                            "; method: " + jp.getSignature().getName() + argList);
    }
}
