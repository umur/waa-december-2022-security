package com.miu.springsecurity.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="products")
public class Product {
    @Id
    private int id;

    private String name;
    private double price;
    private double rating;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private Category category;

    @OneToMany(mappedBy = "product")
    @JsonManagedReference
    private List<Review> reviews;
}
