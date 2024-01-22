package com.lucascost.flashcards.service;

import com.lucascost.flashcards.dto.TagListRequest;
import com.lucascost.flashcards.entity.Deck;
import com.lucascost.flashcards.dto.DeckMinDTO;
import com.lucascost.flashcards.entity.Tag;
import com.lucascost.flashcards.repository.DeckRepository;
import com.lucascost.flashcards.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
public class DeckService {

    @Autowired
    private DeckRepository deckRepository;

    @Autowired
    private TagRepository tagRepository;

    public List<DeckMinDTO> listDecks(){
        List<Deck> decks = deckRepository.findAll();
        return decks.stream().map(DeckMinDTO::new).toList();
    }

    public Deck findById(Integer id){
        return deckRepository.findById(id).orElse(null);
    }

    public Deck saveDeck(Deck deck){
        try {
            if(deck.getTitle() != null && deck.getTitle().trim().length() > 0){
                 return deckRepository.save(deck);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public DeckMinDTO updateDeck(Deck deck){
        try {
            Optional<Deck> existingDeck = deckRepository.findById(deck.getId());
            if(existingDeck.isPresent()){
                if( deck.getTitle() != null && deck.getTitle().trim().length() > 0){
                    existingDeck.get().setTitle(deck.getTitle());
                    deckRepository.save(existingDeck.get());
                    return new DeckMinDTO(existingDeck.get());
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteDeck(Integer deckId){
        Optional<Deck> deck = deckRepository.findById(deckId);
        if (deck.isPresent()){
            deckRepository.delete(deck.get());
            return true;
        }
        return false;
    }

    public List<DeckMinDTO> listDecksByFilter(String query, List<String> tagNames) {
        List<Deck> decks = new ArrayList<>();

        decks.addAll(deckRepository.findAllByTitleContainingIgnoreCase(query));
        decks.addAll(deckRepository.findDecksByTagNames(tagNames));

        Set<Deck> result = new HashSet<>(decks);

        return result.stream().map(DeckMinDTO::new).toList();
    }
}

