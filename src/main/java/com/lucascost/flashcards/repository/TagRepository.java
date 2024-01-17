package com.lucascost.flashcards.repository;

import com.lucascost.flashcards.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}
