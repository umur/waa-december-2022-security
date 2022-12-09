package com.miu.springsecurity.service.impl;

import com.miu.springsecurity.dto.AddressDto;
import com.miu.springsecurity.entity.Address;
import com.miu.springsecurity.repository.AddressRepo;
import com.miu.springsecurity.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Service
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AddressServiceImpl implements AddressService {

    private final AddressRepo addressRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<AddressDto> findAll() {
        return addressRepo.findAll().stream().map(a -> modelMapper.map(a, AddressDto.class)).toList();
    }

    @Override
    public AddressDto findById(int id) {
        return addressRepo.findById(id).map(a -> modelMapper.map(a, AddressDto.class)).get();
    }

    @Override
    public void save(AddressDto addressDto) {
        Address address = modelMapper.map(addressDto, Address.class);
        addressRepo.save(address);
    }

    @Override
    public void update(int id, AddressDto addressDto) {
        addressRepo.findById(id).orElseThrow(() -> new RuntimeException("Address not found."));
        Address address = modelMapper.map(addressDto, Address.class);
        addressRepo.save(address);
    }

    @Override
    public void delete(int id) {
        Address address = addressRepo.findById(id).orElseThrow(() -> new RuntimeException("Address not found."));
        addressRepo.delete(address);
    }
}
