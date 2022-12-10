package edu.miu.labthree.repository;

import edu.miu.labthree.entity.Address;
import edu.miu.labthree.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepo extends CrudRepository<Address,Integer > {

}
