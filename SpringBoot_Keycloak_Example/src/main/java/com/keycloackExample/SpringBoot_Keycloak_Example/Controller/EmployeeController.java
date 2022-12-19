package com.keycloackExample.SpringBoot_Keycloak_Example.Controller;


import com.keycloackExample.SpringBoot_Keycloak_Example.Entity.Employee;
import com.keycloackExample.SpringBoot_Keycloak_Example.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class EmployeeController {
    @Autowired
   private  EmployeeRepository employeeRepository;

    @GetMapping("/admin/employees")
    List<Employee> findAll(){
        return employeeRepository.findAll();
    }
}
