package edu.miu.springsecurity1.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.springsecurity1.entity.Product;
import edu.miu.springsecurity1.entity.User;
import edu.miu.springsecurity1.repository.ProductRepo;
import edu.miu.springsecurity1.repository.UserRepo;
import edu.miu.springsecurity1.security.AwesomeUserDetails;
import edu.miu.springsecurity1.service.ProductService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(isolation = Isolation.SERIALIZABLE)
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final UserRepo userRepo;

    @Override
    public void save(Product p) {
        AwesomeUserDetails principal = (AwesomeUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        User foundedUser = userRepo.findByEmail(principal.getUsername());
        p.setUser(foundedUser);
        productRepo.save(p);
    }

    @Override
    public void delete(int id) {
        productRepo.deleteById(id);
    }

    @Override
    public Product getById(int id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public List<Product> getAll() {
        var result = new ArrayList<Product>();
        productRepo.findAll().forEach(result::add);
        return result;
    }
}
