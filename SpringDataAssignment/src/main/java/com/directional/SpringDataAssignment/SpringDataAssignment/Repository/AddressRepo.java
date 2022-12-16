package com.directional.SpringDataAssignment.SpringDataAssignment.Repository;


import com.directional.SpringDataAssignment.SpringDataAssignment.Entity.BiDirectional.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends CrudRepository<Address,Long> {

}
