package com.lucascost.flashcards.controller;

import com.lucascost.flashcards.dto.DeckMinDTO;
import com.lucascost.flashcards.dto.DeckTagDTO;
import com.lucascost.flashcards.entity.Card;
import com.lucascost.flashcards.entity.Deck;
import com.lucascost.flashcards.service.CardService;
import com.lucascost.flashcards.service.DeckService;
import com.lucascost.flashcards.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deck")
public class DeckController {
    @Autowired
    private DeckService deckService;

    @Autowired
    private CardService cardService;

    @Autowired
    private TagService tagService;

    @GetMapping("")
    public ResponseEntity<List<DeckMinDTO>> listAll(@RequestParam(required = false) String query){
        if(query != null)
            return ResponseEntity.ok().body(deckService.listDecksByTitle(query));

        return ResponseEntity.ok().body(deckService.listDecks());
    }

    @GetMapping("/{deckId}")
    public ResponseEntity<Deck> deckDetail (@PathVariable Integer deckId){
        Deck existingDeck = deckService.findById(deckId);

        if(existingDeck != null)
            return ResponseEntity.ok().body(existingDeck);

        return ResponseEntity.notFound().build();
    }

    @PostMapping("")
    public ResponseEntity<Deck> saveDeck(@RequestBody Deck deck){
        deck.setId(null);

        Deck createdDeck = deckService.saveDeck(deck);
        if (createdDeck != null)
            return ResponseEntity.status(201).body(deck);

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeckMinDTO> updateDeck(@PathVariable int id, @RequestBody Deck deck){
        deck.setId(id);
        DeckMinDTO updateResult = deckService.updateDeck(deck);

        if(updateResult != null)
            return ResponseEntity.ok().body(updateResult);

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDeck(@PathVariable int id){
        if(deckService.deleteDeck(id))
            return ResponseEntity.noContent().build();

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{deckId}/cards")
    public ResponseEntity<Card> saveCard(@PathVariable int deckId, @RequestBody Card card){
        Card savedCard = cardService.saveCard(deckId, card);
        if( savedCard != null)
            return ResponseEntity.status(201).body(savedCard);

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{deckId}/cards/{cardId}")
    public ResponseEntity<Card> updateCard(@PathVariable int deckId, @PathVariable int cardId, @RequestBody Card card){
        Card updatedCard = cardService.updateCard(deckId,cardId,card);
        if( updatedCard != null)
            return ResponseEntity.ok().body(updatedCard);

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{deckId}/cards/{cardId}")
    public ResponseEntity<String> deleteCard(@PathVariable int deckId, @PathVariable int cardId){
        if(cardService.deleteCard(deckId,cardId))
            return ResponseEntity.noContent().build();

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{deckId}/tags")
    public ResponseEntity<String> addTagToDeck(@PathVariable int deckId, @RequestBody DeckTagDTO deckTagDTO){
        deckTagDTO.setDeckId(deckId);
        if (tagService.addTagToDeck(deckTagDTO))
            return ResponseEntity.ok().build();

        return ResponseEntity.badRequest().build();
    }
}
