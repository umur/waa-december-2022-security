package com.example.lab3springdata.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import lombok.Data;

import java.io.Serializable;


@Entity
@Data
public class Address implements Serializable {
    @Id
    private int id;
    private String street;
    private int zip;
    private String city;

    @OneToOne (mappedBy = "address")
    @JsonIgnoreProperties("address")
    private User user;

}
