package com.py.deckofcard.restapi.deck.entity;

import com.py.deckofcard.restapi.deck.entity.enums.CardValue;
import com.py.deckofcard.restapi.deck.entity.enums.Suits;

public class Card {
    private int value;
    private Suits suit;

    public Card ( Suits suit,int  value){
        this.value = value;
        this.suit = suit;
    }

    public int getValue(){ return value;}
    public Suits getSuit() {return suit;}
    public CardValue getCardValue() { return CardValue.getCardFromValue(value);}

    public boolean equalTo(Card card){
        return ( value == card.getValue() && suit == card.getSuit());
    }


}
