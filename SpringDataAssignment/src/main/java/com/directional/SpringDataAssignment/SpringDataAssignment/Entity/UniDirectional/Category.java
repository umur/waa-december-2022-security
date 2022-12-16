package com.directional.SpringDataAssignment.SpringDataAssignment.Entity.UniDirectional;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JoinColumn(name="category_Id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Product> product;
}
