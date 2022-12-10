package edu.miu.labthree.service.impl;

import edu.miu.labthree.dto.AddressDto;
import edu.miu.labthree.entity.Address;
import edu.miu.labthree.repository.AddressRepo;
import edu.miu.labthree.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public void save(AddressDto addressDto) {
        Address address = modelMapper.map(addressDto, Address.class);
        addressRepo.save(address);
    }

    @Override
    public List<AddressDto> getAll() {

         List<Address> addressList = (List<Address>) addressRepo.findAll().iterator();
        List<AddressDto> addressDto = addressList.stream().map(a->modelMapper.map(a,AddressDto.class)).toList();
         return addressDto;
    }

    @Override
    public void delete(int id) {
        addressRepo.deleteById(id);

    }

    @Override
    public AddressDto getById(int id) {
        Address a = addressRepo.findById(id).get();
        return modelMapper.map(a, AddressDto.class);
    }
}
