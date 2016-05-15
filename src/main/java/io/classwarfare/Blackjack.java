package io.classwarfare;

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
    Scanner input;
    boolean gameInSession;
    public Blackjack(Player player){
        this.player = player;
    }


    public void play() {

        input = new Scanner(System.in);
        gameInSession = true;
        Player player = new Player();
        while (gameInSession && player.getWallet()>=0) {

            deck= new Deck();
            playerHand = new Hand();
            dealerHand = new Hand();
            cardsPulledFromDeck = 0;
            hitAndStayPhase = true;
            bustCheck = false;
            dealerStayCheck = false;
            winningHand=new Hand();

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
            decideWinner();
            askToPlayAgain(input);
        }
    }

    /**
     *           PROMPTS THE USER TO HIT OR STAY
     * @param input
     */
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

    /**
     *         ASKS THE USER IF THEY WOULD LIKE TO PLAY ANOTHER ROUND
     * @param input
     */
    public void askToPlayAgain(Scanner input){
        System.out.println("Your new balance is " + player.getWallet() + " Would you like to play again? 1 for Yes, 2 for No");
        int playAgain = input.nextInt();
        if(playAgain==1 && gameInSession){
            placeBet();
        }
        if (playAgain==2){
            System.out.println("Thank you for playing, enjoy your day!");
            gameInSession = false;
            player.placeBet(-1);
        }
    }

    /**
     *            COMPARES HANDS TO CHOOSE A WINNER
     */
    public void decideWinner(){
        if (winningHand == playerHand) {
            System.out.println("You Win!");
            player.collectWinnings(player.getBet() * 2);
        } else if (winningHand == dealerHand) {
            if(dealerHand.checkValue()<=21) {
                System.out.println("Dealer has " + dealerHand.checkValue() + " You Lose!");
            }
        }
    }


    public void backToMenu() {

    }

    /**
     *     CHECKS TO SEE IF A HAND IS ABOVE 21
     */
    public boolean checkIfHandIsOver21(Hand hand) {
        boolean isBust = false;
        if (hand.checkValue() > 21) {
            isBust = true;
        }
        return isBust;
    }
    public boolean checkHandsForBust(){
        if(checkIfHandIsOver21(playerHand)){
            System.out.println("You Busted!");
            winningHand = dealerHand;
            bustCheck = true;
            return bustCheck;
        }
        if(checkIfHandIsOver21(dealerHand)){
            System.out.println("Dealer Busted!");
            winningHand = playerHand;
            bustCheck = true;
        }
        return bustCheck;
    }

    /**
     *     CHECKS FOR BLACKJACK.
     * @param hand
     * @return
     */
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
            hitAndStayPhase = false;
            return hitAndStayPhase;
        }else if (checkHandForBlackJack(playerHand) && !checkHandForBlackJack(dealerHand)) {
            System.out.println("You win by Blackjack!");
            player.collectWinnings((player.getBet() * 1.5));
            hitAndStayPhase = false;
            return hitAndStayPhase;
        }else {
            return hitAndStayPhase;
        }

    }

    /**
     *     COMPARES HANDS AND RETURNS THE HIGHER HAND
     * @return
     */
    public Hand compareHands() {
        Hand winningHand = dealerHand;
        if (playerHand.checkValue() > dealerHand.checkValue()) {
            winningHand = playerHand;
        }
        return winningHand;
    }

    /**
     *     DEALS CARDS
     */
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

    /**
     *     ADDS CARD TO THE HAND THAT IS PASSED
     * @param hand
     */
    public void hit(Hand hand) {
        hand.cardList.add(deck.cards.get(cardsPulledFromDeck));
        cardsPulledFromDeck++;
    }

    /**
     *     PRINTS BLACKJACK GRAPHICS
     */
    public void showHands(){
        System.out.println("Dealer showing card is \n" + dealerHand.cardList.get(0).getGraphic() + "\n\nYour hand is: ");
        for(int i =0;i<playerHand.cardList.size();i++){
            System.out.println(playerHand.cardList.get(i).getGraphic());
        }
        System.out.println(" for a total of "+ playerHand.checkValue());
    }

    /**
     *    PROMPTS THE USER TO PLACE A BET
     */
    private void placeBet(){
            double bet=0;

            try {
                System.out.print("Enter your bet:");
                bet=input.nextInt();

                if (bet == -1) {
                    System.out.println("You already sat down, place your bet.");
                    placeBet();
                }
                else if (bet<=player.getWallet()) {
                    player.placeBet(bet);
                }
                else {
                    System.out.println("Your bet is greater than you balance");
                    placeBet();
                }
            }catch (Exception e){
                System.out.println("Please enter a Integer");
                input.nextLine();
                placeBet();
            }

        }

}

