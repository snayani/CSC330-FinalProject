package edu.cuny.csi.csc330.fall14.project;

import java.io.Serializable;

/**
 * The Class CargoItem. Is the lowest you can go in the hierarchy. Items are added into a container
 */
public class CargoItem implements Serializable{
	

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 662553920649645369L;
	
	/** The item name. */
	private String itemName;
	
	/** The weight. */
	private double weight;
	
	/** The height. */
	private double height;
	
	/** The length. */
	private double length;
	
	/** The width. */
	private double width;
	
	/**
	 * Instantiates a new cargo item.
	 * Prints a message to the console if created successfully.
	 *
	 * @param itemName the item name
	 * @param weight the weight
	 * @param height the height
	 * @param length the length
	 * @param width the width
	 */
	public CargoItem(String itemName, double weight, double height,
			double length, double width) {
		this.itemName = itemName;
		this.weight = weight;
		this.height = height;
		this.length = length;
		this.width = width;
		System.out.println("Item "+this.itemName+" successfully created");
		//database.writeItemsDB(this);
	}
	
	/**
	 * Sets the item name.
	 *
	 * @param itemName the new item name
	 */
	public void setItemName(String itemName) {
	this.itemName = itemName;
	}
	      
	/**
	 * Gets the item name.
	 *
	 * @return the item name
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * Sets the weight of the item.
	 *
	 * @param weight the new weight
	 */
	public void setWeight(double weight){
	this.weight = weight;
	}
 
	/**
	 * Gets the weight of the item.
	 *
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * Sets the height of the item.
	 *
	 * @param height the new height
	 */
	public void setHeight(double height) {
	this.height = height;
	}

	/**
	 * Gets the height of the item.
	 *
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * Sets the length of the item.
	 *
	 * @param length the new length
	 */
	public void setLength(double length) {
	this.length = length;
	}

	/**
	 * Gets the length of the item.
	 *
	 * @return the length
	 */
	public double getLength() {
		return length;
	}

	/**
	 * Sets the width of the item.
	 *
	 * @param width the new width
	 */
	public void setWidth(double width) {
	this.width = width;
	}

	/**
	 * Gets the width of the item.
	 *
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * Gets the volume of the item.
	 *
	 * @return the volume
	 */
	public double getVolume() {
		return(width*height*length);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CargoItem [itemName=" + itemName + ", weight=" + weight
				+ ", height=" + height + ", length=" + length + ", width="
				+ width + ", getVolume()=" + getVolume() + "]";
	}
	
	/**
	 * The main method. Tester
	 *
	 * @param args the arguments
	 */
	public static void main (String args[])
	{
		CargoItem item1 = new CargoItem("Toys", 200, 10, 20, 10);
		CargoItem item2 = new CargoItem("Pens", 50, 50, 20, 5);
		CargoItem item3 = new CargoItem("Trucks", 5000, 500, 500, 10);
		System.out.println(item1);
		System.out.println(item2);
		System.out.println(item3);
	}

}