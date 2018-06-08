package com.py.deckofcard.restapi.deck.entity;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private ArrayList<Card> cards;

    public void addCard(Card card)
    {
        cards.add(card);
    }

    public Deck(){
        cards = new ArrayList<>();
    }

    public List<Card> getCards() { return cards; }
    public void clearDeck(){ cards = new ArrayList<>();}
}
