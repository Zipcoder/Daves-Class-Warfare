package io.classwarfare;

public abstract class Game {
    private double payOut;
    private static double wallet;


    public void start(Game game){
        game.play();
        //start the game
    }

    public abstract void backToMenu();

    public abstract void play();


}
