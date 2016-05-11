package io.classwarfare;

/**
 * Created by brianabbott on 5/11/16.
 */
public class Card {
    private Suit suit;
    private int value;
    private String faceCard;

    /**
     *  Constructor for new cards which updates all fields
     */
    Card(Suit suit,int value, String faceCard){
        this.suit = suit;
        this.value = value;
        this.faceCard = faceCard;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getFaceCard() {
        return faceCard;
    }

    public void setFaceCard(String faceCard) {
        this.faceCard = faceCard;
    }
}
