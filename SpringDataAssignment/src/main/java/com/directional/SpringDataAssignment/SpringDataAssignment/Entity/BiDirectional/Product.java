package com.directional.SpringDataAssignment.SpringDataAssignment.Entity.BiDirectional;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private double rating;


    @OneToMany(mappedBy = "product")
    @JsonIgnore
    List<Review> review;

    @ManyToOne
    public Category category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    public User user;

}
