package com.example.lab3springdata.services.impl;

import com.example.lab3springdata.dto.roleDto.RoleBasicDto;
import com.example.lab3springdata.entity.Role;
import com.example.lab3springdata.repository.RoleRepo;
import com.example.lab3springdata.services.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepo roleRepo;
    private final ModelMapper modelMapper;

    public RoleServiceImpl(RoleRepo roleRepo, ModelMapper modelMapper) {
        this.roleRepo = roleRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public RoleBasicDto getById(int id) {
        Role role= roleRepo.findById(id).get();
        return modelMapper.map(role,RoleBasicDto.class);
    }

    @Override
    public List<RoleBasicDto> getAll() {
        List<Role> roleList = (List<Role>) roleRepo.findAll();
        return roleList
                .stream()
                .map(
                        role->modelMapper
                                .map(role,RoleBasicDto.class))
                .toList();
    }

    @Override
    public void save(RoleBasicDto roleDto) {
        Role role = modelMapper.map(roleDto,Role.class);
        roleRepo.save(role);
    }

    @Override
    public void update(int id, RoleBasicDto roleDto) {

        Role role = modelMapper.map(roleDto,Role.class);

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
