package io.classwarfare;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
public class RussianRouletteTest {

    RussianRoulette russianRouletteTest;
    Player testPlayer;

    //NEED TO SIMULATE INPUT HERE

    @Before
    public void russianRouletteTestSetup() {
        testPlayer = new Player();
        russianRouletteTest = new RussianRoulette(testPlayer);
        russianRouletteTest.play();
    }
/*
    @Test
    public void pullTriggerTest(){
        boolean actualValue = russianRouletteTest.pullTrigger();
        assertTrue("This should be true", actualValue);
    }
*/
    @Test
    public void payTest() {
        double expectedValue = 5;
        double actualValue = russianRouletteTest.pay(5);
        assertEquals("It should return the passed value",expectedValue,actualValue,0.0);
    }

}
