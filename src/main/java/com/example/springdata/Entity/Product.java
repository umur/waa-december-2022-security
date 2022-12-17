package com.example.springdata.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private float price;
    private int rating;
    @OneToMany
    @JoinColumn(name="product_id")
    private List<Review> review;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

}
