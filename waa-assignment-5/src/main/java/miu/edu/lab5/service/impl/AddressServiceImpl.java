package miu.edu.lab5.service.impl;

import miu.edu.lab5.entity.Address;
import miu.edu.lab5.repository.AddressRepo;
import miu.edu.lab5.service.AddressService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepo addressRepo;

    public AddressServiceImpl(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    @Override
    public Address getById(int id) {
        Address address= addressRepo.findById(id).get();
        return address;
    }

    @Override
    public List<Address> getAll() {
        List<Address> list = (List<Address>) addressRepo.findAll();
        return list;
    }

    @Override
    public void save(Address address) {
        addressRepo.save(address);
    }

    @Override
    public void update(int id, Address address) {
        Address Address = addressRepo.findById(id).get();
        addressRepo.delete(Address);
        address.setId(id);
        addressRepo.save(address);
    }

    @Override
    public void delete(int id) {
        addressRepo.deleteById(id);
    }
}
