package edu.miu.mae.controller;

import edu.miu.mae.dto.AddressDto;
import edu.miu.mae.entity.Address;
import edu.miu.mae.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/address")
@RestController
public class AddressController extends BaseController<Address, AddressDto> {

    @Autowired
    public AddressController( AddressService as){
        this.bs = as;
    }
}
