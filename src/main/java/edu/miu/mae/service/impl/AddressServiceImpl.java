package edu.miu.mae.service.impl;

import edu.miu.mae.StreamUtils;
import edu.miu.mae.dto.AddressDto;
import edu.miu.mae.entity.Address;
import edu.miu.mae.repository.AddressRepository;
import edu.miu.mae.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    @Override
    public void save(AddressDto ad) {
        addressRepository.save(  modelMapper.map(ad,Address.class));
    }

    @Override
    public AddressDto getById(int id) {
        return  modelMapper.map(addressRepository.findById(id).get(),AddressDto.class);
    }

    @Override
    public void update(AddressDto ad, int id) {
        Address map = modelMapper.map(ad, Address.class);
        if(id!=map.getId()){
            addressRepository.deleteById(id);
        }
        addressRepository.save(map);
    }

    @Override
    public void delete(int id) {
        addressRepository.deleteById(id);
    }

    @Override
    public List<AddressDto> getAll() {
       return  StreamUtils.asStream(addressRepository.findAll()).map(x->
            modelMapper.map(x,AddressDto.class))
                .collect(Collectors.toList());

    }

}
