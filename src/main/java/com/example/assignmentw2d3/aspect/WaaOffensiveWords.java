package com.example.assignmentw2d3.aspect;

import com.example.assignmentw2d3.entity.OffensiveWord;
import com.example.assignmentw2d3.entity.User;
import com.example.assignmentw2d3.repo.OffensiveWordsRepo;
import com.example.assignmentw2d3.repo.UserRepo;
import com.example.assignmentw2d3.security.JWTHelper;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.time.LocalDateTime;

@Aspect
@Order(2)
@Component
@RequiredArgsConstructor
public class WaaOffensiveWords {
    private final HttpServletRequest request;
    private final OffensiveWordsRepo offensiveWordsRepo;
    private final UserRepo userRepo;
    private final JWTHelper jwtHelper;

    @Pointcut("@annotation(com.example.assignmentw2d3.aspect.annotation.CheckOffensiveWords)")
    public void waaOffensiveWords() {}

    @Around("waaOffensiveWords()")
    public Object waaOffensiveWordsExecute(ProceedingJoinPoint jp) throws Throwable {
        var requestBody = jp.getArgs();
        var fields = requestBody[0].getClass().getDeclaredFields();
        if(isOffensive(fields, requestBody[0])) {
            addOffensiveOccurence();
            requestBody[0] = replaceOffensiveWords(fields, requestBody[0]);
        }
        var proceed = jp.proceed(requestBody);
        return proceed;
    }

    public void addOffensiveOccurence() {
        OffensiveWord occurrence = new OffensiveWord();
        occurrence.setOccurrence(LocalDateTime.now());
        final String authorizationHeader = request.getHeader("Authorization");
        var token = authorizationHeader.substring(7);
        boolean isTokenValid = jwtHelper.validateToken(token);
        var email = jwtHelper.getUsernameFromToken(token);
        User user = userRepo.findByEmail(email);
        occurrence.setUser(user);
        offensiveWordsRepo.save(occurrence);
    }

    public boolean isOffensive(Field[] fields, Object cls) throws Exception{
        String value;
        boolean offensiveFlag = false;
        try {
            for(Field f: fields) {
                if(f.getType() == String.class) {
                    f.setAccessible(true);
                    value = (String) f.get(cls);
                    if(value.contains("spring")) {
                        offensiveFlag = true;
                    }
                }
            }
        } catch (Exception e) {
            throw  e;
        }
        return offensiveFlag;
    }

    public Object replaceOffensiveWords(Field[] fields, Object cls) throws Exception{
        String value;
        try {
            for(Field f: fields) {
                if(f.getType() == String.class) {
                    value = (String) f.get(cls);
                    if(value.contains("spring")) {
                        f.set(cls, value.replace("spring", "******"));
                    }
                    f.setAccessible(false);
                }
            }
        } catch (Exception e) {
            throw  e;
        }
        return cls;
    }
}
