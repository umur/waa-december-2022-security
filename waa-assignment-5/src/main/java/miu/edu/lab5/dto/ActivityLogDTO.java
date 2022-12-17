package miu.edu.lab5.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ActivityLogDTO {
    private long id;
    private LocalDate date;
    private String operation;
    private long duration;
}
