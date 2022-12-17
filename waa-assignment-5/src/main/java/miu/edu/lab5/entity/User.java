package miu.edu.lab5.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "people")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)

    private List<Review> reviews;

//    @OneToOne
//    private Address address;

    @ManyToMany(mappedBy = "users")
    private List <Role> roles;
//    public List<Role> getRoles() {
//        return  null;}

}
