package com.lucascost.flashcards.controller;

import com.lucascost.flashcards.dto.DeckMinDTO;
import com.lucascost.flashcards.entity.Deck;
import com.lucascost.flashcards.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deck")
public class DeckController {
    @Autowired
    private DeckService deckService;

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
}
