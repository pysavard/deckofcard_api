package com.py.deckofcard.restapi.deck.entity;

import com.py.deckofcard.restapi.deck.entity.enums.CardValue;
import com.py.deckofcard.restapi.deck.entity.enums.Suits;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private ArrayList<Card> cards;
    private int id;

    public void addCard(Card card)
    {
        cards.add(card);
    }

    public void addCard(Suits suit, CardValue value) { cards.add(new Card(suit, value));}

    public Deck(int id ){
        this.id  = id;
        cards = new ArrayList<>();
    }

    public int getId() { return id;}
    public List<Card> getCards() { return cards; }
    public void clearDeck(){ cards = new ArrayList<>();}
}
