package com.py.deckofcard.restapi.deck.entity;

import com.py.deckofcard.restapi.deck.dto.CardDto;
import com.py.deckofcard.restapi.deck.entity.enums.CardValue;
import com.py.deckofcard.restapi.deck.entity.enums.Suits;

public class Card {
    private CardValue value;
    private Suits suit;

    public Card(Suits suit, CardValue value) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return value.getValue();
    }

    public Suits getSuit() {
        return suit;
    }

    public CardValue getCardValue() {
        return value;
    }

    public boolean equalTo(Card card) {
        return (value == card.getCardValue() && suit == card.getSuit());
    }

    public boolean equalTo(CardDto card) {
        return (value.getValue() == card.value && suit.getName() == card.suit);
    }
}
