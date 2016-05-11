package io.classwarfare;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by brianabbott on 5/11/16.
 */
public class CardTest {

    @Test
    public void cardConstructionTest(){
        Card testCard = new Card(Suit.SPADES,4,"");
        Suit expectedSuit = Suit.SPADES;
        int expectedValue = 4;
        String expectedFaceCard = "";
        Suit actualSuit = testCard.getSuit();
        int actualValue = testCard.getValue();
        String actualFaceValue = testCard.getFaceCard();
        assertEquals("The suit should be Spades",expectedSuit,actualSuit);
        assertEquals("The value should be 4",expectedValue,actualValue);
        assertEquals("The card should not be a facecard",expectedFaceCard,actualFaceValue);
    }

}
