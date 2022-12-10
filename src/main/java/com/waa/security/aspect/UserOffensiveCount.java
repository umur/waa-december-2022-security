package com.waa.security.aspect;

import com.waa.security.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;


@Data
public class UserOffensiveCount {
    public UserOffensiveCount(String user,int count, LocalDateTime time) {
        this.count = count;
        this.time = time;
        this.user = user;
    }
    private final String user;
    private int timeout = 15 * 60;
    private int count;
    private LocalDateTime time;

    public boolean isBanned(){
        return Duration.between(time, LocalDateTime.now()).getSeconds() < timeout;
    }

    public long timeOut() {
        Duration diff = Duration.between(time, LocalDateTime.now());

        if (diff.toSeconds() < timeout) {
            return timeout - diff.toSeconds();
        }

        return 0;
    }
}
