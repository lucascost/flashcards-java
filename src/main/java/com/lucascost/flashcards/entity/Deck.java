package com.lucascost.flashcards.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Deck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @OneToMany(mappedBy = "deck", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Card> cards;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "deck_tag",
            joinColumns = @JoinColumn(name = "fk_deck"),
            inverseJoinColumns = @JoinColumn(name = "fk_tag")
    )
    private List<Tag> tags = new ArrayList<>();

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

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public void addTag(Tag tag){
        tags.add(tag);
        tag.getDecks().add(this);
    }

    public void removeTag(Tag tag){
        tags.remove(tag);
        tag.getDecks().remove(this);
    }
}
