package com.w1d3.springdata.service;

import com.w1d3.springdata.dto.AddressDto;
import com.w1d3.springdata.entity.Address;

import java.util.List;

public interface AddressService {
    void save(Address address);
    List<AddressDto> findAll();
    AddressDto findById(int id);

    void deleteById(int id);
}
