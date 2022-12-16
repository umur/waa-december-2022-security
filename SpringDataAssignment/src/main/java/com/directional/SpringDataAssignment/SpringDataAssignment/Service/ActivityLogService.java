package com.directional.SpringDataAssignment.SpringDataAssignment.Service;

import com.directional.SpringDataAssignment.SpringDataAssignment.Entity.BiDirectional.ActivityLog;
import com.directional.SpringDataAssignment.SpringDataAssignment.Entity.BiDirectional.Address;

import java.util.List;


public interface ActivityLogService {
    public void saveOrUpdate(ActivityLog activityLog);
    public void delete(Long id);
    public ActivityLog get(Long id);
    public List<ActivityLog> getAll();
}
