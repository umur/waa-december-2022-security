package miu.edu.springdata.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String zip;
    @Column(nullable = false)
    private String city;

    @OneToOne
    private User user;
}
