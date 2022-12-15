package edu.miu.codebase.controller;

import edu.miu.codebase.aspect.executionTime.ExecutionTime;
import edu.miu.codebase.entity.ActivityLog;
import edu.miu.codebase.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/admin/activitylogs")
@CrossOrigin(origins = "http://localhost:3000")
public class ActivityLogController {

    private final ActivityLogService activityLogService;

    @ExecutionTime
    @GetMapping
    public List<ActivityLog> getAll() {
        return activityLogService.getAll();
    }

    @ExecutionTime
    @GetMapping("/filterByDate")
    public List<ActivityLog> filterByDate(@RequestParam LocalDate date) {
        return activityLogService.findAllByDate(date);
    }

    @ExecutionTime
    @GetMapping("/filterByDurationGreaterThan")
    public List<ActivityLog> findAllByDurationGreaterThan(@RequestParam Long duration) {
        return activityLogService.findAllByDurationGreaterThan(duration);
    }

}
