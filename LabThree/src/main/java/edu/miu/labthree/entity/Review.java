package edu.miu.labthree.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "reviews")
public class Review {
    @Id
    private int id;
    private int comment;

    @ManyToOne
    private Product product;
    @ManyToOne
    private User user;




}
