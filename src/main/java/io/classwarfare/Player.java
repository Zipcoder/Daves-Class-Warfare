package io.classwarfare;


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
        this.bet=bet;
        this.wallet-=bet;
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
    }

    public double getBet(){
        return bet;
    }

    public double getWallet(){
        return wallet;
    }

    public double setbet(double amount) { return this.bet=amount; }

}
