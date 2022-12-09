package miu.edu.springdata.aspect;

import lombok.RequiredArgsConstructor;
import miu.edu.springdata.service.OffensiveUserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@RequiredArgsConstructor
public class WaaOffensiveWords {

    private final OffensiveUserService offensiveUserService;

    @Pointcut("@annotation(miu.edu.springdata.annotation.OffWord)")
    public void OffWord(){}

    @Around("OffWord()")
    public Object OffensiveWordCatcher(ProceedingJoinPoint joinpoint) throws Throwable {
        if(offensiveUserService.checkIfBanned())
            return "You have been banned for about 15 minutes";
        Object[] signatureArgs = joinpoint.getArgs();
        offensiveUserService.scanOffensiveWord(signatureArgs);
        var result = joinpoint.proceed(signatureArgs);
        return result;
    }
}
