package com.ujjwalhumagain.springsecurityassignment.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private float price;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToMany(mappedBy = "products")
    @JsonManagedReference
    private List<Category> categories;
}
