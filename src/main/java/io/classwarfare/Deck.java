package io.classwarfare;


import java.util.ArrayList;
import java.util.Collections;


public class Deck {
    ArrayList<Card> cards=new ArrayList<Card>();

    /**
     *  Deck constructor which adds for sets
     */
    Deck(){
        addSuitToDeck(Suit.SPADES);
        addSuitToDeck(Suit.CLUBS);
        addSuitToDeck(Suit.DIAMONDS);
        addSuitToDeck(Suit.HEARTS);
        shuffleCards();
    }

    /**
     *  SHUFFLES CARDS CURRENTLY STORED IN CARDS ARRAYLIST
     */
    public void shuffleCards(){
        Collections.shuffle(cards);
    }

    /**
     * @param suit METHOD ADDING 13 CARDS OF A SPECIFIED SUIT
     */
    protected void addSuitToDeck(Suit suit){
        String cardStructure = "|\n|    |";

        for(int i = 2; i < 11;i++){

            cards.add(new Card(suit,i,"",pickCardGraphic(suit)+i+cardStructure));
        }
        cards.add(new Card(suit,11,"ACE",pickCardGraphic(suit)+ "A" + cardStructure));
        cards.add(new Card(suit,10,"KING",pickCardGraphic(suit)+ "K" + cardStructure));
        cards.add(new Card(suit,10,"QUEEN",pickCardGraphic(suit)+ "Q" + cardStructure));
        cards.add(new Card(suit,10,"JACK",pickCardGraphic(suit)+ "J" + cardStructure));
    }

    /**
     *  HELPER METHOD TO ASSIGN SUIT SYMBOLS FOR CARD GRAPHICS
     */
    private String pickCardGraphic(Suit suit){
        String graphic = "";
        switch(suit){
            case SPADES:
                graphic = "______\n|  "+"\u2660";
                break;
            case HEARTS:
                graphic = "______\n|  "+"\u2665";
                break;
            case DIAMONDS:
                graphic = "______\n|  "+"\u2666";
                break;
            case CLUBS:
                graphic = "______\n|  "+"\u2663";
                break;
        }
        return graphic;
    }
}
