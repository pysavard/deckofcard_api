package com.py.deckofcard.restapi.deck.bll;

import com.py.deckofcard.restapi.deck.dto.CardDto;
import com.py.deckofcard.restapi.deck.dto.DeckDto;
import com.py.deckofcard.restapi.deck.entity.Card;

import java.util.List;

public interface DeckService {
    void shuffle();
    Card dealOneCard();
    DeckDto getCardsInDeck();
}
