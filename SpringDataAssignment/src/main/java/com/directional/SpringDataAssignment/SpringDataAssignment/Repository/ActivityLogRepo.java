package com.directional.SpringDataAssignment.SpringDataAssignment.Repository;

import com.directional.SpringDataAssignment.SpringDataAssignment.Entity.BiDirectional.ActivityLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepo extends CrudRepository<ActivityLog,Long> {

}
