package com.example.lab3springdata.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
public class Product implements Serializable {
    @Id
    private int id;
    private String name;
    private int price;
    private int rating;

    @ManyToOne
    @JsonIgnoreProperties("products")
    private Category category;


    @OneToMany(mappedBy = "product",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    //@JsonManagedReference
   //@JsonBackReference
    @JsonIgnoreProperties("product")
     private List<Review> reviews;


}
