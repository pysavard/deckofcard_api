package com.py.deckofcard.restapi.deck.bll;

import com.py.deckofcard.restapi.TestBase;
import com.py.deckofcard.restapi.deck.dao.DeckDao;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

public class DeckServiceImplementationTest extends TestBase {

    @Mock
    private DeckDao deckDao;

    @InjectMocks
    private DeckServiceImplementation sut;

    @Test
    public void shuffle_shouldCreateEmptyDeckOfCards()
    {
        sut.shuffle();

        verify(deckDao).emptyDeck();
    }

    @Test
    public void shuffle_shouldCreateDeckWith52Card(){
        sut.shuffle();

        verify(deckDao, times(52)).addCard(any(), anyInt());
    }
}
