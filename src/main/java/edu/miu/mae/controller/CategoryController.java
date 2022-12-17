package edu.miu.mae.controller;

import edu.miu.mae.dto.CategoryDto;
import edu.miu.mae.entity.Address;
import edu.miu.mae.entity.Category;
import edu.miu.mae.service.AddressService;
import edu.miu.mae.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/category")
@RestController
public class CategoryController  extends BaseController<Category, CategoryDto> {

    @Autowired
    public CategoryController(CategoryService as){
        this.bs = as;
    }
}