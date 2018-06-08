package com.py.deckofcard.restapi.deck.dao;

import com.py.deckofcard.restapi.deck.entity.Deck;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DeckCollectionDaoImplementation  implements DeckCollectionDao{
    //TODO : Again, in memory db would be great
    private static Map<Integer, Deck> decks = new HashMap<>();
    private static int currentId = 1;

    @Override
    public synchronized Deck createDeck() {
        currentId++;
        Deck deck = new Deck(currentId);

        decks.put(currentId, deck);

        return deck;
    }

    @Override
    public Deck getDeck(int id) {
        return decks.get(id);
    }
}
