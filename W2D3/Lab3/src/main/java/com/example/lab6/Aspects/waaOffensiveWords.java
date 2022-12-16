package com.example.lab6.Aspects;

import com.example.lab6.Entity.Counter;
import com.example.lab6.Repository.CounterRepository;
import com.example.lab6.Security.WaaUserDetails;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
@Aspect
@Component
@RequiredArgsConstructor
public class waaOffensiveWords {


        private final CounterRepository repository;

        @Pointcut("@annotation(WaaWord)")
        public void annotated() {}

        @Around("annotated()")
        public Object replaceOffensiveWord(ProceedingJoinPoint joinPoint) throws Throwable {
            System.out.println("annotated");
            String content = (String) joinPoint.proceed();
            if (content.contains("spring")) {
                content = content.replace("spring", "******");
                WaaUserDetails userDetails = (WaaUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                repository.save(new Counter(content, userDetails.getById()));

            }
            return content;
        }
    }

