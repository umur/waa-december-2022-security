package miu.edu.springdata.service;

import miu.edu.springdata.dto.AddressDto;
import miu.edu.springdata.entity.Address;

import java.util.List;

public interface AddressService {
    void save(Address address);
    List<AddressDto> findAll();
    AddressDto findById(int id);
    void deleteById(int id);
}
