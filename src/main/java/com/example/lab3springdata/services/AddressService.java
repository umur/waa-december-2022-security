package com.example.lab3springdata.services;

import com.example.lab3springdata.dto.addressDto.AddressBasicDto;
import com.example.lab3springdata.entity.Address;

import java.util.List;

public interface AddressService {
    AddressBasicDto getById(int id);
    List<AddressBasicDto>  getAll();
    void save(AddressBasicDto address);
    void update(int id, AddressBasicDto address);
    void delete(int id);

}
