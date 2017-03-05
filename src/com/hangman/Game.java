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
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Game {

    Player player1;
    HangManWord gameWord;
    private final Scanner scanner;
    List<String> alreadyChosen;

    //Game constructor
    public Game() {
        gameWord = new HangManWord();
        player1 = new Player();
        scanner = new Scanner(System.in);
        alreadyChosen = new ArrayList<>();
    }

    //startGame method runs the game using other various methods and logic
    public void startGame() {
        System.out.println("Welcome to Hang Man!");
        System.out.println("You will be shown - to represent the letters of the hidden word.");
        System.out.println("You may guess the entire word or individual letters, one at a time.");
        System.out.println("If you try to guess the whole word or enter more than one letter and it is not the hidden word, you will automatically lose.");
        System.out.println("You will have 8 incorrect guesses until you lose.");
        //Starting lives and losses are set, lives are displayed
        String input = "";
        player1.setStartingLives();
        player1.setLosses(0);
        player1.displayLives(player1);
        System.out.println();
        //outler loop begins
        while (true) {
            System.out.println("Do you want to play? Press y to play or n to quit");

            input = scanner.next().toLowerCase();
            //if user enters n, the game will end
            if (input.equals("n")) {
                System.out.println("Please play again soon.");
                break;
                //if the user enter's y, the game will continue
                //Secret word is chosen using getRandomWord method, the word is hidden, alreadyChosen array cleared
            } else if (input.equals("y")) {
                player1.setStartingLives();
                gameWord.setRemaining(1);
                alreadyChosen.clear();
                gameWord.setGameWord(gameWord.getRandomWord());
                System.out.println("Your word is: ");
                gameWord.hideWord();
                System.out.println();
                //The inner game loop begins, continuing until there are no remaining letters or player runs out of lives
                while (gameWord.getRemaining() > 0 && player1.getLives() > 0) {
                    System.out.println("Please choose a letter, or guess the whole word.");
                    alreadyChosen.add(input);
                    input = scanner.next().toLowerCase();
                    //setChoiceInWord boolean set to true or false depending on whether user input is found in the word or not
                    gameWord.setChoiceInWord((gameWord.getGameWord().indexOf(input)) != -1);

                    //if user input has been added to alreadyChosen list, ask the user to enter a letter they havent already entered
                    if (alreadyChosen.contains(input)) {
                        System.out.println("Please choose a letter that you have not already guessed.");
                        System.out.println(gameWord.getSb().toString());
                    } //if the user enters the correct word, user wins the game and score is increased by one
                    else if (input.length() > 1 && input.equals(gameWord.getGameWord())) {
                        System.out.println("You guessed the word correctly. You win!");
                        player1.setScore(player1.getScore() + 1);
                        System.out.println("You have now won " + player1.getScore() + " game(s), and you have lost " + player1.getLosses() + " game(s).");
                        break;
                        //if user enters more than one letter and the input does not equal the hidden word, the player loses
                    } else if (input.length() > 1) {
                        System.out.println("You guessed the word incorrectly");
                        player1.setLives(0);
                        

                        //if the user input was found in the word, input is converted to a char, for loop used with
                        //a stringbuilder to check position of the guessed character, and update the hidden word
                        //with correctly guessed letter, remaining variable -1 for each letter found in the word
                    } else if (gameWord.isChoiceInWord()) {
                        char letter = input.charAt(0);
                        int position;
                        for (position = 0; position < gameWord.getWordLength(gameWord.getGameWord()); position++) {
                            if (gameWord.getGameWord().charAt(position) == letter) {
                                gameWord.getSb().replace(position, position + 1, input);
                                gameWord.setRemaining(gameWord.getRemaining() - 1);
                            }
                        }
                        System.out.println(gameWord.getSb().toString());
                        // if the user guesses an incorrect letter, the player loses a life
                        //the remaining lives are displayed, and the hidden word is displayed again for convinience
                    } else {
                        player1.setLives(player1.getLives() - 1);
                        System.out.print("Your answer was incorrect, you lost a life.");
                        System.out.println();
                        System.out.println(gameWord.getSb().toString());
                        player1.displayLives(player1);
                    }
                    //if the player runs out of lives, add 1 to losses and display the fact that they have lost as well as updated wins and losses
                    if (player1.getLives() == 0) {
                        player1.setLosses(player1.getLosses() + 1);
                        System.out.println("You ran of out lives, you lost!");
                        System.out.println("You have now won " + player1.getScore() + " game(s), and you have lost " + player1.getLosses() + " game(s).");
                    }
                    //if all the letters are guessed, add 1 to player score, display that they have won and update wins and losses
                    if (gameWord.getRemaining() == 0) {
                        player1.setScore(player1.getScore() + 1);
                        System.out.println("You guessed all the letters, good job!");
                        System.out.println("You have now won " + player1.getScore() + " game(s), and you have lost " + player1.getLosses() + " game(s).");

                    }

                }
                //if user enters anything other than y or n, they are asked to follow directions and enter y or n again
            } else if (!input.equals("y") || !input.equals("n")) {
                System.out.println("Incorrect input, please follow the instructions given.");
            }

        }
    }
    //new instance of game class is created and startgame method is called to run the game
    public static void main(String[] args) 
    {
        Game newGame = new Game();
        newGame.startGame();

    }

}
