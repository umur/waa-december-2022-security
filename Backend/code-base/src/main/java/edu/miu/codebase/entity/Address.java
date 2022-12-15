package edu.miu.codebase.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private String zip;
    private String city;

//    @Embedded
//    private CommonColumns commonColumns;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
