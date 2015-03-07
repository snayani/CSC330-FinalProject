package edu.cuny.csi.csc330.fall14.project;

import java.io.Serializable;


/**
 * The Class CargoPilot.
 */
public class CargoPilot implements Serializable {
	
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3610534597937775553L;
	
	/** The pilot's name. */
	private String pilotName;
	
	/** The pilot's Social Security number. */
	private int socialSecurity; 
	
	/** The pilot's Date of Birth. */
	private String DOB;
	
	/** The pilot's Country of Birth. */
	private String countryOfBirth;
	
	/** The pilot's City of Birth. */
	private String cityOfBirth;
	
	/** The pilot's weight. */
	private double weight;
	
	/** The pilot's height in centimeters. */
	private double heightCentimeters;
	
	/**
	 * Instantiates a new cargo pilot.
	 * Prints a message to the console when created
	 *
	 * @param pilotName The pilot's name
	 * @param socialSecurity The social security number
	 * @param dOB The pilot's Date of Birth
	 * @param countryOfBirth The pilot's's Country of Birth
	 * @param cityOfBirth The pilot's City of Birth
	 * @param weight The pilot's weight
	 * @param heightCentimeters The pilot's height in centimeters
	 */
	public CargoPilot(String pilotName, int socialSecurity, String dOB,
			String countryOfBirth, String cityOfBirth, double weight,
			double heightCentimeters) {
		this.pilotName = pilotName;
		this.socialSecurity = socialSecurity;
		this.DOB = dOB;
		this.countryOfBirth = countryOfBirth;
		this.cityOfBirth = cityOfBirth;
		this.weight = weight;
		this.heightCentimeters = heightCentimeters;
		System.out.println("Pilot Created Successfully");
		//database.writePilotDB(this);
	}
	
	/**
	 * Gets the pilot's name.
	 *
	 * @return the pilot name
	 */
	public String getpilotName() {
		return pilotName;
	}
	
	/**
	 * Sets the pilot's name.
	 *
	 * @param pilotName the new name
	 */
	public void setName(String pilotName) {
		this.pilotName = pilotName;
	}
	
	/**
	 * Gets the pilot's social security number.
	 *
	 * @return the social security
	 */
	public int getSocialSecurity() {
		return socialSecurity;
	}
	
	/**
	 * Sets the pilot's social security number.
	 *
	 * @param socialSecurity the new social security number
	 */
	public void setSocialSecurity(int socialSecurity) {
		this.socialSecurity = socialSecurity;
	}
	
	/**
	 * Gets the pilot's Date of Birth.
	 *
	 * @return the Date of Birth
	 */
	public String getDOB() {
		return DOB;
	}

	/**
	 * Sets the pilot's Date of Birth.
	 *
	 * @param dob the new Date of Birth
	 */
	public void setDOB(String dob) {
		DOB= dob;
	}
		
	/**
	 * Gets the pilot's Country of Birth.
	 *
	 * @return the pilot's Country of Birth
	 */
	public String getCountryOfBirth() {
		return countryOfBirth;
	}
	
	/**
	 * Sets the pilot's Country of Birth.
	 *
	 * @param countryOfBirth The pilot's new Country of Birth
	 */
	public void setCountryOfBirth(String countryOfBirth) {
		this.countryOfBirth = countryOfBirth;
	}
	
	/**
	 * Gets the pilot's City of Birth.
	 *
	 * @return the pilot's City of Birth
	 */
	public String getCityOfBirth() {
		return cityOfBirth;
	}
	
	/**
	 * Sets the pilot's City of Birth.
	 *
	 * @param cityOfBirth the pilot's new City of Birth
	 */
	public void setCityOfBirth(String cityOfBirth) {
		this.cityOfBirth = cityOfBirth;
	}
	
	/**
	 * Gets the pilot's weight.
	 *
	 * @return the pilot's weight
	 */
	public double getWeight() {
		return weight;
	}
	
	/**
	 * Sets the pilot's weight.
	 *
	 * @param weight the pilot's new weight
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	/**
	 * Gets the pilot's height in centimeters.
	 *
	 * @return the pilot's height in centimeters
	 */
	public double getHeightCentimeters() {
		return heightCentimeters;
	}
	
	/**
	 * Sets the pilot's height in centimeters.
	 *
	 * @param heightCentimeters the pilot's new height in centimeters
	 */
	public void setHeightCentimeters(int heightCentimeters) {
		this.heightCentimeters = heightCentimeters;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CargoPilot [pilotName=" + pilotName + ", socialSecurity="
				+ socialSecurity + ", DOB=" + DOB + ", countryOfBirth="
				+ countryOfBirth + ", cityOfBirth=" + cityOfBirth + ", weight="
				+ weight + ", heightCentimeters=" + heightCentimeters + "]";
	}
	
	
}