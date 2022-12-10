package com.miu.springsecurity.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="reviews")
public class Review {
    @Id
    private int id;
    private String comment;

    @ManyToOne
//    @JoinTable(name = "product_reviews",
//            inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")},
//            joinColumns = {@JoinColumn(name = "review_id", referencedColumnName = "id")}
//    )
    @JsonBackReference
    private Product product;

    @ManyToOne
    private User user;
}
