package madeira.cs;

import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class Week3 {

    public static double getNumber(Scanner s) {
        System.out.println("Enter a number: ");
        //handles bad cases
        while (!s.hasNextInt() && !s.hasNextDouble()) {
            s.next();
            System.out.println("Invalid entry, try again");
        }
        return s.nextDouble();
    }

    public static void main(String[] args) {

        /*
            Problem I
            ---------
            Prompt the user to enter two numbers
            Compare the two numbers and print out "First" if first is greater or "Second" second is greater
            This should handle decimals and integers at a wide range of values
        */
        Scanner scanner = new Scanner(System.in);
        double num1 = getNumber(scanner);
        double num2 = getNumber(scanner);
        if (num1 > num2) System.out.println("The first number was greater.");
        else if (num2 > num1) System.out.println("The second number was greater.");
        else System.out.println("The two numbers are equal.");


        /*
            Problem II
            ----------
            Prompt the user to enter their favorite genre of music
            Reply with "Same!" if it is the same as your favorite genre or "Lame." if not.
        */

        //i'd be lying if i said i had a favorite genre i listen to almost anything
        //sometimes i wonder what the spotify algorithm thinks of me
        System.out.println("What's your favorite genre of music? ");
        scanner.nextLine();
        String genre = scanner.nextLine();
        //if else logic
        if (genre == "heavy metal" || genre == "emo") {
            System.out.println("I don't really vibe with that");
        } else {
            System.out.println("I could bop to that");
        }

        /*
            Problem III
            -----------
            Declare an integer, any integer.
            Prompt the user to guess your number.
            Give them 10 tries to get it right.
            If they do, present them with a congratulatory message, if not, roast them unfairly.
        */

        Random rand = new Random();
        //generate a random number between 0 and 25
        int number = rand.nextInt(25);
        int guessesLeft = 10;
        System.out.println("I've picked a random number between 0 and 25. Try to guess it!");

        while (guessesLeft > 0) {
            //get guess
            System.out.println("You have "+guessesLeft+" guesses left!");
            int guess = (int) getNumber(scanner);
            //if else logic
            if (guess == number) {
                //if correct guess
                System.out.println("You got it!");
                break;
            } else {
                guessesLeft--;
                //if wrong, either check for loss of game after decrementing guesses or prompt another guess
                if (guessesLeft == 0) {
                    System.out.println("You've lost! The number was: "+number);
                    //roast user unfairly
                    System.out.println("rest in pieces, defeated by a cringe number guessing game :(");
                    break;
                } else System.out.println("Nope! Try again.");
            }
        }



        /*
            Problem IV
            ----------
            Produce the following output using one print statement

            *****
            ****
            ***
            **
            *
        */
        String asterix;
        for (int i = 5; i > 0; i--) {
            //reset asterix
            asterix = "";
            for (int j = i; j > 0; j--) {
                asterix += "*";
            }
            System.out.println(asterix);
        }

        /*
            Problem V
            ---------
            Produce the following output using one print statement

            ****
            **
            *
        */

        for (int i = 4; i >= 1; i /= 2) {
            //reset asterix
            asterix = "";
            for (int j = i; j > 0; j--) {
                asterix += "*";
            }
            System.out.println(asterix);
        }


        /*
            ------------------
            EXTRA CREDIT BELOW
            ------------------


            Problem VI
            ----------
            Declare an number, any number.
            Prompt the user to guess your number.
            Give them 10 tries to get it right.
            For each try they should either be:
                Hot: +/- 2
                Medium: +/- 4
                Mild: +/- 8
            If they are Hot they should have 4 guesses subtracted from their total remaining
            If they are Medium they should have 2 guesses subtracted from their total remaining
            If they are Mild they should have 1 guess subtracted from their total remaining

            Once they're out of guesses, they should be prompted to play again.


            Edge Cases:
            - If I have 4 guesses remaining and my guess is within 2 of the correct answer I should receive the prompt: "One more guess!"
            - Same goes for 2 guesses remaining with a Medium guess
            - User should be able to enter ANY TYPE of number

            Brownie points for well commented / organized code that goes above and beyond to direct the user clearly & leaves no room for ambiguous edge cases

        */

        //generate a random number between 0 and 25 (reassign variables from earlier)
        number = rand.nextInt(25);
        guessesLeft = 10;
        System.out.println("I've picked a random number between 0 and 25. Try to guess it!");

        while (guessesLeft > 0) {
            //get guess
            System.out.println("You have "+guessesLeft+" guesses left!");
            int guess = (int) getNumber(scanner);

            //if else logic
            //1. check for correct guess
            if (guess == number) {
                //if correct guess
                System.out.println("You got it!");
                break;

            //2. wrong guess cases - how many guesses to subtract?
            } else {
                //2-a. test for hot guess
                if (Math.abs(guess - number) <= 2) {
                    //2-a-i if hot guess, test for exactly 4 guesses left
                    System.out.println("You're within 2 of the correct number! You've lost 4 guesses.");
                    if (guessesLeft == 4) { // one more guess edge case; user gets one more guesses
                        guessesLeft = 1;
                        System.out.println("One more guess!");
                    } else guessesLeft -= 4; //2-a-ii (normally subtract 4 for hot guess)
                }
                //2-b. test for medium guess
                else if (Math.abs(guess - number) <= 4) {
                    System.out.println("You're within 4 of the correct number! You've lost 2 guesses.");
                    //2-b-i if medium guess, test for exactly 2 guesses left
                    if (guessesLeft == 2) { // one more guess edge case; user gets one more guesses
                        guessesLeft = 1;
                        System.out.println("One more guess!");
                    } else guessesLeft -= 2; //2-b-ii (normally subtract 4 for hot guess)
                }
                //2-c. not an edge case, regular guess
                else guessesLeft -= 1;
            }

            //3. once appropriate amount of guesses have been subtracted, has user lost?
            if (guessesLeft <= 0) {
                System.out.println("You're out of guesses! The number was: "+number);
                break;
            } else System.out.println("Try again.");

        }

    }
}