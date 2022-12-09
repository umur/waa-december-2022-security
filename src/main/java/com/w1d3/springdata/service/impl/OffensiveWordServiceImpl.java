package com.w1d3.springdata.service.impl;

import com.w1d3.springdata.entity.OffensiveUser;
import com.w1d3.springdata.entity.User;
import com.w1d3.springdata.repository.OffensiveWordRepo;
import com.w1d3.springdata.security.AwesomeUserDetails;
import com.w1d3.springdata.service.OffensiveWordService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
@Service
public class OffensiveWordServiceImpl implements OffensiveWordService {
    private OffensiveWordRepo offensiveWordRepo;
    private List<String> offwords = new ArrayList<>();

    public OffensiveWordServiceImpl(OffensiveWordRepo offensiveWordRepo ) {
        this.offensiveWordRepo = offensiveWordRepo;
        offwords.add("spring");
        offwords.add("hell");
        offwords.add("damn");
        offwords.add("freak");
    }


    public OffensiveUser findByUserId(int userId) {
        return offensiveWordRepo.findOffensiveUserByUser_Id(userId);
    }

    public void saveOffensiveUser(OffensiveUser offensiveUser) {
        offensiveWordRepo.save(offensiveUser);
    }

    public boolean scanOffensiveWord(Object[] args) {
        boolean found = false;
        for (Object arg : args) {
            String sentence = arg.toString();
            for (var search : offwords) {
                if (sentence.toLowerCase().indexOf(search.toLowerCase()) != -1) {
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
            return ((AwesomeUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
        }catch (Exception ex){
            return 0;
        }

    }
}
