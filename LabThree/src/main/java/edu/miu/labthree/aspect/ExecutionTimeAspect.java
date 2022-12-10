package edu.miu.labthree.aspect;

import edu.miu.labthree.entity.ActivityLog;
import edu.miu.labthree.service.ActivityLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
public class ExecutionTimeAspect {
    public final ActivityLogService activityLogService;

    public ExecutionTimeAspect(ActivityLogService activityLogService) {
        this.activityLogService = activityLogService;
    }
    @Pointcut("@annotation(edu.miu.labthree.aspect.annotation.ExecutionTime)")
    public void a() {}

    @Around("a()")
    public Object calcExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long end = System.nanoTime();
        ActivityLog activity = new ActivityLog();
        activity.setDate(LocalDate.now());
        activity.setOperation(proceedingJoinPoint.getSignature().getName());
        activity.setDuration(start-end);
        activityLogService.save(activity);
        return result;
    }
}
