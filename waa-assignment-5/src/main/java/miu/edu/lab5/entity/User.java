package miu.edu.lab5.entity;


import lombok.Data;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "people")
public class User {

    @Id
    private int id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    @OneToOne
    private Address address;

    public List<Role> getRoles() {
        return  null;
    }
}
