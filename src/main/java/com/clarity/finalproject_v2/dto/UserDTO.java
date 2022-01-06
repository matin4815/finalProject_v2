package com.clarity.finalproject_v2.dto;

import com.clarity.finalproject_v2.enums.Roles;
import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@Data
public class UserDTO {

    private String name;
    private String lastName;
    @NotNull
    private String userName;
    @NotNull
    private String password;
//    @NotNull
//    private MultipartFile file;


}
