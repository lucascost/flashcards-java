package com.lucascost.flashcards.controller;

import com.lucascost.flashcards.entity.Tag;
import com.lucascost.flashcards.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping
    public ResponseEntity<List<Tag>> listTags(){
        return ResponseEntity.ok(tagService.listTags());
    }

    @PostMapping
    public ResponseEntity<Tag> saveTag(@RequestBody Tag tag){
        Tag savedTag = tagService.saveTag(tag);
        if(savedTag != null)
            return ResponseEntity.status(201).body(savedTag);

        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Tag> updateTag(@RequestBody Tag tag){
        Tag updatedTag = tagService.updateTag(tag);
        if (updatedTag != null)
            return ResponseEntity.ok(updatedTag);

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{tagId}")
    public ResponseEntity<String> deleteTag(@PathVariable int tagId){
        if (tagService.deleteTag(tagId))
            return ResponseEntity.noContent().build();

        return ResponseEntity.badRequest().build();
    }

}
