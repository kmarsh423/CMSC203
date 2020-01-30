/**
   This program demonstrates how numeric types and operators behave in Java
*/
import java.util.Scanner;

public class NumericTypes {
	public static void main (String [] args) {
		Scanner stdin = new Scanner(System.in); //scanner object
		//identifier declarations 
		final int NUMBER = 2; // number of scores
		int score1 = 100; // first test score
		int score2 = 95; // second test score
		final int BOILING_IN_F = 212; // boiling temperature
		double fToC; // temperature in Celsius
		double average; // arithmetic average
		String output; // line of output to print out
		int userT; //Holds user temperature
		System.out.print("Enter the first score: ");
		int userScore1 = stdin.nextInt(); //First user score
		System.out.print("Enter the second score: ");
		int userScore2 = stdin.nextInt(); //Second user score
		average = (double)(userScore1 + userScore2) / NUMBER;
		System.out.print(userScore1 + " and " + userScore2 + " have an average of " + average + "\n");
		average = (double)(score1 + score2) / NUMBER;
		output = score1 + " and " + score2 + " have an average of " + average;	
		System.out.println(output);
		// Convert Fahrenheit temperatures to Celsius
		fToC = (double)5/9 * (BOILING_IN_F - 32);
		output = BOILING_IN_F + " in Fahrenheit is " + fToC + " in Celsius.";
		System.out.println(output);
		System.out.print("Enter a temperature in Fahrenheit: ");
		userT = stdin.nextInt();
		fToC = (double)5/9 * (userT - 32);
		System.out.print(userT + " in Fahrenheit is " + fToC + " in Celsius.\n");
		System.out.println("Goodbye"); // to show that the program is ended	
	}
}

