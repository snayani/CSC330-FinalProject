package edu.cuny.csi.csc330.fall14.project;

import java.io.Serializable;
import java.util.*;

/**
 * The Class CargoFlight. The CargoFlight class is the primary class for the project. 
 * Items are assigned to containers, and the containers area assigned to a flight.
 * A Pilot is also assigned to the flight.
 */
public class CargoFlight implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5213867721977300748L;
	
	/** The plane. */
	private CargoPlane plane;
	
	/** The pilot. */
	private CargoPilot pilot;
	
	/** The destination. */
	private String destination;
	
	/** The origin. */
	private String origin;
	
	/** The id. */
	private String id;
	
	/** The departure date time. */
	private String departureDateTime;
	
	/** The arrival date time. */
	private String arrivalDateTime;
	
	/** The container weights. */
	private double containerWeights;
	
	/** The container volumes. */
	private double containerVolumes;
	
	/** The container list. */
	protected List<CargoContainer> containerList = new ArrayList<CargoContainer>();
	
	/**
	 * Instantiates a new cargo flight.
	 * Prints a message to the system if it is created successfully.
	 *
	 * @param id the id
	 * @param plane the plane
	 * @param pilot the pilot
	 * @param destination the destination
	 * @param origin the origin
	 * @param departureDateTime the departure date time
	 * @param arrivalDateTime the arrival date time
	 */
	
	
	public CargoFlight(String id, CargoPlane plane, CargoPilot pilot, String destination,
			String origin, String departureDateTime, String arrivalDateTime) 
	{

		this.plane = plane;
		this.pilot = pilot;
		this.destination = destination;
		this.origin = origin;
		this.departureDateTime = departureDateTime;
		this.arrivalDateTime = arrivalDateTime;
		this.id= id;
		System.out.println("Item Created Successfully");
		//database.writeFlightsDB(this);
	}

	/**
	 * Adds the container to the data member containerList and ensures that the container being added is not greater than the maximum weight and volume
	 * of the plane it is being added to. The container weight and volume are added to the total for the flight.
	 * Prints a message to the system if the container was added, or if it would not fit on the plane.
	 *
	 * @param container- a container to add
	 */
	public void addContainer(CargoContainer container)
	{
		if ( (plane.getMaxWeight() - containerWeights >= container.getcurrentWeight() ) && (plane.getMaxVolume() - containerVolumes >= container.getcurrentWeight()) )
		{
			containerList.add(container);
			containerWeights= containerWeights+container.getcurrentWeight();
			containerVolumes= containerVolumes+container.getcurrentVolume();
			System.out.println("Container Added to flight" + this.id);
		}
		else 
		{
			System.out.println("The container that belongs to "+container.getownerName()+" would not fit on this plane");
		}
	}
	
	/**
	 * Removes the container. Removes the container from the data member containerList and subtracts the container's weight from the flight's total.
	 * Prints a message to system if container is removed, or if the container could not be found.
	 *
	 * @param container- a container to remove
	 */
	public void removeContainer(CargoContainer container) {
		
		if (containerList.contains(container))
		{
			containerWeights= containerWeights-container.getcurrentWeight();
			containerVolumes= containerVolumes-container.getcurrentVolume();
			containerList.remove(container);
			System.out.println("Container removed");
		}
		
		else
		{
			System.out.println("Container not found");
		}
		
	}
	
	/**
	 * Gets the weight for all containers on board the flight.
	 *
	 * @return the weight
	 */
	public double getWeight()
	{
		return this.containerWeights;
	}
	
	/**
	 * Gets the weight for containers that can fit on the flight.
	 *
	 * @return the remaining weight
	 */
	public double getRemainingWeight()
	{
		return plane.getMaxWeight()-getWeight(); 
	}
	
	/**
	 * Gets the volume for all containers on board the flight.
	 *
	 * @return the volume
	 */
	public double getVolume()
	{
		return this.containerVolumes;
	}
	
	/**
	 * Gets the volume for containers that can fit on the flight.
	 *
	 * @return the remaining volume
	 */
	public double getRemainingVolume()
	{
		return plane.getMaxVolume()-getVolume(); 
	}
	
	/**
	 * Displays all containers on the flight.
	 */
	public void displayContainers()
	{	
		System.out.println(containerList);
	}
	
	/**
	 * Displays all items in all containers.
	 */
	public void displayItems()
	{

		for (CargoContainer c : containerList)
		{
			for(CargoItem i: c.cargoList)
			{
				System.out.println(i.toString());
			}
		}
	}
	
	/**
	 * Gets the id of the flight.
	 *
	 * @return the id
	 */
	public String getID() {
		return id;
	}
	
	/**
	 * Gets the plane that the flight is assigned to.
	 *
	 * @return the plane
	 */
	public CargoPlane getPlane() {
		return plane;
	}

	/**
	 * Assigns a new plane to the flight.
	 *
	 * @param plane the new plane
	 */
	public void setPlane(CargoPlane plane) {
		this.plane = plane;
	}

	/**
	 * Gets the pilot assigned to the flight.
	 *
	 * @return the pilot
	 */
	public CargoPilot getPilot() {
		return pilot;
	}

	/**
	 * Assigns a new pilot to the flight.
	 *
	 * @param pilot the new pilot
	 */
	public void setPilot(CargoPilot pilot) {
		this.pilot = pilot;
	}

	/**
	 * Gets the destination.
	 *
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * Sets the destination.
	 *
	 * @param destination the new destination
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * Gets the origin.
	 *
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * Sets the origin.
	 *
	 * @param origin the new origin
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	/**
	 * Gets the departure date time.
	 *
	 * @return the departure date time
	 */
	public String getDepartureDateTime() {
		return departureDateTime;
	}

	/**
	 * Sets the departure date time.
	 *
	 * @param departureDateTime the new departure date time
	 */
	public void setDepartureDateTime(String departureDateTime) {
		this.departureDateTime = departureDateTime;
	}
	
	/**
	 * Gets the arrival date time.
	 *
	 * @return the arrival date time
	 */
	public String getArrivalDateTime() {
		return arrivalDateTime;
	}

	/**
	 * Sets the arrival date time.
	 *
	 * @param arrivalDateTime the new arrival date time
	 */
	public void setArrivalDateTime(String arrivalDateTime) {
		this.arrivalDateTime = arrivalDateTime;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CargoFlight [id="+ id + "plane=" + plane + ", pilot=" + pilot
				+ ", destination=" + destination + ", origin=" + origin
				+ ", departureDateTime=" + departureDateTime
				+ ", arrivalDateTime=" + arrivalDateTime + ", currentWeight="
				+ containerWeights + ", currentVolume=" + containerVolumes
				+ ", containerList=" + containerList + "]";
	}
	
	/**
	 * The main method. Tester method.
	 *
	 * @param argsv the arguments
	 */
	public static void main(String argsv[])
	{
		CargoContainer cont1 = new CargoContainer("Austin", 800, 8000);
		CargoContainer cont2 = new CargoContainer("Swathi", 10000, 10000000);
		CargoItem item1 = new CargoItem("Toys", 200, 10, 20, 10); //Volume= 2000
		CargoItem item2 = new CargoItem("Pens", 50, 50, 20, 5); //Volume= 5000
		CargoItem item3 = new CargoItem("Trucks", 5000, 500, 500, 10); //Volume= 2500000
		
		//System.out.println(cont1);
		cont1.addItem(item1);
		//System.out.println(cont1);
		cont1.addItem(item2);
		//System.out.println(cont1);
		cont1.addItem(item3);
		cont2.addItem(item3);
		//System.out.println(cont2);
		cont1.removeItem(item1);
		//System.out.println(cont1);
		cont1.addItem(item1);
		
		
		CargoPlane plane1 = new CargoPlane("N1001", "Leer", "G6", "LE1001", 1000, 1000, 50, 3000, 2000, 50, 10);
		CargoPlane plane2 = new CargoPlane("N1002", "Boeing", "Airbus", "EB5000", 1000, 1000, 50, 3000, 2000, 50, 10);
		//System.out.println(plane1);
		//System.out.println(plane2);
		
		

		String date1= "10/03/14";
		
		String date2= "10/04/14";
		
		CargoFlight flight1 = new CargoFlight("1", plane1, null, "JFK", "LAX", date1, date2);
		CargoFlight flight2 = new CargoFlight("2", plane2, null, "JFK", "LAX", date1, date2);
		
		flight1.addContainer(cont1);
		flight2.addContainer(cont2);
		
		
		flight1.displayContainers();
		
		flight1.displayItems();
		
		
		//System.out.println(flight1);
		//System.out.println(flight2);
		
	}
	
}
