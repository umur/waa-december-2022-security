package miu.edu.lab5.controller;

import miu.edu.lab5.entity.Address;
import miu.edu.lab5.service.impl.AddressServiceImpl;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin
@RequestMapping("/addresses")
@RestController
public class AddressController {
    private final AddressServiceImpl addressService;

    public AddressController(AddressServiceImpl addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<Address> getAll(){
        return addressService.getAll();
    }
    @GetMapping("/{id}")
    public Address getById(@PathVariable int id){
        return addressService.getById(id);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Address address){
        addressService.update(id,address);
    }
    @PostMapping
    public void create(@RequestBody Address address){
        addressService.save(address);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        addressService.delete(id);
        return "deleted";
    }

}
