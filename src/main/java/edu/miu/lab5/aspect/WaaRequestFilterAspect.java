package edu.miu.lab5.aspect;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class WaaRequestFilterAspect {

    private final AuthenticationManager authenticationManager;
    private final WaaOffensiveWordsAspect waaOffensiveWordsAspect;
    private final HttpServletRequest request;

    @Pointcut("within(edu.miu.lab5.controller..*)")
    public void allMethods() {

    }

    @Around("allMethods()")
    public Object checkRequest(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("checking request User");
        if (request.getUserPrincipal() != null) {
            var user = request.getUserPrincipal().getName();
            if (waaOffensiveWordsAspect.getUserOffensiveCountMap().get(user) != null) {
                var userOffensiveCount = waaOffensiveWordsAspect.getUserOffensiveCountMap().get(user);
                if (userOffensiveCount.isBanned()) {
                    return "User is banned for " + userOffensiveCount.timeOut() + " seconds";

                }
            }
        }
        return joinPoint.proceed();


    }
}
