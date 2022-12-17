package edu.miu.mae.aspect;

import edu.miu.mae.dto.ActivityLogDto;
import edu.miu.mae.repository.ActivityRepository;
import edu.miu.mae.service.ActivityService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class ExecutionTimeAspect {
    @Autowired
    private ActivityService activityService;
    @Pointcut("@annotation(edu.miu.mae.aspect.annotation.ExecutionTime)")
    public void executionTimeAnnotation(){

    }

    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();

        var result = proceedingJoinPoint.proceed();

        long finish = System.nanoTime();

        System.out.println(proceedingJoinPoint.getSignature().getName() + " takes ns: " + finish);
        ActivityLogDto activityLogDto = new ActivityLogDto();
        activityLogDto.setDate(LocalDateTime.now());
        activityLogDto.setDuration(finish-start);
        activityLogDto.setOperation(proceedingJoinPoint.getSignature().getName());
        activityService.save(activityLogDto);

        return result;
    }
}
