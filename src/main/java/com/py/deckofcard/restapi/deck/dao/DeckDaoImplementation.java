package com.py.deckofcard.restapi.deck.dao;

import com.py.deckofcard.restapi.deck.entity.Card;
import com.py.deckofcard.restapi.deck.entity.Deck;
import com.py.deckofcard.restapi.deck.entity.enums.Suits;

import java.util.Collections;
import java.util.List;

public class DeckDaoImplementation implements DeckDao{

    private static Deck deckOfCards = new Deck();

    @Override
    public void EmptyDeck(){
        deckOfCards.clearDeck();
    }

    @Override
    public void AddCard(Card card){
        deckOfCards.addCard(card);
    }

    @Override
    public void AddCard(Suits suit, int value) {
        deckOfCards.addCard(new Card(suit, value));
    }

    @Override
    public void RemoveCard(Card card){
        if (!deckOfCards.getCards()
                .removeIf(x -> x.getValue() == card.getValue() && x.getSuit() == card.getSuit()))
        {
            throw new RuntimeException("Card not present in deck");
        }
    }

    @Override
    public List<Card> GetAll() {
        return Collections.unmodifiableList(deckOfCards.getCards());
    }
}
