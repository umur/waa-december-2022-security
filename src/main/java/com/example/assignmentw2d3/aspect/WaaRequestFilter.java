package com.example.assignmentw2d3.aspect;

import com.example.assignmentw2d3.entity.OffensiveWord;
import com.example.assignmentw2d3.entity.User;
import com.example.assignmentw2d3.repo.OffensiveWordsRepo;
import com.example.assignmentw2d3.repo.UserRepo;
import com.example.assignmentw2d3.security.JWTHelper;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Aspect
@Order(1)
@Component
@Transactional
@RequiredArgsConstructor
public class WaaRequestFilter {
    private final HttpServletRequest request;
    private final OffensiveWordsRepo offensiveWordsRepo;
    private final UserRepo userRepo;
    private final JWTHelper jwtHelper;
    @Pointcut("@annotation(com.example.assignmentw2d3.aspect.annotation.RequestFilter)")
    public void requestFilter() {}

    @Before("requestFilter()")
    public void requestFilterExecute() throws Exception{
        final String authorizationHeader = request.getHeader("Authorization");
        var token = authorizationHeader.substring(7);
        var email = jwtHelper.getUsernameFromToken(token);
        User user = userRepo.findByEmail(email);
        List<OffensiveWord> occurrences = offensiveWordsRepo.findAllByUserOrderByOccurrence(user);
        if(occurrences.size() >= 5) {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime firstOccurrence = occurrences.get(0).getOccurrence();
            LocalDateTime lastOccurrence = occurrences.get(4).getOccurrence();
            long difference = firstOccurrence.until(now, ChronoUnit.MINUTES);
            long ban = lastOccurrence.until(now, ChronoUnit.MINUTES);
            try{
                if(difference < 30 && ban < 1) {
                    throw new Exception("offensive words encountered in 5 current requests.");
                } else {
                    offensiveWordsRepo.deleteAllByUser_Id(user.getId());
                }
            } catch (Exception e) {
                throw e;
            }
        }
        System.out.println("inside request filter aspect!");
    }
}
