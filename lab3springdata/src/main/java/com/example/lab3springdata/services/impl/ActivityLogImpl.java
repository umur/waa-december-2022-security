package com.example.lab3springdata.services.impl;

import com.example.lab3springdata.dto.addressDto.AddressBasicDto;
import com.example.lab3springdata.entity.ActivityLog;
import com.example.lab3springdata.entity.Address;
import com.example.lab3springdata.repository.ActivityLogRepo;
import com.example.lab3springdata.repository.AddressRepo;
import com.example.lab3springdata.services.ActivityLogService;
import com.example.lab3springdata.services.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityLogImpl implements ActivityLogService {
    private final ActivityLogRepo activityLogRepo;

    public ActivityLogImpl(ActivityLogRepo activityLogRepo) {
        this.activityLogRepo = activityLogRepo;

    }


    @Override
    public void save(ActivityLog activityLog) {

        activityLogRepo.save(activityLog);
    }


}
