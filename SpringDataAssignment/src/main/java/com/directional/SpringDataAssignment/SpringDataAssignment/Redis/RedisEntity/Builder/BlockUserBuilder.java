package com.directional.SpringDataAssignment.SpringDataAssignment.Redis.RedisEntity.Builder;

import com.directional.SpringDataAssignment.SpringDataAssignment.Redis.RedisEntity.BlockUsers;

import java.time.LocalDateTime;

public class BlockUserBuilder {
    public int id;
    public String username;
    public LocalDateTime blockUntil;

    public int strikeCount;

    public BlockUserBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public BlockUserBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public BlockUserBuilder setBlockUntil(LocalDateTime blockUntil) {
        this.blockUntil = blockUntil;
        return this;
    }

    public BlockUserBuilder setStrikeCount(int blockUntil) {
        this.strikeCount = strikeCount;
        return this;
    }

    public BlockUsers build()
    {
        return new BlockUsers(id,username,blockUntil,strikeCount);
    }
}
