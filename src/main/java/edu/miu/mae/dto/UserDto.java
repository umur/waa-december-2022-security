package edu.miu.mae.dto;

import edu.miu.mae.entity.Address;
import edu.miu.mae.entity.Review;
import lombok.Data;
import java.util.List;

@Data
public class UserDto {
    private int id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private Address address;

    private List<ReviewDto> listReviews;

    public UserDto(String email, String encode, String firstName, String lastName, Address address) {
        this.email = email;
        this.password = encode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }
}
