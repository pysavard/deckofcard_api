package com.py.deckofcard.restapi.deck.entity;


import com.py.deckofcard.restapi.TestBase;
import com.py.deckofcard.restapi.deck.dto.CardDto;
import com.py.deckofcard.restapi.deck.entity.enums.CardValue;
import com.py.deckofcard.restapi.deck.entity.enums.Suits;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CardTest extends TestBase {

    @Test
    public void equalTo_withCardParameters_whenSuitAndValueAreEqual_ShouldReturnTrue(){
        Card card = fixture.create(Card.class);
        Card card2 = new Card(card.getSuit(), card.getCardValue());

        boolean result = card.equalTo(card2);

        assertThat(result).isTrue();
    }

    @Test
    public void equalTo_withCardParameters_whenSuitsAreNotEqual_shouldReturnFalse(){
        Card card = new Card(Suits.Diamonds, CardValue.Ace);
        Card card2 = new Card(Suits.Clubs, card.getCardValue());

        boolean result = card.equalTo(card2);

        assertThat(result).isFalse();
    }

    @Test
    public void equalTo_withCardParameters_whenCardValueAreNotEqual_shoudlReturnFalse(){
        Card card = new Card(Suits.Clubs, CardValue.Ace);
        Card card2 = new Card(Suits.Clubs, CardValue.King);

        boolean result = card.equalTo(card2);

        assertThat(result).isFalse();
    }

    @Test
    public void equalTo_withCardDtoParameters_whenSuitAndValueAreEqual_ShouldReturnTrue(){
        Card card = fixture.create(Card.class);
        Card card2 = new Card(card.getSuit(), card.getCardValue());

        boolean result = card.equalTo(new CardDto(card2));

        assertThat(result).isTrue();
    }

    @Test
    public void equalTo_withCardDtoParameters_whenSuitsAreNotEqual_shouldReturnFalse(){
        Card card = new Card(Suits.Diamonds, CardValue.Ace);
        Card card2 = new Card(Suits.Clubs, card.getCardValue());

        boolean result = card.equalTo(new CardDto(card2));

        assertThat(result).isFalse();
    }

    @Test
    public void equalTo_withCardDtoParameters_whenCardValueAreNotEqual_shoudlReturnFalse(){
        Card card = new Card(Suits.Clubs, CardValue.Ace);
        Card card2 = new Card(Suits.Clubs, CardValue.King);

        boolean result = card.equalTo(new CardDto(card2));

        assertThat(result).isFalse();
    }
}
