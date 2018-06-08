package com.py.deckofcard.restapi.deck.entity.enums;

public enum CardValue {

    Ace(1, "Ace"),
    Two(2, "2"),
    Three(3, "3"),
    Four(4, "4"),
    Five(5, "5"),
    Six(6, "6"),
    Seven(7, "7"),
    Eight(8, "8"),
    Nine(9, "9"),
    Ten(10, "10"),
    Jack(11, "Jack"),
    Queen(12, "Queen"),
    King(13, "King");

    private CardValue(int value, String name){
        this.value = value;
        this.name  = name;
    }

    private int value;
    private String name;

    public int getValue() { return value;}
    public String getName() { return name;}

    public static CardValue getCardFromValue(int cardValue) {
        for (CardValue currentCardValue : CardValue.values()) {
            if (currentCardValue.value == cardValue) return currentCardValue;
        }
        throw new RuntimeException("CardValue does not exist");
    }
}
