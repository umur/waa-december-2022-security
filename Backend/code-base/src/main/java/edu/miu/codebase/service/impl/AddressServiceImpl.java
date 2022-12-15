package edu.miu.codebase.service.impl;

import edu.miu.codebase.dto.AddressDto;
import edu.miu.codebase.entity.Address;
import edu.miu.codebase.repository.AddressRepo;
import edu.miu.codebase.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepo addressRepo;

    public final ModelMapper modelMapper;

    @Override
    public AddressDto create(AddressDto addressDto) {
        return modelMapper.map(addressRepo.save(modelMapper.map(addressDto, Address.class)), AddressDto.class);
    }

    @Override
    public AddressDto update(int addressId, AddressDto addressDto) {
        Address address = modelMapper.map(addressDto, Address.class);
        address = addressRepo.save(address);
        return modelMapper.map(address, AddressDto.class);
    }

    @Override
    public void delete(int addressId) {
        Address address = addressRepo.findById(addressId).orElseThrow(() -> new RuntimeException("Address not found"));
        addressRepo.delete(address);
    }

    ///////////////////////// GET Methods /////////////////////////

    @Override
    public List<AddressDto> getAll() {
        return addressRepo.findAll().stream()
                .map(address -> modelMapper.map(address, AddressDto.class))
                .toList();
    }

    @Override
    public AddressDto getById(int addressId) {
        return modelMapper.map(addressRepo.findById(addressId).orElseThrow(() -> new RuntimeException("Address not found")), AddressDto.class);
    }
}
