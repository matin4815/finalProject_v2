package com.clarity.finalproject_v2.controller;

import com.clarity.finalproject_v2.dto.TagsDTO;
import com.clarity.finalproject_v2.service.TagsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class TagsController {
    private TagsService tagsService;
    private ModelMapper modelMapper;

    @Autowired
    public TagsController(TagsService tagsService) {
        this.tagsService = tagsService;
    }

    @PostMapping(value = {"/save"})
    public TagsDTO saveTag(@RequestBody TagsDTO tagsDTO){
        return modelMapper.map(tagsService.saveTagByDTO(tagsDTO), TagsDTO.class);
    }

    @GetMapping(value = "/get/names")
    public List<String> getAllTagNames(){
        return this.tagsService.findAllTagNames();
    }

    @GetMapping(value = "/get/{tagName}")
    public String getTagName(@PathVariable(value = "tagName") String tagName){
        return tagsService.findTag(tagName);
    }

}
