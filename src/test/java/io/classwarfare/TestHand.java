package io.classwarfare;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zihaocastine on 5/11/16.
 */
public class TestHand {
    @Test
    public void testCheckValue(){
        Hand hand =new Hand();

        hand.checkValue();
        Assert.assertEquals("Hand check value should be :", 5, hand.checkValue(),0);
        }
    }

