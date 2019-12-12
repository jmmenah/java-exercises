/*
1.- Modify the program GameRockPaperScissors.java so that three rounds are played. (6,5 points)

    The program must be play 3 rounds showing a numbered message for each one (1,5 points)
    The program will accept only three valid options: rock, paper or scissors (case insensitive) (3,5 points)
    At the end of the three rounds the program will show the final result of the three rounds (See examples below) (1,5 points)

See the following examples of program output:

$ java GameRockPaperScissors 
Round #1
========
Please, choose (rock, paper or scissors): ROCK
The computer choose: scissors
rock destroys scissors: Player wins!

Round #2
========
Please, choose (rock, paper or scissors): lizard
Not valid option!

Please, choose (rock, paper or scissors): Spock
Not valid option!

Please, choose (rock, paper or scissors): Paper
The computer choose: scissors
scissors cut paper: Computer wins!

Round #3
========
Please, choose (rock, paper or scissors): pape
Not valid option!

Please, choose (rock, paper or scissors): scissORS
The computer choose: scissors
It's a tie!

### Game Finished ###
Player = 1
Computer = 1
Tied Game!

$ java GameRockPaperScissors 
Round #1
========
Please, choose (rock, paper or scissors): rock
The computer choose: paper
paper covers rock: Computer wins!

Round #2
========
Please, choose (rock, paper or scissors): paper
The computer choose: paper
It's a tie!

Round #3
========
Please, choose (rock, paper or scissors): scissors
The computer choose: scissors
It's a tie!

### Game Finished ###
Player = 0
Computer = 1
I'm sorry you lost the game

$ java GameRockPaperScissors 
Round #1
========
Please, choose (rock, paper or scissors): rock
The computer choose: scissors
rock destroys scissors: Player wins!

Round #2
========
Please, choose (rock, paper or scissors): rock
The computer choose: scissors
rock destroys scissors: Player wins!

Round #3
========
Please, choose (rock, paper or scissors): rock
The computer choose: rock
It's a tie!

### Game Finished ###
Player = 2
Computer = 0
Congratulations!, Player is the winner


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
 
class GameRockPaperScissors {
    // Necessary to calculate and display the final results
    static int pointsPlayer;
    static int pointsComputer;

    public static void main(String args[]){
    	for(int i=1;i<=3;i++){
    		System.out.println("Round #"+i);
    		System.out.println("========");
			playGame();
    	}
    	System.out.println("### Game Finished ###");
    	System.out.println("Player = "+pointsPlayer);
    	System.out.println("Computer = "+pointsComputer);
    	if(pointsPlayer>pointsComputer){
    		System.out.println("Congratulations!, Player is the winner");
    	}
    	else if(pointsPlayer<pointsComputer){
    		System.out.println("I'm sorry you lost the game");
    	}
    	else{
    		System.out.println("Tied Game!");
    	}
    	System.out.println();
    }

    public static void playGame() {
 	String p = playerChoice();
 	String c = computerChoice();

	// Who wins? 
	if(p.equals(c)){
            System.out.println("It's a tie!\n");
        }
        else {
	    System.out.println(whoWins(p, c) + " wins!\n");
        }
    }	

    // player choice
    public static String playerChoice() {
 	Scanner console = new Scanner(System.in);
        System.out.print("Please, choose (rock, paper or scissors): ");
	String player = console.next();

	while (!(player.equalsIgnoreCase("rock")||player.equalsIgnoreCase("paper")||player.equalsIgnoreCase("scissors"))){
		System.out.println("Not valid option!");
		System.out.print("Please, choose (rock, paper or scissors): ");
		player = console.next();
	}
	player = player.toLowerCase();
	
	return player;

        // check only valid options: rock, paper or scissors
       
        
    }

    // computer choice 
    public static String computerChoice() {
        String[] options = {"rock", "paper", "scissors"};

        int random = (int) (Math.random() * 3);  // random number between 0 and 2
        String computer = options[random];  // translate number 0, 1, 2 to rock, paper, scissors
 
        System.out.println("The computer choose: " + computer); 

        return computer;
    }  

    // Who is the winner? Player or Computer
    public static String whoWins(String player, String computer) {          
	String winner;

        if(computer.equals("rock")){
            if(player.equals("paper")){
                System.out.print("paper covers rock: ");
                winner = "Player";
                pointsPlayer++;
            }
            else{  // player scissors
                System.out.print("rock destroys scissors: ");
                winner = "Computer";
                pointsComputer++;
            }
        } 
        else if(computer.equals("paper")){
                 if(player.equals("scissors")){
                     System.out.print("scissors cut paper: ");
                     winner = "Player";
                     pointsPlayer++;
                 } 
                 else{  // player rock
                     System.out.print("paper covers rock: ");
                     winner = "Computer";
                     pointsComputer++;
                 }
        }
        else{ // computer scissors
            if(player.equals("rock")){
                System.out.print("rock destroys scissors: ");
                winner = "Player";
                pointsPlayer++;
            }
            else{  // player paper
                System.out.print("scissors cut paper: ");
                winner = "Computer";
                pointsComputer++;
            }
        }
        return winner;
    }  // whoWins	

}  // class
