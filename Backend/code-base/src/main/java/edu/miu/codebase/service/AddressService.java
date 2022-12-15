package edu.miu.codebase.service;

import edu.miu.codebase.dto.AddressDto;
import edu.miu.codebase.entity.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {

    AddressDto create(AddressDto addressDto);

    AddressDto update(int addressId, AddressDto addressDto);

    void delete(int addressId);

    ///////////////////////// GET Methods /////////////////////////

    List<AddressDto> getAll();

    AddressDto getById(int addressId);

}
