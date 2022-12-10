package edu.miu.labthree.controller;

import edu.miu.labthree.dto.AddressDto;
import edu.miu.labthree.entity.Address;
import edu.miu.labthree.service.AddressService;
import edu.miu.labthree.service.impl.AddressServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/addresses")
public class AddressController {
    private final AddressServiceImpl addressService;

    @PostMapping
    public String save(@RequestBody AddressDto addressDto) {
        try {
            addressService.save(addressDto);
            return "Address saved!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Try again";
        }
    }

    @GetMapping
    public List<AddressDto> getAll() {

        return addressService.getAll();
    }

    @PutMapping
    public String update(@RequestBody AddressDto addressDto){
        try {
            addressService.save( addressDto);
            return "Address updated!";
        }catch (Exception e){
            e.printStackTrace();
            return "Sorry can't update address";
        }
    }
    @GetMapping("/{id}")
    public AddressDto getById(@PathVariable int id) {
        return addressService.getById(id);
    }
}
