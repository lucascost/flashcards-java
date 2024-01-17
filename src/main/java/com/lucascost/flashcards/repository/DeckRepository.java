package com.lucascost.flashcards.repository;

import com.lucascost.flashcards.entity.Deck;
import com.lucascost.flashcards.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeckRepository extends JpaRepository<Deck, Integer> {
    List<Deck> findAllByTitleContainingIgnoreCase(String title);
    List<Deck> findByTagsContaining(Tag tag);
}
