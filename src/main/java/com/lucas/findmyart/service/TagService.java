package com.lucas.findmyart.service;

import com.lucas.findmyart.model.order.Tag;
import com.lucas.findmyart.repository.TagRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TagService {

    private TagRepository tagRepository;

    private List<Tag> getAll() {
        return tagRepository.findAll();
    }

    public Tag getByTagName(String tagName) {
        Optional<Tag> tag = tagRepository.findByTag(tagName);
        return tag.get();
    }

}
