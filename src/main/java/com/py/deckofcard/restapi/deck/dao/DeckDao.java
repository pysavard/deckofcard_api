package com.py.deckofcard.restapi.deck.dao;

import com.py.deckofcard.restapi.deck.entity.Card;
import com.py.deckofcard.restapi.deck.entity.enums.Suits;

import java.util.List;

public interface DeckDao {

    void EmptyDeck();
    void AddCard(Card card);
    void AddCard(Suits suit, int value);
    void RemoveCard(Card card);
    List<Card> GetAll();
}
