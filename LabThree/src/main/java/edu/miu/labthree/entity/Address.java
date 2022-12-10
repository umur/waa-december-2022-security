package edu.miu.labthree.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "addresses")
public class Address {
    @Id
    private int id;
    private String street;
    private String city;
    private int zip;



}
