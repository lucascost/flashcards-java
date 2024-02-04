package com.lucascost.flashcards.service;

import com.lucascost.flashcards.entity.Card;
import com.lucascost.flashcards.entity.Deck;
import com.lucascost.flashcards.repository.CardRepository;
import com.lucascost.flashcards.repository.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private DeckRepository deckRepository;

    private boolean isValid(String value){
        return value != null && value.trim().length() > 0;
    }

    public Card saveCard(int deckId, Card card){
        Optional<Deck> existingDeck = deckRepository.findById(deckId);
        if(existingDeck.isPresent()){
            try{
                if( isValid(card.getFront()) && isValid(card.getBack()) ){
                    card.setDeck(existingDeck.get());
                    cardRepository.save(card);
                    return card;
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    public Card updateCard(int deckId, int cardId, Card card){
        Optional<Deck> existingDeck = deckRepository.findById(deckId);
        Optional<Card> existingCard = cardRepository.findById(cardId);

        if(existingDeck.isPresent() && existingCard.isPresent() && existingDeck.get().getCards().contains(existingCard.get())){
             try {
                card.setId(cardId);
                card.setDeck(existingDeck.get());
                cardRepository.save(card);
                return card;
             }
             catch (Exception e){
                 e.printStackTrace();
             }
         }
        return null;
    }

    public boolean deleteCard(int deckId, int cardId){
        Optional<Deck> existingDeck = deckRepository.findById(deckId);
        Optional<Card> existingCard = cardRepository.findById(cardId);

        try {
            if (existingDeck.isPresent() && existingCard.isPresent() && existingDeck.get().getCards().contains(existingCard.get())){
                cardRepository.delete(existingCard.get());
                existingCard = cardRepository.findById(cardId);
                return existingCard.isEmpty();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
