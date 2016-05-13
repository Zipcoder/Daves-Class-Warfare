package io.classwarfare;


public class Card {
    private Suit suit;
    private int value;
    private String faceCard;
    private String graphic;

    /**
     *  CONSTRUCTOR FOR NEW CARDS WHICH UPDATES ALL FIELDS
     */
    Card(Suit suit,int value, String faceCard,String graphic){
        this.suit = suit;
        this.value = value;
        this.faceCard = faceCard;
        this.graphic = graphic;
    }

    /**
     * GETTERS AND SETTERS
     */
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

    public String getGraphic() {
        return graphic;
    }

    public void setGraphic(String graphic) {
        this.graphic = graphic;
    }
}
