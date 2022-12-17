package edu.miu.mae.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Review {

    @Id
    private int id;
    private String comment;

    @ManyToOne
    private Product product;

    @ManyToOne
    private User user;

}
