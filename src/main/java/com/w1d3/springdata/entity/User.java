package com.w1d3.springdata.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    @OneToMany
            @JoinColumn(name = "userId")
    List<Review> reviews;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    List<Role> roles;

}
