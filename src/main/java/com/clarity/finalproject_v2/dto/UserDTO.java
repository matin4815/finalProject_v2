package com.clarity.finalproject_v2.dto;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserDTO {

    private String name;
    private String lastName;
    @NotNull
    private String userName;
    @NotNull
    private String password;
}
