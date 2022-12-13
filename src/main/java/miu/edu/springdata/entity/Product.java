package miu.edu.springdata.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Data
@Entity
@RequiredArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private double rating;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    @JsonManagedReference("product")
    private List<Review> reviews;
//    @JsonIgnore
    @ManyToOne
//    @JsonManagedReference("product")
    private Category category;


    @JsonIgnore
    @JsonManagedReference("product")
    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;

}
