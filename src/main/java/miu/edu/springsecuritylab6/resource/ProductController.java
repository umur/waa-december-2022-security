package miu.edu.springsecuritylab6.resource;

import miu.edu.springsecuritylab6.entity.Product;
import miu.edu.springsecuritylab6.service.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductController {

    public ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PreAuthorize("hasAnyAuthority('user:read')")
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProduct();
    }


    @PreAuthorize("hasAnyAuthority('user:read')")
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getAllProductById(id);
    }

    @PreAuthorize("hasAnyAuthority('user:write')")
    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @PreAuthorize("hasAnyAuthority('user:update')")
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product){
        return productService.updateProduct(id, product);
    }
    @PreAuthorize("hasAnyAuthority('user:delete')")
    @DeleteMapping("/{id}")
    public void deleteMapping(@PathVariable Long id){
        productService.deleteProduct(id);
    }


}
