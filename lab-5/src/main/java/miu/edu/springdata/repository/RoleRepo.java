package miu.edu.springdata.repository;

import miu.edu.springdata.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepo extends CrudRepository<Role, Integer> {
    List<Role> findByRole(String role);
}
