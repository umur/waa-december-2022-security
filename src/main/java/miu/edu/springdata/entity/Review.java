package miu.edu.springdata.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String comment;

    @ManyToOne
    @JsonBackReference("product")
    private Product product;
}
