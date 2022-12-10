package edu.miu.labthree.service.impl;

import edu.miu.labthree.entity.ActivityLog;
import edu.miu.labthree.repository.ActivityLogRepo;
import edu.miu.labthree.service.ActivityLogService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {

    private final ActivityLogRepo activityLogRepo;

    public ActivityLogServiceImpl(ActivityLogRepo activityLogRepo) {
        this.activityLogRepo = activityLogRepo;
    }

    @Override
    public void save(ActivityLog activityLog) {
        activityLogRepo.save(activityLog);

    }

    @Override
    public void delete(int id) {
        activityLogRepo.deleteById(id);
    }

    @Override
    public Optional<ActivityLog> get(int id) {
        return activityLogRepo.findById(id);
    }

    @Override
    public List<ActivityLog> getAll() {
        List<ActivityLog> activityLogs = new ArrayList<>();
        activityLogRepo.findAll().forEach(activityLogs::add);
        return  activityLogs;
    }
}
