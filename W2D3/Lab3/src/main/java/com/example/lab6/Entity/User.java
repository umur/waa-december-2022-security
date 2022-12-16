package com.example.lab6.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

import javax.management.relation.Role;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "user_table")
public class User {
    @Id
    private  int id;
    private VarcharJdbcType email;
    private VarcharJdbcType password;
    private String firstName;
    private String lastName;
    @OneToMany
    List<Review> reviews;

    @OneToOne
    private Address address;

    public List<Role> getRoles() {
        return null;
    }
}
