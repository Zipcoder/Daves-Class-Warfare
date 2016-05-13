package io.classwarfare;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by wilsondulap on 5/11/16.
 */
public class Hangman extends Game {
    private int numberOfGuesses = 0;
    private String[] wordBank = {"beagle", "beagle"};
    private String answerWord = pickWord();
    private ArrayList<Character> correctGuesses = new ArrayList<Character>();
    private ArrayList<Character> incorrectGuesses = new ArrayList<Character>();
    private char[] answerArray = answerWord.toCharArray();
    private char[] displayArray;
    private boolean win = false;
    private int randomNumber;

    public char[] getAnswerArray() {
        return answerArray;
    }

    public void setAnswerArray(char[] answerArray) {
        this.answerArray = answerArray;
    }

    public void setAnswerWord(String answerWord) {
        this.answerWord = answerWord;
    }

    public String getAnswerWord() {
        return answerWord;
    }

    public void setDisplayArray() {
        displayArray = new char[answerArray.length];
        for (int i = 0; i < displayArray.length; i++) {
            displayArray[i] = '_';
        }
    }

    public void updateDisplayArray() {
        for (int i = 0; i < correctGuesses.size(); i++) {
            for (int j = 0; j < answerArray.length; j++) {
                if (correctGuesses.get(i) == answerArray[j]) {
                    displayArray[j] = answerArray[j];
                }
            }
        }
    }

    public String makeDisplayString() {
        String displayString = "";
        for (int i = 0; i < displayArray.length; i++) {
            displayString += Character.toString(displayArray[i]);
        }
        return displayString;
    }

    public int getDisplayArrayLength() {
        return displayArray.length;
    }

    public boolean getUserInput() {
        Scanner input = new Scanner(System.in);
        putToDisplay("\nGuess the word, or a letter in the word.");
        String s = input.next().toLowerCase();
        if (s.length() > 1) {
            check(s);
            return true;
        } else if (s.length() == 1) {
            check(s.charAt(0));
            return true;
        }
        return false;
    }

    public void checkNumberOfGuesses() {
        if (numberOfGuesses >= 7) {
            win = true;
            putToDisplay("You're dead!!!\nGAME OVER\n");
        }
    }

    @Override
    public void play() {
        pickWord();
        setDisplayArray();
        while (!win) {
            putToDisplay(makeDisplayString());
            getUserInput();
            updateDisplayArray();
        }
    }

    @Override
    public void backToMenu() {

    }

    public void putToDisplay(String toDisplay) {
        System.out.println(toDisplay);
    }

    public void checkForCompletion() {
        boolean complete = false;

        if (makeDisplayString().equals(answerWord)) {
            complete = true;

        }
        if (complete) {
            putToDisplay("YOU WIN!\nGAME OVER\n");
            win = true;
        }
    }

    //This checks the guessed word against the actual answer, if they guess a single char
    public boolean check(String word) {
        String guess = word.toLowerCase();

        if (guess.equals(answerWord)) {
            putToDisplay("Hey, your guess was correct! \n GAME OVER\n");
            win = true;
            return true;
        } else {
            putToDisplay("Sorry, that's not the answer!");
            numberOfGuesses++;
            checkNumberOfGuesses();
            return false;
        }
    }

    public boolean check(char letter) { //sees whether guess has already been made, and that it's correct
        boolean result = false;
        for (int j = 0; j < answerArray.length; j++) { //NOT INDEXING CORRECTLY??

            if (answerArray[j] == letter && (checkCorrectGuesses(letter) == true)) { //already guessed correctly
                putToDisplay("You've already guessed this letter!");
                result = true;
                return result;

            } else if (answerArray[j] == letter && (checkCorrectGuesses(letter) == false)) { //novel correct guess
                putToDisplay("Hey, your guess was correct!");
                addToCorrectGuesses(letter);
                updateDisplayArray();
                checkForCompletion();
                result = true;
                return result;
            }
        }
        putToDisplay("Sorry, wrong answer!");
        addToIncorrectGuesses(letter); //incorrect guess
        numberOfGuesses++;
        checkNumberOfGuesses();
        result = false;
        return result;
    }

    public boolean checkCorrectGuesses(char letter) {
        boolean result = false;
        for (int i = 0; i < correctGuesses.size(); i++) {
            if (correctGuesses.get(i) == letter) {
                result = true;
            }
        }
        return result;
    }

    public boolean checkIncorrectGuesses(char letter) {

        boolean result = false;
        for (int j = 0; j < incorrectGuesses.size(); j++) {
            if (incorrectGuesses.get(j) == letter) {
                result = true;
                break;
            }
        }
        return result;
    }

    public void addToCorrectGuesses(char letter) {
        correctGuesses.add(letter);
    }

    public void addToIncorrectGuesses(char letter) {
        incorrectGuesses.add(letter);
    }


    public String pickWord() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(wordBank.length);
        String word = wordBank[randomNumber];
        return word;
    }

    public int getNumberOfGuesses() {
        return numberOfGuesses;
    }

}
