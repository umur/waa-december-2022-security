package com.example.lab3springdata.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="users")
@Data
public class User implements Serializable {
    @Id
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastname;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private List<Review> reviews;

    @OneToOne
    @JsonIgnoreProperties("user")
    private Address address;
}
