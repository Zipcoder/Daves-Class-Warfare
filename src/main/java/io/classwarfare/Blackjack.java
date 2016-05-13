package io.classwarfare;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by markhauenstein on 5/11/16.
 */
public class Blackjack extends Game {
    Player player;
    double payout;
    int cardsPulledFromDeck = 0;
    Deck deck;
    Hand playerHand;
    Hand dealerHand;
    Hand winningHand;
    boolean bustCheck;
    boolean hitAndStayPhase;
    boolean dealerStayCheck;
    boolean playingGame;

    public Blackjack(Player player){
        this.player = player;
    }


    public void play() {
        printWelcome();
        Scanner input = new Scanner(System.in);
        boolean gameInSession = true;
        Player player = new Player();
        while (gameInSession && player.showBalance()>0) {
            if(player.showBalance()<=0){
                System.out.println("You are out of money, get out of here ya bum!");
                break;
            }
            deck= new Deck();
            playerHand = new Hand();
            dealerHand = new Hand();
            cardsPulledFromDeck = 0;
            hitAndStayPhase = true;
            bustCheck = false;
            dealerStayCheck = false;
            winningHand=new Hand();
            double blackJackPayMod = 0;

            double bet = placeBets(input);

            deal();
            if(!checkForBlackJack()){
                hitAndStayPhase = false;

            }
            while (hitAndStayPhase) {
                if(checkHandsForBust()){
                    gameInSession=false;
                    break;
                    }
                winningHand = compareHands();
                showHands();
                chooseHitOrStay(input);
                if (dealerStayCheck){hitAndStayPhase=false;}
            }
            decideWinner(bet);
            askToPlayAgain(input,gameInSession);
        }
    }


    public void chooseHitOrStay(Scanner input){
        System.out.println("Press 1 for Hit, 2 for Stay");
        int hitOrStay = input.nextInt();
        if (hitOrStay == 1) {
            hit(playerHand);

        }
        if (hitOrStay == 2) {
            while(dealerHand.checkValue() < 17) {
                System.out.println("Dealer Hits");
                hit(dealerHand);
                checkHandsForBust();
            } if (dealerHand.checkValue() >= 17) {
                dealerStayCheck = true;
            }
        }
    }

    public void askToPlayAgain(Scanner input,boolean gameInSession){
        System.out.println("Your new balance is " + player.showBalance() + " Would you like to play again? 1 for Yes, 2 for No");
        int playAgain = input.nextInt();
        if (playAgain==2){
            System.out.println("Thank you for playing, enjoy your day!");
            gameInSession = false;
        }
    }

    public void decideWinner(double bet){
        if (winningHand == playerHand) {
            System.out.println("You Win!");
            player.collectWinnings(bet * 2);
        } else if (winningHand == dealerHand) {
            if(dealerHand.checkValue()<=21) {
                System.out.println("Dealer has " + dealerHand.checkValue() + " You Lose!");
            }
        }
    }


    public void backToMenu() {

    }

    // checkBust checks to see if a hand is above 21 and returns a boolean-false by default.
    public boolean checkHandForBust(Hand hand) {
        boolean isBust = false;
        if (hand.checkValue() > 21) {
            isBust = true;
        }
        return isBust;
    }
    public boolean checkHandsForBust(){
        if(checkHandForBust(playerHand)){
            System.out.println("You Busted!");
            winningHand = dealerHand;
            bustCheck = true;
            return bustCheck;
        }
        if(checkHandForBust(dealerHand)){
            System.out.println("Dealer Busted!");
            winningHand = playerHand;
            bustCheck = true;
        }
        return bustCheck;
    }


    // checkBlackJack checks to see if a hand is at 21 and returns a boolean-false by default.
    public boolean checkHandForBlackJack(Hand hand) {
        boolean handHasBlackJack = false;
        if (hand.checkValue() == 21){
            handHasBlackJack = true;
        }
        return handHasBlackJack;
    }
    public boolean checkForBlackJack(){

        if ((checkHandForBlackJack(dealerHand) && checkHandForBlackJack(playerHand)) || checkHandForBlackJack(dealerHand)) {
            System.out.println("Dealer wins by Blackjack!");
           // winningHand = dealerHand;
            hitAndStayPhase = false;
            return hitAndStayPhase;
        }else if (checkHandForBlackJack(playerHand) && !checkHandForBlackJack(dealerHand)) {
            System.out.println("You win by Blackjack!");
            //winningHand = playerHand;
            player.collectWinnings((player.getBet() * 1.5));
            hitAndStayPhase = false;
            return hitAndStayPhase;
        }else {
            return hitAndStayPhase;
        }

    }
    // compareHands compares the two hands, and will return the higher hand. Dealer wins on a tie.
    public Hand compareHands() {
        Hand winningHand = dealerHand;
        if (playerHand.checkValue() > dealerHand.checkValue()) {
            winningHand = playerHand;
        }
        return winningHand;
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

    // prints the First card of the dealer, and all the cards in the players hand.
    public void showHands(){
        System.out.print("Dealer showing card is |" + dealerHand.cardList.get(0).getValue()+" of "+dealerHand.cardList.get(0).getSuit()+"|\nYour hand is a |");
        for(int i =0;i<playerHand.cardList.size();i++){
            System.out.print(playerHand.cardList.get(i).getValue()+" of "+playerHand.cardList.get(i).getSuit()+"|");
        }
        System.out.println(" for a total of "+ playerHand.checkValue());
    }

    public double placeBets(Scanner input){
        System.out.println("Your balance is "+player.showBalance()+" place your bet");
        double bet = input.nextDouble();

        while(bet>player.showBalance()){
            System.out.println("You don't have that much money, you only have "+player.showBalance()+" Please place another bet");
            bet = input.nextDouble();
        }
        player.placeBet(bet);
        return bet;
    }

    public void printWelcome(){
        System.out.println("____    __    ____  _______  __        ______   ______   .___  ___.  _______    .___________.  ______      ");
        System.out.println("\\   \\  /  \\  /   / |   ____||  |      /      | /  __  \\  |   \\/   | |   ____|   |           | /  __  \\     ");
        System.out.println(" \\   \\/    \\/   /  |  |__   |  |     |  ,----'|  |  |  | |  \\  /  | |  |__      `---|  |----`|  |  |  |    ");
        System.out.println("  \\            /   |   __|  |  |     |  |     |  |  |  | |  |\\/|  | |   __|         |  |     |  |  |  |    ");
        System.out.println("   \\    /\\    /    |  |____ |  `----.|  `----.|  `--'  | |  |  |  | |  |____        |  |     |  `--'  |    ");
        System.out.println("    \\__/  \\__/     |_______||_______| \\______| \\______/  |__|  |__| |_______|       |__|      \\______/    ");
        System.out.println("                                                                                                          ");
        System.out.println("      .______    __          ___       ______  __  ___        __       ___       ______  __  ___         ");
        System.out.println("      |   _  \\  |  |        /   \\     /      ||  |/  /       |  |     /   \\     /      ||  |/  /         ");
        System.out.println("      |  |_)  | |  |       /  ^  \\   |  ,----'|  '  /        |  |    /  ^  \\   |  ,----'|  '  /          ");
        System.out.println("      |   _  <  |  |      /  /_\\  \\  |  |     |    <   .--.  |  |   /  /_\\  \\  |  |     |    <           ");
        System.out.println("      |  |_)  | |  `----./  _____  \\ |  `----.|  .  \\  |  `--'  |  /  _____  \\ |  `----.|  .  \\         ");
        System.out.println("      |______/  |_______/__/     \\__\\ \\______||__|\\__\\  \\______/  /__/     \\__\\ \\______||__|\\__\\        ");

    }


}

/*
 */