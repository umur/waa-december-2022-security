package edu.miu.codebase.service.impl;

import edu.miu.codebase.entity.ActivityLog;
import edu.miu.codebase.repository.ActivityLogRepo;
import edu.miu.codebase.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {

    private final ActivityLogRepo activityLogRepo;

    @Override
    public void save(ActivityLog activityLog) {
        activityLogRepo.save(activityLog);
    }

    @Override
    public List<ActivityLog> getAll() {
        var activityLogList = new ArrayList<ActivityLog>();
        activityLogRepo.findAll().forEach(activityLogList::add);

        return activityLogList;
    }

    @Override
    public List<ActivityLog> findAllByDate(LocalDate date) {
        return null;
    }

    @Override
    public List<ActivityLog> findAllByDurationGreaterThan(long minDuration) {
        return null;
    }
}
