package com.lucascost.flashcards.repository;

import com.lucascost.flashcards.entity.Deck;
import com.lucascost.flashcards.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DeckRepository extends JpaRepository<Deck, Integer> {
    List<Deck> findAllByTitleContainingIgnoreCase(String title);
    List<Deck> findByTagsContaining(Tag tag);

    @Query("SELECT DISTINCT d FROM Deck d JOIN d.tags t WHERE t.name IN :tagNames")
    List<Deck> findDecksByTagNames(@Param("tagNames") List<String> tagNames);
}
