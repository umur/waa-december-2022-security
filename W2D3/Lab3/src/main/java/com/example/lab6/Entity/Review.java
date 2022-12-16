package com.example.lab6.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Review {
    @Id
    private int id;
    private String comment;

    @ManyToOne
    Product prodReview;
    @OneToOne
     User userReview;


}
