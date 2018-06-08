package com.py.deckofcard.restapi.deck.dao;

import com.py.deckofcard.restapi.TestBase;
import com.py.deckofcard.restapi.deck.entity.Card;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DeckDaoImplementationTest extends TestBase {

    @InjectMocks
    private DeckDaoImplementation sut;

    @Before
    public void Before(){
        //Because we are using static list.
        sut.emptyDeck();
    }

    @Test
    public void emptyDeck_ShouldDeleteAllCardFromDeck(){
        sut.addCard(fixture.create(Card.class));

        sut.emptyDeck();

        assertThat(sut.getAllCard().isEmpty()).isTrue();
    }

    @Test
    public void addCard_ShouldAddACardToTheList(){
        Card expectedCard= fixture.create(Card.class);

        sut.addCard(expectedCard);

        assertThat(sut.getAllCard())
                .filteredOn(x -> x.equalTo(expectedCard))
                .containsExactly(expectedCard);
    }

    @Test
    public void addCardWithValue_ShouldAddACardToTheList(){
        Card expectedCard= fixture.create(Card.class);

        sut.addCard(expectedCard.getSuit(), expectedCard.getCardValue());

        assertThat(sut.getAllCard().get(0).equalTo(expectedCard)).isTrue();
    }

    @Test
    public void removeCard_whenCardExist_shouldRemoveCard(){
        Card cardToRemove = fixture.create(Card.class);
        sut.addCard(cardToRemove);

        sut.removeCard(cardToRemove);

        assertThat(sut.getAllCard()).doesNotContain(cardToRemove);
    }

    @Test
    public void removeCard_whenCardNotPresent_shouldThrow(){
        assertThatThrownBy(() -> sut.removeCard(fixture.create(Card.class)))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void getAllCard_shouldReturnAllCard(){
        Card expectedCard1 = fixture.create(Card.class);
        Card expectedCard2 = fixture.create(Card.class);
        Card expectedCard3 = fixture.create(Card.class);

        sut.addCard(expectedCard1);
        sut.addCard(expectedCard2);
        sut.addCard(expectedCard3);

        assertThat(sut.getAllCard()).contains(expectedCard1, expectedCard2, expectedCard3);
    }
}
