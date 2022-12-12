package miu.edu.lab5.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Address {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private int zip;
    private String city;

    @OneToOne
    private User user;
}
