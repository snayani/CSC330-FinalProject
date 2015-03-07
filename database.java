package edu.cuny.csi.csc330.fall14.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class database.
 */
public class database {
	
	static String connectionUrl = "jdbc:mysql://localhost:3306/cargo";
	static String connectionUser = "root";
	static String connectionPassword = "";
	
	/**
	 * Gets a list of CargoItems from the database
	 *
	 * @return a list of CargoItems from the database
	 */
	public static List<CargoItem> getCargoItemsDB() {
		
		List<CargoItem> itemList = new ArrayList<CargoItem>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			new com.mysql.jdbc.Driver();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM cargoitems limit 50");
			
			
			while (rs.next()) {
				CargoItem cargo1= new CargoItem(rs.getString("itemName"), rs.getInt("weight"), rs.getInt("height"), rs.getInt("length"), rs.getInt("width"));
				itemList.add(cargo1);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		
		return itemList;
	}
	
	/**
	 * Removes a CargoItem from the Database
	 *
	 * @param item1 a CargoItem
	 */
	public static void removeItemsDB(CargoItem item1) {
			
			Connection conn = null;
			ResultSet rs = null;
			java.sql.PreparedStatement stmt= null;
			
			try {
				new com.mysql.jdbc.Driver();
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				String connectionUrl = "jdbc:mysql://localhost:3306/cargo";
				String connectionUser = "root";
				String connectionPassword = "";
				conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
				stmt = conn.prepareStatement("Delete from cargoitems where itemName = (?)");
				
				stmt.setString(1, item1.getItemName());
				
				stmt.executeUpdate();
				
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
				try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
				try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			
	}
	
	
	/**
	 * Adds a cargo item to the database
	 *
	 * @param item1 a CargoItem
	 */
	public static void writeItemsDB(CargoItem item1) {
		
		Connection conn = null;
		ResultSet rs = null;
		java.sql.PreparedStatement stmt= null;
		
		try {
			new com.mysql.jdbc.Driver();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			stmt = conn.prepareStatement("INSERT INTO cargoitems VALUES (default, ?,?,?,?,?)");
			
			stmt.setString(1, item1.getItemName());
			stmt.setDouble(2, item1.getWeight());
			stmt.setDouble(3, item1.getHeight());
			stmt.setDouble(4, item1.getLength());
			stmt.setDouble(5, item1.getWidth());
			
			stmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		
	}
	
	/**
	 * Gets flights from the database.
	 *
	 * @return a list of CargoFlights from the database
	 */
	public static List<CargoFlight> getFlightsDB() {
			
			List<CargoFlight> flightList = new ArrayList<CargoFlight>();
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				new com.mysql.jdbc.Driver();
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT * FROM flight limit 50");
				
				
				while (rs.next()) {
					CargoPlane plane2 = new CargoPlane("N1002", "Boeing", "Airbus", "EB5000", 1000, 1000, 50, 3000, 2000, 50, 10);
					CargoFlight flight= new CargoFlight(rs.getString("flightID"), plane2, null , rs.getString("origin"), rs.getString("destination"), rs.getString("departureDate"), rs.getString("arrivalDate"));
					flightList.add(flight);
				}
				
				//System.out.println(flightList);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
				try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
				try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			
			return flightList;
		}

	/**
	 * Removes a flight from the database
	 *
	 * @param flight1 a CargoFlight
	 */
	public static void removeFlightsDB(CargoFlight flight1) {
		
		Connection conn = null;
		ResultSet rs = null;
		java.sql.PreparedStatement stmt= null;
		
		try {
			new com.mysql.jdbc.Driver();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			stmt = conn.prepareStatement("Delete from flight where flightID = (?)");
			
			stmt.setString(1, flight1.getID());
			
			stmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		
	}

	/**
	 * Write a flight to the database
	 *
	 * @param flight1 a CargoFlight
	 */
	public static void writeFlightsDB(CargoFlight flight1) {
		
		Connection conn = null;
		ResultSet rs = null;
		java.sql.PreparedStatement stmt= null;
		
		try {
			new com.mysql.jdbc.Driver();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			stmt = conn.prepareStatement("INSERT INTO flight VALUES (?,?,?,?,?,?,?,?)");
			
			stmt.setString(1,flight1.getPilot().getpilotName());
			stmt.setString(2,flight1.getDestination());
			stmt.setString(3,flight1.getOrigin());
			stmt.setString(4,flight1.getDepartureDateTime());
			stmt.setString(5,flight1.getArrivalDateTime());
			stmt.setDouble(6,flight1.getWeight());
			stmt.setDouble(7,flight1.getVolume());
			stmt.setString(8,flight1.getID());
			
			stmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		
	}



	/**
	 * Gets the pilots from the database
	 *
	 * @return a list of CargoPilots from the database
	 */
	public static List<CargoPilot> getPilotDB() {
		
		List<CargoPilot> pilotList = new ArrayList<CargoPilot>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			new com.mysql.jdbc.Driver();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM pilot limit 50");
			
			
			while (rs.next()) {
				CargoPilot pilot= new CargoPilot(rs.getString("pilotName"), rs.getInt("socialSecurity"), rs.getString("dob"), rs.getString("countryBirth"), rs.getString("cityBirth"), rs.getDouble("weight"), rs.getDouble("height"));
				pilotList.add(pilot);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		
		return pilotList;
	}

	/**
	 * Removes a pilot from the database
	 *
	 * @param pilot1 a CargoPilot
	 */
	public static void removePilotDB(CargoPilot pilot1) {
		
		Connection conn = null;
		ResultSet rs = null;
		java.sql.PreparedStatement stmt= null;
		
		try {
			new com.mysql.jdbc.Driver();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			stmt = conn.prepareStatement("Delete from pilot where pilotName = (?)");
			
			stmt.setString(1, pilot1.getpilotName());
			
			stmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		
	}

	/**
	 * Writes a pilot to the Database.
	 *
	 * @param pilot1 a Cargo Pilot
	 */
	public static void writePilotDB(CargoPilot pilot1) {
		
		Connection conn = null;
		ResultSet rs = null;
		java.sql.PreparedStatement stmt= null;
		
		try {
			new com.mysql.jdbc.Driver();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			stmt = conn.prepareStatement("INSERT INTO pilot VALUES (?,?,?,?,?,?,?)");
			
			stmt.setString(1, pilot1.getpilotName());
			stmt.setInt(2,pilot1.getSocialSecurity());
			stmt.setString(3, pilot1.getDOB());
			stmt.setString(4, pilot1.getCountryOfBirth());
			stmt.setString(5, pilot1.getCityOfBirth());
			stmt.setDouble(6, pilot1.getWeight());
			stmt.setDouble(7, pilot1.getHeightCentimeters());
			
			stmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		
	}

	/**
	 * Gets the planes from the database
	 *
	 * @return a list of CargoPlanes
	 */
	public static List<CargoPlane> getPlaneDB() {
		
		List<CargoPlane> planeList = new ArrayList<CargoPlane>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			new com.mysql.jdbc.Driver();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM planes limit 50");
			
			
			while (rs.next()) {
				CargoPlane plane= new CargoPlane(rs.getString("tailNumber"),rs.getString("make"),rs.getString("model"),rs.getString("serial"),rs.getInt("maxFuel"),rs.getInt("currentFuel"),rs.getInt("burnRate"),rs.getDouble("maxWeight"),rs.getInt("maxVolume"),rs.getInt("fuelCapacity"),rs.getInt("fuelRate"));
				planeList.add(plane);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		
		return planeList;
	}

	/**
	 * Removes a plane from the database.
	 *
	 * @param plane1 a CargoPlane
	 */
	public static void removePlaneDB(CargoPlane plane1) {
		
		Connection conn = null;
		ResultSet rs = null;
		java.sql.PreparedStatement stmt= null;
		
		try {
			new com.mysql.jdbc.Driver();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			stmt = conn.prepareStatement("Delete from planes where serial = (?)");
			
			stmt.setString(1, plane1.getSerial());
			
			stmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		
	}

	/**
	 * Writes a plane to the database
	 *
	 * @param plane1 a CargoPlane
	 */
	public static void writePlaneDB(CargoPlane plane1) {
		
		Connection conn = null;
		ResultSet rs = null;
		java.sql.PreparedStatement stmt= null;
		
		try {
			new com.mysql.jdbc.Driver();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			stmt = conn.prepareStatement("INSERT INTO planes VALUES (?,?,?,?,?,?,?,?,?,?,?)");
			
			stmt.setString(1, plane1.getTailNumber());
			stmt.setString(2, plane1.getMake());
			stmt.setString(3, plane1.getModel());
			stmt.setString(4, plane1.getSerial());
			stmt.setInt(5, plane1.getMaxFuel());
			stmt.setInt(6, plane1.getCurrentFuel());
			stmt.setInt(7, plane1.getBurnRate());
			stmt.setDouble(8, plane1.getMaxWeight());
			stmt.setInt(9, plane1.getMaxVolume());
			stmt.setInt(10, plane1.getFuelCapacity());
			stmt.setInt(11, plane1.getFuelRate());
			
			stmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		
	}

	/**
	 * Gets the containers from the database
	 *
	 * @return a list of CargoContainers
	 */
	public static List<CargoContainer> getContainerDB() {
		
		List<CargoContainer> containerList = new ArrayList<CargoContainer>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			new com.mysql.jdbc.Driver();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM containers limit 50");
			
			
			while (rs.next()) {
				CargoContainer container1= new CargoContainer(rs.getString("ownerName"),rs.getDouble("maxWeight"), rs.getDouble("maxVolume"));
				containerList.add(container1);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		
		return containerList;
		
	}

	/**
	 * Removes a container from the database
	 *
	 * @param container1 a CargoContainer
	 */
	public static void removeContainerDB(CargoContainer container1) {
		
		Connection conn = null;
		ResultSet rs = null;
		java.sql.PreparedStatement stmt= null;
		
		try {
			new com.mysql.jdbc.Driver();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			stmt = conn.prepareStatement("Delete from containers where itemName = (?) and maxWeight= (?)");
			
			stmt.setString(1, container1.getownerName());
			stmt.setDouble(2, container1.getmaxWeight());
			
			stmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		
	}

	/**
	 * Writes container to the database
	 *
	 * @param container1 a CargoContainer
	 */
	public static void writeContainerDB(CargoContainer container1) {
		
		Connection conn = null;
		ResultSet rs = null;
		java.sql.PreparedStatement stmt= null;
		
		try {
			new com.mysql.jdbc.Driver();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			stmt = conn.prepareStatement("INSERT INTO containers VALUES (default, ?,?,?,?,?)");

			stmt.setString(1, container1.getownerName());
			stmt.setDouble(2, container1.getmaxWeight());
			stmt.setDouble(3, container1.getmaxVolume());
			stmt.setDouble(4, 0);
			stmt.setDouble(5, container1.getcurrentVolume());
			
			stmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		
	}

}