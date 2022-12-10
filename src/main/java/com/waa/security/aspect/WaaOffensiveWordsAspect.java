package com.waa.security.aspect;

import com.waa.security.entity.Product;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;


@Aspect
@Component
@Data
@RequiredArgsConstructor
public class WaaOffensiveWordsAspect {


    private final OffensiveWordChecker offensiveWordChecker;

    private final HttpServletRequest request;
    private final HashMap<String,UserOffensiveCount> userOffensiveCountMap = new HashMap<>();


    @Pointcut("within(com.waa.security.controller..*)")
    public void allMethods() {
    }


    @Around("allMethods()")
    public Object checkOffensiveWords(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("checking offensive words");
      var userPrincipal = request.getUserPrincipal();
        if (userPrincipal != null) {
            var user = userPrincipal.getName();



            var args = joinPoint.getArgs();
            int index = 0;
            for (Object obj : args) {

                for (String offenseWord : offensiveWordChecker.offensiveWords) {
                    if (obj.toString().contains(offenseWord)) {
                        Product p = ((Product) obj);
                        System.out.println("Offensive word found " + offenseWord);
                        p.setName(p.getName().replace(offenseWord, "****"));

                        if (userOffensiveCountMap.containsKey(user)) {
                            var userRequestCount = userOffensiveCountMap.get(user);
                            var totalCount = userRequestCount.getCount();
                            userOffensiveCountMap.put(user, new UserOffensiveCount(user, ++totalCount, LocalDateTime.now()));
                            if (userOffensiveCountMap.get(user).getCount() >= 5) {
                                long timeOut = userOffensiveCountMap.get(user).timeOut();
                                if (timeOut > 0) {
                                    throw new Exception("User has been banned");
                                }
                            }
                        } else {
                            userOffensiveCountMap.put(user, new UserOffensiveCount(user, 1, LocalDateTime.now()));
                        }

                        args[index] = p;
                        return joinPoint.proceed(args);
                    }

                }
                index++;
            }
        }

            return joinPoint.proceed();
    }


}
