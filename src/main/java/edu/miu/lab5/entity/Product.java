package edu.miu.lab5.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import lombok.ToString;

@Entity
@Table(name = "products")
@Data
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private double price;


    @ManyToOne
    @JsonBackReference
    private User user;

}
