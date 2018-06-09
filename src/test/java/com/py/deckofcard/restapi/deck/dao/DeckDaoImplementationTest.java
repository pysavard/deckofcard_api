package com.py.deckofcard.restapi.deck.dao;

import com.py.deckofcard.restapi.TestBase;
import com.py.deckofcard.restapi.deck.entity.Deck;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.assertj.core.api.Assertions.assertThat;

public class DeckDaoImplementationTest extends TestBase {

    @InjectMocks
    DeckCollectionDaoImplementation sut;

    @Test
    public void createDeck_shouldCreateANewDeckOfCard(){
        Deck deck = sut.createDeck();

        assertThat(deck).isNotNull();
    }

    @Test
    public void getDeck_shouldReturnDeck(){
        Deck expectedDeck = sut.createDeck();

        Deck result = sut.getDeck(expectedDeck.getId());

        assertThat(result).isEqualTo(expectedDeck);
    }
}
