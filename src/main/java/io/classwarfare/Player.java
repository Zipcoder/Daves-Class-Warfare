package io.classwarfare;

import java.util.HashMap;


import static io.classwarfare.Sounds.*;

public class Player {
    private double wallet;
    private int playId;
    private double bet;
    private static int counter=1;
    private HashMap<String, Integer> betAndType;

    /**
     *  PLAYER CONSTRUCTOR
     */
    Player(){
        wallet=5000;
        playId=counter;
        bet=0;
        betAndType=new HashMap<String, Integer>();
        counter++;
    }

    /**
     *  GETTERS AND SETTERS
     */
    public double getBet(){
        return bet;
    }

    public double getWallet(){
        return wallet;
    }

    public double setbet(double amount) { return this.bet=amount; }

    /**
     * PLACES A SINGLE BET and DEDUCTS FROM WALLET
     */
    public void placeBet(double bet){
        if(bet == -1 ){
            this.bet = bet;
        } else {
            this.bet = bet;
            this.wallet -= bet;
        }
    }

    /**
     * PLACE TYPE OF BET AND AMOUNT
     */
    public void placeTypeAndBet(String type, int bet){
        if(bet !=-1){
            betAndType.put(type,bet);
            wallet-=bet;
        }
    }

    /**
     * PLACES MULTIPLE BETS BET and DEDUCTS FROM WALLET
     */
    public void placeMultipleBets(double bet){
        this.bet+=bet;
        this.wallet-=bet;
    }

    /**
     *  SHOWS CURRENT PLAYER BALANCE
     */
    public double showBalance(){
        return wallet;
    }

    /**
     * COLLECTS WINNINGS FROM PARAMETER AND ADDS TO WALLET.
     */
    public void collectWinnings(double amount){
        this.wallet+=amount;
        if(amount > 0){
        playGetMoneySound();}
    }

    /**
     * TAKES TYPE OF BET FOR BIG SIX WHEEL CLASS
     */
    public HashMap<String, Integer> getBetAndType() {
        return betAndType;
    }
}
