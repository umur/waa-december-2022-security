package edu.miu.springsecurity.repository;

import edu.miu.springsecurity.entity.ActivityLog;
import org.springframework.data.repository.CrudRepository;

public interface ActivityLogRepo extends CrudRepository<ActivityLog, Integer> {
}
