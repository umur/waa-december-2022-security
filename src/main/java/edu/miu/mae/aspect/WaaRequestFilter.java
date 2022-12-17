package edu.miu.mae.aspect;

import edu.miu.mae.entity.User;
import edu.miu.mae.entity.UserOffensiveWords;
import edu.miu.mae.exceptions.AopIsAwesomeHeaderException;
import edu.miu.mae.repository.UserOffensiveWordsRepository;
import edu.miu.mae.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.OptionalLong;

@Aspect
@Component
@NoArgsConstructor
@AllArgsConstructor
public class WaaRequestFilter {

    private long  MINUS_30 = 1000*60*30;
    private HttpServletRequest request;

    private UserRepository userRepository;
    private UserOffensiveWordsRepository userOffensiveWordsRepository;


    @Pointcut("within(edu.miu.mae.controller..*)")
    public void isUserBaned(){ }

    @Before("isUserBaned()")
    public void filterBanedUser(JoinPoint joinPoint) throws Throwable {
        String email = request.getUserPrincipal().getName();
        User byEmail = userRepository.findByEmail(email);
        long deadLine = System.currentTimeMillis() - MINUS_30;

        var passed30MinOffensiveRequestTime = userOffensiveWordsRepository.findUserOffensiveWordsByUserIdAndLastCreateTimeLessThan(byEmail.getId(), deadLine);
        if(passed30MinOffensiveRequestTime.size()>=5){
            Long minTime = passed30MinOffensiveRequestTime.stream().mapToLong(x -> x.getLastCreateTime()).min().getAsLong();
            int waiteMinus = (int) ((deadLine - minTime) / 1000 / 60);
            throw  new AopIsAwesomeHeaderException(String.format("Max Bad Words Requests Limit has been Reached. You need wait for %d minutes.",waiteMinus));
        }


    }
}
