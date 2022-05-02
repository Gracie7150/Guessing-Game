// Gracie Shull
// CS 145
// 4/8/2022
// Lab 1: Revised Guessing Game
// Computer picks a number, you guess it

// The program is supposed to have the user enter a number, 
// and they have to slowly try to get it right each time and 
// at the end, there is a result of all of the total games and 
// best games and such.

// imports from javalibrary
import java.util.Scanner;
import java.util.Random;

public class GSGuessingGameLab1 {
   public static void main(String[] args) { // main method
      // creating scanner and defining variables
      Scanner input = new Scanner(System.in);
      int numTries = 0;
      int sum = 0;
      int gameCount = 0;
      int bestGuess = 10000000;
      String playAgain;
      
      instructions();  // shows instructions
      playAgain = "y"; // then immediately proceeds to the game
      
      // allows the user to play more games
      while (playAgain.equalsIgnoreCase("y")) {
         numTries = playGame(numTries);
         sum += numTries;
         gameCount++;
         
         // recording the best guess
         if (numTries < bestGuess) {
            bestGuess = numTries;
         }
         
         // asking the user to play again or end their game
         System.out.println("Do you want to play again? (yes/no) ");
         String answer = input.next();
         playAgain = answer.substring(0,1);
      } // end of while loop
      results(gameCount, sum, bestGuess); // shows the results
   } // end of main method
   
   public static void instructions() {
      System.out.println("This program allows you to play a guessing game."   
      + "\nI will think of a number between 1 and"
      + "\n100 and will allow you to guess until"
      + "\nyou get it. For each guess, I will tell you"
      + "\nwhether the right answer is higher or lower"
      + "\nthan your guess.\n"); 
   } // end of instructions
   
   public static int playGame(int numTries) {
      Scanner input = new Scanner(System.in);
      int range = 100;
      int guess;
      numTries = 0;
      
      // computer thinks of a number
      Random rand = new Random();
      int randomNumber = rand.nextInt(range) + 1; // 1 to 100
      
      // asking to enter your first guess
      System.out.printf("Im thinking of a number between 1 and %d...%n", range);
      System.out.print("Whats your guess?: ");
      guess = input.nextInt();
      
      while(guess != randomNumber) {
         if (guess > randomNumber) {
            System.out.println("Its lower...");
            System.out.print("Your new guess?: ");
            guess = input.nextInt();
            numTries++;
         } else {
            System.out.println("Its higher...");
            System.out.print("Your new guess?: ");
            guess = input.nextInt();
            numTries++;
         }
      }
      numTries++;
      
      // the user has guessed the correct number
      if (numTries == 1) {
         System.out.println("Congradulations, you got it in " + numTries + " try!");
      } else {
         System.out.println("Congradulations, you got it in " + numTries + " tries!");
      }
      return numTries;
   } // end of play game
   
   public static void results(int gameCount, int sum, int bestGuess) {
      // calculating average guesses per game
      double guessGame = sum/gameCount;
      
      // displaying the overall results, pulling
      // from the play game method
      System.out.println("Overall Results:");
      System.out.printf("    Total Games: %d", gameCount);
      System.out.printf("%n    Total Guesses: %d", sum);
      System.out.printf("%n    Guesses/Game: %.1f", guessGame);
      System.out.printf("%n    Best Game: %d", bestGuess);
   } // end of results
} // end of program