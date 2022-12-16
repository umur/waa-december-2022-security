package com.directional.SpringDataAssignment.SpringDataAssignment.Entity.BiDirectional;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class AddressId implements Serializable {
    private String zip;
    private String city;
}
