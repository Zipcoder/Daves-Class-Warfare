package io.classwarfare;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import static io.classwarfare.Sounds.*;

/**
 * Created by zihaocastine on 5/11/16.
 */
public class RussianRoulette extends Game {
    Player player;

    RussianRoulette(Player player) {
        this.player = player;
    }

    public void play() {
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        String s = "";
        int chamberNumber = (random.nextInt(6) + 1);


        while (chamberNumber > 0) {
            /**
             * player pull trigger
             */

            System.out.println("Press any key to pull trigger");
            input.nextLine();
            if (PullTrigger(chamberNumber)) {
                delayOutput("You are dead!");
                System.exit(0);
            } else {
                chamberNumber--;
                /**
                 * dealer pull trigger
                 */
                delayOutput("Dealer gets ready to pull the trigger");

                if (PullTrigger(chamberNumber)) {
                    player.collectWinnings(pay(10000));
                    System.out.println("The dealer is dead!");
                    System.out.println("\nYou take all the money.\n");
                    chamberNumber = 0;
                } else {
                    chamberNumber--;
                    delayOutput("");
                }
            }
        }
    }

    private boolean PullTrigger(int num) {
        if (num < 2) {
            playGunshot();
            return true;
        } else {
            playDryFireshot();
            return false;

        }
    }

    public double pay(double amount) {
        return amount;
    }

    public void backToMenu() {

    }

    private void delayOutput(String s) {
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }
}
