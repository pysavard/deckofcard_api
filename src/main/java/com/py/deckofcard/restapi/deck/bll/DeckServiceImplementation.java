package com.py.deckofcard.restapi.deck.bll;

import com.py.deckofcard.restapi.deck.dao.DeckDao;
import com.py.deckofcard.restapi.deck.dto.CardDto;
import com.py.deckofcard.restapi.deck.dto.DeckDto;
import com.py.deckofcard.restapi.deck.entity.Card;
import com.py.deckofcard.restapi.deck.entity.enums.CardValue;
import com.py.deckofcard.restapi.deck.entity.enums.Suits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class DeckServiceImplementation implements DeckService {

    @Autowired
    private DeckDao deckDao;

    private Object lockDeck = new Object();

    @Override
    public void shuffle() {
        synchronized (lockDeck) {
            deckDao.emptyDeck();
            for (int suitsValue = 1; suitsValue <= 4; suitsValue++) {
                for (int cardsValue = 1; cardsValue <= 13; cardsValue++) {
                    deckDao.addCard(Suits.valueOf(suitsValue), CardValue.getCardFromValue(cardsValue));
                }
            }
        }
    }

    @Override
    public CardDto dealOneCard() {
        synchronized (lockDeck) {
            List<Card> cards =  deckDao.getAllCard();
            if (cards.isEmpty()) return new CardDto();
            return dealARandomCard(cards);
        }
    }

    private CardDto dealARandomCard(List<Card> cards)
    {
        Random rand = new Random();
        Card randomCard = cards.get(rand.nextInt(cards.size()));
        deckDao.removeCard(randomCard);
        return new CardDto(randomCard);
    }

    @Override
    public DeckDto getCardsInDeck() {
        return new DeckDto(deckDao.getAllCard());
    }
}
