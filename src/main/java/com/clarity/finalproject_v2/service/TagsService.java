package com.clarity.finalproject_v2.service;

import com.clarity.finalproject_v2.dto.TagsDTO;
import com.clarity.finalproject_v2.entity.Tag;
import com.clarity.finalproject_v2.repository.TagRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagsService {

    private final TagRepository tagRepository;
    private final ModelMapper modelMapper;

    public TagsService(TagRepository tagRepository, ModelMapper modelMapper) {
        this.tagRepository = tagRepository;
        this.modelMapper = modelMapper;
    }

    public Tag saveTagByDTO(TagsDTO tagsDTO){
        Tag tag = modelMapper.map(tagsDTO, Tag.class);
        return tagRepository.save(tag);
    }

    public List<String> findAllTagNames(){
        List<Tag> tags = this.tagRepository.findAll();
        List<String> tagNames = new ArrayList<String>();
        for(Tag tag: tags){
            tagNames.add(tag.getName());
        }
        return tagNames;
    }

    public String findTag(String tagName){
        Tag tag = this.tagRepository.findTag(tagName);
        return tag.getName();
    }

//    @Transactional(readOnly = true)
//    public Post findTagPosts(S tring tagName){
//        Tag tag = this.tagRepository.findTag(tagName);
//        Optional<Post> post = postRepository.findById(tag.getId());
//        if(post.isPresent()){
//            return post.get();
//        }
//        return null;
//    }
}
