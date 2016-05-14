package io.classwarfare;

import static io.classwarfare.Sounds.*;

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
        if(bet == -1 ){
            this.bet = bet;
        } else {
            this.bet = bet;
            this.wallet -= bet;
        }
    }

    public double showBalance(){
        return wallet;
    }

    public void collectWinnings(double amount){
        this.wallet+=amount;
        if(amount > 0){
        playGetMoneySound();}
    }

    public double getBet(){
        return bet;
    }

    public double getWallet(){
        return wallet;
    }

}
