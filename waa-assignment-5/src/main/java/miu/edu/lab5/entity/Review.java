package miu.edu.lab5.entity;


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

    @OneToMany(mappedBy = "reviews")
    private List<Product> product;

    @ManyToOne
    private User user;

}
