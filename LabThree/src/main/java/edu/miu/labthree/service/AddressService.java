package edu.miu.labthree.service;

import edu.miu.labthree.dto.AddressDto;
import edu.miu.labthree.entity.Address;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AddressService{

    void save (AddressDto addressDto);
    List<AddressDto> getAll ();
    void delete (int id);
    AddressDto getById (int id);



}
