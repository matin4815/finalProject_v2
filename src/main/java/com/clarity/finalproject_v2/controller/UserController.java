package com.clarity.finalproject_v2.controller;

import com.clarity.finalproject_v2.dto.UserDTO;
import com.clarity.finalproject_v2.entity.User;
import com.clarity.finalproject_v2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/get/categories")
    public List<User> getAllUsers(){
        return this.userService.findAllUsers();
    }

    @PostMapping(value = "/register")
    public String registerUser(@RequestParam UserDTO userDTO) throws IOException {
        User user = modelMapper.map(userDTO, User.class);
        UserDTO registeredUser = modelMapper.map(userService.registerUser(user), UserDTO.class);
        return "user with the user name " + registeredUser.getUserName() + "is registered";
    }

}
