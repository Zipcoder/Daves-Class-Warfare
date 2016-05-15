package io.classwarfare;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zihaocastine on 5/11/16.
 */
public class PlayerTest {
    @Test
    public void testPlaceBet(){
        Player player=new Player();
        player.placeBet(100);
        Assert.assertEquals("The balance should be $4900 after the bet", 4900, player.showBalance(),0 );
    }

    @Test
    public void testShowBalance(){
        Player player=new Player();
        Assert.assertEquals("The initials balance should be $5000", 5000, player.showBalance(),0 );
    }

    @Test
    public void testCollectWinnings(){
        Player player=new Player();
        player.collectWinnings(500);
        Assert.assertEquals("The balance should be $5500 after collect winning", 5500, player.showBalance(),0 );
    }
}
