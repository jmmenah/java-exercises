/*
Rock, Paper, or Scissors

Rock paper scissors is a classic two player game. Each player chooses either rock, paper, or scissors. 
The items are compared, and whichever player chooses the more powerful item wins.

The possible outcomes are:
 - Rock destroys scissors.
 - Scissors cut paper.
 - Paper covers rock.
 - If there's a tie, then the game ends in a draw.

The program can be coded in three parts:
 1. Get the player's choice.
 2. Get the computer's choice.
 3. Compare the two choices and determine a winner
*/

import java.util.Scanner;
 
class RockPaperScissors {
    public static void main(String args[]){
        // player choice
 	Scanner console = new Scanner(System.in);
        System.out.print("Please, choose (rock, paper or scissors): ");
	String player = console.next().toLowerCase();

        // check only valid options: rock, paper or scissors
        if ( !(player.equals("rock") || player.equals("paper") || player.equals("scissors")) ) {
            System.out.println("Not valid option!");
            return; // termination of program
        } 

        // computer choice 
        String[] options = {"rock", "paper", "scissors"};

        int random = (int) (Math.random() * 3);  // random number between 0 and 2
        String computer = options[random];  // translate number 0, 1, 2 to rock, paper, scissors
 
        System.out.println("The computer choose: " + computer);

        // Who wins? 
        // Complete the code with if-else statements
	if(player.equals(computer)){
            System.out.println("It's a tie!");
        }
	else if (player.equals("rock") && computer.equals("paper")){
		System.out.println("Computer has won");
	}
	else if (player.equals("rock") && computer.equals("scissors")){
		System.out.println("Player has won");
	}
	else if (player.equals("paper") && computer.equals("rock")){
		System.out.println("Player has won");
	}
	else if (player.equals("paper") && computer.equals("scissors")){
		System.out.println("Computer Has won");
	}
	else if (player.equals("scissors") && computer.equals("paper")){
		System.out.println("Player has won");
	}
	else {
		System.out.println("Computer has won");
	}
}	
}
