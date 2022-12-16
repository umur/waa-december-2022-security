package com.directional.SpringDataAssignment.SpringDataAssignment.Entity.UniDirectional;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private double rating;

    @JoinColumn(name = "product_id")
    @OneToMany
    List<Review> review;

}
