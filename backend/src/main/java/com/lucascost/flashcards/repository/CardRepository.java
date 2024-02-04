package com.lucascost.flashcards.repository;

import com.lucascost.flashcards.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CardRepository extends JpaRepository<Card, Integer> {
}
