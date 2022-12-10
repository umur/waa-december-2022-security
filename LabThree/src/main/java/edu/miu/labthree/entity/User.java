package edu.miu.labthree.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @ElementCollection
    private List<Roles> roles;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Address address;

    @OneToMany(mappedBy = "user")
    private List<Review> reviewList;
}
