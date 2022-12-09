package miu.edu.springdata.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.springdata.dto.AddressDto;
import miu.edu.springdata.entity.Address;
import miu.edu.springdata.service.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/addresses")
public class AddressController {
    private final AddressService addressService;

    @PostMapping
    public void save(@RequestBody Address address) {
        addressService.save(address);
    }

    @GetMapping
    public List<AddressDto> findAll() {
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public AddressDto findById(@PathVariable int id) {
        return addressService.findById(id);
    }

    @PutMapping("/{id}")
    public void save(@PathVariable int id, @RequestBody Address address) {
        if (id > 0)
            address.setId(id);
        addressService.save(address);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        addressService.deleteById(id);
    }
}
