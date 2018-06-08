package com.py.deckofcard.restapi.deck.dao;

import com.py.deckofcard.restapi.deck.entity.Card;
import com.py.deckofcard.restapi.deck.entity.Deck;
import com.py.deckofcard.restapi.deck.entity.enums.CardValue;
import com.py.deckofcard.restapi.deck.entity.enums.Suits;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class DeckDaoImplementation implements DeckDao{
    //TODO : Should be replaced with in-memory database
    private static Deck deckOfCards = new Deck();

    @Override
    public void emptyDeck(){
        deckOfCards.clearDeck();
    }

    @Override
    public void addCard(Card card){
        deckOfCards.addCard(card);
    }

    @Override
    public void addCard(Suits suit, CardValue value) {
        deckOfCards.addCard(new Card(suit, value));
    }

    @Override
    public void removeCard(Card card){
        if (!deckOfCards.getCards()
                .removeIf(x -> x.getValue() == card.getValue() && x.getSuit() == card.getSuit()))
        {
            throw new RuntimeException("Card not present in deck");
        }
    }

    @Override
    public List<Card> getAllCard() {
        return Collections.unmodifiableList(deckOfCards.getCards());
    }
}
