package edu.miu.springsecurity1.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDtoResponse {
    private String accessToken;
    private String refreshToken;
}
