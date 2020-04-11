package dataManager;

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

import dataElement.*;
import javafx.scene.layout.Region;

public class ManagementCompany {
	
	private final int MAX_PROPERTY = 5;
	private double mgmFeePer;
	private String name;
	private Property[] properties = new Property[MAX_PROPERTY];
	private String taxID;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	private Plot plot;
	
	/**
	 * Default constructor for ManagementCompany
	 */
	public ManagementCompany(){
		properties = new Property[MAX_PROPERTY];
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}
	
	/**
	 * Constructor for ManagementCompany
	 * @param name
	 * @param taxID
	 * @param mgmFee
	 */
	public ManagementCompany(String name, String taxID, double mgmFee){
		properties = new Property[MAX_PROPERTY];
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}
	
	/**
	 * Constructor for ManagementCompnay
	 * @param name
	 * @param taxID
	 * @param mgmFeePer
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	public ManagementCompany(String name, String taxID, double mgmFeePer, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
		plot = new Plot(x, y, width, depth);
	}
	
	/**
	 * Copy Constructor for ManagementCompany
	 * @param otherCompany
	 */
	public ManagementCompany(ManagementCompany otherCompany) {
		 this.name = otherCompany.getName();
		 this.taxID = otherCompany.getTaxID();
		 this.mgmFeePer = otherCompany.getMgmFeePer();
		 this.setPlot(otherCompany.getPlot());
		 
	}

	/**
	 * Sets the plot object to the plot parameter
	 * @param plot
	 */
	public void setPlot(Plot plot) {
		this.plot = new Plot(plot);
	}

	/**
	 * Adds a property object to a property array
	 * returns -1 if array is full, -2 if the object is null, -3 if the object, -4 if the object overlaps, and the element if it is added successful
	 * @param property
	 * @return numberRet
	 */
	public int addProperty(Property property) {
		int numberRet = 2;
		
		try {
		for(int i = 0; i < properties.length; i++) {	
				if(property== null) {
					numberRet = -2;
					break;
				}
				else if(properties[i]== null) {
					properties[i] = new Property(property.getPropertyName(), property.getCity(), property.getRentAmount(), property.getOwner(), property.getPlot().getX(), property.getPlot().getY(), property.getPlot().getWidth(), property.getPlot().getDepth());
					numberRet = i;	
					for(int k = 0; k < properties.length; k++) {
						if(i == k) {
							continue;
						}
						else if(properties[k].getPlot().encompasses(properties[i].getPlot()) == false) {
							numberRet = -3;
							properties[i] = null;
							break;
						}
					    else if(properties[k].getPlot().overlaps(properties[i].getPlot()) == true) { 
							numberRet = -4;	
							properties[i] = null;
							break;
						}
						
					}
					break;
				}
				else if(i == MAX_PROPERTY-1) {
					numberRet = -1;
					break;
				}
				else
					continue;
		}
		}catch(Exception e) {
			return numberRet;
		}
		return numberRet;
	}
	
	/**
	 * Adds a property object to a property array
	 * returns -1 if array is full, -2 if the object is null, -3 if the object, -4 if the object overlaps, and the element if it is added successful
	 * @param name
	 * @param city
	 * @param rent
	 * @param owner
	 * @return numberRet
	 */
	public int addProperty(String name, String city, double rent, String owner) {
		int numberRet = 0;
		
		try {
		
		for(int i = 0; i < properties.length; i++) {
			if(name.equals(null) || city.equals(null) || rent == 0.0 || owner.equals(null))
				return -2;
			else if(properties[i]== null) {
				properties[i] = new Property(name, city, rent, owner);
				for(int k = 0; k <properties.length; k++ ) {
				if(properties[k] == null || properties[k].toString() == properties[i].toString()){
					numberRet = i;
					continue;
				}
				else if(properties[k].getPlot().overlaps(properties[i].getPlot()) == true) {
						numberRet = -4;	
						properties[i] = null;
						break;
					}
					else if(properties[k].getPlot().encompasses(properties[i].getPlot()) == false) {
						numberRet = -3;
						properties[i] = null;
						break;
					}
				}
				break;
			}
			else if(i == MAX_PROPERTY-1) {
				numberRet = -1;
				break;
			}
			else
				continue;
		}
		}catch(Exception e) {
			return numberRet;
		}
		return numberRet;
	}
	
	/**
	 * Adds a property object to a property array
	 * returns -1 if array is full, -2 if the object is null, -3 if the object, -4 if the object overlaps, and the element if it is added successful
	 * @param name
	 * @param city
	 * @param rent
	 * @param owner
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 * @return
	 */
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		int numberRet = 0;
		try {
		for(int i = 0; i < properties.length; i++) {
			if(name.equals(null) || city.equals(null) || rent == 0.0 || owner.equals(null))
				return -2;
			else if(properties[i]== null) {
				properties[i] = new Property(name, city, rent, owner, x, y, width, depth);
				numberRet = i;
				for(int k = 0; k < properties.length; k++) {
					if(properties[k].getPlot().overlaps(properties[i].getPlot()) == true) {
						numberRet = -4;	
						properties[i] = null;
						break;
					}
					else if(properties[k].getPlot().encompasses(properties[i].getPlot()) == false) {
						numberRet = -3;
						properties[i] = null;
						break;
					}
					else
						continue;
				}
				break;
			}
			else if(i == MAX_PROPERTY-1 && properties[i] != null) {
				numberRet = -1;
				break;
			}
			else
				continue;
		}
		}catch(Exception e) {
			return numberRet;
		}
		return numberRet;
	}
		
	/**
	 * Display the property at the index parameter
	 * @param i
	 * @return properties[i].toString()
	 */
	public String displayPropertyAtIndex(int i) {;
		return properties[i].toString();
	}
	
	/**
	 * get the constant max property amount in the ManagementCompany
	 * @return MAX_PROPERTY
	 */
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}
	
	/**
	 * Find the max rent amount in the property array
	 * @return max
	 */
	public double maxRentProp() {
		double max = 0;
		for(int i = 0; i <properties.length; i++) {
			if(properties[i] == null)
				break;
			else if(properties[i].getRentAmount() > max)
				max = properties[i].getRentAmount();
			else
				continue;
		}
		return max;
	}
	
	/**
	 * Find the max property at that index
	 * @return max
	 */
	public int maxRentPropertyIndex() {
		int max = 0;
		for(int i = 0; i < properties.length; i++) {
			if(properties[i] == null)
				break;
			else if(properties[i].getRentAmount() > properties[max].getRentAmount())
				max = i;
			else
				continue;
		}
		return max;
	}

	/**
	 * tallies up the total rent in the property array of the objects
	 * @return total
	 */
	public double totalRent() {
		double total = 0;
		for(int i = 0; i < MAX_PROPERTY; i++) {
			if(properties[i] == null)
				break;
			total+= properties[i].getRentAmount();
		}
		return total;
	}
	
	/**
	 * gets the plot from the company object
	 * @return plot
	 */
	public Plot getPlot() {
		return plot;
	}

	/**
	 * gets the name from the company object
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets mgmFee from the company object
	 * @return mgmFeePer
	 */
	private double getMgmFeePer() {
		return mgmFeePer;
	}

	/**
	 * Gets the taxID from the company object
	 * @return taxID
	 */
	private String getTaxID() {
		return taxID;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("List of the properties for " + name + ", taxID: " + taxID + "\n");
		builder.append("_________________________________________________________________\n");
		for(int i = 0; i<properties.length; i++) {
			if(properties[i]==null)
				break;
			builder.append(properties[i].toString()+ "\n");
		}
		builder.append("_________________________________________________________________");
		builder.append("\n\ntotal managment Fee: " + (mgmFeePer*this.totalRent())/100);
		return builder.toString();
	}
	

}
