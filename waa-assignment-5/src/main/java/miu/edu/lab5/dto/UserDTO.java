package miu.edu.lab5.dto;

import lombok.Data;
import miu.edu.lab5.entity.Address;
import miu.edu.lab5.entity.Review;

import java.util.List;

@Data
public class UserDTO {
    private int id;
    private String name;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private List<Review> reviews;
    private Address address;

}
