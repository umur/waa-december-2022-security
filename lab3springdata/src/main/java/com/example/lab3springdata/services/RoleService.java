package com.example.lab3springdata.services;



import com.example.lab3springdata.dto.roleDto.RoleBasicDto;

import java.util.List;

public interface RoleService {
    RoleBasicDto getById(int id);
    List<RoleBasicDto>  getAll();
    void save(RoleBasicDto role);
    void update(int id, RoleBasicDto role);
    void delete(int id);

}
