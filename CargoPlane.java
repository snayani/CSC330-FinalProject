package edu.cuny.csi.csc330.fall14.project;

// TODO: Auto-generated Javadoc
//Finished: Austin 11-9-14

/**
 * The Class CargoPlane.
 */
public class CargoPlane {
	
	/** The tail number. */
	private String tailNumber;
	
	/** The make. */
	private String make;
	
	/** The model. */
	private String model;
	
	/** The serial. */
	private String serial;
	
	/** The max fuel. */
	private int maxFuel;
	
	/** The current fuel. */
	private int currentFuel;
	
	/** The burn rate. */
	private int burnRate;
	
	/** The max weight. */
	private double maxWeight;
	
	/** The max volume. */
	private int maxVolume;
	
	/** The fuel capacity. */
	private int fuelCapacity;
	
	/** The fuel rate. */
	private int fuelRate;
	
	/**
	 * Instantiates a new cargo plane.
	 * Prints a message to the system if created successfully.
	 *
	 * @param tailNumber the tail number
	 * @param make the make
	 * @param model the model
	 * @param serial the serial
	 * @param maxFuel the max fuel
	 * @param currentFuel the current fuel
	 * @param burnRate the burn rate
	 * @param maxWeight the max weight
	 * @param maxVolume the max volume
	 * @param fuelCapacity the fuel capacity
	 * @param fuelRate the fuel rate
	 */
	public CargoPlane(String tailNumber, String make, String model,
			String serial, int maxFuel, int currentFuel, int burnRate,
			double maxWeight, int maxVolume, int fuelCapacity, int fuelRate) {
		this.tailNumber = tailNumber;
		this.make = make;
		this.model = model;
		this.serial = serial;
		this.maxFuel = maxFuel;
		this.currentFuel = currentFuel;
		this.burnRate = burnRate;
		this.maxWeight = maxWeight;
		this.maxVolume = maxVolume;
		this.fuelCapacity = fuelCapacity;
		this.fuelRate = fuelRate;
		System.out.println("Plane Created Successfully");
		//database.writePlaneDB(this);
	}
	
	/**
	 * Gets the tail number.
	 *
	 * @return the tail number
	 */
	public String getTailNumber() {
		return tailNumber;
	}
	
	/**
	 * Gets the make.
	 *
	 * @return the make
	 */
	public String getMake() {
		return make;
	}
	
	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	
	/**
	 * Gets the serial.
	 *
	 * @return the serial
	 */
	public String getSerial() {
		return serial;
	}
	
	/**
	 * Gets the max fuel.
	 *
	 * @return the max fuel
	 */
	public int getMaxFuel() {
		return maxFuel;
	}
	
	/**
	 * Gets the current fuel.
	 *
	 * @return the current fuel
	 */
	public int getCurrentFuel() {
		return currentFuel;
	}
	
	/**
	 * Gets the burn rate.
	 *
	 * @return the burn rate
	 */
	public int getBurnRate() {
		return burnRate;
	}
	
	/**
	 * Gets the max weight.
	 *
	 * @return the max weight
	 */
	public double getMaxWeight() {
		return maxWeight;
	}
	
	/**
	 * Gets the max volume.
	 *
	 * @return the max volume
	 */
	public int getMaxVolume() {
		return maxVolume;
	}
	
	/**
	 * Gets the fuel capacity.
	 *
	 * @return the fuel capacity
	 */
	public int getFuelCapacity() {
		return fuelCapacity;
	}
	
	/**
	 * Gets the fuel rate.
	 *
	 * @return the fuel rate
	 */
	public int getFuelRate() {
		return fuelRate;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CargoPlane [tailNumber=" + tailNumber + ", make=" + make
				+ ", model=" + model + ", serial=" + serial + ", maxFuel="
				+ maxFuel + ", currentFuel=" + currentFuel + ", burnRate="
				+ burnRate + ", maxWeight=" + maxWeight + ", maxVolume="
				+ maxVolume + ", fuelCapacity=" + fuelCapacity + ", fuelRate="
				+ fuelRate + "]";
	}
	
	/**
	 * The main method. Tester method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[])
	{
		CargoPlane plane1 = new CargoPlane("N1003", "Leer", "G6", "LE1001", 1000, 1000, 50, 3000, 2000, 50, 10);
		System.out.println(plane1.getMaxVolume());
	}

}


