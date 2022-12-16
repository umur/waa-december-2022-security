package com.directional.SpringDataAssignment.SpringDataAssignment.Redis.RedisRepo;

import com.directional.SpringDataAssignment.SpringDataAssignment.Entity.BiDirectional.Product;
import com.directional.SpringDataAssignment.SpringDataAssignment.Redis.RedisEntity.BlockUsers;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BlockRepo {

    public final RedisTemplate redisTemplate;

    public BlockUsers save(BlockUsers blockUsers)
    {
        redisTemplate.opsForHash().put("BlockUsers",blockUsers.getUsername(),blockUsers);
        return blockUsers;
    }
    public List<BlockUsers> findAll()
    {
        return redisTemplate.opsForHash().values("BlockUsers");
    }

    public BlockUsers findByUserName(String username)
    {
        return (BlockUsers) redisTemplate.opsForHash().get("BlockUsers",username);
    }

    public String deleteByUserName(String username)
    {
        redisTemplate.opsForHash().delete("BlockUsers",username);
        return "Product removed";
    }

}
