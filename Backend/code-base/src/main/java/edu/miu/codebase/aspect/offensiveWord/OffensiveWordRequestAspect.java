package edu.miu.codebase.aspect.offensiveWord;

import edu.miu.codebase.entity.User;
import edu.miu.codebase.repository.UserRepo;
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
public class OffensiveWordRequestAspect {

    private final HttpServletRequest httpServletRequest;
    private final UserRepo userRepo;
    private final OffensiveWordRepo offensiveWordRepo;
    private static List<String> offensiveWordList = new ArrayList<>();

    static {
        offensiveWordList.add("spring");
    }

    @Pointcut("@annotation(edu.miu.codebase.aspect.offensiveWord.OffensiveWordFilter)")
    public void offensiveWordRequestFilter() {}
    public User getUserDetails() {
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if(user instanceof UserDetails)
            username = ((UserDetails) user).getUsername();
        else
            username = user.toString();

        return userRepo.findByEmail(username);
    }
    public OffensiveWord getOffensiveWordCount(User user) {
        OffensiveWord oWord = offensiveWordRepo.findByUser_Email(user.getEmail());
        if(oWord == null) {
            OffensiveWord offensiveWord = new OffensiveWord();
            offensiveWord.setCount(0);
            offensiveWord.setUser(user);
            offensiveWord.setLastUpdated(LocalDateTime.now());
            offensiveWordRepo.save(offensiveWord);
            return offensiveWord;
        }
        return oWord;
    }

    @Before("offensiveWordRequestFilter()")
    public void offensiveWordCount(JoinPoint joinPoint) {
        User user = getUserDetails();
        OffensiveWord offensiveWord = getOffensiveWordCount(user);

        if(offensiveWord.getCount() > 5 && offensiveWord.getLastUpdated().isBefore(LocalDateTime.now())) {
            offensiveWord.setCount(0);
        }

        String input = httpServletRequest.getHeader("word");
        if(input != null && offensiveWordList.contains(input)) {
            offensiveWord.setCount(offensiveWord.getCount() + 1);
            if(offensiveWord.getCount() > 5) {
                offensiveWord.setLastUpdated(LocalDateTime.now().plus(10, ChronoUnit.SECONDS));
                String message = "Max Bad word limit. You need to wait for " + offensiveWord.getLastUpdated() + " min";
                ResponseEntity.badRequest().body(message);
                throw new RuntimeException(message);
            }
        }
    }
}
