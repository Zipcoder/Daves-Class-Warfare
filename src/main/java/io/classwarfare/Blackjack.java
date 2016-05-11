package io.classwarfare;

/**
 * Created by markhauenstein on 5/11/16.
 */
public class Blackjack {
    Deck deck;
    Player player;
    Hand playerHand;
    Hand dealerHand;
    double payout;
    int cardsPulledFromDeck =0;
    // checkBust checks to see if a hand is above 21 and returns a boolean-false by default.
    public boolean checkBust(Hand hand){
        boolean isBust = false;
        if (hand.checkValue()>21){
           isBust=true;
            cardsPulledFromDeck = 0;
        }
        return isBust;
    }
    // checkBlackJack checks to see if a hand is at 21 and returns a boolean-false by default.
    public boolean checkBlackJack(Hand hand){
        boolean isBlackJack = false;
        if (hand.checkValue()==21){
            isBlackJack = true;
            cardsPulledFromDeck = 0;
        }
        return isBlackJack;
    }
    // compareHands compares the two hands, and will return the higher hand. Dealer wins on a tie.
    public Hand compareHands(Hand playerHand, Hand dealerHand){
        Hand winningHand = dealerHand;
        if(playerHand.checkValue()>dealerHand.checkValue()){
            winningHand = playerHand;
        }
        return winningHand;
    }
    // Deal method is used to start the game. It gives the player and the dealer two cards each.
    public void deal(){
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
    public void hit(Hand hand){
        hand.cardList.add(deck.cards.get(cardsPulledFromDeck));
    }
}
