package com.directional.SpringDataAssignment.SpringDataAssignment.Entity.BiDirectional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Address {

//    @EmbeddedId
//    private AddressId id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    private String zip;
    private String city;

    private String street;

    @OneToOne
    @JsonIgnore
    public User user;
}
