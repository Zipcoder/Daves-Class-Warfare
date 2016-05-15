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

    @Test  //Deck should be randomized after shuffleCards
    public void shuffleTest(){
        Deck deckShuffledTest = new Deck();
        Card expectedFirstCard = deckShuffledTest.cards.get(0);
        deckShuffledTest.shuffleCards();
        Card actualFirstCard = deckShuffledTest.cards.get(0);
        assertNotEquals("The two decks should be different",expectedFirstCard,actualFirstCard);
    }

    @Test  //newly added suit should have the correct numbers and symbols
    public void cardHasCorrectGraphicTest(){
        Deck deckGraphics = new Deck();
        deckGraphics.cards.clear();
        deckGraphics.addSuitToDeck(Suit.DIAMONDS);
        String firstCardGraphic = deckGraphics.cards.get(0).getGraphic();
        String expectedGraphic = "______\n| " + "\u2666" + "2 |\n|    |";
        assertEquals("The graphic should show a diamond",expectedGraphic,firstCardGraphic);
    }
}
