package edu.miu.codebase.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AddressDto {
    private int id;
    private String street;
    private String zip;
    private String city;
}
