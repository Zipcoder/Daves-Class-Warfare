package io.classwarfare;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by wilsondulap on 5/11/16.
 */
public class Hangman {
    //private char letter;
    private int numberOfGuesses = 0;
    public String[] wordBank = {"beagle", "beagle"};
    public String answerWord = pickWord(); //this is the answer they're trying to guess
    public ArrayList<Character> correctGuesses = new ArrayList<Character>();
    public ArrayList<Character> incorrectGuesses = new ArrayList<Character>();
    public char[] answerArray = answerWord.toCharArray();
    public char[] displayArray;


    public int randomNumber;
    /*
The game greets the player; if the player is ready to play, he types "y"
The playGame() **method** runs, making these happen:
The variable answerWord is set as equal to the value of calling the pickWord() **method**d
The player submits a guess in the form of the variable "input," which is set in someother class
The "input" is fed into the method CHECK.
    If it's a character
        The character is set to lower case CHECK
        The answerWord is set to an array called answerArray CHECK (happens before this method)
        CHECKA **method** check(char) goes through answerArray and checks whether any of the elements equals "input".
            If yes,
                A **method** checkCorrectGuesses(boolean) checks whether this letter is already in the correctGuesses array
                    If yes,
                        Inform the user that he's already guessed this
                        break
                    If no,
                        Some **method** runs to add this guess into the right place(s) in the correctGuesses array
                        The user is told that his guess is correct
            CHECKIf no,
                run a **method** that will add the letter to the incorrectGuesses method
                Inform the user that his guess was incorrect
     If it's a word
        CHECKThe word is set to lower case
        If the word equals the answerWord,
            Congratulate the user
            Tell him the game is over
            Return true
        If the word != answerWord,
            Tell him his guess was wrong
            Increment numberOfGuesses
            Return false
 YOU STILL DON'T HAVE THE PART THAT TURNS THE CORRECT-GUESS CHARACTERS INTO A STRING THAT YOU CAN USE TO TELL WHETHER
 THE PLAYER HAS WON OR NOT


     */

    /*
    public boolean check(char letter){ //This checks the guessed word against the actual answer, if they guess a String-word
        letter = Character.toLowerCase(letter);
        answerArray = answerWord.toCharArray();
        //(checkAnswerArray(letter))? return true: return false;
        if(checkAnswerArray(letter)){
            return true;
        }else{
            return false;
        }

    */

    //WORKS
    public void setDisplayArray(){
        displayArray = new char[answerArray.length];
        for(int i=0; i<displayArray.length; i++){
            displayArray[i] = '_';
        }
        System.out.println(displayArray[5]);
    }

    public void updateDisplayArray(){
        for(int i=0; i<correctGuesses.size(); i++){
            for(int j=0; j<answerArray.length; j++){
                if(correctGuesses.get(i) == answerArray[j]){
                    displayArray[j] = answerArray[j];
                }
            }
        }
    }

    public String makeDisplayString(){
        String displayString = "";
        for(int i=0; i<displayArray.length; i++){
            displayString += Character.toString(displayArray[i]);
        }
        return displayString;
    }

    public int getDisplayArrayLength(){
        return displayArray.length;
    }

    public boolean getUserInput(){
        Scanner input = new Scanner(System.in);
        putToDisplay("Guess the word, or a letter in the word.");
        String s = input.next();
        if(s.length() > 1){
            System.out.println("It's a string");
            check(s);
            return true;
        }else if(s.length() == 1){
            System.out.println("It's a CHAR");
            check(s.charAt(0));
            return true;
        }

        return false;
    }
    public void checkNumberOfGuesses(){
        if(numberOfGuesses >= 7){
            putToDisplay("You're dead!!!\nGAME OVER");
        }
    }

    public static void main(String[] args){
        Hangman hangmantest = new Hangman();
        //hangmantest.getUserInput();
        //hangmantest.getUserInput();

        hangmantest.pickWord();
        hangmantest.setDisplayArray();
        hangmantest.putToDisplay(hangmantest.makeDisplayString());
        hangmantest.getUserInput();
        hangmantest.updateDisplayArray();
        hangmantest.putToDisplay(hangmantest.makeDisplayString());
        hangmantest.getUserInput();
        hangmantest.updateDisplayArray();
        hangmantest.putToDisplay(hangmantest.makeDisplayString());hangmantest.getUserInput();
        hangmantest.updateDisplayArray();
        hangmantest.putToDisplay(hangmantest.makeDisplayString());hangmantest.getUserInput();
        hangmantest.updateDisplayArray();
        hangmantest.putToDisplay(hangmantest.makeDisplayString());hangmantest.getUserInput();
        hangmantest.updateDisplayArray();
        hangmantest.putToDisplay(hangmantest.makeDisplayString());hangmantest.getUserInput();
        hangmantest.updateDisplayArray();
        hangmantest.putToDisplay(hangmantest.makeDisplayString());hangmantest.getUserInput();
        hangmantest.updateDisplayArray();
        hangmantest.putToDisplay(hangmantest.makeDisplayString());hangmantest.getUserInput();
        hangmantest.updateDisplayArray();
        hangmantest.putToDisplay(hangmantest.makeDisplayString());hangmantest.getUserInput();
        hangmantest.updateDisplayArray();
        hangmantest.putToDisplay(hangmantest.makeDisplayString());hangmantest.getUserInput();
        hangmantest.updateDisplayArray();
        hangmantest.putToDisplay(hangmantest.makeDisplayString());

    }

    public void putToDisplay(String toDisplay){
        System.out.println(toDisplay);
    }

    public void checkForCompletion(){
        boolean complete = false;
        /*
        for(int i=0; i<answerArray.length;i++){
            if(answerArray[i] == displayArray[i]){
                complete = false;
            }
        }
        */
        if(makeDisplayString().equals(answerWord)){
            complete = true;
        }
        if(complete){
            putToDisplay("YOU WIN!\nGAME OVER");
        }

    }

    //WORKS
    public boolean check(String word){ //This checks the guessed word against the actual answer, if they guess a single char
        String guess = word.toLowerCase();

        //System.out.println(guess + "\n" + answerWord);
        if(guess.equals(answerWord)){
            putToDisplay("Hey, your guess was correct! \n GAME OVER");
            return true;
        }else{
            putToDisplay("Sorry, that's not the answer!");
            numberOfGuesses++;
            checkNumberOfGuesses();
            return false;
        }


    };

    //WORKS
    public boolean check(char letter){ //sees whether guess has already been made, and that it's correct
        boolean result = false;
        for(int j=0; j<answerArray.length; j++){ //NOT INDEXING CORRECTLY??
            if(j>0){System.out.println(j);};
            if(answerArray[j] == letter && (checkCorrectGuesses(letter) == true)){ //already guessed correctly
                putToDisplay("You've already guessed this letter!");
                result = true;
                return result;

            }else if(answerArray[j] == letter && (checkCorrectGuesses(letter) == false)){ //novel correct guess
                putToDisplay("Hey, your guess was correct!");
                addToCorrectGuesses(letter);
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
        //if(result == false && checkCorrectGuesses(letter) == false){
            //System.out.println("Sorry, wrong answer!");

        //}
    }


    //WORKS
    public boolean checkCorrectGuesses(char letter){
        //correctGuesses.add('a');
        boolean result = false;
        for(int i=0; i<correctGuesses.size(); i++){
            if(correctGuesses.get(i) == letter){
                result = true;
            }
        }
        return result;
    }

    //WORKS
    public boolean checkIncorrectGuesses(char letter){

        boolean result = false;
        for(int j=0; j< incorrectGuesses.size(); j++){
            if( incorrectGuesses.get(j) == letter){
                result = true;
                break;
            }
        }
        return result;
    }

    //WORKS
    public void addToCorrectGuesses(char letter){
        correctGuesses.add(letter);
    }

    //WORKS
    public void addToIncorrectGuesses(char letter){
        incorrectGuesses.add(letter);
    }


    //WORKS
    public String pickWord(){ //Picks a word from the wordBank
        Random rand = new Random();
        int randomNumber = rand.nextInt(wordBank.length);
        String word = wordBank[randomNumber];
        //return wordBank[randomNumber];
        return word;
        //return wordBank[1];
    }

    public int getNumberOfGuesses(){
        return numberOfGuesses;
    }

    public String getAnswerWord(){
        return answerWord;
    }

    /*
    public char guessLetter(){ //

    }

    public String guessWord(){

    }
    */


}
