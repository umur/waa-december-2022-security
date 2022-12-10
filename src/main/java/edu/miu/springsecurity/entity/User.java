package edu.miu.springsecurity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "Users")
public class User {
    @Id
    private int id;

    private String email;
    private String password;
    private String firstName;
    private String lastName;

    //User can have only one Address.
    @OneToOne(cascade = CascadeType.MERGE)
    private Address address;

    //User can create many Reviews
    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> roles;

    @JsonIgnore
    @OneToMany
    private List<RequestPerUser> requests;
}
