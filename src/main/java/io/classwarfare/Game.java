package io.classwarfare;

public abstract class Game {
    private double payOut;
    private static double wallet=2000000;

    /**
     *  ABSTRACT CLASS USED TO ENSURE CREATION OF CERTAIN METHODS ACROSS GAME TYPES
     */
    public void start(Game game){
        game.play();
        //start the game
    }

    public abstract void backToMenu();

    public abstract void play();

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double value) {
        wallet=value;
    }
}
