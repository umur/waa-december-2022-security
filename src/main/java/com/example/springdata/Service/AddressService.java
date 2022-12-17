package com.example.springdata.Service;



import com.example.springdata.Entity.Address;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AddressService {
    public void saveOrUpdate(Address address);
    public void delete(Integer id);
    public Address get(Integer id);
    public List<Address> getAll();
}
