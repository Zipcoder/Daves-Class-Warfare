package io.classwarfare;

import java.util.*;
import java.util.Scanner;

/**
 * Created by markhauenstein on 5/14/16.
 */
public class TexasHoldum implements CardGame {
    Player player;
    Hand playerHand;
    Hand dealerHand;
    Hand cardsOnTable;
    int cardsPulledFromDeck;
    int playerScore;
    int dealerScore;
    Deck deck;
    Scanner input;
    boolean gameInSession;
    double bet;
    double betIncrease;
    int betOrFold;

    public TexasHoldum(Player player){
        this.player = player;
    }


    public void play(){
        input = new Scanner(System.in);
        gameInSession = true;
        Player player = new Player();
        while (gameInSession && player.showBalance()>10) {

            cardsPulledFromDeck = 0;
            playerScore = 0;
            dealerScore = 0;
            bet = 0;
            betIncrease = 0;
            betOrFold = 0;
            deck = new Deck();
            playerHand = new Hand();
            dealerHand = new Hand();
            cardsOnTable = new Hand();

            player.payToPot(10);
            System.out.println("You ante $10");
            deal();
            showHand();
            for(int i=0;i<3;i++){
                System.out.println("Press 1 to bet, 2 to fold");
                betOrFold = input.nextInt();
                if(betOrFold==2){
                    break;
                }
                makeABet(input);
                showHandAndRiver();
            }
            if(betOrFold==2){
                player.payToPot(bet+10);
                if(!PlayAgain()){
                    break;
                }
                continue;
            }
            makeABet(input);
            playerHand.cardList.addAll(cardsOnTable.cardList);
            dealerHand.cardList.addAll(cardsOnTable.cardList);
            playerScore = giveScore(playerHand);
            dealerScore = giveScore(dealerHand);
            decideWinner(playerScore,dealerScore);
            if(!PlayAgain()){
                break;
            }
        }
    }

    public static void main(String[] args) {
        Player player = new Player();
        TexasHoldum texas = new TexasHoldum(player);
        texas.play();
    }
    public void makeABet(Scanner input){
        System.out.println("you have $"+(player.showBalance()-bet)+" in your account\nPlace your bet:");
        betIncrease = input.nextInt();
        while(betIncrease<100){
            System.out.println("You must bet at least $100 in order to continue");
            betIncrease = input.nextInt();
        }
        bet+=betIncrease;
        hit(cardsOnTable);
    }

    public void decideWinner(int playScore, int dealerScore){
        tieCheck(playerScore,dealerScore);
        if(playerScore>dealerScore){
            System.out.println("CONGRATULATIONS! YOU WON $"+((bet*2)+20));
            player.collectWinnings(bet+20);
        }else if (dealerScore>playerScore){
            playerLoss();
        }
    }
    public boolean PlayAgain(){
        boolean stopGame = false;
        System.out.println("Would you like to play again? 1 for Yes, 2 for No");
        int choice = input.nextInt();
        if (choice==1){
            stopGame = true;
        }
        return stopGame;
    }

    // prints the First card of the dealer, and all the cards in the players hand.
    public void showHand(){
       System.out.print("Your hand is a |");
        for(int i =0;i<playerHand.cardList.size();i++){
            System.out.print(playerHand.cardList.get(i).getValue()+" of "+playerHand.cardList.get(i).getSuit()+"|");
        }
    }
    public void playerLoss(){
        System.out.print("You lose, dealer had a \n|");
        for(int i =0;i<playerHand.cardList.size();i++){
            System.out.print(dealerHand.cardList.get(i).getValue()+" of "+dealerHand.cardList.get(i).getSuit()+"|");
        }
    }
    public void showHandAndRiver(){
        System.out.print("Your hand is a |");
        for(int i =0;i<playerHand.cardList.size();i++){
            System.out.print(playerHand.cardList.get(i).getValue()+" of "+playerHand.cardList.get(i).getSuit()+"|");
        }
        System.out.print(" The River is |");
        for(int i = 0; i< cardsOnTable.cardList.size(); i++){
            System.out.print(cardsOnTable.cardList.get(i).getValue()+" of "+ cardsOnTable.cardList.get(i).getSuit()+"|");
        }
    }
    // Deal method is used to give the player and the dealer two cards each.
    public void deal() {
        playerHand.cardList.add(deck.cards.get(cardsPulledFromDeck));
        cardsPulledFromDeck++;
        dealerHand.cardList.add(deck.cards.get(cardsPulledFromDeck));
        cardsPulledFromDeck++;
        playerHand.cardList.add(deck.cards.get(cardsPulledFromDeck));
        cardsPulledFromDeck++;
        dealerHand.cardList.add(deck.cards.get(cardsPulledFromDeck));
        cardsPulledFromDeck++;
    }
    // hit method adds a card to the Hand that is passed into it.
    public void hit(Hand hand) {
        hand.cardList.add(deck.cards.get(cardsPulledFromDeck));
        cardsPulledFromDeck++;
    }
    public boolean hasPair(Hand hand){
       boolean hasAPair = false;
        for (int i=0;i<5;i++){
            for(int ii=(i+1);i<5;i++){
                if(hand.cardList.get(i).getValue()==hand.cardList.get(ii).getValue()){
                    hasAPair = true;
                }
            }
        }
       return hasAPair;
    }
    public boolean hasTwoPair(Hand hand){
        boolean hasATwoPair = false;
        int counter=0;
        for (int i=0;i<5;i++){
            for(int ii=(i+1);i<5;i++){
                if(hand.cardList.get(i).getValue()==hand.cardList.get(ii).getValue()){
                    counter++;
                }
            }
        }
        if (counter>=2){
            hasATwoPair = true;
        }
        return hasATwoPair;
    }
    public boolean hasThreeOfKind(Hand hand){
        boolean hasAThreeOfKind = false;
        ArrayList<Integer> arrayOfValuesWithPairs = new ArrayList<Integer>();
        int counter = 0;
        for (int i=0;i<5;i++){
            for(int ii=(i+1);ii<5;ii++){
                if(hand.cardList.get(i).getValue()==hand.cardList.get(ii).getValue()){
                    arrayOfValuesWithPairs.add(hand.cardList.get(i).getValue());
                }
            }
        }
        for (int i=0;i<arrayOfValuesWithPairs.size();i++){
            counter = 0;
            for(int ii=0;ii<5;ii++){
            if (arrayOfValuesWithPairs.get(i)==hand.cardList.get(ii).getValue()){
                counter++;
            }
        }
            if(counter==3){
                hasAThreeOfKind = true;
            }
        }
        return hasAThreeOfKind;
    }
    public boolean hasStraight(Hand hand){
        boolean hasAStraight = false;
        int counter = 0;
        int[] valueArray = new int[5];
        for(int i=0;i<5;i++){
            valueArray[i]=hand.cardList.get(i).getValue();
        }
        Arrays.sort(valueArray);
        for(int i=0;i<4;i++){
            if(valueArray[i]==(valueArray[i+1]-1)){
                counter++;
            }
        }
        if(counter==4){
            hasAStraight = true;
        }
        return hasAStraight;
    }
    public boolean hasFlush(Hand hand){
        boolean hasAStraight = false;
        int counter = 0;
        Enum[] valueArray = new Enum[5];
        for(int i=0;i<5;i++){
            valueArray[i]=hand.cardList.get(i).getSuit();
        }
        Arrays.sort(valueArray);
        for(int i=0;i<4;i++){
            if(valueArray[i].equals((valueArray[i+1]))){
                counter++;
            }
        }
        if(counter==4){
            hasAStraight = true;
        }
        return hasAStraight;
    }

    public boolean hasFullHouse(Hand hand) {
        boolean hasFullHouse = false;
        ArrayList<Integer> arrayOfValuesWithPairs = new ArrayList<Integer>();
        int counter = 0;
        for (int i = 0; i < 5; i++) {
            for (int ii = (i + 1); ii < 5; ii++) {
                if (hand.cardList.get(i).getValue() == hand.cardList.get(ii).getValue()) {
                    arrayOfValuesWithPairs.add(hand.cardList.get(i).getValue());
                }
            }
        }
        for (int i = 0; i < arrayOfValuesWithPairs.size(); i++) {
            counter = 0;
            for (int ii = 0; ii < 5; ii++) {
                if (arrayOfValuesWithPairs.get(i) == hand.cardList.get(ii).getValue()) {
                    counter++;
                }
            }
            if ((counter == 3 && arrayOfValuesWithPairs.size() == 4)) {
                hasFullHouse = true;
            }
        }
            return hasFullHouse;
        }


    public boolean hasFourOfKind(Hand hand){
        boolean hasAFourOfKind = false;
        ArrayList<Integer> findThisFourTimes = new ArrayList<Integer>();
        int counter = 0;
        for (int i=0;i<5;i++){
            for(int ii=(i+1);ii<5;ii++){
                if(hand.cardList.get(i).getValue()==hand.cardList.get(ii).getValue()){
                    findThisFourTimes.add(hand.cardList.get(i).getValue());
                }
            }
        }
        for (int i=0;i<findThisFourTimes.size();i++){
            counter = 0;
            for(int ii=0;ii<5;ii++){
                if (findThisFourTimes.get(i)==hand.cardList.get(ii).getValue()){
                    counter++;
                }
            }
            if(counter==4){
                hasAFourOfKind = true;
            }
        }
        return hasAFourOfKind;
    }
    public boolean hasStraightFlush(Hand hand){
        boolean hasAStraightFlush=false;
        if(hasFlush(hand)&&hasStraight(hand)){
            hasAStraightFlush=true;
        }
        return hasAStraightFlush;
    }
    public int giveScore(Hand hand){
        int score=0;
        if(hasPair(hand)){
           score =1;
        }
        if(hasTwoPair(hand)){
            score=2;
        }
        if(hasThreeOfKind(hand)){
            score=3;
        }
        if(hasStraight(hand)){
            score=4;
        }
        if(hasFlush(hand)){
            score=5;
        }
        if(hasFullHouse(hand)){
            score=6;
        }
        if(hasFourOfKind(hand)){
            score=7;
        }
        if(hasStraightFlush(hand)){
            score=8;
        }
        return score;
    }

    public void tieCheck(int playerScore, int dealerScore) {
        int playerHighCard = 0;
        int dealerHighCard = 0;
        if (playerScore == dealerScore) {
            for (int i = 0; i < 5; i++) {
                if (playerHand.cardList.get(i).getValue() > playerHighCard) {
                    playerHighCard = playerHand.cardList.get(i).getValue();
                }
                if (dealerHand.cardList.get(i).getValue() > dealerHighCard) {
                    dealerHighCard = dealerHand.cardList.get(i).getValue();
                }
            }
        }
        if (playerHighCard==11){
            playerHighCard=14;
        }
        if (dealerHighCard==11){
            dealerHighCard=14;
        }
        if (playerHighCard==10){
            for (int i = 0; i < 5; i++) {
               if(dealerHand.cardList.get(i).getFaceCard().equals("JACK")){
                    if (dealerHighCard < 12){
                        dealerHighCard = 11;
                    }
                }
            if(dealerHand.cardList.get(i).getFaceCard().equals("QUEEN")){
                    if (dealerHighCard < 13){
                        dealerHighCard = 12;
                    }
                }
            if(dealerHand.cardList.get(i).getFaceCard().equals("KING")){
                    if (dealerHighCard < 14){
                        dealerHighCard = 13;
                    }
                }
            }
        }
        if(playerHighCard>dealerHighCard){
            playerScore++;
        } else if (dealerHighCard>=playerHighCard){
            dealerScore++;
        }
    }

}

