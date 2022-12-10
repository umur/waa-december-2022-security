package edu.miu.labthree.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignInResponse {
    private String accessToken;
    private String refreshToken;
}
