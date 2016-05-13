package io.classwarfare;

import java.net.MalformedURLException;
import java.util.Random;

import java.net.URL;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Created by zihaocastine on 5/11/16.
 */
public class RussianRoulette extends Game{
    Player player;
    protected int chamberNumber;

    /**
     *                     CONSTRUCTOR
     * @param player
     */
    RussianRoulette(Player player){
        this.player = player;
    }

    /**
     *                   METHOD TO PLAY GAME
     */
    public void play() {
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        chamberNumber =(random.nextInt(6)+1);

        /**
         *            PULLING TRIGGER WHILE THERE ARE CHAMBERS LEFT
         *            PULL AT CHAMBER 1 AND GUN FIRES.
         */
        while(chamberNumber > 0){

            System.out.println("Press any key to pull trigger");
            input.nextLine();

            //Player pulling trigger
            if(pullTrigger(chamberNumber)){
                delayOutput("You dead!");
                System.exit(0);
            }else{
                chamberNumber--;

                delayOutput("Dealer pulls the trigger");
                //Dealer pulling trigger
                if(pullTrigger(chamberNumber)){
                    player.collectWinnings(pay(5000));
                    System.out.println("Now you have all your money back.");
                    System.exit(0);
                }else{
                    chamberNumber--;
                    delayOutput("");
                }
            }
        }
    }

    /**
     *               PASSES CHAMBER NUMBER IN, IF IT IS THE LAST CHAMBER THEN
     *               CHANGES BOOLEAN TO FIRE GUN IN LOOP
     * @param num
     * @return
     */
    protected boolean pullTrigger(int num){
        if(num < 2){
            playGunshot();
            return true;
        }else {
            playDryFireshot();
            return false;
        }
    }

    /**
     *                  play gun shot sound
     */
    private void playGunshot(){
        URL test = null;
        try {
            test = new File ("src/main/resources/gunshot.wav").toURI().toURL();
            AudioClip clip = Applet.newAudioClip(test);
            clip.play();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /**
     *               play dry fire shot sound
     */
    private void playDryFireshot(){
        URL test = null;
        try {
            test = new File ("src/main/resources/drygun.wav").toURI().toURL();
            AudioClip clip = Applet.newAudioClip(test);
            clip.play();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
    public double pay(double amount) {
        return amount;
    }

    public void backToMenu() {

    }

    private void delayOutput(String s){
        try {
            TimeUnit.MILLISECONDS.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }
}
