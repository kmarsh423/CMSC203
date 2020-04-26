package utility;

import java.io.*;
import java.util.*;
/**
 * Class: CMSC 203
 * Instructor: Dr. Grinberg
 * Description:
 * This file gets most of the store data and returns highs and lows, also reads and writes into the file
 * Due: 04/26/2020
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. 
 * I have not given my code to any student. Print your Name here: Kobie Marsh
 * @author Kobie Marsh
 * 
 */

public class TwoDimRaggedArrayUtility {
	
	/**
	 * This method gets the average of all the information inside the 2D array data
	 * @param double[][] data
	 * @return double avg
	 */
	public static double getAverage(double[][] data) {
		double avg, amount = 0;
		for(int i = 0; i < data.length; i++) {
			for(int k = 0; k < data[i].length; k++) {
				amount++;
			}
		}
		avg = getTotal(data) / amount;
		return avg;
	}
	
	/**
	 * This method gets the total info in a specified column
	 * @param double [][] data
	 * @param int col
	 * @return double columnTotal
	 */
	public static double getColumnTotal(double[][] data, int col) {
		double columnTotal = 0;
		for(int i = 0; i < data.length; i++) {
			for(int k = 0; k < data[i].length; k++) {
				if(k == col)
					columnTotal += data[i][k];
			}
			
		}

		return columnTotal;
	}
	
	/**
	 * This method gets the highest in the 2D double array data
	 * @param double[][] data
	 * @return double largest
	 */
	public static double getHighestInArray(double[][] data) {
		double largest = Double.MAX_VALUE;
		for(int i = 0; i < data.length; i++) {
			for(int k = 0; k < data[i].length; k++) {
				if(largest <= data[i][k])
					largest = data[i][k];
			}
		}
		return largest;
	}
	
	/**
	 * This method gets the highest in a specified column
	 * @param double [][] data
	 * @param int col
	 * @return double highest
	 */
	public static double getHighestInColumn(double[][] data, int col) {
		double highest = Double.MIN_VALUE;
		for(int i = 0; i < data.length; i++) {
			for(int k = 0; k < data[i].length; k++)
				if(col == k && highest <= data[i][k]) {
						highest = data[i][k];
				} 
		}
		return highest;
	}

	/**
	 * This method gets the index of the highest in the specified column
	 * @param double[][] data
	 * @param int col
	 * @return double highest
	 */
	public static int getHighestInColumnIndex(double[][] data, int col) {
		int highest = 0;
		double highestEle = 0;
		for(int i = 0; i < data.length; i++) {
			if(highestEle <= data[i][col])
				highest = i;
		}
		return highest;
	}
	
	/**
	 * This method gets the highest value in a specified row
	 * @param double[][] data
	 * @param int row
	 * @return double highest
	 */
	public static double getHighestInRow(double[][] data, int row) {
		double highest = Double.MAX_VALUE;
		for(int i = 0; i < data[row].length; i++) {
			if(highest <= data[row][i])
				highest = data[row][i];
		}
		return highest;
	}
	
	/**
	 * This method gets the index holding the highest value in a specified row
	 * @param double[][] data
	 * @param int row
	 * @return double highest
	 */
	public static int getHighestInRowIndex(double[][] data, int row) {
		int highest = 0;
		double highestEle = 0;
		for(int i = 0; i < data[row].length; i++) {
			if(highestEle <= data[row][i])
				highest = i;
		}
		return highest;
	}
	
	/**
	 * This method gets the lowest value in the array 
	 * @param double[][] data
	 * @return double lowest 
	 */
	public static double getLowestInArray(double[][] data) {
		double lowest = Double.MAX_VALUE;
		for(int i = 0; i < data.length; i++) {
			for(int k = 0; k< data[i].length; k++) {
				if(data[i][k] != 0 && lowest >= data[i][k]) {
					lowest = data[i][k];
				}
			}
		}
		return lowest;
	}
	
	/**
	 * This method gets the lowest value in a specified column
	 * @param double[][] data
	 * @param int col
	 * @return double lowest
	 */
	public static double getLowestInColumn(double[][] data, int col) {
		double lowest = Double.MAX_VALUE;
		for(int i = 0; i < data.length; i++) {
			for(int k = 0; k < data[i].length; k++)
				if(k == col && data[i][col] <= lowest) {
					lowest = data[i][k];
			}
		}

		return lowest;
	}
	
	/**
	 * This method gets the index of the lowest value in a specified column
	 * @param double[][] data
	 * @param int col
	 * @return double lowest
	 */
	public static int getLowestInColumnIndex(double[][] data, int col) {
		int lowest = 0;
		double lowestEle = data[0][col];
		for(int i = 0; i < data.length; i++) {
			for(int k = 0; k < data[i].length; k++) {
				if(lowestEle >= data[i][col])
					lowest = i;
			}
		}
		return lowest;
	}
	
	/**
	 * This method gets the lowest value in a specified row
	 * @param duoble[][] data
	 * @param int row
	 * @return double lowest
	 */
	public static double getLowestInRow(double[][] data, int row) {
		double lowest = Double.MAX_VALUE; 
		for(int i = 0; i < data[row].length; i++) {
			if(lowest >= data[row][i])
				lowest = data[row][i];
		}
		return lowest;
	}
	
	/**
	 * This method gets the index of the lowest value in a specified row
	 * @param double[][] data
	 * @param int row
	 * @return double lowest
	 */
	public static int getLowestInRowIndex(double[][] data, int row) {
		int lowest = 0;
		double lowestEle = data[row][0];
		for(int i = 0; i < data[row].length; i++) {
			if(lowestEle >= data[row][i])
				lowest = i;
		}
		return lowest;
	}
	
	/**
	 * This method gets the total of a specified row in the array
	 * @param double[][] data
	 * @param int row
	 * @return double rowTotal
	 */
	public static double getRowTotal( double[][] data, int row) {
		double rowTotal = 0;
		for(int i = 0; i < data[row].length; i++) {
			rowTotal+= data[row][i];
		}
		return rowTotal;
	}
	
	/**
	 * This method gets the total of all the data in the array
	 * @param double[][] data
	 * @return double total
	 */
	public static double getTotal(double[][] data) {
		double total = 0;
		for(int i = 0; i < data.length; i++) {
			for(int k = 0; k < data[i].length; k++) {
				total+=data[i][k];
			}
		}
		return total;
	}
	
	/**
	 * This method reads the file and inputs it into a 2D double array called data 
	 * @param File file
	 * @return double[][] data
	 */
	public static double[][] readFile(File file){
		double[][]data = new double[6][];
		int i = 0;
		String line;
		try {
			Scanner read = new Scanner(file);
			while (read.hasNextLine()) {
				int k = 0;
				String[] vals;
				line = read.nextLine();
				vals = line.trim().split(" ");			
				data[i] = new double[vals.length];
				for(String val : vals) {
					data[i][k++] = Double.parseDouble(val);
				}
				i++;
			}
			read.close();
		} catch(Exception e) {
			System.out.println("Something went wrong in read file");
			e.printStackTrace();
		}
	
		
		return data;
	}
	
	/**
	 * This method writes to the file using the 2D double array data
	 * @param double[][ data
	 * @param File outputFile
	 */
	public static void writeToFile(double[][] data, File outputFile) {
		try {
			FileWriter newWrite = new FileWriter(outputFile);
			for(int i = 0; i < data.length; i++) {
				for(int k = 0; k < data[i].length; k++) {
					newWrite.write(String.valueOf(data[i][k]) + " ");
				}
				newWrite.write("\n");
			}
			newWrite.close();
		}catch (IOException e) {
			System.out.print("Something went wrong in write file");
			e.printStackTrace();
		}
	}
	
}
