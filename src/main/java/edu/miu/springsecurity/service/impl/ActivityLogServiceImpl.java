package edu.miu.springsecurity.service.impl;

import edu.miu.springsecurity.entity.ActivityLog;
import edu.miu.springsecurity.repository.ActivityLogRepo;
import edu.miu.springsecurity.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {
    private final ActivityLogRepo activityLogRepo;

    @Override
    public void save(ActivityLog activityLog) {
        activityLogRepo.save(activityLog);
    }

}
