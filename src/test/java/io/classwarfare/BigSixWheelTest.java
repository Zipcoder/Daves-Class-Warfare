package io.classwarfare;

import org.junit.Assert;
import org.junit.Test;


/**
 * Created by zihaocastine on 5/14/16.
 */
public class BigSixWheelTest {
    @Test
    public void TestWheelNumber(){
        Player player=new Player();
        BigSixWheel bigSixWheel=new BigSixWheel(player);
        bigSixWheel.spinningWheel();
        Assert.assertEquals("Answer should be true", true,bigSixWheel.checkType(bigSixWheel.wheelNumber));
        /*
        ByteArrayInputStream ind=new ByteArrayInputStream("20".getBytes());
        System.setIn(ind);
       // System.setIn(new ByteArrayInputStream("20".getBytes()));
        //bigSixWheel.abc();
        */
    }

    @Test
    public void TestCalculateWinning(){
        Player player=new Player();
        BigSixWheel bigSixWheel=new BigSixWheel(player);
        player.placeTypeAndBet("20",20);
        bigSixWheel.wheelNumber= "20";
        player.collectWinnings(bigSixWheel.calculateWinning());
        Assert.assertEquals("Answer should be 5380", 5380,player.getWallet(),0);

    }



}
