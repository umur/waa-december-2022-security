package com.example.springdata.Repository;

import com.example.springdata.Entity.Address;
import com.example.springdata.Entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends CrudRepository<Address,Integer> {
}
