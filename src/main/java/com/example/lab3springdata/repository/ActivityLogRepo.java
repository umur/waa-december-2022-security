package com.example.lab3springdata.repository;

import com.example.lab3springdata.entity.ActivityLog;
import com.example.lab3springdata.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepo extends CrudRepository<ActivityLog,Integer> {
}
