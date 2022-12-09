package com.miu.springsecurity.aspects.offensivewords;

import com.miu.springsecurity.entity.User;
import com.miu.springsecurity.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
@Transactional
@RequiredArgsConstructor
public class OffensiveWordHeaderRequestAspect {
    private final HttpServletRequest httpServletRequest;
    private final UserRepo userRepo;
    private final OffensiveWordsRepo offensiveWordsRepo;
    private static List<String> offensiveWordList = new ArrayList<>();

    static {
        offensiveWordList.add("spring");
        offensiveWordList.add("bean");
        offensiveWordList.add("holy");
    }
    @Pointcut("@annotation(com.miu.springsecurity.aspects.offensivewords.OffensiveWordFilter)")
    public void a(){}
    public User getUserDetails(){
        Object getUser = SecurityContextHolder. getContext(). getAuthentication(). getPrincipal();
        String username;
        if (getUser instanceof UserDetails) {
            username = ((UserDetails)getUser). getUsername();
        } else {
            username = getUser.toString();
        }
        return userRepo.findByEmail(username);
    }

    public OffensiveWords getOffensiveCount(User user){
        OffensiveWords entry = offensiveWordsRepo.findByUser(user);
        if(entry == null){
            OffensiveWords offensiveWords = new OffensiveWords();
            offensiveWords.setConsecutiveCount(0);
            offensiveWords.setUser(user);
            offensiveWords.setDetectedDate(LocalDateTime.now());
            offensiveWordsRepo.save(offensiveWords);
            return offensiveWords;
        }
        return entry;
    }
    @Before("a()")
    public void offensiveCount(JoinPoint joinPoint) {
        User user = getUserDetails();
        OffensiveWords offensiveWords = getOffensiveCount(user);
        if( offensiveWords.getConsecutiveCount() > 5 && offensiveWords.getDetectedDate().isBefore(LocalDateTime.now()) ){
            offensiveWords.setConsecutiveCount(0);
        }

        String input = httpServletRequest.getHeader("safeword");
        if( input != null && offensiveWordList.contains(input) ){
            offensiveWords.setConsecutiveCount(offensiveWords.getConsecutiveCount()+1);
            if( offensiveWords.getConsecutiveCount() > 5 ){
                offensiveWords.setDetectedDate(LocalDateTime.now().plus(15, ChronoUnit.MINUTES));
                String message = " Max Bad word limit reached. Wait time: "+ offensiveWords.getDetectedDate() +"min";
                ResponseEntity.badRequest().body(message);
                throw new RuntimeException(message);
            }
        }
    }
}
