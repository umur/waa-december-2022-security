package com.example.lab3springdata.controllers;

import com.example.lab3springdata.dto.roleDto.RoleBasicDto;
import com.example.lab3springdata.entity.Role;
import com.example.lab3springdata.services.impl.RoleServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/roles")
@RestController
@CrossOrigin
public class RoleController {
    private final RoleServiceImpl roleService;

    public RoleController(RoleServiceImpl roleService) {

        this.roleService = roleService;
    }

    @GetMapping
    public List<RoleBasicDto> getAll(){

        return roleService.getAll();
    }
    @GetMapping("/{id}")
    public RoleBasicDto getById(@PathVariable int id){
        return roleService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody RoleBasicDto roleDto){
        roleService.save(roleDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody RoleBasicDto roleDto){
        roleService.update(id,roleDto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        roleService.delete(id);
        return "deleted";
    }



}
