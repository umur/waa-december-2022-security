package edu.miu.springsecurity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
public class AddressDto {
    private int id;
    private String street;
    private int zip;
    private String city;

    @JsonIgnoreProperties("address")
    private UserDto user;
}
