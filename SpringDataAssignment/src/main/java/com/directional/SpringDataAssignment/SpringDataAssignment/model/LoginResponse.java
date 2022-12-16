package com.directional.SpringDataAssignment.SpringDataAssignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    public String accessToken;
    public String refreshToken;
}
