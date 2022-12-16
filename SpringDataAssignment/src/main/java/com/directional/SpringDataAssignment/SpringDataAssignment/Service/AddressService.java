package com.directional.SpringDataAssignment.SpringDataAssignment.Service;


import com.directional.SpringDataAssignment.SpringDataAssignment.Entity.BiDirectional.Address;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AddressService {
    public void saveOrUpdate(Address address);
    public void delete(Long id);
    public Address get(Long id);
    public List<Address> getAll();
}
