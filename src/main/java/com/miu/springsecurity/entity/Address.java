package com.miu.springsecurity.entity;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="addresses")
public class Address {
    @Id
    private int id;

    private String street;
    private int zip;
    private String city;
}
