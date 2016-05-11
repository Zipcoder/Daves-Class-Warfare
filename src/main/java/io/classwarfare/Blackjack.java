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

    public boolean checkBust(Hand hand){
        boolean isBust = false;
        if (hand.checkvalue()>21){
           isBust=true;
        }
        return isBust;
    }
    public boolean checkBlackJack(Hand hand){
        boolean isBlackJack = false;
        if (hand.checkvalue()==21){
            isBlackJack = true;
        }
        return isBlackJack;
    }
    public Hand compareHands(Hand playerHand, Hand dealerHand){
        Hand winningHand = dealerHand;
        if(playerHand.checkvalue()>dealerHand.checkvalue()){
            winningHand = playerHand;
        }
        return winningHand;
    }
    public void deal(){
        
    }
}
