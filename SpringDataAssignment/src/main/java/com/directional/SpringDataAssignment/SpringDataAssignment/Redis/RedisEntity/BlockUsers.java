package com.directional.SpringDataAssignment.SpringDataAssignment.Redis.RedisEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("BlockUsers")
public class BlockUsers implements Serializable {
    public int id;
    public String username;
    public LocalDateTime blockUntil;
    public int strikeCount;
}
