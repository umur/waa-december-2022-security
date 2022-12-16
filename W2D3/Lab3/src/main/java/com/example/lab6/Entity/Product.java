package com.example.lab6.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Product {
    @Id
    private int id;
    private String name;
    private String rating;
    @OneToOne
    private Category category;
   @OneToMany(mappedBy = "prodReview")
    List<Review>reviews;

}
