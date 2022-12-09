package com.w1d3.springdata.service.impl;

import com.w1d3.springdata.entity.Role;
import com.w1d3.springdata.repository.RoleRepo;
import com.w1d3.springdata.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepo roleRepo;



    @Override
    public List<Role> findByRole(String role) {
        return roleRepo.findByRole("USER");

    }


}
