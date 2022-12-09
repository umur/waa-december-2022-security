package com.w1d3.springdata.repository;


import com.w1d3.springdata.dto.ActivityLogDto;
import com.w1d3.springdata.entity.ActivityLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ActivityLogRepo extends CrudRepository<ActivityLog,Integer> {

}
