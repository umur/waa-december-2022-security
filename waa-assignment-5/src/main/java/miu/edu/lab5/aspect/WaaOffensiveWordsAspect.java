package miu.edu.lab5.aspect;

import lombok.RequiredArgsConstructor;
import miu.edu.lab5.entity.RequestPerUser;
import miu.edu.lab5.exception.ConcurrentRequestException;
import miu.edu.lab5.repository.UserRepo;
import miu.edu.lab5.security.SecUserDetails;
import miu.edu.lab5.service.RequestPerUserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RequiredArgsConstructor
@Aspect
@Component
@Order(2)
public class WaaOffensiveWordsAspect {

    List<String> offensiveWordList = new ArrayList<>(List.of(
            "terrible",
            "bad",
            "bad idea",
            "fake",
            "fear"
    ));

    private final RequestPerUserService requestPerUserService;
    private final UserRepo userRepo;

    @Around("execution(* miu.edu.lab5.*.*(..))")
    public Object FilterOffensive(ProceedingJoinPoint pjp) throws Throwable {
        var modifiedArgs = pjp.getArgs();
        int index = 0;
        for(Object arg: pjp.getArgs()){
            if(arg instanceof String){
                modifiedArgs[index] = replaceOffensive(arg.toString());
            } else {

                var className = arg.getClass();
                var fields = className.getDeclaredFields();

                for(Field field : fields){

                    if(field.getType() == String.class) {
                        field.setAccessible(true);
                        var value = field.get(arg);
                        field.set(arg, replaceOffensive(value.toString()));
                    }
                }
                modifiedArgs[index] = arg;
            }
            index++;
        }

        return pjp.proceed(modifiedArgs);
    }

    private String replaceOffensive(String word) throws ConcurrentRequestException {
        var result = word;
        var off = offensiveWordList.stream()
                .filter(o -> word.toLowerCase(Locale.ROOT).contains(o))
                .findFirst();

        if(off.isPresent()){

            var authenticationContext = SecurityContextHolder.getContext().getAuthentication();
            var userDetails = (SecUserDetails)authenticationContext.getPrincipal();

            //create requestPerUser record
            var request = new RequestPerUser();
            request.setRequestTime(LocalDateTime.now());
            request.setUser(userRepo.findByEmail(userDetails.getEmail()));
            requestPerUserService.save(request);

            var offensive = off.get();
            result = word.replace(offensive, getStars(offensive));
        }
        return result;
    }

    private String getStars(String word){
        var result = "";
        for(int i = 0; i< word.length(); i++){
            result += "*";
        }
        return result;
    }
}
