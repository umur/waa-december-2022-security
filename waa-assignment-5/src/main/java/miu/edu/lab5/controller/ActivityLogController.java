package miu.edu.lab5.controller;

import miu.edu.lab5.aspect.annotation.ExecutionTime;
import miu.edu.lab5.dto.ActivityLogDTO;
import miu.edu.lab5.entity.ActivityLog;
import miu.edu.lab5.service.impl.ActivityLogServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("logs")
public class ActivityLogController {

    @Autowired
    private ModelMapper modelMapper;
    private ActivityLogServiceImpl activityLogService;

    public ActivityLogController(ActivityLogServiceImpl activityLogService){
        this.activityLogService= activityLogService;
    }

    @ExecutionTime
    @GetMapping
    public ActivityLog getAll(){
        //System.out.println("Hello I am Checking in");
        for(int i =0; i<222222222; i++){

        }
        return null;
    }

    @GetMapping("/{id}")
    public ActivityLog getById(@PathVariable int id){
        //System.out.println("Hello I am Checking in");
        return null;
    }
    @PostMapping
    public ActivityLogDTO addActivity(){

        System.out.println("hey GILBERT i just run after aspect.");
        ActivityLog activityLog = new ActivityLog();
        return this.toDTO(activityLogService.save(activityLog));
    }
    public ActivityLogDTO toDTO(ActivityLog activityLog){
        return modelMapper.map(activityLog, ActivityLogDTO.class);
    }



}
