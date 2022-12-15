package com.example.springdata.Controller;



import com.example.springdata.Entity.Address;
import com.example.springdata.Service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/address")
@CrossOrigin
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AddressController {

    public final AddressService addressService;

    public void getById(@PathVariable Integer id) {
        addressService.get(id);
    }

    @GetMapping
    public List<Address> GetAll() {
       return addressService.getAll();
    }

    @PostMapping
    public void add(@RequestBody Address address) {
        addressService.saveOrUpdate(address);
    }

    @PutMapping
    public void update(@RequestBody Address address) {
        addressService.saveOrUpdate(address);
    }

    @DeleteMapping
    public void delete(@PathVariable Integer id) {
        addressService.delete(id);
    }


}
