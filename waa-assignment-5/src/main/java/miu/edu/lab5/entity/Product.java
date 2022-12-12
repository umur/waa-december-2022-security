package miu.edu.lab5.entity;


import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Product {
    @Id
    private int id;
    private String name;
    private double salary;
    private int rating;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Review reviews;

}
