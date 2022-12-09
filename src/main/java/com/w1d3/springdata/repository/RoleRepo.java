package com.w1d3.springdata.repository;

import com.w1d3.springdata.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepo extends CrudRepository<Role,Integer> {
    List<Role> findByRole(String role);

}
