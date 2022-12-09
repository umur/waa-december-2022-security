package com.miu.springsecurity.entity;

import javax.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="users")
public class User {
    @Id
    private int id;

    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @OneToOne
    private Address address;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> roles;
}
