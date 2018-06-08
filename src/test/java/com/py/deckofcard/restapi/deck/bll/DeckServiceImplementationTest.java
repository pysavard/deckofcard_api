package com.py.deckofcard.restapi.deck.bll;

import com.py.deckofcard.restapi.TestBase;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;

public class DeckServiceImplementationTest extends TestBase {

    @Mock
    CardFactory cardFactoryMock;

    @MockBean
    DeckOfCardFactory deckOfCardFactoryMock;

    @InjectMocks
    DeckServiceImplementation sut;

    @Test
    public void shuffle_shouldCreateEmptyDeckOfCards()
    {

    }
}
