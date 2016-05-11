package io.classwarfare;

/**
 * Created by zihaocastine on 5/11/16.
 */
public class Player {
    private double wallet;
    private int playId;
    private double bet;
    private static int counter=1;

    //set player balance to 5000, and Id;
    Player(){
        wallet=5000;
        playId=counter;
        bet=0;
        counter++;
    }
    public void placeBet(double bet){
        this.wallet-=bet;
    }

    public double showBalance(){
        return wallet;
    }

    public void collectWinnings(double amount){
        this.wallet+=amount;
    }

}
