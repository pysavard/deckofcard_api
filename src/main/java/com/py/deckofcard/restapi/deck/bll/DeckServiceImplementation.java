package com.py.deckofcard.restapi.deck.bll;

import com.py.deckofcard.restapi.deck.dao.DeckCollectionDao;
import com.py.deckofcard.restapi.deck.dto.CardDto;
import com.py.deckofcard.restapi.deck.dto.DeckDto;
import com.py.deckofcard.restapi.deck.entity.Card;
import com.py.deckofcard.restapi.deck.entity.Deck;
import com.py.deckofcard.restapi.deck.entity.enums.CardValue;
import com.py.deckofcard.restapi.deck.entity.enums.Suits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class DeckServiceImplementation implements DeckService {

    @Autowired
    private DeckCollectionDao deckCollectionDao;

    private Object lockDeck = new Object();

    @Override
    public void shuffle(int deckId) {
        synchronized (lockDeck) {
            Deck deck = deckCollectionDao.getDeck(deckId);
            Random rand = new Random();
            List<Card> cards = deck.getCards();
            int deckSize = cards.size();

            for ( int i = 0 ; i < deck.getCards().size(); i++)
            {
                Card currentCard = cards.get(i);
                int randomPosition = rand.nextInt(deckSize - i);
                cards.set(i, cards.get(randomPosition));
                cards.set(randomPosition,currentCard );
            }
        }
    }

    public void createDeck(Deck deck){
        deck.clearDeck();
        for (int suitsValue = 1; suitsValue <= 4; suitsValue++) {
            for (int cardsValue = 1; cardsValue <= 13; cardsValue++) {
                deck.addCard(Suits.valueOf(suitsValue), CardValue.getCardFromValue(cardsValue));
            }
        }
    }

    @Override
    public CardDto dealOneCard(int deckId) {
        synchronized (lockDeck) {
            Deck deck = deckCollectionDao.getDeck(deckId);

            List<Card> cards =  deck.getCards();
            if (cards.isEmpty()) return new CardDto();
            return dealARandomCard(deck, cards);
        }
    }

    private CardDto dealARandomCard(Deck deck, List<Card> cards)
    {
        Card randomCard = cards.get(0);
        deck.getCards().remove(0);
        return new CardDto(randomCard);
    }

    @Override
    public DeckDto getCardsInDeck(int deckId) {
        Deck deck = deckCollectionDao.getDeck(deckId);

        return new DeckDto(deck);
    }

    @Override
    public DeckDto createDeck() {
        Deck deck = deckCollectionDao.createDeck();
        createDeck(deck);
        return new DeckDto(deck);
    }
}
