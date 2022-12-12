package com.example.lab3springdata.controllers;

import com.example.lab3springdata.aspects.annotation.ExecutionTime;
import com.example.lab3springdata.dto.addressDto.AddressBasicDto;
import com.example.lab3springdata.entity.Address;
import com.example.lab3springdata.services.impl.AddressServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/addresses")
@RestController
public class AddressController {
    private final AddressServiceImpl addressService;

    public AddressController(AddressServiceImpl addressService) {

        this.addressService = addressService;
    }
    @ExecutionTime
    @GetMapping
    public List<AddressBasicDto> getAll(){
        return addressService.getAll();
    }
   @GetMapping("/{id}")
   public AddressBasicDto getById(@PathVariable int id){
        return addressService.getById(id);
   }

   @PostMapping
    public void create(@RequestBody AddressBasicDto addressDto){
        addressService.save(addressDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody AddressBasicDto addressDto){
        addressService.update(id,addressDto);
}


    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        addressService.delete(id);
        return "deleted";
    }



}
