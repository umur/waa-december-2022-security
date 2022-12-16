package com.directional.SpringDataAssignment.SpringDataAssignment.Entity.UniDirectional;

import lombok.Data;

import javax.persistence.*;

@Data

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String zip;
    private String city;

    @JoinColumn(name = "user_id")
    @OneToOne
    private User user;
}
