package miu.edu.lab5.service;

import miu.edu.lab5.entity.ActivityLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface ActivityLogService  {

    public ActivityLog getAll();
    public ActivityLog save(ActivityLog activityLog);
}