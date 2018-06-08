package com.py.deckofcard.restapi.deck.bll;

import com.py.deckofcard.restapi.deck.dto.CardDto;
import com.py.deckofcard.restapi.deck.dto.DeckDto;

public interface DeckService {
    void shuffle(int deckId);
    CardDto dealOneCard(int deckId);
    DeckDto getCardsInDeck(int deckId);
    DeckDto createDeck();
}
