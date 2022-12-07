package edu.miu.springsecurity.controller;

import edu.miu.springsecurity.dto.AddressDto;
import edu.miu.springsecurity.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/addresses")
@RestController
public class AddressController {

    public final AddressService addressService;

    @GetMapping
    public Iterable<AddressDto> getAll(){
        return addressService.getAll();
    }

    @GetMapping("/{id}")
    public AddressDto getById(@PathVariable int id){
        return addressService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody AddressDto address){
        addressService.save(address);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody AddressDto address){
        addressService.update(id, address);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        addressService.delete(id);
    }
}
