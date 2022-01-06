package com.clarity.finalproject_v2.controller;


import com.clarity.finalproject_v2.dto.CategoryDTO;
import com.clarity.finalproject_v2.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;
    private ModelMapper modelMapper;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping(value = "/getcategories")
    public List<String> getAllCategoryNames(){
        return this.categoryService.findAllCategoryNames();
    }

    @PostMapping(value = {"/save"})
    public CategoryDTO saveCategory(@RequestBody CategoryDTO categoryDTO){
        return modelMapper.map(categoryService.saveCategoryByDTO(categoryDTO), CategoryDTO.class);
    }
}
