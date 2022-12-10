package edu.miu.springsecurity.service;

import edu.miu.springsecurity.dto.AddressDto;

public interface AddressService {
    Iterable<AddressDto> getAll();
    AddressDto getById(int id);
    void save(AddressDto address);
    void update(int id, AddressDto address);
    void delete(int id);
}

