package edu.miu.mae.model;

import edu.miu.mae.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToOne;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {
    private String email;
    private String password;

    private Set<String> role;

    private String firstName;

    private String lastName;

    @OneToOne
    private Address address;

}
