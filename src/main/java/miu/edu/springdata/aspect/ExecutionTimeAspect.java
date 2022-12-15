package miu.edu.springdata.aspect;

import lombok.RequiredArgsConstructor;
import miu.edu.springdata.annotation.ExecutionTime;
import miu.edu.springdata.entity.ActivityLog;
import miu.edu.springdata.service.ActivityLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDate;

@Aspect
@Component
@RequiredArgsConstructor
public class ExecutionTimeAspect {

    private final ActivityLogService activityLogService;

    @Pointcut("@annotation(miu.edu.springdata.annotation.ExecutionTime)")
    public void executionTimeAnnotation(){}

    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        var log = new ActivityLog();
        log.setDate(LocalDate.now());
        var startTime = System.nanoTime();
        var result = joinPoint.proceed();
        var endTime = System.nanoTime();
        log.setDuration(Duration.ofNanos(endTime-startTime));
        log.setOperation(joinPoint.getSignature().toShortString());
        activityLogService.save(log);
        return result;
    }

}
