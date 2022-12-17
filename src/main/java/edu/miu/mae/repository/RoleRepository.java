package edu.miu.mae.repository;

import edu.miu.mae.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role,Integer> {
    public Role findByRole(String roleName);
}
