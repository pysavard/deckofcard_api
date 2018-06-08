package com.py.deckofcard.restapi.deck.dto;

import com.py.deckofcard.restapi.deck.entity.Card;

public class CardDto {
    public String name;
    public String suits;
    public int value;

    public CardDto(Card card){
        this.suits = card.getSuit().getName();
        this.value = card.getValue();
        this.name = card.getCardValue().getName() + " of " + suits;
    }

    public CardDto()
    {
        this.suits = "";
        this.name = "";
        this.value = 0;
    }
}
