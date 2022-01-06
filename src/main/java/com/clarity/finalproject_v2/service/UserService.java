package com.clarity.finalproject_v2.service;

import com.clarity.finalproject_v2.dto.UserDTO;
import com.clarity.finalproject_v2.entity.Category;
import com.clarity.finalproject_v2.entity.User;
import com.clarity.finalproject_v2.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class UserService {
    
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public List<User> findAllUsers() {
        return this.userRepository.findAll();
    }

    public User findUser(String userName){
        return userRepository.findUser(userName);
    }

    @Transactional
    public User registerUser(User user) throws IOException {
//        String path = ResourceUtils.getFile("classpath:static/img").getAbsolutePath();
//        byte[] bytes = user.getPicFile().getBytes();
//        String name = UUID.randomUUID() + "." + Objects.requireNonNull(user.getPicFile().getContentType()).split("/")[1];
//        user.setProfilePick(name);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return this.userRepository.save(user);
     }
}
