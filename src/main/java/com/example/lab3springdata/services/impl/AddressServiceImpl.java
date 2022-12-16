package com.example.lab3springdata.services.impl;

import com.example.lab3springdata.dto.addressDto.AddressBasicDto;
import com.example.lab3springdata.entity.Address;
import com.example.lab3springdata.repository.AddressRepo;
import com.example.lab3springdata.services.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepo addressRepo;
    private final ModelMapper modelMapper;

    public AddressServiceImpl(AddressRepo addressRepo, ModelMapper modelMapper) {
        this.addressRepo = addressRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public AddressBasicDto getById(int id) {
        Address address= addressRepo.findById(id).get();
        return modelMapper.map(address,AddressBasicDto.class);
    }

    @Override
    public List<AddressBasicDto> getAll() {
        List<Address> addressList = (List<Address>) addressRepo.findAll();
        return addressList
                .stream()
                .map(
                        address->modelMapper
                                .map(address,AddressBasicDto.class))
                .toList();
    }

    @Override
    public void save(AddressBasicDto addressDto) {
        Address address = modelMapper.map(addressDto,Address.class);
        addressRepo.save(address);
    }

    @Override
    public void update(int id, AddressBasicDto addressDto) {

       Address address = modelMapper.map(addressDto,Address.class);

       Address oldAddress = addressRepo.findById(id).get();
       addressRepo.delete(oldAddress);
       address.setId(id);
       addressRepo.save(address);
    }

    @Override
    public void delete(int id) {
        addressRepo.deleteById(id);
    }
}
