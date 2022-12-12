package miu.edu.lab5.dto;


import lombok.Data;
import miu.edu.lab5.entity.User;

@Data
public class AddressDTO {
    private int id;
    private String street;
    private int zip;
    private String city;
    private User user;
}
