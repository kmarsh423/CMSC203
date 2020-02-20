
import java.util.Scanner;



public class windchillCalculator {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		
		double tempInF, windC;
		
		System.out.println("Wind Chill Calculator\n");
		
		do {
			System.out.print("Enter the temperature in Fahrenheit (must be >= -45 and <=40):");
			tempInF = stdin.nextDouble();
			if(tempInF < -45 || tempInF > 40) {
				System.out.print("The value you inputted is not accepted, please try again ( >= -45 and <= 40)");
			}
			
		}while(tempInF < -45 || tempInF > 40);
		
		do {
			System.out.print("Enter the wind chill (must be >= 5 and <= 60):");
			windC = stdin.nextDouble();
			if(windC < 5 || windC > 60) {
				System.out.print("The value you inputted is not accepted, please try again ( >= -45 and <= 40)");
			}
			
		}while(windC < 5 || windC > 60);
		
		System.out.println("Wind chill temperature: " + (35.74 + 0.6215*tempInF - 35.75*Math.pow(windC,0.16) + 0.4275*tempInF*Math.pow(windC, 0.16)) + " degrees Fahrenheit");
		
		System.out.print("Programmer: Kobie Marsh");

	}
	
	
}
