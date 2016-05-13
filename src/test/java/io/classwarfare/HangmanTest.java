package io.classwarfare;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

/**
 * Created by wilsondulap on 5/11/16.
 */
public class HangmanTest {


    public void checkTestStringEndsGame(){ //Checks if a correct guess will end the game
        Hangman hangman = new Hangman();
        boolean expectedValue = true;
        boolean actualValue = hangman.check("bluetick");
        Assert.assertEquals("Expected value: true", expectedValue, actualValue);
    }

    public void checkTestStringCaseSensitivity(){//Checks whether check() is case-insensitive
        Hangman hangman = new Hangman();
        boolean expectedValue = true;
        boolean actualValue = hangman.check("Bluetick");
        Assert.assertEquals("Expected value: true", expectedValue, actualValue);
    }

    public void checkTestStringCaseSensitivityControl(){//Checks whether check() is case-insensitive
        Hangman hangman = new Hangman();
        boolean expectedValue = true;
        boolean actualValue = hangman.check("bluetick");
        Assert.assertEquals("Expected value: true", expectedValue, actualValue);
    }


    public void checkTestStringCaseSensitivityWrongGuess(){//Checks whether check() is case-insensitive
        Hangman hangman = new Hangman();
        boolean expectedValue = true;
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

    public void checkArrayTestAlreadyGuessCorrectly(){
        Hangman hangman = new Hangman();
        hangman.addToCorrectGuesses('z');
        boolean expectedValue = false;
        boolean actualValue = hangman.check('k');
        Assert.assertEquals("Expected value: true", expectedValue, actualValue);
    }

    public void checkCorrectGuessesTest(){
        Hangman hangman = new Hangman();
        boolean expectedValue = true;
        boolean actualValue = hangman.checkCorrectGuesses('a');
        Assert.assertEquals("Expected value: true", expectedValue, actualValue);
    }

    public void checkIncorrectGuessesTest(){
        Hangman hangman = new Hangman();
        //hangman.incorrectGuesses.add('a');
        boolean expectedValue = true;
        boolean actualValue = hangman.checkIncorrectGuesses('a');
        Assert.assertEquals("Expected value: true", expectedValue, actualValue);
    }

    public void addToCorrectGuessesTest(){
        Hangman hangman = new Hangman();
        boolean expectedValue = false;
        //hangman.addToCorrectGuesses('a');
        boolean actualValue = hangman.checkCorrectGuesses('a'); //
        Assert.assertEquals("Expected value: true", expectedValue, actualValue);
    }

    public void addToIncorrectGuessesTest(){
        Hangman hangman = new Hangman();
        boolean expectedValue = false;
        //hangman.addToIncorrectGuesses('a');
        boolean actualValue = hangman.checkIncorrectGuesses('a'); //
        Assert.assertEquals("Expected value: true", expectedValue, actualValue);
    }

    public void firstWordTest(){
        Hangman hangman = new Hangman();
        String expectedValue = hangman.wordBank[0];
        String actualValue = "beagle";
        Assert.assertEquals("Expected value: beagle", expectedValue, actualValue);
    }


    public void pickWordTest(){
        Hangman hangman = new Hangman();
        String expectedValue = "beagle";
        String actualValue = hangman.pickWord();
        Assert.assertEquals("Did not return a value", expectedValue, actualValue);
    }

    public void wordbankLengthTest(){
    Hangman hangman = new Hangman();
        int expectedValue = 2;
        int actualValue = hangman.wordBank.length;
        Assert.assertEquals("Expected value: 2", expectedValue, actualValue);
    }

    public void randomNumberTest(){
        Hangman hangman = new Hangman();
        Random rand = new Random(1);

    }


    public  void getNumberOfGuessesTestIncorrectCharacter(){
        Hangman hangman = new Hangman();
        int expectedValue = 1;
        hangman.check('z');
        int actualValue = hangman.getNumberOfGuesses();
        Assert.assertEquals("Expected value: 1", expectedValue, actualValue);
    }//PASSED


    public void getNumberOfGuessesTestCorrectCharacter(){
        Hangman hangman = new Hangman();
        int expectedValue = 0;
        hangman.check('k');
        int actualValue = hangman.getNumberOfGuesses();
        Assert.assertEquals("Expected value: 0", expectedValue, actualValue);
    }//PASSED

    public void getNumberOfGuessesTestIncorrectWord(){
        Hangman hangman = new Hangman();
        int expectedValue = 1;
        hangman.check("Thumposaurus");
        int actualValue = hangman.getNumberOfGuesses();
        Assert.assertEquals("Expected value: 1", expectedValue, actualValue);
    }//PASSED

    public void getNumberOfGuessesTestCorrectWord(){
        Hangman hangman = new Hangman();
        int expectedValue = 0;
        hangman.check("Bluetick");
        int actualValue = hangman.getNumberOfGuesses();
        Assert.assertEquals("Expected value: 0", expectedValue, actualValue);
    }//PASSED

    public void getAnswerWordTest(){
        Hangman hangman = new Hangman();
        String expectedValue = "bluetick";
        String actualValue = hangman.getAnswerWord();
        Assert.assertEquals("Expected value: bluetick", expectedValue, actualValue);
    }//PASSED

    public void pickWordTestII(){
        Hangman hangman = new Hangman();
        //hangman.answerWord = hangman.pickWord();
        String expectedValue = "beagle";
        String actualValue = hangman.getAnswerWord();
        Assert.assertEquals("ExpectedValue: beagle", expectedValue, actualValue);
    }//PASSED

    public void getUserInputTest(){
        Hangman hangman = new Hangman();
        boolean expectedValue = true;
        boolean actualValue = hangman.getUserInput();
        Assert.assertEquals("Expected value: true", expectedValue, actualValue);
    }


    public void setDisplayArrayTest(){
        Hangman hangman = new Hangman();
        hangman.answerArray = hangman.answerWord.toCharArray();
        hangman.setDisplayArray();
        int expectedValue = 200;
        int actualValue = hangman.getDisplayArrayLength();
        Assert.assertEquals("Expected value: 6", expectedValue, actualValue);
    }//PASSED
    /*
    public void guessLetterTest(){
        Hangman hangman = new Hangman();
        char expectedValue = ; //WHAT SHOULD THIS BE???
        char actualValue = hangman.guessLetter();
        Assert.assertEquals("Expected value: ", expectedValue, actualValue);
    }

    public void guessWordTest(){
        Hangman hangman = new Hangman();
        String expectedValue = ; //WHAT SHOULD THIS BE???
        String actualValue = hangman.guessWord();
        Assert.assertEquals("Expected value: ", expectedValue, actualValue);
    }
    */
}
