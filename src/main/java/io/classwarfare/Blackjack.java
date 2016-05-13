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



    Blackjack(Player player) {
        this.player = player;
    }


    public void play() {

        boolean playingGame = true;
        while (playingGame) {
            if(player.showBalance()<=0){
                System.out.println("You are out of money, get out of here ya bum!");
                playingGame=false;
                break;
            }
            Deck deck = new Deck();
            Hand playerHand = new Hand();
            Hand dealerHand = new Hand();
            Scanner input = new Scanner(System.in);
            boolean gameInPlay = true;
            Hand winningHand = dealerHand;
            System.out.println("Your balance is "+player.showBalance()+" place your bet");
            double bet = input.nextDouble();
            while(bet>player.showBalance()){
                System.out.println("You don't have that much money, Please place another bet");
                bet = input.nextDouble();
            }
            double blackJackPayMod = 0;
            player.placeBet(bet);
            deal(playerHand, dealerHand, deck);
            if (checkBlackJack(playerHand)) {
                System.out.println("You win by Blackjack!");
                winningHand = playerHand;
                blackJackPayMod = (bet * 1.5);
                gameInPlay = false;
            }
            if (checkBlackJack(dealerHand)) {
                System.out.println("Dealer wins by Blackjack!");
                winningHand = dealerHand;
                gameInPlay = false;
            }
            while (gameInPlay) {
                if (checkBust(playerHand)) {
                    System.out.println("You Busted!");
                    winningHand = dealerHand;
                    break;
                }
                if (checkBust(dealerHand)) {
                    System.out.println("Dealer Busted!");
                    winningHand = playerHand;
                    break;
                }
                winningHand = compareHands(playerHand, dealerHand);
                System.out.print("Dealer showing card is " + dealerHand.cardList.get(0).getValue()+" of "+dealerHand.cardList.get(0).getSuit()+"\nYour hand is a ");
                for(int i =0;i<playerHand.cardList.size();i++){
                    System.out.print(playerHand.cardList.get(i).getValue()+" of "+playerHand.cardList.get(i).getSuit());
                }
                System.out.println(" for a total of "+ playerHand.checkValue() + " Press 1 for Hit, 2 for Stay");
                int hitOrStay = input.nextInt();
                if (hitOrStay == 1) {
                    hit(playerHand, deck);
                    if (dealerHand.checkValue() < 17) {
                        hit(dealerHand, deck);
                    }
                }
                if (hitOrStay == 2) {
                    if (dealerHand.checkValue() < 17) {
                        hit(dealerHand, deck);
                    } else if (dealerHand.checkValue() >= 17) {
                        break;
                    }
                }
            }
            if (winningHand == playerHand) {
                System.out.println("You Win!");
                player.collectWinnings(bet * 2 + blackJackPayMod);
            } else if (winningHand == dealerHand) {
                System.out.println("Dealer has "+dealerHand.checkValue()+" You Lose!");
            }
            System.out.println("Your new balance is " + player.showBalance() + " Would you like to play again? 1 for Yes, 2 for No");
            int playAgain = input.nextInt();
            if (playAgain==2){
                System.out.println("Thank you for playing, enjoy your day!");
                playingGame = false;
            }
        }
    }

    public static void main(String[] args) {
        Player player = new Player();
        Blackjack blackjack = new Blackjack(player);
        blackjack.play();
    }


    public void backToMenu() {

    }



    // checkBust checks to see if a hand is above 21 and returns a boolean-false by default.
    public boolean checkBust(Hand hand) {
        boolean isBust = false;
        if (hand.checkValue() > 21) {
            isBust = true;
        }
        return isBust;
    }

    // checkBlackJack checks to see if a hand is at 21 and returns a boolean-false by default.
    public boolean checkBlackJack(Hand hand) {
        boolean isBlackJack = false;
        if (hand.checkValue() == 21) {
            isBlackJack = true;
        }
        return isBlackJack;
    }

    // compareHands compares the two hands, and will return the higher hand. Dealer wins on a tie.
    public Hand compareHands(Hand playerHand, Hand dealerHand) {
        Hand winningHand = dealerHand;
        if (playerHand.checkValue() > dealerHand.checkValue()) {
            winningHand = playerHand;
        }
        return winningHand;
    }

    // Deal method is used to give the player and the dealer two cards each.
    public void deal(Hand playerHand, Hand dealerHand, Deck deck) {
        playerHand.cardList.add(deck.cards.get(cardsPulledFromDeck));
        cardsPulledFromDeck++;
        dealerHand.cardList.add(deck.cards.get(cardsPulledFromDeck));
        cardsPulledFromDeck++;
        playerHand.cardList.add(deck.cards.get(cardsPulledFromDeck));
        cardsPulledFromDeck++;
        dealerHand.cardList.add(deck.cards.get(cardsPulledFromDeck));
        cardsPulledFromDeck++;
    }

    // hit method adds a card to the Hand that is passed into it
    public void hit(Hand hand, Deck deck) {
        hand.cardList.add(deck.cards.get(cardsPulledFromDeck));
        cardsPulledFromDeck++;
    }
}