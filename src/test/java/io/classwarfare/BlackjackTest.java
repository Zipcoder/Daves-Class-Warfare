package io.classwarfare;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
/**
 * Created by markhauenstein on 5/11/16.
 */
public class BlackjackTest {
    @Test
    public void checkBlackjackTest(){
        Blackjack blackjack = new Blackjack();
        Card testCard = new Card(Suit.SPADES,4,"");
        ArrayList<Card> playerCards = new ArrayList<Card>();
        Hand hand = new Hand(playerCards);
        boolean expected = false;
        boolean actual = blackjack.checkBlackJack(hand);
        assertEquals("the test should return false",expected,actual);
    }
    @Test
    public void checkBustTest(){
        Blackjack blackjack = new Blackjack();
        ArrayList<Card> playerCards = new ArrayList<Card>();
        Hand hand = new Hand(playerCards);
        boolean expected = false;
        boolean actual = blackjack.checkBust(hand);
        assertEquals("the test should return false",expected,actual);
    }
    @Test
    public void compareHandsTest(){
        Blackjack blackjack = new Blackjack();
        ArrayList<Card> playerCards = new ArrayList<Card>();
        ArrayList<Card> dealerCards = new ArrayList<Card>();
        Hand playerHand = new Hand(playerCards);
        Hand dealerHand = new Hand(dealerCards);
        Hand expected = dealerHand;
        Hand actual = blackjack.compareHands(playerHand,dealerHand);
        assertEquals("the test should return the dealers hand.",expected,actual);
    }
    @Test
    public void dealTest(){
        Blackjack blackjack = new Blackjack();
        ArrayList<Card> playerCards = new ArrayList<Card>();
        Hand playerHand = new Hand(playerCards);
        int expectedHandLength = 2;
        blackjack.deal();
        int actualHandLength = playerHand.cardList.size();
        assertEquals("The size of the hand should be two",expectedHandLength,actualHandLength);
    }
    @Test
    public void hitTest(){
        Blackjack blackjack = new Blackjack();
        ArrayList<Card> playerCards = new ArrayList<Card>();
        Hand playerHand = new Hand(playerCards);
        int expectedHandLength = 1;
        blackjack.hit(playerHand);
        int actualHandLength = playerHand.cardList.size();
        assertEquals("The size of the hand should be one",expectedHandLength,actualHandLength);
    }
}
