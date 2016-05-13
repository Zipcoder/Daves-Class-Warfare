package io.classwarfare;
import java.util.*;
/**
 * Created by wesleytraute on 5/11/16.
 */
public class SlotMachine extends Game{

    protected static String[][] tumblers = {{"7","BAR","BAR","JAVA","JAVA","JAVA"},{"7","BAR","BAR","JAVA","JAVA","JAVA"},{"7","BAR","BAR","JAVA","JAVA","JAVA"}};

    Player player;
    protected static String winString;
    protected static double payOut = 0;
    SlotMachine(Player currentPlayer){
        this.player=currentPlayer;
    }

    /**
     *                   RUNS THE GAME
     */
    public void play() {
        takeBet(player.getBet());
        spinTumblers();
        calculatePayout(player.getBet());
        player.collectWinnings(pay(payOut));
    }

    /**
     *                  SPINS THE TUMBLERS
     */
    private static void spinTumblers() {
        Collections.shuffle(Arrays.asList(tumblers[0]));
        Collections.shuffle(Arrays.asList(tumblers[1]));
        Collections.shuffle(Arrays.asList(tumblers[2]));
    }

    /**
     *            CHECKS TO SEE IF TUMBLERS ARE IN WIN CONDITION
     * @return boolean
     */
    private static boolean checkTumblers() {
        if(tumblers[0][0].equals(tumblers[1][0]) && tumblers[1][0].equals(tumblers[2][0])) {
            return true;
        }
        else{
            winString = SlotMachineGraphics.loseString;
            return false;
        }
    }

    /**
     *            CHECKS TO SEE WIN TYPE TO DETERMINE MULTIPLIER
     * @return int
     */
    private static double checkMultiplier() {
        if(checkTumblers()==false){
            return 0;
        } else if(tumblers[0][0].equals("7")) {
            winString = SlotMachineGraphics.sevenWin;
            return 5;
        }
        else if(tumblers[0][0].equals("BAR")) {
            winString = SlotMachineGraphics.barWin;
            return 2;
        }
        else if(tumblers[0][0].equals("JAVA")) {
            winString = SlotMachineGraphics.javaWin;
            return 1.5;
        } else {
            return 0;
        }
    }

    /**
     *             CALCULATES THE WIN AMOUNT
     * @param value
     */
    private void calculatePayout(double value) {
        payOut = value * checkMultiplier();
    }

    /**
     *            CONFIRMS WIN AND PAYS CUSTOMER
     * @param value
     * @return
     */
    public double pay(double value) {
        if(checkTumblers()==true) {
            System.out.println(winString);
            System.out.println("\nYou win! Payout is " + payOut + SlotMachineGraphics.sepLine);
            super.setWallet(super.getWallet()-payOut);
            return value;
        }
        else {
            System.out.println(winString);
            System.out.println("\nYou lose! HAH!" + SlotMachineGraphics.sepLine);
            return 0;
        }
    }

    /**
     *         TAKES BET AND ADDS TO CASINO/GAME WALLET
     * @param value
     */
    private void takeBet(double value) {
        super.setWallet(super.getWallet()+value);

    }

    public void backToMenu(){

    }
}
