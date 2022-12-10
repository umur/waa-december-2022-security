package edu.miu.labthree.controller;

import edu.miu.labthree.dto.ProductDto;
import edu.miu.labthree.entity.Product;
import edu.miu.labthree.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService ) {
        this.productService = productService;
    }

    @PostMapping
    public void create(@RequestBody ProductDto product){
        productService.save(product);
    }
    @DeleteMapping("/{id}")
    public String delete (@PathVariable int id) {
        productService.delete(id);
        return "Deleted successfully";
    }

    @PutMapping("/{id}")
    public String update (@PathVariable int id, @RequestBody ProductDto productDto){
        productService.update(id, productDto);
        return "Updated success";
    }

    @GetMapping
    public List<ProductDto> getAll(){
        return productService.getAll();
    }
    @GetMapping("/{id}")
    public ProductDto getById(int id){
       return productService.getById(id);

    }

}
