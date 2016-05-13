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
    Scanner input=new Scanner(System.in);
    public static void main(String[] args) {
        CasinoDriver casinoDriver=new CasinoDriver();
        casinoDriver.start();

    }
    private void start(){
        /**
         * Make new object of Player and games
         */
        player=new Player();

        blackjack=new Blackjack(player);
        slotMachine=new SlotMachine(player);
        russianRoulette=new RussianRoulette(player);
        hangman=new Hangman();
        String choice="";
        printLogo();
        System.out.println("Welcome to Great Wall Casino");
        choiceGame();

    }

    /**
     * print the wall on to the console.
     */
    private void printLogo(){
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
        delayOutput("____                                                                                                      ____");
        delayOutput("|$  \\\\                                                                                                 // $  |");
        delayOutput("|___//                                                                                                 \\\\____|");
        delayOutput("|                                                                                                            |");
        delayOutput("|                                                                                                            |");
        delayOutput("_____     _____     _____     _____     _____     _____     _____     _____     _____     _____     _____    _       ");
        delayOutput("|---|_____|---|_____|---|_____|---|_____|---|_____|---|_____|---|_____|---|_____|---|_____|---|_____|---|____|");
        for(int x = 0; x <5;x++){

            delayOutput("_|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|\n" +
                    "___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|__");
        }

    }

    /**
     * Delay the output by 100 milliseconds
     * @param s
     */
    private void delayOutput(String s){
        try {
            TimeUnit.MILLISECONDS.sleep(25);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }

    private boolean choiceGame(){
        Scanner input=new Scanner(System.in);
        String choice="";
        System.out.println("Please choose a game \n"+ "1)Blackjack\n2)Slot Machine\n3)Hangman\n");
        System.out.print("Enter: ");
        choice=input.next();
        while(!choice.equals("-1")) {
            switch (choice) {
                case "1":
                    break;
                case "2":
                    playSlotMachine();
                    break;
                case "3":
                    hangman.play();
                    break;
                case "4":
                    russianRoulette.play();
                    break;
                case "5":
                    System.out.println("You current balance is "+player.getWallet());
                default:choiceGame();
                    break;
            }
            System.out.println("Please choice a game (-1 to exit)"+
                    "\n1)Blackjack\n2)Slot Machine\n3)Hangman\n5)Check balance");
            System.out.print("Enter: ");
            choice=input.next();
        }

        return false;
    }

    private void playSlotMachine(){

        while((int)player.getBet()!=-1){
            placeBet();
            if(player.getBet()!=-1.0){
                slotMachine.play();
            }
        }

    }

    private void placeBet(){
        double bet=0;

        try {
            System.out.print("Enter your bet :");
            bet=input.nextInt();
            if(bet<=player.getWallet()) {
                player.placeBet(bet);
            }else {
                System.out.println("Your bet is greater than you balance");
                placeBet();
            }
        }catch (Exception e){
            System.out.println("Please enter a double");
            input.nextLine();
            placeBet();
        }

    }
}
