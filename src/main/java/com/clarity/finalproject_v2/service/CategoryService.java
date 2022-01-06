package com.clarity.finalproject_v2.service;

import com.clarity.finalproject_v2.dto.CategoryDTO;
import com.clarity.finalproject_v2.entity.Category;
import com.clarity.finalproject_v2.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryService(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    public List<String> findAllCategoryNames(){
        List<Category> categories = this.categoryRepository.findAll();
        List<String> categoryNames = new ArrayList<String>();
        for(Category category: categories){
            categoryNames.add(category.getName());
        }
        return categoryNames;
    }

    public Category saveCategoryByDTO(CategoryDTO categoryDTO){
        Category category = modelMapper.map(categoryDTO, Category.class);
        return categoryRepository.save(category);
    }
}
