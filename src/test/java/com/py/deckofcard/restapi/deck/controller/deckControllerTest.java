package com.py.deckofcard.restapi.deck.controller;

import com.py.deckofcard.restapi.TestBase;
import com.py.deckofcard.restapi.deck.bll.DeckService;
import com.py.deckofcard.restapi.deck.dto.CardDto;
import com.py.deckofcard.restapi.deck.dto.DeckDto;
import com.py.deckofcard.restapi.deck.exception.NoContentException;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class deckControllerTest extends TestBase {

    @Mock
    DeckService deckService;

    @InjectMocks
    DeckController sut;

    @Test
    public void createDeck_shouldCreateDeck(){
        sut.createDeck();

        verify(deckService).createDeck();
    }

    @Test
    public void shuffle_shouldShuffle(){
        int expectedDeckId = fixture.create(Integer.class);

        sut.shuffle(expectedDeckId);

        verify(deckService).shuffle(expectedDeckId);
    }

    @Test
    public void deal_shouldDealOneCard(){
        CardDto expectedCard = fixture.create(CardDto.class);
        int deckId = fixture.create(Integer.class);
        when(deckService.dealOneCard(deckId)).thenReturn(expectedCard);

        CardDto result = sut.deal(deckId);

        assertThat(result).isEqualTo(expectedCard);
    }

    @Test
    public void deal_whenDeckServiceReturnNull_ShouldThrowNoContentException(){
        int deckId = fixture.create(Integer.class);
        when(deckService.dealOneCard(deckId)).thenReturn(null);

        assertThatThrownBy(()->sut.deal(deckId)).isInstanceOf(NoContentException.class);
    }



    @Test
    public void getAllCard_shouldReturnDeckOfCards(){
        DeckDto expectedDeck = fixture.create(DeckDto.class);
        int deckId = fixture.create(Integer.class);
        when(deckService.getCardsInDeck(deckId)).thenReturn(expectedDeck);

        DeckDto result = sut.getAllCard(deckId);

        assertThat(result).isEqualTo(expectedDeck);
    }
}
