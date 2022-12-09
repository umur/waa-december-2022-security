package com.w1d3.springdata.service.impl;

import com.w1d3.springdata.dto.ActivityLogDto;
import com.w1d3.springdata.entity.ActivityLog;
import com.w1d3.springdata.repository.ActivityLogRepo;
import com.w1d3.springdata.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class ActivityLogServiceImpl implements ActivityLogService {
    private  final ActivityLogRepo activityLogRepo;
    private  final ModelMapper mapper;
    @Override
    public void save(ActivityLogDto activityLogDto) {
        activityLogRepo.save(mapper.map(activityLogDto, ActivityLog.class));
    }
}
