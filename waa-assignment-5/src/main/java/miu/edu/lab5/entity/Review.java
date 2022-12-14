package miu.edu.lab5.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Review {

    @Id
    private int id;
    private String comment;

    @JsonIgnore
    @OneToMany(mappedBy = "reviews")
    private List<Product> product;

     @JsonIgnore
    @ManyToOne
    private User user;

}
