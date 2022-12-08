package edu.miu.springsecurity1.repository;

import edu.miu.springsecurity1.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository<Role, Integer> {
}
