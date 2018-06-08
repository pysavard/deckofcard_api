package com.py.deckofcard.restapi.deck.bll;

import com.py.deckofcard.restapi.TestBase;
import com.py.deckofcard.restapi.deck.dao.DeckCollectionDao;
import com.py.deckofcard.restapi.deck.dto.CardDto;
import com.py.deckofcard.restapi.deck.entity.Card;
import com.py.deckofcard.restapi.deck.entity.Deck;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class DeckServiceImplementationTest extends TestBase {

    @Mock
    private DeckCollectionDao deckDao;

    @InjectMocks
    private DeckServiceImplementation sut;

    @Test
    public void shuffle_shouldEmptyDeckBeforeCreateNew() {
        Deck deck = mock(Deck.class);
        when(deckDao.getDeck(1)).thenReturn(deck);

        sut.shuffle(1);

        verify(deck).clearDeck();
    }

    @Test
    public void shuffle_shouldCreateADeckOf52Cards() {
        Deck deck = mock(Deck.class);
        when(deckDao.getDeck(1)).thenReturn(deck);

        sut.shuffle(1);

        verify(deck, times(52)).addCard(any(), any());
    }

    @Test
    public void dealOneCard_whenDeckNotEmpty_shouldReturnRandomCard() {
        Card card1 = fixture.create(Card.class);
        Card card2 = fixture.create(Card.class);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);

        Deck deck = mock(Deck.class);
        when(deckDao.getDeck(1)).thenReturn(deck);

        when(deck.getCards()).thenReturn(cards);

        CardDto result = sut.dealOneCard(1);

        assertThat(card1.equalTo(result) || card2.equalTo(result)).isTrue();

    }

    @Test
    public void dealOneCard_whenDeckNotEmpty_shouldRemoveDealtCard() {
        Card card = fixture.create(Card.class);
        Deck deck = new Deck(1);
        when(deckDao.getDeck(1)).thenReturn(deck);

        deck.addCard(card);

        CardDto result = sut.dealOneCard(1);

        assertThat(deck.getCards()).isEmpty();
    }

    @Test
    public void dealOneCard_whenDeckEmpty_shouldReturnEmptyCard() {
        CardDto emptyCard = new CardDto();
        Deck deck = new Deck(1);
        when(deckDao.getDeck(1)).thenReturn(deck);
        CardDto result = sut.dealOneCard(1);

        assertThat(result).isEqualToComparingFieldByField(emptyCard);
    }
}
