package com.py.deckofcard.restapi.deck.dto;

import com.py.deckofcard.restapi.deck.entity.Card;

public class CardDto {
    public String name;
    public String suit;
    public int value;

    public CardDto(Card card){
        this.suit = card.getSuit().getName();
        this.value = card.getValue();
        this.name = card.getCardValue().getName() + " of " + suit;
    }

    public CardDto()
    {
        this.suit = "";
        this.name = "";
        this.value = 0;
    }
}
