package com.py.deckofcard.restapi.deck.dao;

import com.py.deckofcard.restapi.deck.entity.Card;
import com.py.deckofcard.restapi.deck.entity.enums.Suits;

import java.util.List;

public interface DeckDao {

    void emptyDeck();
    void addCard(Card card);
    void addCard(Suits suit, int value);
    void removeCard(Card card);
    List<Card> getAllCard();
}
