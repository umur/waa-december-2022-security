package com.directional.SpringDataAssignment.SpringDataAssignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Persons {
    public int id;
    public String firstname;
    public String lastname;
    public String email;
    public String age;


}
