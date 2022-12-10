package edu.miu.labthree.entity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
@Entity
@Data
@Table(name = "Categories")
public class Category {
    @Id
    private int id;
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> productsList;
}
