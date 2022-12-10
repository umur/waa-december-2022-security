package edu.miu.labthree.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SignInRequest {
    private String email;
    private String password;
}
