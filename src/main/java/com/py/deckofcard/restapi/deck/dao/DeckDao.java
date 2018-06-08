package com.py.deckofcard.restapi.deck.dao;

import com.py.deckofcard.restapi.deck.entity.Card;
import com.py.deckofcard.restapi.deck.entity.enums.CardValue;
import com.py.deckofcard.restapi.deck.entity.enums.Suits;

import java.util.List;

public interface DeckDao {

    void emptyDeck();
    void addCard(Card card);
    void addCard(Suits suit, CardValue value);
    void removeCard(Card card);
    List<Card> getAllCard();
}
