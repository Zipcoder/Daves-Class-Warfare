package io.classwarfare;
import org.junit.Test;
import org.junit.Before.*;
import static org.junit.Assert.*;
/**
 * Created by wesleytraute on 5/11/16.
 */
public class SlotMachineTest {


    @Test
    public void spinTumblersTest() {
        //SlotMachine.spinTumblers();
        String[] expectedValue = {"7","BAR","BAR","BAR","JAVA","JAVA","JAVA","JAVA","JAVA","JAVA"};
        String[] actualValue = SlotMachine.getTumblers();
        assertArrayEquals("The tumblers should be equal",expectedValue,actualValue);
    }

    @Test
    public void checkTumblersTest() {
        boolean actualValue = SlotMachine.checkTumblers();
        assertTrue("The tumblers have not been spin, this should be true",actualValue);
    }

    @Test
    public void checkMultiplierTest() {
        int expectedValue = 5;
        int actualValue = SlotMachine.checkMultiplier();
        assertEquals("The multipliers should be equal", expectedValue,actualValue);
    }



}
