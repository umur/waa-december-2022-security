package com.keycloackExample.SpringBoot_Keycloak_Example.Repository;

import com.keycloackExample.SpringBoot_Keycloak_Example.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    List<Employee> findAll();

    @Override
    <S extends Employee> S save(S entity);
}
