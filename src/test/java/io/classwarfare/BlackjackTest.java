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
        Player player = new Player();
        Blackjack blackjack = new Blackjack(player);
        Hand hand = new Hand();
        boolean expected = false;
        boolean actual = blackjack.checkBlackJack(hand);
        assertEquals("the test should return false",expected,actual);
    }
    @Test
    public void checkBustTest(){
        Player player = new Player();
        Blackjack blackjack = new Blackjack(player);
        Hand hand = new Hand();
        boolean expected = false;
        boolean actual = blackjack.checkBust(hand);
        assertEquals("the test should return false",expected,actual);
    }
    @Test
    public void compareHandsTest(){
        Player player = new Player();
        Blackjack blackjack = new Blackjack(player);
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();
        Hand expected = dealerHand;
        Hand actual = blackjack.compareHands(playerHand,dealerHand);
        assertEquals("the test should return the dealers hand.",expected,actual);
    }
    @Test
    public void dealTest(){
        Player player = new Player();
        Blackjack blackjack = new Blackjack(player);
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();
        Deck deck = new Deck();
        int expectedHandLength = 2;
        blackjack.deal(playerHand,dealerHand,deck);
        int actualHandLength = playerHand.cardList.size();
        assertEquals("The size of the hand should be two",expectedHandLength,actualHandLength);
    }
    @Test
    public void hitTest(){
        Player player = new Player();
        Blackjack blackjack = new Blackjack(player);
        Deck deck = new Deck();
        Hand playerHand = new Hand();
        int expectedHandLength = 1;
        blackjack.hit(playerHand, deck);
        int actualHandLength = playerHand.cardList.size();
        assertEquals("The size of the hand should be one",expectedHandLength,actualHandLength);
    }
}
