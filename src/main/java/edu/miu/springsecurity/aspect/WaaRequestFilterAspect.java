package edu.miu.springsecurity.aspect;

import edu.miu.springsecurity.exception.ConcurrentRequestException;
import edu.miu.springsecurity.security.AwesomeUserDetails;
import edu.miu.springsecurity.service.RequestPerUserService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Aspect
@Component
@Order(1)
public class WaaRequestFilterAspect {
    private final RequestPerUserService requestPerUserService;

    @Pointcut("execution(* edu.miu.springsecurity.controller.*.*(..))")
    public void filterJP(){

    }

    @Before("filterJP()")
    public void CheckBefore(JoinPoint pjp) throws Throwable {

        var authenticationContext = SecurityContextHolder.getContext().getAuthentication();
        if(authenticationContext.getPrincipal() instanceof AwesomeUserDetails){
            var userDetails = (AwesomeUserDetails)authenticationContext.getPrincipal();
            var requests = requestPerUserService.getAllByUser(userDetails.getEmail());

            // If the same user sends more than 5 different requests that contain offensive words in last 30 minutes,
            // do not accept the requests of this user for next 15 minutes and return the error message Max Bad Words
            // Requests Limit has been Reached. You need wait for X minutes. Change X with remaining time of the ban.

            if( requests.size() >= 5 ){
                var latest = requests.get(0).getRequestTime();
                var oldest = requests.get(requests.size() - 1).getRequestTime();

                var diffWithOldest = Duration.between(oldest, LocalDateTime.now()).toMinutesPart();
                if(diffWithOldest <= 30){
                    var diffWithLatest = Duration.between(latest, LocalDateTime.now()).toMinutesPart();
                    if(diffWithLatest <= 15){
                        throw new ConcurrentRequestException("Max Bad Words Requests Limit has been exceeded. You need to wait for " + (15-diffWithLatest) + " minutes.");
                    } else {
                        //delete all requests in db
                        requestPerUserService.deleteAllByUser(userDetails.getEmail());
                    }
                } else
                    requestPerUserService.deleteAllByUser(userDetails.getEmail());
            }
        }
    }
}
