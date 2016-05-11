package io.classwarfare;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by brianabbott on 5/11/16.
 */
public class DeckTest {

    @Test   //New Deck should have 52 cards added by the addsuit method in the constructor
    public void deckDefaultSizeTest(){
        Deck deckSuitTest = new Deck();
        int expectedDeckSize = 52;
        int actualDeckSize = deckSuitTest.cards.size();
        assertEquals("The deck should have 52 cards",expectedDeckSize,actualDeckSize);
    }

    @Test
    public void shuffleTest(){
        Deck deckShuffledTest = new Deck();
        Card expectedFirstCard = deckShuffledTest.cards.get(0);
        deckShuffledTest.shuffle();
        Card actualFirstCard = deckShuffledTest.cards.get(0);
        assertNotEquals("The two decks should be different",expectedFirstCard,actualFirstCard);
    }
}
