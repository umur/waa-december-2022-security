package edu.miu.labthree.repository;

import edu.miu.labthree.dto.ProductDto;
import edu.miu.labthree.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepo extends CrudRepository<Product,Integer > {
    List<ProductDto> findAllByPriceGreaterThan (int price);
    //List<Product> findAllByCategoryCostLessThan();
    List<ProductDto> findAllByNameContainingKeyword(String keyword);

    List<ProductDto> findAllByNameContainingKeyword(String cat, int price);
}
