package io.classwarfare;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by markhauenstein on 5/11/16.
 */
public class BlackjackTest {
    @Test
    public void checkBlackjackTest(){
        Blackjack blackjack = new Blackjack();
        Hand hand = new Hand();
        boolean expected = false;
        boolean actual = blackjack.checkBlackJack(hand);
        assertEquals("the test should return false",expected,actual);
    }
    @Test
    public void checkBustTest(){
        Blackjack blackjack = new Blackjack();
        Hand hand = new Hand();
        boolean expected = false;
        boolean actual = blackjack.checkBust(hand);
        assertEquals("the test should return false",expected,actual);
    }
    @Test
    public void compareHandsTest(){
        Blackjack blackjack = new Blackjack();
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();
        Hand expected = dealerHand;
        Hand actual = blackjack.compareHands(playerHand,dealerHand);
        assertEquals("the test should return the dealers hand.",expected,actual);
    }
}
