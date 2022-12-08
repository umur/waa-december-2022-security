package com.w1d3.springdata.aspect;

import com.w1d3.springdata.dto.ActivityLogDto;
import com.w1d3.springdata.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDate;

@Aspect
@Component
@RequiredArgsConstructor
public class ExecutionTimeAspect {

private  final ActivityLogService activityLogService;
    @Pointcut("@annotation(com.w1d3.springdata.aspect.annotation.ExecutionTime)")
    public void ExecutionTimePointCut(){}

    @Around("ExecutionTimePointCut()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        ActivityLogDto activityLog =new ActivityLogDto();
        activityLog.setDate(LocalDate.now());
        activityLog.setOperation(proceedingJoinPoint.getSignature().toShortString());
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        activityLog.setDuration(Duration.ofNanos(finish-start));
        activityLogService.save(activityLog);
        return result;

    }


}
