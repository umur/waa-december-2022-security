package miu.edu.springdata.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.springdata.entity.ActivityLog;
import miu.edu.springdata.repository.ActivityLogRepo;
import miu.edu.springdata.service.ActivityLogService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {

    private  final ActivityLogRepo activityLogRepo;

    public void save(ActivityLog log){
        activityLogRepo.save(log);
    }
}
