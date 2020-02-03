package stuff;

import stuff.Movie;
import java.util.*;

public class MovieDriver {
	
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
	
		String yesOrNo;
		
		Movie m1 = new Movie();
	
		do {
			
			System.out.println("Enter the name of a movie:");
			
			m1.setTitle(stdin.next()+stdin.nextLine());
		
			System.out.println("Enter the movie's rating:");
			m1.setRating(stdin.next());
		
			System.out.println("Enter the amount of tickets sold for this movie");
			m1.setSoldTickets(stdin.nextInt());
			
			System.out.println(m1.toString());
			
			System.out.println("Do you want to enter another? (y or n)");
			yesOrNo = stdin.next();
			
			
		}while(yesOrNo.equals("y") || yesOrNo.equals("Y"));
		
		
	}
}
