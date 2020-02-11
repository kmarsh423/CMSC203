package dataElemtent;

/**
 * The Purpose of this class is to model a television
 * @author Kobie Marsh
 * 02/11/20
 */

public class Television {
	
	
	private final String MANUFACTURER; // Takes the Manufacturer of the TV 
	private final int SCREEN_SIZE; // Takes the screen size of the TV
	private boolean powerOn = false; // Determines whether the TV is on or off
	private int channel = 2; // Determines the channel number
	private int volume = 20; // Sets the volume of the TV
	
	
	
	/**
	 * Constructs the Television object
	 * @param brand
	 * @param size
	 */
	public Television(String brand, int size) {
		this.MANUFACTURER = brand;
		this.SCREEN_SIZE = size;
	}
	
	/**
	 * Sets the channel number in the TV
	 * @param channel
	 */
	public void setChannel(int channel) {
		this.channel = channel;
	}
	
	/**
	 * Changes the power of the TV to either off or on
	 * @param powerOn
	 */
	public void power() {
		this.powerOn = !this.powerOn;
	}
	
	/**
	 * Increments Volume
	 * @param volume
	 */
	public void increaseVolume() {
		this.volume++;
	}
	
	/**
	 * Decrements Volume
	 * @param volume
	 */
	public void decreaseVolume() {
		this.volume--;
	}
	
	/**
	 * Gets value of channel located in Television object
	 * @return int channel
	 */
	public int getChannel() {
		return this.channel;
	}
	
	/**
	 * gets value of volume located in Television object
	 * @return int volume
	 */
	public int getVolume() {
		return this.volume;
	}
	
	/**
	 * gets Manufacturer name from object
	 * @return constant manufacturer
	 */
	public String getManufacturer() {
		return this.MANUFACTURER;
	}
	/**
	 * gets Screen size from the object
	 * @return constant screen size
	 */
	public int getScreenSize() {
		return this.SCREEN_SIZE;
	}
	
}
