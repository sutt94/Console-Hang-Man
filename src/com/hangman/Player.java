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
public class Player {

    private int lives;
    private int score;
    private char guessedLetter;
    private int losses;

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public char getGuessedLetter() {
        return guessedLetter;
    }

    public void setGuessedLetter(char guessedLetter) {
        this.guessedLetter = guessedLetter;
    }
    //method sets starting lives to 8
    public void setStartingLives() {
        this.setLives(8);
    }
    //method displays remaining lives
    public void displayLives(Player player) {
        System.out.println("You have " + this.getLives() + " lives remaining.");
    }

}
