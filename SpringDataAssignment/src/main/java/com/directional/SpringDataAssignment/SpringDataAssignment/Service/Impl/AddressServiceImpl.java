package com.directional.SpringDataAssignment.SpringDataAssignment.Service.Impl;

import com.directional.SpringDataAssignment.SpringDataAssignment.Entity.BiDirectional.Address;
import com.directional.SpringDataAssignment.SpringDataAssignment.Repository.AddressRepo;
import com.directional.SpringDataAssignment.SpringDataAssignment.Service.AddressService;
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
    public void delete(Long id) {
        addressRepo.deleteById(id);
    }

    @Override
    public Address get(Long id) {
       var item = addressRepo.findById(id).get();
       return item;
    }

    @Override
    public List<Address> getAll() {
        var result = new ArrayList<Address>();
        addressRepo.findAll().forEach(result::add);
        return  result;
    }
}
