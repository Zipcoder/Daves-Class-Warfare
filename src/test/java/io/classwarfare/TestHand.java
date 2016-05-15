package io.classwarfare;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by zihaocastine on 5/11/16.
 */
public class TestHand {
    @Test
    public void testCheckValue(){

        Hand hand =new Hand();
        hand.cardList.add(new Card(Suit.SPADES,5,"test",""));
        hand.checkValue();
        Assert.assertTrue("Hand check value should be :", hand.checkValue() == 5);
        }
    }

