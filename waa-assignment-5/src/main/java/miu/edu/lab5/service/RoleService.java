package miu.edu.lab5.service;




import miu.edu.lab5.entity.Role;

import java.util.List;

public interface RoleService {

    Role getById(int id);
    List<Role> getAll();
    void save (Role role);
    void update(int id, Role role);
    void delete(int id);

}
