package com.example.lab6.Service.ServiceImpl;


import com.example.lab6.Entity.ActivityLog;
import com.example.lab6.Repository.ActivityLogRepository;
import com.example.lab6.Service.ActivityLogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {

    private ActivityLogRepository activityLogRepository;

    @Override
    public void saveActivityLog(ActivityLog log) {
        activityLogRepository.save(log);
    }
}