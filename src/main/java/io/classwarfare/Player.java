package io.classwarfare;

import java.util.HashMap;


import static io.classwarfare.Sounds.*;

public class Player {
    private double wallet;
    private int playId;
    private double bet;
    private static int counter=1;
    private HashMap<String, Integer> betAndType;

    //set player balance to 5000, and Id;
    Player(){
        wallet=5000;
        playId=counter;
        bet=0;
        betAndType=new HashMap<String, Integer>();
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

    public void placeTypeAndBet(String type, int bet){
        if(bet !=-1){
            betAndType.put(type,bet);
            wallet-=bet;
        }
    }
    public void placeMultipleBets(double bet){
        this.bet+=bet;
        this.wallet-=bet;
    }

    public double showBalance(){
        return wallet;
    }

    public void collectWinnings(double amount){
        this.wallet+=amount;
        if(amount > 0){
        playGetMoneySound();}
    }

    public HashMap<String, Integer> getBetAndType() {
        return betAndType;
    }

    public double getBet(){
        return bet;
    }

    public double getWallet(){
        return wallet;
    }

    public double setbet(double amount) { return this.bet=amount; }

}
