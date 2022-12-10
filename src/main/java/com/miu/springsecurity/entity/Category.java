package com.miu.springsecurity.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="categories")
public class Category {
    @Id
    private int id;

    private String name;

    @OneToMany(mappedBy="category")
    @JsonManagedReference
    private List<Product> products;
}
