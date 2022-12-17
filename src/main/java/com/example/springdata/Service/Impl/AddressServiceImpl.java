package com.example.springdata.Service.Impl;


import com.example.springdata.Entity.Address;
import com.example.springdata.Repository.AddressRepo;
import com.example.springdata.Service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    public final AddressRepo addressRepo;

    @Override
    public void saveOrUpdate(Address address) {
        addressRepo.save(address);
    }

    @Override
    public void delete(Integer id) {
        addressRepo.deleteById(id);
    }

    @Override
    public Address get(Integer id) {
       return addressRepo.findById(id).get();
    }

    @Override
    public List<Address> getAll() {
        var result = new ArrayList<Address>();
        addressRepo.findAll().forEach(result::add);
        return  result;
    }
}
