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
    public void chooseHitOrStayTest(){
        
    }
}

