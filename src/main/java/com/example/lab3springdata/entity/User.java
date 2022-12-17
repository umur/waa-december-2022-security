package com.example.lab3springdata.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
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
    private String lastName;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private List<Review> reviews;

    @OneToOne
    @JsonIgnoreProperties("user")
    private Address address;

    @ManyToMany(mappedBy="users")

    private List<Role> roles;
}
