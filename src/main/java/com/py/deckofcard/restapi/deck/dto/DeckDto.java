package com.py.deckofcard.restapi.deck.dto;

import com.py.deckofcard.restapi.deck.entity.Deck;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class DeckDto {
    public int Id;
    public int CardCount;
    public ArrayList<CardDto> cards;

    public DeckDto(Deck deck){
        this.Id = deck.getId();

        this.cards = deck.getCards().stream()
                    .map(CardDto::new)
                    .collect(Collectors.toCollection(ArrayList::new));
        this.CardCount = this.cards.size();
    }
}
