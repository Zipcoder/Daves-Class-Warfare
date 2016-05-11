package io.classwarfare;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by brianabbott on 5/11/16.
 */
public class Deck {
    ArrayList<Card> cards=new ArrayList<Card>();

    /**
     *  Deck constructor which adds for sets
     */
    Deck(){
        addSuit(Suit.SPADES);
        addSuit(Suit.CLUBS);
        addSuit(Suit.DIAMONDS);
        addSuit(Suit.HEARTS);
        shuffle();
    }

    /**
     *  shuffles cards currently stored in cards array list
     */
    public void shuffle(){
        Collections.shuffle(cards);
    }

    /**
     * @param suit object detailing the suit of a set of 13 cards
     */
    private void addSuit(Suit suit){
        for(int i = 2; i < 11;i++){
            cards.add(new Card(suit,i,""));
        }
        cards.add(new Card(suit,11,"ACE"));
        cards.add(new Card(suit,10,"KING"));
        cards.add(new Card(suit,10,"QUEEN"));
        cards.add(new Card(suit,10,"JACK"));
    }

}
