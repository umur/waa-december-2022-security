package edu.miu.mae.dto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ActivityLogDto {

    private int id;
    private LocalDateTime date;
    private String operation;
    private long duration;
}
