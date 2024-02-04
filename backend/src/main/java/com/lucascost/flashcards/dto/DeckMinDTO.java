package com.lucascost.flashcards.dto;

import com.lucascost.flashcards.entity.Deck;
import com.lucascost.flashcards.entity.Tag;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class DeckMinDTO {
    private Integer id;
    private String title;
    private List<String> tags;

    public DeckMinDTO() {
    }

    public DeckMinDTO(Deck deck) {
        this.id = deck.getId();
        this.title = deck.getTitle();
        this.tags = deck.getTagNames();
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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}

