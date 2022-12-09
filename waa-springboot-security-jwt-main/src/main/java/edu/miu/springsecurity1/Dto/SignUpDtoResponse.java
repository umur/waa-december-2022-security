package edu.miu.springsecurity1.Dto;
import edu.miu.springsecurity1.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDtoResponse {
    private User user;
}
