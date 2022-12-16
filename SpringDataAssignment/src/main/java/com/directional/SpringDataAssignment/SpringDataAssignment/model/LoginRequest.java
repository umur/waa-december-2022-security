package com.directional.SpringDataAssignment.SpringDataAssignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginRequest {
    public String email;
    public String password;
}
