package com.directional.SpringDataAssignment.SpringDataAssignment.Service.Impl;

import com.directional.SpringDataAssignment.SpringDataAssignment.Entity.BiDirectional.ActivityLog;
import com.directional.SpringDataAssignment.SpringDataAssignment.Entity.BiDirectional.Address;
import com.directional.SpringDataAssignment.SpringDataAssignment.Repository.ActivityLogRepo;
import com.directional.SpringDataAssignment.SpringDataAssignment.Service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityLogService {

    public final ActivityLogRepo ActivityLogRepo;

    @Override
    public void saveOrUpdate(ActivityLog activityLog) {
        ActivityLogRepo.save(activityLog);
    }

    @Override
    public void delete(Long id) {
        ActivityLogRepo.deleteById(id);
    }

    @Override
    public ActivityLog get(Long id) {
        return ActivityLogRepo.findById(id).get();
    }

    @Override
    public List<ActivityLog> getAll() {
        List<ActivityLog> activityLogs = new ArrayList<>();
          ActivityLogRepo.findAll().forEach(activityLogs::add);
          return  activityLogs;
    }
}
