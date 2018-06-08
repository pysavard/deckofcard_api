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
            deck.clearDeck();
            for (int suitsValue = 1; suitsValue <= 4; suitsValue++) {
                for (int cardsValue = 1; cardsValue <= 13; cardsValue++) {
                    deck.addCard(Suits.valueOf(suitsValue), CardValue.getCardFromValue(cardsValue));
                }
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
        Random rand = new Random();
        Card randomCard = cards.get(rand.nextInt(cards.size()));
        removeCard(deck, randomCard);
        return new CardDto(randomCard);
    }

    private void removeCard(Deck deck, Card card){
        if (!deck.getCards()
                .removeIf(x -> x.getValue() == card.getValue() && x.getSuit() == card.getSuit()))
        {
            throw new RuntimeException("Card not present in deck");
        }
    }

    @Override
    public DeckDto getCardsInDeck(int deckId) {
        Deck deck = deckCollectionDao.getDeck(deckId);

        return new DeckDto(deck);
    }

    @Override
    public DeckDto createDeck() {
        return new DeckDto(deckCollectionDao.createDeck());
    }
}
