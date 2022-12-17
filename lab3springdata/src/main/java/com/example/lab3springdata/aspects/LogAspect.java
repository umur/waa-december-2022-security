package com.example.lab3springdata.aspects;

import com.example.lab3springdata.entity.ActivityLog;
import com.example.lab3springdata.services.ActivityLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
public class LogAspect {
    @Autowired
    ActivityLogService activityLogService;
    @Pointcut("@annotation(com.example.lab3springdata.aspects.annotation.ExecutionTime)")
            public void myPointCutForExecution(){
            }

            @Around("myPointCutForExecution()")
    public Object calculateExecutonTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.nanoTime();
        var result = pjp.proceed();
        long finish = System.nanoTime();

                ActivityLog activityLog = new ActivityLog();
                activityLog.setDate(LocalDate.now());
                activityLog.setOperation(pjp.getSignature().getName());
                activityLog.setDuration(finish-start);
                activityLogService.save(activityLog);

        return result;
    }
}
