package miu.edu.springdata.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;

    @JoinColumn(name="user_id")
    @JsonBackReference
    @OneToMany
    private List<Review> reviews;


    @JsonBackReference
    @OneToOne(mappedBy = "user")
    private Product products;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> roles;
}
