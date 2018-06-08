package com.py.deckofcard.restapi.deck.bll;

import com.py.deckofcard.restapi.deck.entity.Card;

public interface DeckService {
    void shuffle();
    Card dealOneCard();
}
