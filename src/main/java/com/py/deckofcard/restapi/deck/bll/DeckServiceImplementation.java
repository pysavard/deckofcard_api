package com.py.deckofcard.restapi.deck.bll;

import com.py.deckofcard.restapi.deck.dao.DeckDao;
import com.py.deckofcard.restapi.deck.dto.DeckDto;
import com.py.deckofcard.restapi.deck.entity.Card;
import com.py.deckofcard.restapi.deck.entity.enums.Suits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                    deckDao.addCard(Suits.valueOf(suitsValue), cardsValue);
                }
            }
        }
    }

    @Override
    public Card dealOneCard() {
        synchronized (lockDeck) {
            //TODO
            return null;
        }
    }

    @Override
    public DeckDto getCardsInDeck() {
        return new DeckDto(deckDao.getAllCard());
    }
}
