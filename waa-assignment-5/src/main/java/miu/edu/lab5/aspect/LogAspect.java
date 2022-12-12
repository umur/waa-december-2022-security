package miu.edu.lab5.aspect;

import miu.edu.lab5.entity.ActivityLog;
import miu.edu.lab5.service.ActivityLogService;
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
    private ActivityLogService activityLogService;

    @Pointcut("@annotation(miu.edu.lab5.aspect.annotation.ExecutionTime)")
    public void myAnnotation(){

    }

    @Around("myAnnotation()")
    public Object Camilla(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();
       var result = proceedingJoinPoint.proceed();
       long endTime = System.currentTimeMillis();

        System.out.println("Hello I am Checking in, total time: " + (endTime-startTime));

        ActivityLog timeinDB = new ActivityLog();
        timeinDB.setId(2222);
        timeinDB.setDate(LocalDate.now());
        timeinDB.setOperation(proceedingJoinPoint.getSignature().getName());
        timeinDB.setDuration(endTime-startTime);

        activityLogService.save(timeinDB);

        return result;
    }


}
