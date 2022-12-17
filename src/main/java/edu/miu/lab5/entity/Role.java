package edu.miu.lab5.entity;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name = "roles")

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

}
