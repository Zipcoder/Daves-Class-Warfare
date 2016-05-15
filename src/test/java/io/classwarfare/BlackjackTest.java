package io.classwarfare;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;
/**
 * Created by markhauenstein on 5/11/16.
 */
public class BlackjackTest {
    @Test
    public void checkHandsForBlackJackTest(){
        Player player = new Player();
        Blackjack blackjack = new Blackjack(player);
        Hand hand = new Hand();
        boolean expected = false;
        boolean actual = blackjack.checkHandForBlackJack(hand);
        assertEquals("Hand should not have blackjack",expected,actual);
    }
    @Test
    public void checkIfHandIsOver21Test(){
        Player player = new Player();
        Blackjack blackjack = new Blackjack(player);
        Hand hand = new Hand();
        boolean expected = false;
        boolean actual = blackjack.checkIfHandIsOver21(hand);
        assertEquals("Hand should not be over 21, should retrun false",expected,actual);
    }
    @Test
    public void dealTest(){
        Player player = new Player();
        Blackjack blackjack = new Blackjack(player);
        blackjack.playerHand = new Hand();
        blackjack.dealerHand = new Hand();
        blackjack.deck = new Deck();
        blackjack.deal();
        int expected = 2;
        int actual = blackjack.playerHand.cardList.size();
        assertEquals("Hand should have a length of 2",expected,actual);
    }
    @Test
    public void hitTest(){
        Player player = new Player();
        Blackjack blackjack = new Blackjack(player);
        blackjack.playerHand = new Hand();
        blackjack.dealerHand = new Hand();
        blackjack.deck = new Deck();
        blackjack.hit(blackjack.playerHand);
        int expected = 1;
        int actual = blackjack.playerHand.cardList.size();
        assertEquals("Hand should have a length of 1",expected,actual);
    }
    @Test
    public void checkHandForBustTest(){
        Player player = new Player();
        Blackjack blackjack = new Blackjack(player);
        Hand hand = new Hand();
        hand.cardList.add(new Card(Suit.HEARTS,10,"",""));
        hand.cardList.add(new Card(Suit.CLUBS,10,"",""));
        hand.cardList.add(new Card(Suit.HEARTS,9,"",""));
        boolean expected = true;
        boolean actual = blackjack.checkIfHandIsOver21(hand);
        assertEquals("Hand should be over 21, and should be busted",expected,actual);
    }

/*
       @Test
    public void chooseHitOrStayTest(){
        Player player = new Player();
        Blackjack blackjack = new Blackjack(player);
        Scanner scanner = new Scanner();
        int hitOrStay = 1;
        Hand playerHand= new Hand();
        int expected = 1;
        blackjack.chooseHitOrStay(scanner);
        int actual = playerHand.cardList.size();
    }

    @Test
    public void decideWinnerTest(){
        Player player = new Player();
        Blackjack blackjack = new Blackjack(player);
        Hand dealerHand = new Hand();
        Hand playerHand = new Hand();
        Hand expected = dealerHand;
        blackjack.decideWinner();
        assertEquals("should return the dealers hand as the winning hand",expected,a);
    }
*/
}


