package io.classwarfare;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by zihaocastine on 5/13/16.
 */
public class BigSixWheel extends Game{
    private Player player;
    private Random random;
    private String wheelNumber;
    private Scanner input;
    private boolean keepBet;
    private boolean keepPlay;

    BigSixWheel(Player player){
        this.player=player;
        this.random=new Random();
        keepBet=true;
        keepPlay=true;
        input=new Scanner(System.in);
    }

    @Override
    public void play() {
        keepPlay=true;
        while(keepPlay){
            player.getBetAndType().clear();
            keepBet=true;
            while(keepBet){
                placeTypeAndBet();
            }
            spinningWheel();
            player.collectWinnings(calculateWinning());
        }

    }

    /**
     * calculate the user winning amount, if user did not win anything. return 0
     * @return
     */
    private int calculateWinning(){
        int total=0;
        System.out.println("The wheel is on "+wheelNumber);
        for (String each: player.getBetAndType().keySet()) {
            if(wheelNumber.equals(each)){
                if(each.equals("joker")||each.equals("casino")){
                    total+= 45*player.getBetAndType().get(each);
                }else {
                    total += Integer.parseInt(each) * player.getBetAndType().get(each);
                }
            }
        }
        return total;
    }

    /**
     * spinning the wheel, put a string to wheelNumber
     */
    private void spinningWheel(){
        int tempWheel= (random.nextInt(54)+1);
        if(tempWheel>0&&tempWheel<=24){
            wheelNumber="1";
        }else if(tempWheel>24 &&tempWheel<=39){
            wheelNumber="2";
        }else if(tempWheel>39 && tempWheel<=46){
            wheelNumber="5";
        }else if(tempWheel>46 && tempWheel<=50){
            wheelNumber="10";
        }else if(tempWheel>50 && tempWheel<=52){
            wheelNumber="20";
        }else if(tempWheel>52 && tempWheel<=53){
            wheelNumber="casino";
        }else {
            wheelNumber="joker";
        }
    }

    /**
     * let user to enter the type of bet, and amount of the bet
     */
    private void placeTypeAndBet() {
        int bet = 0;
        String type="";
        try {
            System.out.println("You have " + player.getWallet() + " Dollars.");
            System.out.println("Where would you like to place your bet? (1, 2, 5, 10, 20, Joker, Casino)\nEnter play to quit bet, enter exit to exit the game");
            type=input.next().toLowerCase();
            if(!type.equals("play")&& !type.equals("exit")) {
                System.out.print("Enter your bet :\n");
                bet = input.nextInt();
                if (bet <= player.getWallet() && bet > 0 && checkType(type)) {
                    player.placeTypeAndBet(type, bet);
                } else if (bet > player.getWallet()) {
                    System.out.println("Your bet is greater than your balance!");
                    placeTypeAndBet();
                } else {
                    System.out.println("That's an invalid bet! or invalid type of bet");
                    placeTypeAndBet();
                }
            }else if (type.equals("play")) {
                keepBet = false;
            }else {
                keepPlay=false;
                keepBet=false;

            }
        } catch (Exception e) {
            System.out.println("Please enter a whole number as bet");
            input.nextLine();
            placeTypeAndBet();
        }

    }

    /**
     * check the type of bet player is making.
     * @param type
     * @return
     */

    private boolean checkType(String type){
        boolean ans=false;
        switch (type.toLowerCase()){
            case "1":
            case "2":
            case "5":
            case "10":
            case "20":
            case "joker":
            case "casino": ans=true;
                break;
            default: ans=false;
                break;
        }
        return ans;
    }

    @Override
    public void backToMenu() {

    }

}
