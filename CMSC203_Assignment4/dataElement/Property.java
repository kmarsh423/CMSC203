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

public class Property {
	

	private String city;
	private String owner;
	private String propertyName;
	private double rentAmount;
	private Plot plot;
	
	/**
	 * Default object for property
	 */
	public Property(){
		rentAmount = 0;
		plot = new Plot();
	}
	
	/**
	 * Constructor for the Property object accepting plot p 
	 * @param Plot p
	 */
	public Property(Plot p){
		plot = new Plot(p.getX(), p.getY(), p.getWidth(), p.getDepth());
	}
	
	/**
	 * Constructor for the Property object
	 * @param String propertyName
	 * @param String city
	 * @param double rentAmount
	 * @param String owner
	 */
	public Property(String propertyName, String city, double rentAmount, String owner){
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		plot = new Plot();
	}
	
	/**
	 * Constructor for the Property object
	 * @param propertyName
	 * @param city
	 * @param rentAmount
	 * @param owner
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth){
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		plot = new Plot(x, y, width, depth);
	}
	
	
	/**
	 * Gets string city from the object
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city in the object to the city int the parameter
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the owner from the object
	 * @return owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Sets the owner in the object to the owner in the parameter
	 * @param owner
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	/**
	 * Sets Plot to new plot object
	 * @param plot
	 */
	public void setPlot(Plot plot) {
		this.plot = new Plot(plot);
	}

	/**
	 * Gets plot from property object
	 * @return plot
	 */
	public Plot getPlot() {
		return plot;
	}
	
	/**
	 * Gets property name from the Property object 
	 * @return propertyName
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * Sets property name in the property object
	 * @param propertyName
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	/**
	 * Gets rent amount of Property object
	 * @return rentAmount
	 */
	public double getRentAmount() {
		return rentAmount;
	}

	/**
	 * Sets the rent amount to the rentAmount parameter
	 * @param rentAmount
	 */
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("Property Name: ");
		builder.append(propertyName);
		builder.append("\n Located in ");
		builder.append(city);
		builder.append("\n Belonging to: ");
		builder.append(owner);
		builder.append("\n Rent Amount: ");
		builder.append(rentAmount);
		return builder.toString();
	}
	
	
}
