package miu.edu.lab5.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Review {

    @Id
    private int id;
    private String comment;

    @JsonIgnore
    @OneToMany(mappedBy = "reviews", cascade = CascadeType.ALL)
    private List<Product> product;

     @JsonIgnore
    @ManyToOne
    private User user;

}
