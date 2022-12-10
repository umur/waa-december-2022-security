package edu.miu.labthree.service;

import edu.miu.labthree.entity.ActivityLog;

import java.util.List;
import java.util.Optional;

public interface ActivityLogService {

    void save(ActivityLog activityLog);
    public void delete(int id);
    public Optional<ActivityLog> get(int id);
    public List<ActivityLog> getAll();
}
