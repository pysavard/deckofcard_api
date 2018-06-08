package com.py.deckofcard.restapi.deck.entity.enums;

public enum Suits {

    Hearts("Heart", 1),
    Spades("Spade", 2),
    Clubs("Club", 3),
    Diamonds("Diamond", 4);

    private String name;
    private int value;

    Suits(String name, int value){
        this.name = name;
        this.value = value;
    }

    public String getName(){
        return name;
    }

    public int getValue() {
        return value;
    }

    public static Suits valueOf(int value)
    {
        switch (value){
            case 1:
                return Suits.Hearts;
            case 2:
                return Suits.Spades;
            case 3:
                return Suits.Clubs;
            case 4:
                return Suits.Diamonds;
        }
        throw new RuntimeException("Invalid suits value " + Integer.toString(value));
    }
}
