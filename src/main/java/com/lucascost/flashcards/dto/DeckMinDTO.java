package com.lucascost.flashcards.dto;

import com.lucascost.flashcards.entity.Deck;
import org.springframework.beans.BeanUtils;

public class DeckMinDTO {
    private Integer id;
    private String title;

    public DeckMinDTO() {
    }

    public DeckMinDTO(Deck entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

