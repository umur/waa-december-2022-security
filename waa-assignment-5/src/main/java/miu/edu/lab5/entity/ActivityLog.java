package miu.edu.lab5.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Data
public class ActivityLog {

    @Id
    private long id;
    private LocalDate date;
    private String operation;
    private long duration;
}
