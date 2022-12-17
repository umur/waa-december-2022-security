package edu.miu.mae.aspect;

import edu.miu.mae.StreamUtils;
import edu.miu.mae.dto.ProductDto;
import edu.miu.mae.entity.OffensiveWord;
import edu.miu.mae.entity.User;
import edu.miu.mae.entity.UserOffensiveWords;
import edu.miu.mae.entity.UserOffensiveWordsId;
import edu.miu.mae.repository.OffensiveWordRepository;
import edu.miu.mae.repository.UserOffensiveWordsRepository;
import edu.miu.mae.repository.UserRepository;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.security.Principal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Aspect
@Component
public class WaaOffensiveWords {

    @Autowired
    private  HttpServletRequest request;

    @Autowired
    private   ModelMapper modelMapper;

    @Autowired
    private  OffensiveWordRepository offensiveWordRepository;
    @Autowired
    private UserOffensiveWordsRepository userOffensiveWordsRepository;
    @Autowired
    private UserRepository userRepository;


    @Pointcut("within(edu.miu.mae.controller..*)")
    public void desensitizationOffensiveWordsPointCut(){ }

    @Around("desensitizationOffensiveWordsPointCut()")
    public Object desensitizationOffensiveWords(ProceedingJoinPoint joinPoint) throws Throwable {

        Object[]  inputParams= joinPoint.getArgs();
        var objectStream = Arrays.stream(inputParams).filter(x -> x.getClass().equals(ProductDto.class));


        //Only filter Product endpoint
        if(objectStream.count()==0){
            return  joinPoint.proceed();
        }
        var allOffensiveWord = offensiveWordRepository.findAll();
        var offensiveWordSet = StreamUtils.asStream(allOffensiveWord).map(OffensiveWord::getWord);
        var hasOffensiveWord = Arrays.stream(inputParams)
                .filter(x-> offensiveWordSet.filter(y->x.toString().contains(y))
                        .count()==0?false:true).count()==0?false:true;


        //no OffensiveWord
        if(!hasOffensiveWord){
           return joinPoint.proceed();
        }


        Principal userPrincipal = request.getUserPrincipal();
        if(userPrincipal==null){
            return joinPoint.proceed();
        }

        User user = userRepository.findByEmail(userPrincipal.getName());

        if(hasOffensiveWord){
            var collectOff = StreamUtils.asStream(allOffensiveWord)
                    .filter(x -> {
                        boolean isContains = false;
                        for (Object o:inputParams) {
                            isContains = o.toString().contains(x.getWord());
                        }
                        return isContains;
                    }).collect(Collectors.toList());


            UserOffensiveWords userOffensiveWords = new UserOffensiveWords();
            userOffensiveWords.setOffensiveWord(collectOff.get(0));
            userOffensiveWords.setUser(user);
            userOffensiveWords.setLastCreateTime(System.currentTimeMillis());
            userOffensiveWords.setId(new UserOffensiveWordsId(collectOff.get(0).getId(),user.getId()));
            userOffensiveWordsRepository.save(userOffensiveWords);


            //desensitizationOffensiveWords
            var desensitizationArgs = Arrays.stream(inputParams)
                    .map(x-> {
                        //replace
                        var offensiveWords = new HashSet<OffensiveWord>();
                        Iterator<OffensiveWord> iterator = allOffensiveWord.iterator();
                        while (iterator.hasNext()){
                            OffensiveWord next = iterator.next();
                            if(x.toString().contains(next.getWord())){
                                offensiveWords.add(next);
                            }
                        }

                        ProductDto x1 = (ProductDto) x;
                        for(OffensiveWord word:offensiveWords){
                            x1.setName(x1.getName().replaceAll(word.getWord(),"******"));
                        }
                        return x1;
                    }).toArray(Object[]::new);


                return   joinPoint.proceed(desensitizationArgs);
            }


        return joinPoint.proceed();
        }

}
