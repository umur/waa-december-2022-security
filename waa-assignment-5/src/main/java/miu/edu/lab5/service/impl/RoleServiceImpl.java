package miu.edu.lab5.service.impl;


import miu.edu.lab5.entity.Role;
import miu.edu.lab5.repository.RoleRepo;
import miu.edu.lab5.service.RoleService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepo roleRepo;

    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public Role getById(int id) {
        Role role= roleRepo.findById(id).get();
        return role;
    }

    @Override
    public List<Role> getAll() {
        List<Role> list = (List<Role>) roleRepo.findAll();
        return list;
    }

    @Override
    public void save(Role role) {
        roleRepo.save(role);
    }

    @Override
    public void update(int id, Role role) {
        Role oldRole = roleRepo.findById(id).get();
        roleRepo.delete(oldRole);
        role.setId(id);
        roleRepo.save(role);
    }

    @Override
    public void delete(int id) {
        roleRepo.deleteById(id);
    }
}

