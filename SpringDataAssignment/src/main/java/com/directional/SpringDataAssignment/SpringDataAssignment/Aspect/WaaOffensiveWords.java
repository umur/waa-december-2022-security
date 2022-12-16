package com.directional.SpringDataAssignment.SpringDataAssignment.Aspect;

import com.directional.SpringDataAssignment.SpringDataAssignment.Redis.RedisEntity.BlockUsers;
import com.directional.SpringDataAssignment.SpringDataAssignment.Redis.RedisEntity.Builder.BlockUserBuilder;
import com.directional.SpringDataAssignment.SpringDataAssignment.Redis.RedisRepo.BlockRepo;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Aspect
@Component
@RequiredArgsConstructor
public class WaaOffensiveWords {

    public final HttpServletRequest request;
    public final BlockRepo blockRepo;

    @Pointcut("within(com.directional.SpringDataAssignment.SpringDataAssignment.Controller.*)")


    public void a() {
    }

    @Around("a()")
    public Object checkIfOffensiveWord(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String currentUserName = null;
        String word = request.getHeader("WAA-OFFENSIVE-WORD").toLowerCase();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        }
        BlockUsers blockUser = blockRepo.findByUserName(currentUserName);

        if (blockUser != null) {
            if (LocalDateTime.now().isAfter(blockUser.getBlockUntil())) {
                blockRepo.deleteByUserName(currentUserName);
               return proceedingJoinPoint.proceed();
            }
            throw new HttpClientErrorException(org.springframework.http.HttpStatus.BAD_REQUEST, "You are blocked");
        }

        if (word != null && word.contains("spring")) {
            LocalDateTime timeToBlock = LocalDateTime.now().plusMinutes(15);
            var newBlockUser = new BlockUserBuilder().setUsername(currentUserName).setBlockUntil(timeToBlock).setStrikeCount(blockUser.getStrikeCount()+1).build();
            blockRepo.save(newBlockUser);
        }
        return proceedingJoinPoint.proceed();
    }


}
