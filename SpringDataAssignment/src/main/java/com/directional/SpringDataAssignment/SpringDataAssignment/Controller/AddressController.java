package com.directional.SpringDataAssignment.SpringDataAssignment.Controller;

import com.directional.SpringDataAssignment.SpringDataAssignment.Aspect.Annotation.ExecutionTime;
import com.directional.SpringDataAssignment.SpringDataAssignment.Entity.BiDirectional.Address;
import com.directional.SpringDataAssignment.SpringDataAssignment.Service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/address")
public class AddressController {

    public final AddressService addressService;


    @GetMapping("/{id}")
    public Address getById(@PathVariable Long id) {

        var item = addressService.get(id);
        return item;
    }

    @ExecutionTime
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
    public void delete(@PathVariable Long id) {
        addressService.delete(id);
    }


}
