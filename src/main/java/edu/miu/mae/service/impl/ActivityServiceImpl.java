package edu.miu.mae.service.impl;

import edu.miu.mae.dto.ActivityLogDto;
import edu.miu.mae.entity.ActivityLog;
import edu.miu.mae.repository.ActivityRepository;
import edu.miu.mae.repository.CategoryRepository;
import edu.miu.mae.service.ActivityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void save(ActivityLogDto ad) {
        ActivityLog map = modelMapper.map(ad, ActivityLog.class);

        System.out.println(map.toString());
        activityRepository.save(map);
    }

    @Override
    public ActivityLogDto getById(int id) {
        ActivityLog activityLog = activityRepository.findById(id).stream().findFirst().get();
        return modelMapper.map(activityLog,ActivityLogDto.class);
    }

    @Override
    public void update(ActivityLogDto ad, int id) {
        if(id!=ad.getId()){
            delete(id);
        }
       activityRepository.save( modelMapper.map(ad,ActivityLog.class));


    }

    @Override
    public void delete(int id) {
        activityRepository.deleteById(id);
    }

    @Override
    public List<ActivityLogDto> getAll() {
        return null;
    }
}
