package madeira.cs;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.lang.Math;
/*

    Grade
    =====
    A+ 5/5 required points +5/0 extra credit

    Comments
    ========
    This demonstrates complete understanding of control flow,
    loops and basic Java data structures. You've done this both elegantly &
    with accuracy. My only suggestion is to be wary of "edge cases". Think
    of a user as clueless - might they enter something unexpected? Regardless,
    excellent work.

 */
public class Week2 {
    public static void main(String[] args) throws FileNotFoundException {
        /*
            Problem I
            --------
            Write a program that prints your full name
            You must:
                a. Print your full name on a single output line
                b. Use 1 print statement for each part of your name (i.e. first, middle, last)
         */
        System.out.println("Carina Nicole Karp");


        /*
            Problem II
            --------
            Write a program that prints "Hello World"
            You must:
                a. Print on two separate lines
                b. Not use the "println()" method
         */
        System.out.print("Hello \nWorld");


        /*
            Problem III
            --------
            Write a program that reads your age in years
            You must:
                a. Print the variable type of their age (i.e. int)
        */
        //skip a line since problem 2 used .print
        System.out.println(" ");

        Scanner myScanner = new Scanner(System.in);
        System.out.println("What is your age?");
        int age1 = myScanner.nextInt();
        System.out.println("This value is an int type");
        //stops it from disrupting the next problem
        myScanner.nextLine();

        /*
            Problem IV
            --------
            Write a program that reads your first and last name (in two separate prompts).
            You must:
                a. Notify the user whether they've entered your first or last name
                b. The names can be entered in any order
         */
        String entry;
        for (int i = 0; i < 2; i++) {
            System.out.println("Enter my first or last name");
            entry = myScanner.nextLine();
            if (entry.equals("Carina")) {
                System.out.println("You've entered my first name");
            } else if (entry.equals("Karp")) {
                System.out.println("You've entered my last name");
            } else {
                System.out.println("error");
            }
        }


        /*
            Problem V
            --------
            Fix the errors such that the following will print false.
            You must:
                a. Only change the numbers, not the boolean assignment
         */

        int i = 0;
        int x = 6;
        int j = 25;
        boolean b = false;
        b = j % x == i;
        System.out.print(b);



        // ==================
        // EXTRA CREDIT BELOW
        // ==================


        /*
            Problem VI
            --------
            Write a program that prints your age in 5 years
            You must:
                a. Read your current age
                b. Manipulate that number
         */

        //skip a line, the last problem used .print
        System.out.println(" ");

        System.out.println("What is your age (enter a number)");
        int currentAge = myScanner.nextInt();
        int newAge = currentAge + 5;
        System.out.println("In five years, you will be " + newAge);

        //stops it from disrupting the next problem
        myScanner.nextLine();


        /*
            Problem VII
            --------
            Write a program that reads 3 numbers, sums them & divides the sum by 2
            You must:
                a. Print the result
                b. Use a mix of decimals and integers
                c. Your result should be a decimal
         */
        //num1
        System.out.println("Enter a decimal: ");
        double num1 = myScanner.nextDouble();
        //num2
        System.out.println("Enter an integer: ");
        int num2 = myScanner.nextInt();
        //num3
        System.out.println("Enter another decimal: ");
        // FIXME: Maybe consider edge cases here...what if user doesn't enter a double
        double num3 = myScanner.nextDouble();
        //arithmetic
        double sum = num1 + num2 + num3;
        double byTwo = sum / 2.0;
        System.out.println("Your result is: " + byTwo);

        // FIXME: Probably worthwhile to notify user what operations you used.

        //stops it from disrupting the next problem
        myScanner.nextLine();

        /*
            Problem VIII
            --------
            Write a program that reads in a string and identifies if the string is your name
            You must:
                a. Give the user 3 guesses
                b. Present them with a success or fail message
         */
        //initialize variables for guessing
        int guessesLeft = 3;
        String guess;
        boolean noBreak = true;
        while (guessesLeft > 0) {
            //prompt guess and update user on turns left
            System.out.println("What is my name?");
            guess = myScanner.nextLine();
            //test to see if guess is correct
            if (guess.equals("Carina")) {
                System.out.println("You guessed it! :)");
                //disable losing message
                noBreak = false;
                break;
            }
            // FIXME: Prompt with an incorrect message here perhaps
            guessesLeft--;
        }
        //losing message
        if (noBreak) {
            System.out.println("Out of guesses!");
        }


        /*
            Problem IX
            --------
            Write a program that reads input from a file called "readme.txt"
            You must:
                a. Print the content of the file
            Hints:
                a. Create the file, write some stuff, save it to the same folder as your program

         */

        File myObj = new File("/Users/pete/Desktop/ICSStudentWork/Karp/Mod1Challenge/src/madeira/cs/readme.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            System.out.println(myReader.nextLine());
        }
        myReader.close();


        /*
            Problem X
            --------
            Write a program that reads a 10 digit number & adds 1 to each DIGIT in the number.
            Print the result as a recombined whole number
            e.g.
            Initial number: 12345678910
            New number: 234567891011
         */

        //read number
        System.out.println("Enter a 10-digit number: ");
        int original = myScanner.nextInt();
        //divide into incremented digits
        /*
        FIXME: again, worthwhile to check for edge case of too large a number
        FIXME: entering an 11 digit # will overflow the array
         */


        int[] digits = new int[10];
        for (int m = 0; m < 10; m++) {
            //m is int; a is double version of the same number just bc the .pow method needs a double
            double a = m;
            //divide by one more power of 10 each time, downcast the double to an int so the division rounds down, and modulo by ten to get each digit
            //rip i wish java had a .split() equivalent
            int temp = (original / ((int) Math.pow(10,a)) % 10);
            //i didn't know how else to handle 9 so i made it a separate case with a temporary variable to hold it i'm sorry it's janky
            if (temp == 9) {
                digits[m] = 0;
            } else {
                digits[m] = temp + 1;
            }
        }
        //the array is backwards so iterate through backwards and print them on the same line
        int result = 0;
        for (int m = 9; m >= 0; m--) {
            System.out.print(digits[m]);
        }





    }
}
