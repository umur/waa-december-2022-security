package com.w1d3.springdata.repository;

import com.w1d3.springdata.entity.OffensiveUser;
import org.springframework.data.repository.CrudRepository;

public interface OffensiveWordRepo extends CrudRepository<OffensiveUser,Integer> {
    OffensiveUser findOffensiveUserByUser_Id(int userId);
}
