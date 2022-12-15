package edu.miu.codebase.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String comment;

//    @Embedded
//    private CommonColumns commonColumns;

    @JsonBackReference
    @ManyToOne
    private User user;

    @JsonBackReference
    @ManyToOne
    private Product product;

}
