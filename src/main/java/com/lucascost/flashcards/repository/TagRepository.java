package com.lucascost.flashcards.repository;

import com.lucascost.flashcards.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Integer> {
    Tag findByName(String name);
}
