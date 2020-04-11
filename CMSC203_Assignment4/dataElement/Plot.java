package dataElement;
/**
 * Class: CMSC 203
 * Instructor: Dr. Grinberg
 * Description:
 * This program creates property for a management company and fits them on a specified plot
 * Due: 03/29/2020
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. 
 * I have not given my code to any student. Print your Name here: Kobie Marsh
 * @author Kobie Marsh
 **/

public class Plot {
	
	private int x;
	private int y;
	private int width;
	private int depth;
	
	/**
	 * This method is a default constructor for the Plot object
	 */
	public Plot() {
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}
	
	/**
	 * This method is a copy constructor for the Plot object. Copies information from a Plot object into a new Plot object 
	 * @param Plot p
	 */
	public Plot(Plot p) {
		x = p.getX();
		y = p.getY();
		width = p.getWidth();
		depth = p.getDepth();
	}
	
	/**
	 * This method is a constructor for the Plot object.
	 * @param int x
	 * @param int y
	 * @param int width
	 * @param int depth
	 */
	public Plot(int x, int y, int width, int depth){
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	/**
	 * This method checks if a plot is overlapping another plot and returns true if overlapping or false is not overlapping
	 * @param plot
	 * @return trueOrFalse
	 */
	public boolean overlaps(Plot plot) {
		boolean trueOrFalse = false; 
	
		if(x < plot.getX() + plot.getWidth() && this.x + this.width > plot.getX() && y < plot.getY() + plot.getDepth() && y + depth > plot.getY()) 
			trueOrFalse = true;
		return trueOrFalse;
	}
	
	/**
	 * This method checks if a plot is inside the Management company plot and returns true if inside the bounds and false if outside the bounds
	 * @param plot
	 * @return trueOrFalse
	 */
	public boolean encompasses(Plot plot) {
		boolean trueOrFalse = false; 

		if((plot.getX() + plot.getWidth() <= 10) && (plot.getY() + plot.getDepth() <= 10))
			trueOrFalse = true;
		
		return trueOrFalse;
	}

	/**
	 * Gets the x value in the object and returns the x value
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the x value of the object
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Gets the y value in the object and returns the y value
	 * @return y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the y value of the object
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Get the width in the object and return the width value
	 * @return width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the width of the object
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Get the depth in the object and return the depth value
	 * @return depth
	 */
	public int getDepth() {
		return depth;
	}

	/**
	 * Sets the depth of the object
	 * @param depth
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Upper left: (" + x + "," + y + "); Width: " + width + " Depth: " + depth);
		return builder.toString();
	}
	
	

}
