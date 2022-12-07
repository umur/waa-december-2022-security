package edu.miu.springsecurity.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
public class Address {
    @Id
    private int id;

    private String street;
    private int zip;
    private String city;

    //An Address can belong to only one User.
    @OneToOne(mappedBy = "address")
    private User user;
}
