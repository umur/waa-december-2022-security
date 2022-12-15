package edu.miu.codebase.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

//    @Embedded
//    private CommonColumns commonColumns;

    @JsonBackReference
    @OneToMany(mappedBy = "category")
    private List<Product> products;

}
