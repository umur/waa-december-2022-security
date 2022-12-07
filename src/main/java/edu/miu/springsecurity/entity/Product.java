package edu.miu.springsecurity.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Product {
    @Id
    private int id;

    private String name;
    private double price;
    private int rating;

    //A Category can have many Products
    //A Product can belong to only one Category.
    @ManyToOne(cascade = CascadeType.MERGE)
    private Category category;

    //A Product can have many Reviews
    @OneToMany(mappedBy = "product", cascade = CascadeType.MERGE)
    private List<Review> reviews;
}
