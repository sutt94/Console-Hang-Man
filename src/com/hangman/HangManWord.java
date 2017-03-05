package com.hangman;

//***************************************************************

//Author: Billy Suttlemyre            Class: COP2551 Intro to OOP   *

//Date: 04/22/2015                Hours Worked: 10 hours         *

//                                                              *

//I, Billy Suttlemyre, hereby pledge on my honor that this code is  *

//solely that of my own. I received no help whatsoever with this*

//project other than with general concepts and debugging.       *

//I did not code this alongside any friend and I did not copy   *

//any lines of code from either the web or from a friend. I can *

//explain the logic of every single line of this code without   *

//hesitation when asked and I understand that I may be asked to *

//do so by the professor. If I am found to be in violation of   *

//this contract, which is based on the Academic Misconduct      *

//policy found in the syllabus, I understand that I will receive*

//an unforgiveable "F" for this course regardless of my prior   *

//grades.                                                        *

//***************************************************************
import java.util.Random;

public class HangManWord {

    private String[] wordBank = {"computer", "ram", "java", "integer", "program", "variable", "process", "int", "drive", "moniter", "desktop", "laptop,", "keyboard", "internet", "google", "game", "code", "double", "string", "class", "mouse", "windows", "apple", "cpu", "gpu" };
    
    private String gameWord;
    private int length;
    private int remaining;
    private int position;
    private boolean choiceInWord;
    private int numberOfGuessedLetters;
    private String hiddenWord;
    private StringBuilder sb;

    public StringBuilder getSb() {
        return sb;
    }

    public void setSb(StringBuilder sb) {
        this.sb = sb;
    }

    public String getHiddenWord() {
        return hiddenWord;
    }

    public void setHiddenWord(String hiddenWord) {
        this.hiddenWord = hiddenWord;
    }

    public int getNumberOfGuessedLetters() {
        return numberOfGuessedLetters;
    }

    public void setNumberOfGuessedLetters(int numberOfGuessedLetters) {
        this.numberOfGuessedLetters = numberOfGuessedLetters;
    }

    public String[] getWordBank() {
        return wordBank;
    }

    public void setWordBank(String[] wordBank) {
        this.wordBank = wordBank;
    }

    public String getGameWord() {
        return gameWord;
    }

    public void setGameWord(String gameWord) {
        this.gameWord = gameWord;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isChoiceInWord() {
        return choiceInWord;
    }

    public void setChoiceInWord(boolean choiceInWord) {
        this.choiceInWord = choiceInWord;
    }
    //method sets length = to gameWords length and returns it
    public int getWordLength(String word) {
        length = gameWord.length();
        return length;
    }

    //method sets length using getWordLength method, remaining is set to wordLength, amount of - as word length are 
    //stored in hiddenWord using a for loop. The hidden verion of the word is then displayed and a stringbuilder of the hiddenWord is created
    public void hideWord() {
        length = getWordLength(gameWord);
        this.setRemaining(getWordLength(gameWord));
        this.setHiddenWord("");
        for (position = 0; position < length; position++) {
            this.setHiddenWord(this.getHiddenWord() + "-");

        }
        System.out.print(this.getHiddenWord());
        sb = new StringBuilder(this.getHiddenWord());

    }

    //method chooses a random word from the wordbank array and returns it

    public String getRandomWord() {
        int r = new Random().nextInt(wordBank.length);
        String random = (wordBank[r]);
        return random;
    }

}
