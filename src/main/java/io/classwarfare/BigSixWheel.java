package io.classwarfare;

import java.util.Random;

/**
 * Created by zihaocastine on 5/13/16.
 */
public class BigSixWheel extends Game{
    private Player player;
    private Random random;
    private String wheelNumber;

    BigSixWheel(Player player){
        this.player=player;
        this.random=new Random();
    }

    @Override
    public void play() {
        takeBet(player.getBet());
        spinningWheel();




    }

    /**
     *         TAKES BET AND ADDS TO CASINO/GAME WALLET
     * @param value
     */
    private void takeBet(double value) {
        super.setWallet(super.getWallet()+value);

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
            wheelNumber="Joker";
        }
    }


    @Override
    public void backToMenu() {

    }

}
