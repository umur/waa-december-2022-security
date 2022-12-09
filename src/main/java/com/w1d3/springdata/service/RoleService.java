package com.w1d3.springdata.service;

import com.w1d3.springdata.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> findByRole(String role);

}
