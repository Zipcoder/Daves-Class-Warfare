package io.classwarfare;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Created by zihaocastine on 5/11/16.
 */
public class CasinoDriver {
    RussianRoulette russianRoulette;
    Player player;
    SlotMachine slotMachine;
    Blackjack blackjack;
    Hangman hangman;
    BigSixWheel bigSixWheel;
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
        bigSixWheel=new BigSixWheel(player);
        String choice = "";
        printLogo();
        System.out.println("Welcome to Great Wall Casino");
        choiceGame();

    }

    /**
     * print the wall on to the console.
     */
    private void printLogo() {
        delayOutput("  _______ .______       _______      ___   .___________.   ____    __    ____  ___       __       __       ");
        delayOutput(" /  _____||   _  \\     |   ____|    /   \\  |           |   \\   \\  /  \\  /   / /   \\     |  |     |  |       ");
        delayOutput("|  |  __  |  |_)  |    |  |__      /  ^  \\ `---|  |----`    \\   \\/    \\/   / /  ^  \\    |  |     |  |       ");
        delayOutput("|  | |_ | |      /     |   __|    /  /_\\  \\    |  |          \\            / /  /_\\  \\   |  |     |  |       ");
        delayOutput("|  |__| | |  |\\  \\----.|  |____  /  _____  \\   |  |           \\    /\\    / /  _____  \\  |  `----.|  `----.  ");
        delayOutput(" \\______| | _| `._____||_______|/__/     \\__\\  |__|            \\__/  \\__/ /__/     \\__\\ |_______||_______|  ");
        delayOutput("");
        delayOutput("                          ______      ___           _______. __  .__   __.   ______                         ");
        delayOutput("                         /      |    /   \\         /       ||  | |  \\ |  |  /  __  \\                        ");
        delayOutput("                        |  ,----'   /  ^  \\       |   (----`|  | |   \\|  | |  |  |  |                       ");
        delayOutput("                        |  |       /  /_\\  \\       \\   \\    |  | |  . `  | |  |  |  |                       ");
        delayOutput("                        |  `----. /  _____  \\  .----)   |   |  | |  |\\   | |  `--'  |                       ");
        delayOutput("                         \\______|/__/     \\__\\ |_______/    |__| |__| \\__|  \\______/                        ");
        delayOutput("");
        delayOutput("");
        delayOutput("____                                                                                                     _____");
        delayOutput("|$  \\\\                                                                                                 // $  |");
        delayOutput("|___//                                                                                                 \\\\____|");
        delayOutput("|                                                                                                            |");
        delayOutput("|                                                                                                            |");
        delayOutput("_____     _____     _____     _____     _____     _____     _____     _____     _____     _____     _____    _       ");
        delayOutput("|---|_____|---|_____|---|_____|---|_____|---|_____|---|_____|---|_____|---|_____|---|_____|---|_____|---|____|");
        for (int x = 0; x < 5; x++) {

            delayOutput("_|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|\n" +
                    "___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|__");
        }

    }

    public void printBlackJackWelcome() {
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

    /**
     * Delay the output by 100 milliseconds
     *
     * @param s
     */
    private void delayOutput(String s) {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }

    private boolean choiceGame() {
        Scanner input = new Scanner(System.in);
        String choice = "";
        System.out.println("Please choose a game  or enter '-1' to exit)\n" +
                "\n1)Blackjack\n2)Slot Machine\n3)Hangman\n5)Check balance\n6)BigSixWheel");
        System.out.print("Enter: \n");
        choice = input.next();
        while (!choice.equals("-1")) {
            switch (choice) {
                case "1":
                    printBlackJackWelcome();
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
                case "6":playBigSixWheel();
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

    private void playBigSixWheel(){
        bigSixWheel.play();

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
