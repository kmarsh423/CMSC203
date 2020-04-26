package utility;

/**
 * Class: CMSC 203
 * Instructor: Dr. Grinberg
 * Description:
 * This file calculates the holiday bonus for each store and the total holiday bonus
 * Due: 04/26/2020
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. 
 * I have not given my code to any student. Print your Name here: Kobie Marsh
 * @author Kobie Marsh
 * 
 */


public class HolidayBonus {
	
	/**
	 * This method calculates the individual holiday bonuses for each store
	 * @param double[][] data
	 * @param double high
	 * @param double low
	 * @param double other
	 * @return double[] bonus
	 */
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {
		double[] bonus = new double[6];
		
		for(int i = 0; i < data.length; i++) {
			for(int k = 0; k < data[i].length; k++) {
				if(data[i][k] == TwoDimRaggedArrayUtility.getHighestInColumn(data, k)) {
					bonus[i] += high;
				}
				else if(data[i][k] == TwoDimRaggedArrayUtility.getLowestInColumn(data, k)) {
					bonus[i] += low;
				}
				else
					bonus[i] += other;
			}
		}
		
		return bonus;
	}
	
	/**
	 * This method calculates the total holiday bonuses for every store
	 * @param double[][] data
	 * @param double high
	 * @param double low
	 * @param double other
	 * @return double bonus
	 */
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {
		double bonus = 0;
		
		for(int i = 0; i < data.length; i++) {
			for(int k = 0; k < data[i].length; k++) {
				if(data[i][k] == TwoDimRaggedArrayUtility.getHighestInColumn(data, k)) {
					bonus += high;
				}
				else if(data[i][k] == TwoDimRaggedArrayUtility.getLowestInColumn(data, k)) {
					bonus += low;
				}
				else
					bonus += other;
			}
		}
		
		return bonus;
	}

}
