package io.classwarfare;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

/**
 * Created by wilsondulap on 5/11/16.
 */
public class HangmanTest {

    @Test
    public void checkTestStringEndsGame(){ //Checks if a correct guess will end the game
        Player player=new Player();
        Hangman hangman = new Hangman(player);
        hangman.setAnswerWord("apple");
        boolean expectedValue = true;
        boolean actualValue = hangman.check("apple");
        Assert.assertEquals("Expected value: true", expectedValue, actualValue);
    }

    @Test
    public void checkTestStringCaseSensitivity(){//Checks whether check() is case-insensitive
        Player player=new Player();
        Hangman hangman = new Hangman(player);
        hangman.setAnswerWord("apple");
        boolean expectedValue = true;
        boolean actualValue = hangman.check("APPLE");
        Assert.assertEquals("Expected value: true", expectedValue, actualValue);
    }

    @Test
    public void checkTestStringCaseSensitivityControl(){//Checks whether check() is case-insensitive
        Player player=new Player();
        Hangman hangman = new Hangman(player);
        hangman.setAnswerWord("bluetick");
        boolean expectedValue = true;
        boolean actualValue = hangman.check("bluetick");
        Assert.assertEquals("Expected value: true", expectedValue, actualValue);
    }

    @Test
    public void checkTestStringCaseSensitivityWrongGuess(){//Checks whether check() is case-insensitive
        Player player=new Player();
        Hangman hangman = new Hangman(player);
        hangman.setAnswerWord("apple");
        boolean expectedValue = false;
        boolean actualValue = hangman.check("Thumposaurus");
        Assert.assertEquals("Expected value: true", expectedValue, actualValue);
    }

    /*
    public void checkTestString(){
        Hangman hangman = new Hangman();
        boolean expectedValue = false;
        boolean actualValue = hangman.check("potato"); //must have a String argument to run this test
        Assert.assertEquals("Expected value: true", expectedValue, actualValue);
    }


    public void checkAnswerArrayTest(){
        Hangman hangman = new Hangman();
        boolean expectedValue = false;
        boolean actualValue = hangman.checkAnswerArray(); //must have a character argument
        Assert.assertEquals("Expected value: true", expectedValue, actualValue);
    }
    */

    @Test
    public void checkArrayTestAlreadyGuessCorrectly(){
        Player player=new Player();
        Hangman hangman = new Hangman(player);
        hangman.addToCorrectGuesses('z');
        boolean expectedValue = false;
        boolean actualValue = hangman.check('k');
        Assert.assertEquals("Expected value: true", expectedValue, actualValue);
    }

    @Test
    public void checkCorrectGuessesTest(){
        Player player=new Player();
        Hangman hangman = new Hangman(player);
        hangman.addToCorrectGuesses('a');
        boolean expectedValue = true;
        boolean actualValue = hangman.checkCorrectGuesses('a');
        Assert.assertEquals("Expected value: true", expectedValue, actualValue);
    }

    @Test
    public void checkIncorrectGuessesTest(){
        Player player=new Player();
        Hangman hangman = new Hangman(player);
        hangman.addToIncorrectGuesses('a');
        boolean expectedValue = true;
        boolean actualValue = hangman.checkIncorrectGuesses('a');
        Assert.assertEquals("Expected value: true", expectedValue, actualValue);
    }

    @Test
    public void addToCorrectGuessesTest(){
        Player player=new Player();
        Hangman hangman = new Hangman(player);
        boolean expectedValue = false;
        //hangman.addToCorrectGuesses('a');
        boolean actualValue = hangman.checkCorrectGuesses('a'); //
        Assert.assertEquals("Expected value: true", expectedValue, actualValue);
    }

    @Test
    public void addToIncorrectGuessesTest(){
        Player player=new Player();
        Hangman hangman = new Hangman(player);
        boolean expectedValue = false;
        //hangman.addToIncorrectGuesses('a');
        boolean actualValue = hangman.checkIncorrectGuesses('a'); //
        Assert.assertEquals("Expected value: true", expectedValue, actualValue);
    }

    @Test
    public void pickWordTest(){
        Player player=new Player();
        Hangman hangman = new Hangman(player);
        String expectedValue = "beagle";
        String actualValue = hangman.pickWord();
        Assert.assertEquals("Did not return a value", expectedValue, actualValue);
    }

    @Test
    public void randomNumberTest(){
        Player player=new Player();
        Hangman hangman = new Hangman(player);
        Random rand = new Random(1);

    }

    @Test
    public  void getNumberOfGuessesTestIncorrectCharacter(){
        Player player=new Player();
        Hangman hangman = new Hangman(player);
        int expectedValue = 1;
        hangman.check('z');
        int actualValue = hangman.getNumberOfGuesses();
        Assert.assertEquals("Expected value: 1", expectedValue, actualValue);
    }//PASSED

    @Test
    public void getNumberOfGuessesTestCorrectCharacter(){
        Player player=new Player();
        Hangman hangman = new Hangman(player);
        int expectedValue = 1;
        hangman.check('k');
        int actualValue = hangman.getNumberOfGuesses();
        Assert.assertEquals("Expected value: 0", expectedValue, actualValue);
    }//PASSED

    @Test
    public void getNumberOfGuessesTestIncorrectWord(){
        Player player=new Player();
        Hangman hangman = new Hangman(player);
        int expectedValue = 1;
        hangman.check("Thumposaurus");
        int actualValue = hangman.getNumberOfGuesses();
        Assert.assertEquals("Expected value: 1", expectedValue, actualValue);
    }//PASSED

    @Test
    public void getNumberOfGuessesTestCorrectWord(){
        Player player=new Player();
        Hangman hangman = new Hangman(player);
        int expectedValue = 1;
        hangman.check("Bluetick");
        int actualValue = hangman.getNumberOfGuesses();
        Assert.assertEquals("Expected value: 0", expectedValue, actualValue);
    }//PASSED

    @Test
    public void getAnswerWordTest(){
        Player player=new Player();
        Hangman hangman = new Hangman(player);
        hangman.setAnswerWord("beagle");
        String expectedValue = "beagle";
        String actualValue = hangman.getAnswerWord();
        Assert.assertEquals("Expected value: beagle", expectedValue, actualValue);
    }//PASSED

    @Test
    public void pickWordTestII(){
        Player player=new Player();
        Hangman hangman = new Hangman(player);
        //hangman.answerWord = hangman.pickWord();
        String expectedValue = "beagle";
        String actualValue = hangman.getAnswerWord();
        Assert.assertEquals("ExpectedValue: beagle", expectedValue, actualValue);
    }//PASSED

    @Test
    public void setDisplayArrayTest(){
        Player player=new Player();
        Hangman hangman = new Hangman(player);
        hangman.setAnswerArray(hangman.getAnswerWord().toCharArray());
        hangman.setDisplayArray();
        int expectedValue = 6;
        int actualValue = hangman.getDisplayArrayLength();
        Assert.assertEquals("Expected value: 6", expectedValue, actualValue);
    }

    @Test
    public void hangmanShapeTest(){
        Player player = new Player();
        Hangman hangman = new Hangman(player);
        String expectedHangmanShape = "-----\n|     |\n|     @\n|    /|\\\n|     / \\";;
        String actualHangmanShape = hangman.getHangManShape();
        Assert.assertEquals("The shape should start with all limbs",expectedHangmanShape,actualHangmanShape);
    }

    @Test
    public void hangmanShapeLimbRemovalTest(){
        Player player = new Player();
        Hangman hangman = new Hangman(player);
        hangman.setAnswerWord("qqqq");
        hangman.check('z');
        String expectedHangmanShape = "-----\n|     |\n|     @\n|    /|\\\n|    /";
        String actualHangmanShape = hangman.getHangManShape();
        Assert.assertEquals("The shape should miss one leg",expectedHangmanShape,actualHangmanShape);
    }
}
