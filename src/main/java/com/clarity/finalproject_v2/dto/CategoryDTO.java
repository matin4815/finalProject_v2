package com.clarity.finalproject_v2.dto;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CategoryDTO {

    @NotNull
    private String name;

}
