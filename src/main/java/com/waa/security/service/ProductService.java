package com.waa.security.service;


import com.waa.security.entity.Product;
import com.waa.security.repository.ProductRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

        void save(Product p);

        void delete(long id);
        void save(long id, Product product);

        Product findById(long id);

        List<Product> findAll();

}

