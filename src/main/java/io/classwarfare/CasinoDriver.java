package io.classwarfare;

import java.util.Scanner;

/**
 * Created by zihaocastine on 5/11/16.
 */
public class CasinoDriver {
    RussianRoulette russianRoulette;
    Player player;
    SlotMachine slotMachine;
    Blackjack blackjack;
    Hangman hangman;
    Scanner input = new Scanner(System.in);
    boolean canLeave = false;

    public static void main(String[] args) {
        CasinoDriver casinoDriver = new CasinoDriver();
        casinoDriver.start();

    }

    private void start() {
        /**
         * Make new object of Player and games
         */
        player = new Player();

        blackjack = new Blackjack(player);
        slotMachine = new SlotMachine(player);
        russianRoulette = new RussianRoulette(player);
        hangman = new Hangman(player);
        String choice = "";
        Graphics.printLogo();
        System.out.println("Welcome to Great Wall Casino");
        choiceGame();

    }

    private boolean choiceGame() {
        Scanner input = new Scanner(System.in);
        String choice = "";
        System.out.println("Please choose a game \n" + "1)Blackjack\n2)Slot Machine\n3)Hangman\n");
        System.out.print("Enter: \n");
        choice = input.next();
        while (!choice.equals("-1")) {
            switch (choice) {
                case "1":
                    Graphics.printBlackJackWelcome();
                    playBlackJack();
                    break;
                case "2":
                    playSlotMachine();
                    break;
                case "3":
                    playHangman();
                    break;
                case "4":
                    russianRoulette.play();
                    break;
                case "5":
                    System.out.println("You current balance is " + player.getWallet());
                    break;
                default:
                    choiceGame();
                    break;
            }
            System.out.println("Please choose a game  or enter '-1' to exit)\n" +
                    "\n1)Blackjack\n2)Slot Machine\n3)Hangman\n5)Check balance\n");
            System.out.print("Enter: ");
            choice = input.next();
        }

        if (!canLeave) {
            if (player.getWallet() < 0) {
                System.out.println("Do you really think you can leave without paying us the money?\n I challenge you to roulette!");
                russianRoulette.play();
            } else if (player.getWallet() > 5000) {
                System.out.println("Do you really think you can leave with the all money you won?\n I challenge you to roulette!");
                russianRoulette.play();
            } else
                canLeave = true;
        }

        if (player.getWallet() >= 5000) {
            System.out.println("You leave triumphantly with " + (int) player.getWallet() + " dollars");
        } else {
            System.out.println("You leave in shame");
        }
        return false;
    }

    private void playSlotMachine() {

        while (player.getBet() != -1) {
            placeBet();
            if (player.getBet() != -1.0) {
                slotMachine.play();
            }
        }
        player.placeBet(0);
    }

    private void playBlackJack() {

        while (player.getBet() != -1) {
            placeBet();
            if (player.getBet() != -1.0) {
                blackjack.play();
            }
        }
        player.placeBet(0);
    }

    private void playHangman() {

        while (player.getBet() != -1) {
            placeBet();
            if (player.getBet() != -1.0) {
                hangman.play();
            }
        }
        player.placeBet(0);
    }


    private void placeBet() {
        double bet = 0;

        try {
            System.out.println("You have " + player.getWallet() + " Dollars.");
            System.out.print("Enter your bet (-1 to exit):\n");
            bet = input.nextInt();

            if (bet <= player.getWallet() && bet >= -1) {
                player.placeBet(bet);
            } else if (bet > player.getWallet()) {
                System.out.println("Your bet is greater than your balance!");
                placeBet();
            } else {
                System.out.println("That's an invalid bet!");
                placeBet();
            }
        } catch (Exception e) {
            System.out.println("Please enter a double");
            input.nextLine();
            placeBet();
        }
    }
}
