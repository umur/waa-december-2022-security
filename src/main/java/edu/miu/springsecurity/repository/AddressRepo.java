package edu.miu.springsecurity.repository;

import edu.miu.springsecurity.entity.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepo extends CrudRepository<Address, Integer> {
}
