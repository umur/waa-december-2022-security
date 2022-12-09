package com.w1d3.springdata.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.HashMap;

//@Aspect
//@Component
//@RequiredArgsConstructor
public class WaaOffensiveWordsAspect {
    HashMap<String,String> offensiveWords=new HashMap<>();
    public WaaOffensiveWordsAspect(){
        offensiveWords.put("Spring","******");
        offensiveWords.put("Apple","******");
        offensiveWords.put("Dell","******");
        offensiveWords.put("Mac","******");
    }





    @Pointcut("within(com.w1d3.springdata.service..*)")
    public void OffensiveWordsAspect(){
    }

    @Around("OffensiveWordsAspect()")
    public Object filterOutOffensiveWord(ProceedingJoinPoint joinPoint){
//        joinPoint.getArgs().
        return true;
    }
}
