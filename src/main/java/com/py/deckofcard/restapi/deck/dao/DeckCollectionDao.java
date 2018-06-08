package com.py.deckofcard.restapi.deck.dao;

import com.py.deckofcard.restapi.deck.entity.Deck;

import java.util.Map;

public interface DeckCollectionDao {

    Deck createDeck();

    Deck getDeck(int id);
}


