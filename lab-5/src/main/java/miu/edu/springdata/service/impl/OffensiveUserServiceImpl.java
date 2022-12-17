package miu.edu.springdata.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.springdata.entity.OffensiveUser;
import miu.edu.springdata.entity.User;
import miu.edu.springdata.repository.OffensiveUserRepo;
import miu.edu.springdata.security.MyUserDetails;
import miu.edu.springdata.service.OffensiveUserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class OffensiveUserServiceImpl implements OffensiveUserService {
    private OffensiveUserRepo offensiveUserRepo;
    private List<String> offwords = new ArrayList<>();

    public OffensiveUserServiceImpl(OffensiveUserRepo offensiveUserRepo) {
        this.offensiveUserRepo = offensiveUserRepo;
        offwords.add("spring");
        offwords.add("hell");
        offwords.add("damn");
        offwords.add("freak");
    }


    public OffensiveUser findByUserId(int userId) {
        return offensiveUserRepo.findOffensiveUserByUser_Id(userId);
    }

    public void saveOffensiveUser(OffensiveUser offensiveUser) {
        offensiveUserRepo.save(offensiveUser);
    }

    public boolean scanOffensiveWord(Object[] args) {
        boolean found = false;
        for (Object arg : args) {
            String sentence = arg.toString();
            for (var search : offwords) {
                if (sentence.toLowerCase().indexOf(search.toLowerCase()) != -1) {
                    System.out.println("I found the keyword");
                    sentence.replace(search, "****");
                    found = true;
                }
            }
        }
        if (found) {
            updateOffensiveUser();
        }
        return found;
    }

    @Override
    public boolean checkIfBanned() {
        var offUser = findByUserId(getCurrentUserId());
        if(offUser != null && offUser.getBannedUntil()!=null){
            var now = LocalDateTime.now();
            if(now.isBefore(offUser.getBannedUntil())){
                return true;
            }
        }
        return false;
    }

    private void updateOffensiveUser() {
        int userId = getCurrentUserId();
        var offenUser = findByUserId(userId);
        if (offenUser != null) {
            offenUser.setWordCount(offenUser.getWordCount() + 1);
            if(offenUser.getWordCount()>=5){
                LocalDateTime after15M = LocalDateTime.now().plus(Duration.of(10, ChronoUnit.MINUTES));
                offenUser.setBannedUntil(after15M);
            }
            saveOffensiveUser(offenUser);
        } else {
            var user = new User();
            user.setId(userId);
            var newOff = new OffensiveUser();
            newOff.setWordCount(1);
            newOff.setUser(user);
            saveOffensiveUser(newOff);
        }
    }

    private int getCurrentUserId() {
        try{
            return ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
        }catch (Exception ex){
            return 0;
        }

    }

}
