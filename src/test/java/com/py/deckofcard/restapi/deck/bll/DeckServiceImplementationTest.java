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
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class DeckServiceImplementationTest extends TestBase {

    @Mock
    private DeckCollectionDao deckDao;

    @InjectMocks
    private DeckServiceImplementation sut;

    @Test
    public void shuffle_shouldChangeCardOrderInDeck(){
        Deck deck = fixture.create(Deck.class);
        when(deckDao.getDeck(1)).thenReturn(deck);
        deck.addCard(fixture.create(Card.class));
        deck.addCard(fixture.create(Card.class));
        deck.addCard(fixture.create(Card.class));
        List<Card> beforeShuffle = (List<Card>)((ArrayList<Card>)deck.getCards()).clone();

        sut.shuffle(1);

        assertThat(deck.getCards())
                .doesNotContainSequence(beforeShuffle);
    }

    @Test
    public void createDeck_shouldClearDeck(){
        Deck deck = mock(Deck.class);
        when(deckDao.createDeck()).thenReturn(deck);

        sut.createDeck();

        verify(deck).clearDeck();
    }

    @Test
    public void createDeck_shouldCreateDeckWith52Card(){
        Deck deck = mock(Deck.class);
        when(deckDao.createDeck()).thenReturn(deck);

        sut.createDeck();

        verify(deck, times(52)).addCard(any(), any());
    }

    @Test
    public void createDeck_shouldCreateNewDeckWithAllUniqueCard(){
        Deck deck = fixture.create(Deck.class);
        when(deckDao.createDeck()).thenReturn(deck);

        sut.createDeck();

        Map<Integer, List<Card>> groupCard = deck.getCards()
                .stream()
                .collect(Collectors.groupingBy(x -> x.getValue() + (x.getSuit().getValue() * 100)));
        assertThat(groupCard.values())
                .allSatisfy(x -> assertThat(x.size()).isEqualTo(1));
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
    public void dealOneCard_whenDeckEmpty_shouldReturnNull() {
        Deck deck = new Deck(1);
        when(deckDao.getDeck(1)).thenReturn(deck);
        CardDto result = sut.dealOneCard(1);

        assertThat(result).isNull();
    }
}
