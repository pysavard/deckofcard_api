package com.py.deckofcard.restapi.deck.dto;

import com.py.deckofcard.restapi.deck.entity.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DeckDto {
    public ArrayList<CardDto> cards;

    public DeckDto(List<Card> cards){
        this.cards = cards.stream()
                    .map(CardDto::new)
                    .collect(Collectors.toCollection(ArrayList::new));
    }
}
