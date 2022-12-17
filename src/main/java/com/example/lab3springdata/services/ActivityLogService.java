package com.example.lab3springdata.services;

import com.example.lab3springdata.dto.addressDto.AddressBasicDto;
import com.example.lab3springdata.entity.ActivityLog;

import java.util.List;

public interface ActivityLogService {

    void save(ActivityLog activityLog);

}
