package com.py.deckofcard.restapi.deck.controller;

import com.py.deckofcard.restapi.deck.bll.DeckService;
import com.py.deckofcard.restapi.deck.dto.CardDto;
import com.py.deckofcard.restapi.deck.dto.DeckDto;
import com.py.deckofcard.restapi.deck.exception.NoContentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeckController {

    @Autowired
    private DeckService deckService;

    @PostMapping(value = "deck")
    public DeckDto createDeck() {
        return deckService.createDeck();
    }

    @PostMapping(value = "deck/{id}/shuffle")
    public void shuffle(@PathVariable("id") int id) {
        deckService.shuffle(id);
    }

    @PostMapping(value = "deck/{id}/deal")
    public CardDto deal(@PathVariable("id") int id) {
        CardDto card =deckService.dealOneCard(id);
        if ( card == null) throw new NoContentException();
        return card;
    }

    @GetMapping(value = "deck/{id}")
    public DeckDto getAllCard(@PathVariable("id") int id) {
        return deckService.getCardsInDeck(id);
    }
}
