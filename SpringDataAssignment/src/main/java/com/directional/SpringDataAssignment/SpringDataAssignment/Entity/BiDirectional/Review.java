package com.directional.SpringDataAssignment.SpringDataAssignment.Entity.BiDirectional;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String comment;

    @ManyToOne
    public Product product;

    @ManyToOne
    public User user;

}
