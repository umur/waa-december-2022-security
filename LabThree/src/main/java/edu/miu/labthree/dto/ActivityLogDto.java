package edu.miu.labthree.dto;

import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ActivityLogDto {
    private int id;
    private LocalDate date;
    private String operation;
    private double duration;
}
