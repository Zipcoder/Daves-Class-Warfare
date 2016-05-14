package io.classwarfare;
import org.junit.Before;
import org.junit.Test;
import org.junit.Before.*;
import static org.junit.Assert.*;
/**
 * Created by wesleytraute on 5/11/16.
 */
public class SlotMachineTest {
    Game slots;
    Player player;

    @Before
    public void slotMachineTestSetup() {
        player = new Player();
        slots = new SlotMachine(player);
        player.placeBet(5);
        slots.play();
    }

    @Test
    public void gameWalletTest() {
        double expectedValue = 2000000;
        double actualValue = slots.getWallet();
        assertNotEquals("Should have deducted money from game wallet", expectedValue, actualValue);
    }

    @Test
    public void playerWalletTest() {
        double expectedValue = 5000;
        double actualValue = player.getWallet();
        assertNotEquals("Should deduct money from player wallet", expectedValue, actualValue);
    }

    @Test
    public void payoutChangeTest() {
        double expectedValue = 5;
        double actualValue = SlotMachine.payOut;
        assertNotEquals("Payout should be different then the bet",expectedValue,actualValue);
    }

    @Test
    public void winStringChangeTest() {
        String expectedValue = "";
        String actualValue = SlotMachine.winString;
        assertNotEquals("The win string should have initialized",expectedValue,actualValue);
    }

}

