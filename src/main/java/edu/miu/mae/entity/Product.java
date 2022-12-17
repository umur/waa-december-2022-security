package edu.miu.mae.entity;

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
    private double rating;

    @Column(name="created_by_user_email")
    private String createdByUserEmail;

    @OneToMany(mappedBy = "product")
    private List<Review> reviewsList;


    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category productCategory;



}