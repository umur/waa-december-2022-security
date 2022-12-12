package com.example.lab6.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Category {
    @Id
    private int id;
    private String name;
    @OneToMany
    List<Product> products;
}
