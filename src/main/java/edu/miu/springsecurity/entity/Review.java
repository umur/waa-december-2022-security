package edu.miu.springsecurity.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Review {
    @Id
    private int id;

    private String comment;

    //A Review can only belong to one Product.
    @ManyToOne
    private Product product;

    //A Review can only belong to one User.
    @ManyToOne(cascade = CascadeType.MERGE)
    private User user;
}
