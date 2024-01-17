package com.lucascost.flashcards.service;

import com.lucascost.flashcards.dto.DeckTagDTO;
import com.lucascost.flashcards.entity.Deck;
import com.lucascost.flashcards.entity.Tag;
import com.lucascost.flashcards.repository.DeckRepository;
import com.lucascost.flashcards.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private DeckRepository deckRepository;

    private boolean isValid(String value){
        return value != null && value.trim().length() > 0;
    }

    public List<Tag> listTags(){
        return tagRepository.findAll();
    }

    public Tag saveTag(Tag tag){
        tag.setId(null);
        try{
            if(isValid(tag.getName()))
                return tagRepository.save(tag);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Tag updateTag(Tag tag){
        try {
            Optional<Tag> existingTag = tagRepository.findById(tag.getId());
            if(existingTag.isPresent() && isValid(tag.getName()))
                return tagRepository.save(tag);

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public boolean deleteTag(int tagId){
        try{
            Optional<Tag> existingTag = tagRepository.findById(tagId);
            if (existingTag.isPresent()) {
                List<Deck> decks = deckRepository.findByTagsContaining(existingTag.get());
                for (Deck deck : decks) {
                    deck.removeTag(existingTag.get());
                    deckRepository.save(deck);
                }
                tagRepository.delete(existingTag.get());
                return tagRepository.findById(tagId).isEmpty();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean addTagToDeck(DeckTagDTO deckTagDTO){
        try {
            Optional<Deck> existingDeck = deckRepository.findById(deckTagDTO.getDeckId());
            Optional<Tag> existingTag = tagRepository.findById(deckTagDTO.getTagId());

            if( existingDeck.isPresent() && existingTag.isPresent()){
                existingDeck.get().addTag(existingTag.get());
                deckRepository.save(existingDeck.get());
                return true;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
