package com.example.lab3springdata.controllers;

import com.example.lab3springdata.dto.productDto.ProductBasicDto;
import com.example.lab3springdata.entity.Product;
import com.example.lab3springdata.services.impl.ProductServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RestController
@CrossOrigin
public class ProductController {
    private final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {

        this.productService = productService;
    }

    @GetMapping
    public List<ProductBasicDto> getAll(){

        return productService.getAll();
    }
    @GetMapping("/{id}")
    public ProductBasicDto getById(@PathVariable int id){
        return productService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody ProductBasicDto productDto){
        productService.save(productDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody ProductBasicDto productDto){
        productService.update(id,productDto);
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        productService.delete(id);
        return "deleted";
    }



}
