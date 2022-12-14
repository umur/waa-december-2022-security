package miu.edu.lab5.controller;

import miu.edu.lab5.entity.Product;
import miu.edu.lab5.service.impl.ProductServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {

        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAll(){

        return productService.getAll();
    }
    @GetMapping("/{id}")
    public Product getById(@PathVariable int id){
        return productService.getById(id);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Product product){
        productService.update(id,product);
    }
    @PostMapping
    public void create(@RequestBody Product product){
        productService.save(product);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        productService.delete(id);
        return "deleted";
    }

}
