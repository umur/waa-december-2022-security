package miu.edu.springsecuritylab6.service.serviceimpl;

import miu.edu.springsecuritylab6.entity.Product;
import miu.edu.springsecuritylab6.repository.ProductRepository;
import miu.edu.springsecuritylab6.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public List<Product> getAllProduct() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product getAllProductById(Long id) {
        return productRepository.findById(id).get();
    }


    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        product.setId(id);
        return productRepository.save(product);
    }
}
