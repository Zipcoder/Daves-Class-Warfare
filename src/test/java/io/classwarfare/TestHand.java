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
        ArrayList<Card> playerCards = new ArrayList<Card>();
        Hand hand =new Hand();

        hand.checkValue();
        Assert.assertEquals("Hand check value should be :", 5, hand.checkValue(),0);
        }
    }

