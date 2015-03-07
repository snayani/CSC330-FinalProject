package edu.cuny.csi.csc330.fall14.project;

import java.io.Serializable;
import java.util.*;

/**
 * The Class CargoContainer. Is a container that is loaded onto the plane to hold items (boxes) while in transit.
 */
public class CargoContainer implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6207494264416058561L;
	
	/** The owner name. */
	private String ownerName;
	
	/** The max weight. */
	private double maxWeight; 
	
	/** The max volume. */
	private double maxVolume;
	
	/** The current weight. */
	private double currentWeight;
	
	/** The current volume. */
	private double currentVolume;
	
	/** Whether or not the container was loaded onto a flight */
	private boolean loaded;
	
	/** The cargo list. */
	protected List<CargoItem> cargoList = new ArrayList<CargoItem>();
	
	//Added Constructor- Austin
	
	/**
	 * Instantiates a new cargo container.
	 * Prints a message to the system if the container was created successfully.
	 *
	 * @param ownerName the owner name
	 * @param maxWeight the max weight
	 * @param maxVolume the max volume
	 */
	public CargoContainer(String ownerName, double maxWeight, double maxVolume) {
		this.ownerName = ownerName;
		this.maxWeight = maxWeight;
		this.maxVolume = maxVolume;
		this.loaded= false;
		//database.writeContainerDB(this);
		System.out.println("Container for owner "+ownerName+" created.");
	}

	/**
	 * Clears all items from the container
	 */
	public void clearContainer()
	{
		cargoList.clear();
		this.currentVolume=0;
		this.currentWeight=0;
	}
	
	
	/**
	 * Sets the status of the container to loaded (onto a flight)
	 */
	public void loaded(){
		loaded=true;
	}
	
	/**
	 * Sets the status of the container to unloaded (from a flight)
	 */
	public void unloaded(){
		loaded=false;
	}
	
	/**
	 * Returns whether or not the container was loaded on to a flight
	 *
	 * @return the loaded
	 */
	public boolean getLoaded()
	{
		return loaded;
	}
	
	/**
	 * Gets the owner's name.
	 *
	 * @return the owner name
	 */
	public String getownerName() {
	 return this.ownerName;
	}
	
	/**
	 * Sets the owner's name.
	 *
	 * @param ownerName the new owner name
	 */
	public void setownerName(String ownerName) {
	 this.ownerName = ownerName;
	}
	
	/**
	 * Gets the max weight.
	 *
	 * @return the max weight
	 */
	public double getmaxWeight() {
	 return this.maxWeight;
	}
	
	/**
	 * Sets the max weight.
	 *
	 * @param maxWeight the new max weight
	 */
	public void setmaxWeight(double maxWeight) {
	 this.maxWeight = maxWeight;
	}
	
	/**
	 * Gets the max volume.
	 *
	 * @return the max volume
	 */
	public double getmaxVolume() {
	 return this.maxVolume;
	}
	
	/**
	 * Sets the max volume.
	 *
	 * @param maxVolume the new max volume
	 */
	public void setmaxVolume(double maxVolume) {
	 this.maxVolume = maxVolume;
	}
	
	/**
	 * Gets the current weight for the container.
	 *
	 * @return the current weight
	 */
	public double getcurrentWeight() {
	 return this.currentWeight;
	}
	
	/**
	 * Gets the current volume for the container.
	 *
	 * @return the current volume
	 */
	public double getcurrentVolume() {
	 return this.currentVolume;
	}
	
	
	/**
	 * Adds the item.
	 *
	 * @param item the item
	 * @return true, if successful
	 */
	public boolean addItem(CargoItem item) {
		
	if (item.getWeight()+currentWeight < maxWeight && item.getVolume()+currentVolume < maxVolume)	
		{
			cargoList.add(item);
			currentWeight = currentWeight+item.getWeight();
			currentVolume = currentVolume+item.getVolume();
			System.out.println("Item(s) Added Successfully");
			return true;
		}
	
	else 
		{
			System.out.println("The item "+item.getItemName()+" would not fit in this container");
			return false;
		}
	
	}
	
	/**
	 * Removes the item from the container.
	 *
	 * @param item the item
	 */
	public void removeItem(CargoItem item) {
		
		if (cargoList.contains(item))
		{
			currentWeight = currentWeight-item.getWeight();
			currentVolume = currentVolume-item.getVolume();
			cargoList.remove(item);
			System.out.println("Item removed");
		}
		else
		{
			System.out.println("Item not found");
		}
		
	}
	
	
	/**
	 * Used weight.
	 *
	 * @return the used weight
	 */
	public double usedWeight()  { 
		double usedWeight = maxWeight - currentWeight;
		return usedWeight;
	}
	
	/**
	 * Used volume.
	 *
	 * @return the used volume
	 */
	public double usedVolume() {
		double usedVolume = maxVolume - currentVolume;
		return usedVolume;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CargoContainer [ownerName=" + ownerName + ", maxWeight="
				+ maxWeight + ", maxVolume=" + maxVolume + ", currentWeight="
				+ currentWeight + ", currentVolume=" + currentVolume
				+ ", cargoList=" + cargoList + "]";
	}


/**
 * The main method. Tester method
 *
 * @param args the arguments
 */
public static void main (String args[]){
	
	CargoContainer test1 = new CargoContainer("Austin", 800, 8000);
	CargoContainer test2 = new CargoContainer("Swathi", 10000, 10000000);
	CargoItem item1 = new CargoItem("Toys", 200, 10, 20, 10); //Volume= 2000
	CargoItem item2 = new CargoItem("Pens", 50, 50, 20, 5); //Volume= 5000
	CargoItem item3 = new CargoItem("Trucks", 5000, 500, 500, 10); //Volume= 2500000
	
	System.out.println(test1);
	test1.addItem(item1);
	System.out.println(test1);
	test1.addItem(item2);
	System.out.println(test1);
	test1.addItem(item3);
	test2.addItem(item3);
	System.out.println(test2);
	test1.removeItem(item1);
	System.out.println(test1);
}


}