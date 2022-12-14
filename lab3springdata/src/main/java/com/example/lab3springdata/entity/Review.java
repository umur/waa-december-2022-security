package com.example.lab3springdata.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;

@Entity
@Data
public class Review implements Serializable {
    @Id
    private int id;
    private String comment;

    @ManyToOne
   // @JsonBackReference //ignores json
    //@JsonManagedReference
   // @JsonIgnoreProperties("reviews")
    private Product product;

    @ManyToOne
    @JsonIgnoreProperties("reviews")
    private User user;
}
