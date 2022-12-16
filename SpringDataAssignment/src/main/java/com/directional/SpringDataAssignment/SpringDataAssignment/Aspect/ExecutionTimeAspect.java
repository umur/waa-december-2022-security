package com.directional.SpringDataAssignment.SpringDataAssignment.Aspect;


import com.directional.SpringDataAssignment.SpringDataAssignment.Aspect.Execption.AopIsAwesomeHeaderException;
import com.directional.SpringDataAssignment.SpringDataAssignment.Entity.BiDirectional.ActivityLog;
import com.directional.SpringDataAssignment.SpringDataAssignment.Service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
@RequiredArgsConstructor
public class ExecutionTimeAspect {

    public final ActivityLogService activityLogService;
    @Pointcut("@annotation(com.directional.SpringDataAssignment.SpringDataAssignment.Aspect.Annotation.ExecutionTime)")
    public void a() {}

    @Around("a()")
    public Object CalculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        ActivityLog  item = new ActivityLog();
        item.setDate(LocalDate.now());
        item.setOperation(proceedingJoinPoint.getSignature().getName());
        item.setDuration(finish-start);
        activityLogService.saveOrUpdate(item);
        return result;

    }




}
