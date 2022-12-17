package edu.miu.mae.entity;


import lombok.Data;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    private double price;
    @OneToMany(mappedBy = "productCategory")
//    @JoinColumn(name="id_category")
    private List<Product> productList;
}
