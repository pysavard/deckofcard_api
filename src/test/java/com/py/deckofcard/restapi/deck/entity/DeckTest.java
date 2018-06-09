package com.py.deckofcard.restapi.deck.entity;

import com.py.deckofcard.restapi.TestBase;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DeckTest extends TestBase {

    private Deck sut;

    @Before
    public void before(){
        sut = new Deck(1);
    }

    @Test
    public void addCard_shouldAddACardToCardList(){
        Card card = fixture.create(Card.class);

        sut.addCard(card);

        assertThat(sut.getCards()).containsExactly(card);
    }

    @Test
    public void addCard_withSuitsAndValue_shouldAddACardToCardList(){
        Card card = fixture.create(Card.class);

        sut.addCard(card.getSuit(), card.getCardValue());

        assertThat(sut.getCards().get(0).equalTo(card)).isTrue();
    }

    @Test
    public void clearDeck_shouldEmptyDeck(){
        sut.addCard(fixture.create(Card.class));
        sut.addCard(fixture.create(Card.class));
        sut.addCard(fixture.create(Card.class));

        sut.clearDeck();

        assertThat(sut.getCards()).isEmpty();
    }

    @Test
    public void isEmpty_whenDeckIsEmpty_shouldReturnTrue(){
        sut.clearDeck();

        boolean result = sut.isEmpty();

        assertThat(result).isTrue();
    }

    @Test
    public void isEmpty_whenDeckIsNotEmpty_shouldReturnFalse(){
        sut.addCard(fixture.create(Card.class));

        boolean result = sut.isEmpty();

        assertThat(result).isFalse();
    }

    @Test
    public void getCards_shoulfReturnCardAddedInDeck(){
        Card card = fixture.create(Card.class);
        sut.addCard(card);

        List<Card> cards = sut.getCards();

        assertThat(cards).containsExactly(card);
     }

     @Test
    public void getId_shouldReturnDeckId(){
        int expectedId = fixture.create(Integer.class);
        Deck deck = new Deck(expectedId);

        int result = deck.getId();

        assertThat(result).isEqualTo(expectedId);
     }
}
