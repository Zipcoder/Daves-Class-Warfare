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
    double betIncrease;
    int betOrFold;

    public TexasHoldum(Player player){
        this.player = player;
    }


    public void play(){
        input = new Scanner(System.in);
        gameInSession = true;
        while (gameInSession && player.showBalance()>10) {
            resetGame();
            for(int i=0;i<3;i++){
                System.out.println("\nPress 1 to bet, 2 to fold");
                betOrFold = input.nextInt();
                if(betOrFold==2){
                    break;
                }
                makeABet(input);
                showHandAndRiver();
            }
            if(betOrFold==2){
                if(!PlayAgain()){
                    break;
                }
                continue;
            }
            System.out.println("\nPress 1 to bet, 2 to fold");
            betOrFold = input.nextInt();
            if(betOrFold==2){
                continue;
            }
            makeABet(input);
            findWinner();
            if(!PlayAgain()){
                break;
            }

        }
    }

    /**
     * THIS RUNS AT THE START OF THE GAME, IT RESETS ALL VARIABLES SUCH AS THE DECK AND THE HANDS
     */
    public void resetGame(){
        cardsPulledFromDeck = 0;
        playerScore = 0;
        dealerScore = 0;
        player.setbet(0);
        betIncrease = 0;
        betOrFold = 0;
        deck = new Deck();
        playerHand = new Hand();
        dealerHand = new Hand();
        cardsOnTable = new Hand();
        player.placeMultipleBets(100);
        System.out.println("You ante $100, your balance is $"+player.showBalance());
        deal();
        showHand();
    }

    /**
     * THIS METHOD MERGES THE HANDS WITH THE RIVER, THEN CALCULATES THEIR SCORE,
     * THEN COMPARES THE TWO SCORE TO DECIDE THE WINNER
     */
    public void findWinner(){
        playerHand.cardList.addAll(cardsOnTable.cardList);
        dealerHand.cardList.addAll(cardsOnTable.cardList);
        playerScore = giveScore(playerHand);
        dealerScore = giveScore(dealerHand);
        decideWinner(playerScore,dealerScore);
    }

    /**
     * THIS METHOD HANDLES TAKING BETS
     * @param input
     */
    public void makeABet(Scanner input){
        System.out.println("you have $"+player.showBalance()+" in your account\nPlace your bet:");
        betIncrease = input.nextInt();
        while(betIncrease<100){
            System.out.println("You must bet at least $100 in order to continue");
            betIncrease = input.nextInt();
        }
        player.placeMultipleBets(betIncrease);
        hit(cardsOnTable);
    }

    /**
     * SUB METHOD OF THE FIND WINNER METHOD. THIS HANDLES INSTANCES OF TIES, AND THEN EITHER PAYS
     * THE PLAYER OR PRINTS OUT THE DEALERS HAND BASED ON HIGHER SCORES. IN THE CASE OF A HIGH CARD
     * TIE, THE DEAL IS THE WINNER
     * @param playerScore
     * @param dealerScore
     */
    public void decideWinner(int playerScore, int dealerScore){
        tieCheck(playerScore,dealerScore);
        if(playerScore>dealerScore){
            System.out.println("CONGRATULATIONS! YOU WON $"+((player.getBet()*2)+200));
            player.collectWinnings((player.getBet()*2)+200);
        }else if (dealerScore>=playerScore){
            System.out.print("You lose, dealer had\n");
            for(int i =0;i<playerHand.cardList.size();i++){
                System.out.println(dealerHand.cardList.get(i).getGraphic());
            }
        }
    }

    /**
     * THIS METHOD ASKS THE PLAYER IF THEY WOULD LIKE TO PLAY AGAIN
     * @return
     */
    public boolean PlayAgain(){
        boolean stopGame = false;
        System.out.println("\nWould you like to play again? 1 for Yes, 2 for No");
        int choice = input.nextInt();
        if (choice==1){
            stopGame = true;
        }
        return stopGame;
    }

    /**
     *  PRINTS ALL THE CARDS IN THE PLAYERS HAND.
     */
    public void showHand(){
       System.out.print("Your hand is a\n");
        for(int i =0;i<playerHand.cardList.size();i++){
            System.out.println(playerHand.cardList.get(i).getGraphic());
        }
    }

    /**
     * PRINTS THE CARDS IN THE PLAYERS AND THE CARDS IN THE RIVER
     */
    public void showHandAndRiver(){
        System.out.print("Your hand is a\n");
        for(int i =0;i<playerHand.cardList.size();i++){
            System.out.println(playerHand.cardList.get(i).getGraphic());
        }
        System.out.print(" The River is\n");
        for(int i = 0; i< cardsOnTable.cardList.size(); i++){
            System.out.println(cardsOnTable.cardList.get(i).getGraphic());
        }
    }

    /**
     * DEALS THE PLAYER AND THE DEALER TWO CARDS EACH
     */
    public void deal() {
        Sounds.playShuffleSound();
        playerHand.cardList.add(deck.cards.get(cardsPulledFromDeck));
        cardsPulledFromDeck++;
        dealerHand.cardList.add(deck.cards.get(cardsPulledFromDeck));
        cardsPulledFromDeck++;
        playerHand.cardList.add(deck.cards.get(cardsPulledFromDeck));
        cardsPulledFromDeck++;
        dealerHand.cardList.add(deck.cards.get(cardsPulledFromDeck));
        cardsPulledFromDeck++;
    }

    /**
     * DEALS A CARD TO THE HAND PASSED INTO IT.
     * @param hand
     */
    public void hit(Hand hand) {

        hand.cardList.add(deck.cards.get(cardsPulledFromDeck));
        cardsPulledFromDeck++;
    }

    /**
     * SUB METHOD OF THE findWinner() METHOD. THIS TAKES A HAND AND RUNS IT THROUGH THE METHODS THAT
     * CHECK HANDS FOR THE DIFFERENT POKER HANDS, GIVING IT ITS SCORE.
     * @param hand
     * @return
     */
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

    /**
     * THIS METHOD IS CALLED WHEN THE SCORE IS TIED. IT DETERMINES THE WINNER BY HIGH CARD.
     * IN THE CASE OF A TIED HIGH CARD, THE DEALER WINS.
     * @param playerScore
     * @param dealerScore
     */
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

    /**
     * ALL METHODS BEYOND THIS COMMENT ARE THE POKER HAND RULES. THEY ARE SELF EXPLANATORY ENOUGH.
     * @param hand
     * @return
     */
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


}

