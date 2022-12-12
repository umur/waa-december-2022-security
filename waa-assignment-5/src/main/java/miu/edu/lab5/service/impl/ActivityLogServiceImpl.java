package miu.edu.lab5.service.impl;

import miu.edu.lab5.entity.ActivityLog;
import miu.edu.lab5.repository.ActivityLogRepo;
import miu.edu.lab5.service.ActivityLogService;
import org.springframework.stereotype.Service;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {

    private ActivityLogRepo activityLogrepo;

    public ActivityLogServiceImpl(ActivityLogRepo activityLogrepo){
        this.activityLogrepo=activityLogrepo;
    }

    public ActivityLog getAll(){
        return null;
    }

    @Override
    public ActivityLog save(ActivityLog activityLog) {
        return activityLogrepo.save(activityLog);
    }

}
