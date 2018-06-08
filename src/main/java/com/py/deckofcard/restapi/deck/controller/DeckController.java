package com.py.deckofcard.restapi.deck.controller;

import com.py.deckofcard.restapi.deck.bll.DeckService;
import com.py.deckofcard.restapi.deck.dto.CardDto;
import com.py.deckofcard.restapi.deck.dto.DeckDto;
import com.py.deckofcard.restapi.deck.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeckController {

    @Autowired
    private DeckService deckService;

    @PostMapping(value="deck/shuffle")
    public void shuffle(){
        deckService.shuffle();
    }

    @PostMapping(value="deck/deal")
    public CardDto deal(){
        return null;
    }

    @GetMapping(value="deck")
    public DeckDto getAllCard(){
        return deckService.getCardsInDeck();
    }
}
