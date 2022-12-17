package miu.edu.springsecuritylab6.aspect;

import lombok.RequiredArgsConstructor;
import miu.edu.springsecuritylab6.domain.UserPrincipal;
import miu.edu.springsecuritylab6.entity.CountUser;
import miu.edu.springsecuritylab6.repository.CountUserRepository;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Aspect
@Component
@RequiredArgsConstructor
public class WaaOffensiveWords {
    private final CountUserRepository repository;

    @Pointcut("@annotation(miu.edu.springsecuritylab6.aspect.OffensiveWord)")
    public void annotated() {}

    @Around("annotated()")
    public Object offensiveWordFilter(ProceedingJoinPoint joinPoint) throws Throwable {
        List<String> list = (List<String>) joinPoint.proceed();
        list = list.stream().filter(item -> item.contains("spring"))
                .map(content -> {
                    content = content.replace("spring", "******");
                    return content;
                }).collect(Collectors.toList());
        UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CountUser counter = new CountUser(list.stream().filter(item -> item.contains("spring")).collect(Collectors.joining(", ")), principal.getUsername());
        repository.save(counter);
        return list;
    }
}
