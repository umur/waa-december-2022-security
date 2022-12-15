package com.example.springdata.model;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignUpRequest {
    private String email;
    private String password;
}
