package io.classwarfare;

/**
 * Created by zihaocastine on 5/11/16.
 */
public abstract class Game {
    private double payOut;
    private static double wallet;


    public void start(Game game){
        game.play();
        //start the game
    }

    public abstract void backToMenu();
    public abstract double pay(double amount);
    public abstract void play();

}
