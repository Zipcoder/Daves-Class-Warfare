package io.classwarfare;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by markhauenstein on 5/14/16.
 */
public class TexasHoldumTest {
    @Test
    public void pairTest(){
        Player player = new Player();
        TexasHoldum texas = new TexasHoldum(player);
        Hand hand = new Hand();
        hand.cardList.add(new Card(Suit.HEARTS,2,"",""));
        hand.cardList.add(new Card(Suit.CLUBS,2,"",""));
        hand.cardList.add(new Card(Suit.HEARTS,3,"",""));
        hand.cardList.add(new Card(Suit.HEARTS,4,"",""));
        hand.cardList.add(new Card(Suit.HEARTS,5,"",""));
        boolean expected = true;
        boolean actual = texas.hasPair(hand);
        assertEquals("Hand should have pair",expected,actual);
    }
    @Test
    public void twoPairTest(){
        Player player = new Player();
        TexasHoldum texas = new TexasHoldum(player);
        Hand hand = new Hand();
        hand.cardList.add(new Card(Suit.HEARTS,2,"",""));
        hand.cardList.add(new Card(Suit.CLUBS,2,"",""));
        hand.cardList.add(new Card(Suit.HEARTS,3,"",""));
        hand.cardList.add(new Card(Suit.CLUBS,3,"",""));
        hand.cardList.add(new Card(Suit.HEARTS,5,"",""));
        boolean expected = true;
        boolean actual = texas.hasTwoPair(hand);
        assertEquals("Hand should have two pairs",expected,actual);
    }
    @Test
    public void threeOfAKindTest(){
        Player player = new Player();
        TexasHoldum texas = new TexasHoldum(player);
        Hand hand = new Hand();
        hand.cardList.add(new Card(Suit.HEARTS,3,"",""));
        hand.cardList.add(new Card(Suit.CLUBS,2,"",""));
        hand.cardList.add(new Card(Suit.DIAMONDS,3,"",""));
        hand.cardList.add(new Card(Suit.HEARTS,6,"",""));
        hand.cardList.add(new Card(Suit.HEARTS,3,"",""));
        boolean expected = true;
        boolean actual = texas.hasThreeOfKind(hand);
        assertEquals("Hand should have three of a kind",expected,actual);
    }
    @Test
    public void straightTest(){
        Player player = new Player();
        TexasHoldum texas = new TexasHoldum(player);
        Hand hand = new Hand();
        hand.cardList.add(new Card(Suit.HEARTS,2,"",""));
        hand.cardList.add(new Card(Suit.CLUBS,3,"",""));
        hand.cardList.add(new Card(Suit.DIAMONDS,4,"",""));
        hand.cardList.add(new Card(Suit.HEARTS,6,"",""));
        hand.cardList.add(new Card(Suit.HEARTS,5,"",""));
        boolean expected = true;
        boolean actual = texas.hasStraight(hand);
        assertEquals("Hand should have a straight",expected,actual);
    }
    @Test
    public void flushTest(){
        Player player = new Player();
        TexasHoldum texas = new TexasHoldum(player);
        Hand hand = new Hand();
        hand.cardList.add(new Card(Suit.HEARTS,2,"",""));
        hand.cardList.add(new Card(Suit.HEARTS,3,"",""));
        hand.cardList.add(new Card(Suit.HEARTS,7,"",""));
        hand.cardList.add(new Card(Suit.HEARTS,5,"",""));
        hand.cardList.add(new Card(Suit.HEARTS,6,"",""));
        boolean expected = true;
        boolean actual = texas.hasFlush(hand);
        assertEquals("Hand should have a flush",expected,actual);
    }
    @Test
    public void fullHouseTest(){
        Player player = new Player();
        TexasHoldum texas = new TexasHoldum(player);
        Hand hand = new Hand();
        hand.cardList.add(new Card(Suit.DIAMONDS,2,"",""));
        hand.cardList.add(new Card(Suit.CLUBS,2,"",""));
        hand.cardList.add(new Card(Suit.HEARTS,2,"",""));
        hand.cardList.add(new Card(Suit.HEARTS,3,"",""));
        hand.cardList.add(new Card(Suit.DIAMONDS,3,"",""));
        boolean expected = true;
        boolean actual = texas.hasFullHouse(hand);
        assertEquals("Hand should have a full house",expected,actual);
    }
    @Test
    public void FourOfAKindTest(){
        Player player = new Player();
        TexasHoldum texas = new TexasHoldum(player);
        Hand hand = new Hand();
        hand.cardList.add(new Card(Suit.HEARTS,5,"",""));
        hand.cardList.add(new Card(Suit.CLUBS,2,"",""));
        hand.cardList.add(new Card(Suit.DIAMONDS,2,"",""));
        hand.cardList.add(new Card(Suit.SPADES,2,"",""));
        hand.cardList.add(new Card(Suit.HEARTS,2,"",""));
        boolean expected = true;
        boolean actual = texas.hasFourOfKind(hand);
        assertEquals("Hand should have four of a kind",expected,actual);
    }
    @Test
    public void StraightFlushTest(){
        Player player = new Player();
        TexasHoldum texas = new TexasHoldum(player);
        Hand hand = new Hand();
        hand.cardList.add(new Card(Suit.HEARTS,2,"",""));
        hand.cardList.add(new Card(Suit.HEARTS,3,"",""));
        hand.cardList.add(new Card(Suit.HEARTS,4,"",""));
        hand.cardList.add(new Card(Suit.HEARTS,5,"",""));
        hand.cardList.add(new Card(Suit.HEARTS,6,"",""));
        boolean expected = true;
        boolean actual = texas.hasStraightFlush(hand);
        assertEquals("Hand should have four of a kind",expected,actual);
    }
}
