package edu.miu.mae.service.impl;

import edu.miu.mae.StreamUtils;
import edu.miu.mae.dto.CategoryDto;
import edu.miu.mae.dto.UserDto;
import edu.miu.mae.entity.Address;
import edu.miu.mae.entity.Category;
import edu.miu.mae.entity.User;
import edu.miu.mae.repository.CategoryRepository;
import edu.miu.mae.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void save(CategoryDto ad) {
        categoryRepository.save(modelMapper.map(ad, Category.class));
    }

    @Override
    public CategoryDto getById(int id) {

        return modelMapper.map(categoryRepository.findById(id).get(),CategoryDto.class);


    }

    @Override
    public void update(CategoryDto ad, int id) {
        Category paramDto = modelMapper.map(ad, Category.class);

        if(ad.getId()!=id){
            categoryRepository.deleteById(id);
        }
        categoryRepository.save(paramDto);

    }

    @Override
    public void delete(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<CategoryDto> getAll() {
        return  StreamUtils
                .asStream(categoryRepository.findAll())
                .map(x->modelMapper.map(x, CategoryDto.class))
                .collect(Collectors.toList());
    }
}
