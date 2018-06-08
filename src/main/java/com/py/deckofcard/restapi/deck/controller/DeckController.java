package com.py.deckofcard.restapi.deck.controller;

import com.py.deckofcard.restapi.deck.dto.CardDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeckController {

    @PostMapping(value="deck/shuffle")
    public void shuffle(){
        //TODO Do something
    }

    @PostMapping(value="deck/deal")
    public CardDto deal(){
        return new CardDto();
    }
}
