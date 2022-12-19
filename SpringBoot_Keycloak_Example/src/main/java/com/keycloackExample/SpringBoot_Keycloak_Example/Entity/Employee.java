package com.keycloackExample.SpringBoot_Keycloak_Example.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {
    @Id
    private Long employee_Id;
    private String fullname;
    private String title;
    private double salary;


}
