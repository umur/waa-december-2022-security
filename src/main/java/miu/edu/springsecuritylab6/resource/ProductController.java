package miu.edu.springsecuritylab6.resource;

import miu.edu.springsecuritylab6.entity.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @GetMapping
    public List<Product> getAllProducts(){
        return null;
    }
}
