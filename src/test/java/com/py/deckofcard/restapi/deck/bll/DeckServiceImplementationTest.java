package com.py.deckofcard.restapi.deck.bll;

import com.py.deckofcard.restapi.TestBase;
import com.py.deckofcard.restapi.deck.dao.DeckDao;
import com.py.deckofcard.restapi.deck.dto.CardDto;
import com.py.deckofcard.restapi.deck.entity.Card;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
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

        verify(deckDao, times(52)).addCard(any(), any());
    }

    @Test
    public void dealOneCard_whenDeckNotEmpty_shouldReturnRandomCard(){
        Card card1 = fixture.create(Card.class);
        Card card2 = fixture.create(Card.class);
        when(deckDao.getAllCard()).thenReturn(Arrays.asList(card1, card2));

        CardDto result  = sut.dealOneCard();

        assertThat(card1.equalTo(result) || card2.equalTo(result)).isTrue();
    }

    @Test
    public void dealOneCard_whenDeckNotEmpty_shouldRemoveDealtCard(){
        Card card = fixture.create(Card.class);
        when(deckDao.getAllCard()).thenReturn(Arrays.asList(card));

        sut.dealOneCard();

        verify(deckDao).removeCard(card);
    }

    @Test
    public void dealOneCard_whenDeckEmpty_shouldReturnEmptyCard(){
        CardDto emptyCard = new CardDto();

        CardDto result = sut.dealOneCard();

        assertThat(result).isEqualToComparingFieldByField(emptyCard);
    }
}
