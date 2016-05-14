package io.classwarfare;

public abstract class Game {
    private double payOut;
    private static double wallet=2000000;

//array of games in driver martin fowler patterns of architecture
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
