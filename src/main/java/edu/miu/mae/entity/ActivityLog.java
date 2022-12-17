package edu.miu.mae.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class ActivityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime date;
    private String operation;
    private long duration;

    @Override
    public String toString() {
        return "ActivityLog{" +
                "id=" + id +
                ", date=" + date +
                ", operation='" + operation + '\'' +
                ", duration=" + duration +
                '}';
    }
}