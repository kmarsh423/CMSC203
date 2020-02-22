package Driver;

/**
 * This program is used to ask the name, age, and toy for a child and print out a receipt
 * @author Kobie Marsh
 *
 */

import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import DataElement.Toy;

public class Birthday{
	public static void main(String args[]) {// launching application
		System.out.print("BIRTHDAY GIFTS\n\n");
		//declaring and initializing variables 
		try{// to catch the null pointer exception		
			int yOrN = 0;
			double sum = 0.0;
			DecimalFormat dollar = new DecimalFormat("#,##0.00"); // for the decimal format of the cash
			String again; // for the multiple children
			int stringToInt = -1;
				
			JOptionPane.showMessageDialog(null, "Welcome to the Toy Company to choose gifts for young children");
				
			String childName = null;
				
			Toy toy = new Toy();
			do {// child loop
				toy.setToy("Restart");
				do {// age ok loop	
					do {//name loop
					
						childName = JOptionPane.showInputDialog("Enter the name of the child");
						if (childName.equals(""))// for any accidental enter pushes
							JOptionPane.showMessageDialog(null, "Please enter a valid name");
						
					}while(childName.equals(""));
					
					do {// age loop
						try {
							String str =JOptionPane.showInputDialog("How old is the child?");
							if (str.equals(null))// to make a usable cancel button
								System.exit(0);
							else
								stringToInt = Integer.parseInt(str); // check to see if any integer are in the string		
							if(stringToInt < 0) // catch any negative numbers
							JOptionPane.showMessageDialog(null, "Please enter a valid age");				
							
						}catch(NumberFormatException e) {//catch any non number answers like "Twelve" instead of "12"
							stringToInt = -2;
							JOptionPane.showMessageDialog(null, "Please enter a valid age");
						}
					}while(stringToInt <= -1);
					toy.setAge(stringToInt);
					while(!toy.getToy().equalsIgnoreCase("plushie") &&  // physical toy loop
						!toy.getToy().equalsIgnoreCase("book")  && 
						!toy.getToy().equalsIgnoreCase("blocks")){
						toy.setToy(JOptionPane.showInputDialog("Choose a toy: a plushie, blocks, or a book"));
					if(!toy.getToy().equalsIgnoreCase("plushie") && !toy.getToy().equalsIgnoreCase("book")  && !toy.getToy().equalsIgnoreCase("blocks"))//catches any invalid answer
						JOptionPane.showMessageDialog(null, "Please choose a valid toy"); //catch any non accepted answers									
					};			
					toy.setCost(toy.getToy()); //sets cost for toy
					
					if(toy.ageOK() == false) {// catches the age and asks them if they want to restart since the age is incorrect
							yOrN = JOptionPane.showConfirmDialog(null, "The toy that you chose might not be age appropiate, do you want another gift?");
							if(yOrN == 2 || yOrN == -1)
								System.exit(0);
							else if(yOrN == 0)
								toy.setToy("restart"); // set the toy to something other than "plushie," "blocks," or "book"
					}
					else if(toy.ageOK() == true) {
						yOrN = 1; // breaks the loop since we get penalized for using "break"
						
					}
				}while(yOrN == 0); 
					// Miscellaneous questions
				String addMisc;
				do {
					addMisc = JOptionPane.showInputDialog("Do you want a card with the gift? Yes ir No");
					if(!addMisc.equalsIgnoreCase("yes") && !addMisc.equalsIgnoreCase("no"))
						JOptionPane.showMessageDialog(null, "Please choose a valid answer(Yes or No)");
				}while(!addMisc.equalsIgnoreCase("yes") && !addMisc.equalsIgnoreCase("no"));
				toy.addCard(addMisc);
				do {
					addMisc = JOptionPane.showInputDialog("Do you want a ballon with the gift? Yes or No");
					if(!addMisc.equalsIgnoreCase("yes") && !addMisc.equalsIgnoreCase("no"))
						JOptionPane.showMessageDialog(null, "Please choose a valid answer(Yes or No)");
				}while(!addMisc.equalsIgnoreCase("yes") && !addMisc.equalsIgnoreCase("no"));
				toy.addBalloon(addMisc);
				do {
					again = JOptionPane.showInputDialog("Do you want another toy? Yes or No");
					if(!again.equalsIgnoreCase("yes") && !again.equalsIgnoreCase("no"))
						JOptionPane.showMessageDialog(null, "Please choose a valid answer(Yes or No)");
					
				}while(!again.equalsIgnoreCase("yes") && !again.equalsIgnoreCase("no"));// whether or not the user wants to repeat the questions
				sum += toy.getCost();
				System.out.print("The gift for " + childName + toy.toString() + "\n");//prints out individual child info
			}while(again.equalsIgnoreCase("yes"));
			double x = ((Math.random() * ((99999 - 10000))) + 10000); // RNG
			System.out.println("The total cost of you order is $" + dollar.format(sum) + " Order number is\n" + (int)x + "\nProgrammer: Kobie Marsh"); //Receipt end
		}catch(NullPointerException e) {
			System.exit(0);
		}
	}
	//Closing program
}
	

