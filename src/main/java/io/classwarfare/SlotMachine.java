package io.classwarfare;
import java.util.*;
/**
 * Created by wesleytraute on 5/11/16.
 */
public class SlotMachine {
    private static String[][] tumblers = {{"7","BAR","BAR","BAR","JAVA","JAVA","JAVA","JAVA","JAVA","JAVA"},
            {"7","BAR","BAR","BAR","JAVA","JAVA","JAVA","JAVA","JAVA","JAVA"},
            {"7","BAR","BAR","BAR","JAVA","JAVA","JAVA","JAVA","JAVA","JAVA"}};

    private static int multiplier = 1;
    private static double payout = 5;


    /**
     *                  SPINS THE TUMBLERS
     */
    public static void spinTumblers() {
        Collections.shuffle(Arrays.asList(tumblers[0]));
        Collections.shuffle(Arrays.asList(tumblers[1]));
        Collections.shuffle(Arrays.asList(tumblers[2]));
    }

    public static String[] getTumblers(){
        return tumblers[0];
    }

    /**
     *            CHECKS TO SEE IF TUMBLERS ARE IN WIN CONDITION
     * @return boolean
     */
    public static boolean checkTumblers() {
        if(tumblers[0][0].equals(tumblers[1][0]) && tumblers[1][0].equals(tumblers[2][0])) {
            return true;
        }
        else{
            return false;
        }
    }

    /**
     *            CHECKS TO SEE WIN TYPE TO DETERMINE MULTIPLIER
     * @return int
     */
    public static int checkMultiplier() {
        if(tumblers[0][0].equals("7")) {
            return 5;
        }
        else if(tumblers[0][0].equals("BAR")) {
            return 2;
        }
        else if(tumblers[0][0].equals("JAVA")) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public static void setMultiplier(int value) {
        multiplier = value;
    }
    

}
