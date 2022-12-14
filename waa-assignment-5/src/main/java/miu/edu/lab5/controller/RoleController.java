package miu.edu.lab5.controller;

import miu.edu.lab5.entity.Role;
import miu.edu.lab5.service.impl.RoleServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleServiceImpl roleService;

    public RoleController(RoleServiceImpl roleService) {

        this.roleService = roleService;
    }

    @GetMapping
    public List<Role> getAll(){

        return roleService.getAll();
    }
    @GetMapping("/{id}")
    public Role getById(@PathVariable int id){
        return roleService.getById(id);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Role role){
        roleService.update(id,role);
    }
    @PostMapping
    public void create(@RequestBody Role role){
        roleService.save(role);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        roleService.delete(id);
        return "deleted";
    }

}
