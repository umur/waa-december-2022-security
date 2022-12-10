package edu.miu.springsecurity.service.impl;

import edu.miu.springsecurity.dto.AddressDto;
import edu.miu.springsecurity.entity.Address;
import edu.miu.springsecurity.repository.AddressRepo;
import edu.miu.springsecurity.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class AddressServiceImpl implements AddressService {
    private final AddressRepo addressRepo;
    private final ModelMapper modelMapper;
    @Override
    public Iterable<AddressDto> getAll() {
        List<AddressDto> list = new ArrayList<>();
        var address = addressRepo.findAll();
        address.forEach(p -> list.add(modelMapper.map(p, AddressDto.class)));
        return list;
    }

    @Override
    public AddressDto getById(int id) {
        return modelMapper.map(addressRepo.findById(id).get(), AddressDto.class);
    }

    @Override
    public void save(AddressDto address) {
        addressRepo.save(modelMapper.map(address, Address.class));
    }

    @Override
    public void update(int id, AddressDto address) {
        addressRepo.save(modelMapper.map(address, Address.class));
    }

    @Override
    public void delete(int id) {
        addressRepo.deleteById(id);
    }
}
