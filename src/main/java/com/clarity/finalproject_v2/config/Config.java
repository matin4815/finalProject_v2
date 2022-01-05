package com.clarity.finalproject_v2.config;

import com.clarity.finalproject_v2.dto.CategoryDTO;
import com.clarity.finalproject_v2.dto.TagsDTO;
import com.clarity.finalproject_v2.dto.UserDTO;
import com.clarity.finalproject_v2.entity.Category;
import com.clarity.finalproject_v2.entity.Tag;
import com.clarity.finalproject_v2.entity.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Config {

    @Bean
    public ModelMapper myModelMapper(){
        ModelMapper modelMapper = new ModelMapper();

        TypeMap<Tag, TagsDTO> tagPropertyMapper = modelMapper.createTypeMap(Tag.class, TagsDTO.class);
        TypeMap<Category, CategoryDTO> categoryPropertyMapper = modelMapper.createTypeMap(Category.class, CategoryDTO.class);
        TypeMap<User, UserDTO> userPropertyMapper = modelMapper.createTypeMap(User.class, UserDTO.class);
        return modelMapper;
    }

    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
