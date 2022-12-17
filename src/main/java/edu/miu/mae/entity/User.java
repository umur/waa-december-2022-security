package edu.miu.mae.entity;

import lombok.Data;

import javax.persistence.*;
import  java.util.*;

//@Entit
@Data
@Entity(name="hw_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "user")
    private List<Review> listReviews;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> roles;

    @OneToMany(mappedBy = "user")
    private Set<UserOffensiveWords>
            userOffensiveWords = new HashSet<>();


    public User(String email, String encode, String firstName, String lastName, Address address) {
        this.email = email;
        this.password = encode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

}
