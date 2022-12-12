package miu.edu.lab5.repository;


import miu.edu.lab5.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo  extends CrudRepository<Address, Integer> {
}
