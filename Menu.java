package edu.cuny.csi.csc330.fall14.project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultCaret;

import java.awt.BorderLayout;
import java.util.*;

import javax.swing.JMenuBar;
import javax.swing.JTextPane;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JTabbedPane;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.GridLayout;







import javax.swing.JTextField;

import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Insets;
import java.awt.Font;

import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;

import java.awt.Color;

import javax.swing.JTextArea;
import javax.swing.JScrollBar;

public class Menu {

	private JFrame frmCargoManagementSystem;
	private DefaultTableModel cargoItemModel;
	private DefaultTableModel cargoFlightModel;
	private DefaultTableModel cargoPlaneModel;
	private DefaultTableModel cargoPilotModel;
	private DefaultTableModel cargoContainerModel;
	private DefaultTableModel cargoContainerEditModel;
	private DefaultTableModel cargoItemEditModel;
	private JTabbedPane tabbedPane;
	private JTable cargoItemTable;
	private JLayeredPane addItems;
	private JLabel lblNewLabel;
	private JButton btnCalculate;
	private JLabel volumeValue;
	private JLabel errorBox;
	private JLabel weightLabel;
	private JLabel weightValue;
	private JTable cargoFlightTable;
	private List<CargoItem> cargoItemsList = new ArrayList<CargoItem>();
	private List<CargoFlight> cargoFlightList = new ArrayList<CargoFlight>();
	private List<CargoPlane> cargoPlaneList = new ArrayList<CargoPlane>();
	private List<CargoPilot> cargoPilotList = new ArrayList<CargoPilot>();
	private List<CargoContainer> cargoContainerList = new ArrayList<CargoContainer>();
	private JLabel destinationLBL;
	private JTextField destination;
	private JLabel originLbl;
	private JTextField origin;
	private JLabel lblDepartureDatetime;
	private JTextField departureDateTime;
	private JLabel lblArrivalDatetime;
	private JTextField arrivalDateTime;
	private JScrollPane scrollPane;
	private JLabel lblSelectPlane;
	private JTable cargoPlaneTable;
	private JButton btnCreateFlight;
	private JLabel lblSelectPilot;
	private JScrollPane scrollPane2;
	private JTable cargoPilotTable;
	private JLabel lblId;
	private JTextField flightID;
	protected JTextArea messageBar;
	private JScrollPane messagePane;
	private JTable cargoContainerTable;
	private JTextField containerOwner;
	private JTextField containerMaxWeight;
	private JTextField containerMaxVolume;
	private JButton btnRemoveContainer;
	private JScrollPane cargoContainerEditTablePane;
	private JScrollPane cargoItemEditTablePane;
	private JTable cargoContainerEditTable;
	private JTable cargoItemEditTable;
	private JButton btnRemoveItemEdit;
	private JLabel lblCargoItems_1;
	private JScrollPane cargoFlightTablePane;
	private JLabel lblCargoFlight;
	private JTable cargoFlightEditTable;
	private JButton btnRemoveFlight;
	private JLabel lblCargoItem;
	private JLabel lblItemName;
	private JTextField addItemName;
	private JTextField addItemWeight;
	private JLabel lblItemWeight;
	private JTextField addItemHeight;
	private JLabel lblNewLabel_3;
	private JTextField addItemWidth;
	private JLabel lblItemWidth;
	private JLabel lblItemLength;
	private JTextField addItemLength;
	private JButton btnAddItem;
	private JButton btnRemoveItem_1;
	private JLayeredPane addPilot;
	private JLabel lblPilotName;
	private JTextField addPilotName;
	private JLabel lblPilotSSN;
	private JTextField addPilotSSN;
	private JLabel lblPilotDateOf;
	private JTextField addPilotDOB;
	private JLabel lblPilotCountryOf;
	private JTextField addPilotCountry;
	private JLabel lblPilotCityOf;
	private JTextField addPilotCity;
	private JLabel lblPilotWeight;
	private JTextField addPilotWeight;
	private JLabel lblNewLabel_4;
	private JTextField addPilotHeight;
	private JButton btnAddPilot;
	private JLabel lblTailnumber;
	private JLabel lblMake;
	private JLabel lblModel;
	private JLabel lblSerial;
	private JLabel lblMaxWeight;
	private JLabel lblMaxVolume;
	private JTextField addTailNumber;
	private JTextField addMake;
	private JTextField addModel;
	private JTextField addSerial;
	private JTextField addMaxWeight;
	private JTextField addMaxVolume;
	private JButton btnAddPlane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frmCargoManagementSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frmCargoManagementSystem = new JFrame();
		frmCargoManagementSystem.setTitle("Cargo Management System");
		frmCargoManagementSystem.setBounds(100, 100, 627, 574);
		frmCargoManagementSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String cargoItemCol[] = {"Name","Weight","Height", "Length", "Width"}; //CargoItem
		
		String cargoFlightCol[]= {"ID","Origin","Destination","Curent Weight","Current Volume", "Remaining Weight", "Remaining Volume", "Departure Date", "Arrival Date"}; //CargoFlight
		
		String cargoPlaneCol[]= {"Tail Number", "Make", "Model", "Serial", "Max Weight", "Max Volume"}; //CargoPlane
		
		String cargoPilotCol[]= {"Name", "DOB", "Birth Country", "Weight", "Height"}; //CargoPilot
		
		String cargoContainerCol[]= {"Owner", "Max Weight", "Max Volume", "Current Weight", "Current Volume"}; //CargoContainer
		
		
		messagePane = new JScrollPane();
		messagePane.setBounds(0, 478, 611, 58);
		frmCargoManagementSystem.getContentPane().add(messagePane);
		
		messageBar= new JTextArea();
		messagePane.setViewportView(messageBar);
		messageBar.setWrapStyleWord(true);
		messageBar.setLineWrap(true);
		messageBar.setEditable(false);
		//frame.getContentPane().add(messageBar);
		DefaultCaret caret = (DefaultCaret)messageBar.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		JTextAreaOutputStream.setOut(messageBar);
		
		cargoItemsList= database.getCargoItemsDB();
		cargoFlightList= database.getFlightsDB();
		cargoPlaneList= database.getPlaneDB();
		cargoPilotList= database.getPilotDB();
		cargoContainerList= database.getContainerDB();
				
		cargoItemModel= new DefaultTableModel(cargoItemCol, 0);
		cargoItemEditModel= new DefaultTableModel(cargoItemCol, 0);
		
		frmCargoManagementSystem.getContentPane().setLayout(null);
		
		cargoFlightModel= new DefaultTableModel(cargoFlightCol,0);
		
		cargoPlaneModel= new DefaultTableModel(cargoPlaneCol,0);
		
		cargoPilotModel= new DefaultTableModel(cargoPilotCol,0);
		
		cargoContainerModel= new DefaultTableModel(cargoContainerCol,0);
		
		cargoContainerEditModel= new DefaultTableModel(cargoContainerCol,0);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 610, 477);
		frmCargoManagementSystem.getContentPane().add(tabbedPane);
		
		addPilot = new JLayeredPane();
		tabbedPane.addTab("Add Pilot", null, addPilot, null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		addPilot.setLayout(gridBagLayout);
		
		lblPilotName = new JLabel("Pilot Name");
		GridBagConstraints gbc_lblPilotName = new GridBagConstraints();
		gbc_lblPilotName.insets = new Insets(0, 0, 5, 5);
		gbc_lblPilotName.anchor = GridBagConstraints.WEST;
		gbc_lblPilotName.gridx = 1;
		gbc_lblPilotName.gridy = 1;
		addPilot.add(lblPilotName, gbc_lblPilotName);
		
		addPilotName = new JTextField();
		GridBagConstraints gbc_addPilotName = new GridBagConstraints();
		gbc_addPilotName.insets = new Insets(0, 0, 5, 0);
		gbc_addPilotName.fill = GridBagConstraints.HORIZONTAL;
		gbc_addPilotName.gridx = 2;
		gbc_addPilotName.gridy = 1;
		addPilot.add(addPilotName, gbc_addPilotName);
		addPilotName.setColumns(10);
		
		lblPilotSSN = new JLabel("Pilot Social Security Number");
		GridBagConstraints gbc_lblPilotSSN = new GridBagConstraints();
		gbc_lblPilotSSN.anchor = GridBagConstraints.WEST;
		gbc_lblPilotSSN.insets = new Insets(0, 0, 5, 5);
		gbc_lblPilotSSN.gridx = 1;
		gbc_lblPilotSSN.gridy = 2;
		addPilot.add(lblPilotSSN, gbc_lblPilotSSN);
		
		addPilotSSN = new JTextField();
		GridBagConstraints gbc_addPilotSSN = new GridBagConstraints();
		gbc_addPilotSSN.insets = new Insets(0, 0, 5, 0);
		gbc_addPilotSSN.fill = GridBagConstraints.HORIZONTAL;
		gbc_addPilotSSN.gridx = 2;
		gbc_addPilotSSN.gridy = 2;
		addPilot.add(addPilotSSN, gbc_addPilotSSN);
		addPilotSSN.setColumns(10);
		
		lblPilotDateOf = new JLabel("Pilot Date of Birth");
		GridBagConstraints gbc_lblPilotDateOf = new GridBagConstraints();
		gbc_lblPilotDateOf.anchor = GridBagConstraints.WEST;
		gbc_lblPilotDateOf.insets = new Insets(0, 0, 5, 5);
		gbc_lblPilotDateOf.gridx = 1;
		gbc_lblPilotDateOf.gridy = 3;
		addPilot.add(lblPilotDateOf, gbc_lblPilotDateOf);
		
		addPilotDOB = new JTextField();
		GridBagConstraints gbc_addPilotDOB = new GridBagConstraints();
		gbc_addPilotDOB.insets = new Insets(0, 0, 5, 0);
		gbc_addPilotDOB.fill = GridBagConstraints.HORIZONTAL;
		gbc_addPilotDOB.gridx = 2;
		gbc_addPilotDOB.gridy = 3;
		addPilot.add(addPilotDOB, gbc_addPilotDOB);
		addPilotDOB.setColumns(10);
		
		lblPilotCountryOf = new JLabel("Pilot Country of Origin");
		GridBagConstraints gbc_lblPilotCountryOf = new GridBagConstraints();
		gbc_lblPilotCountryOf.anchor = GridBagConstraints.WEST;
		gbc_lblPilotCountryOf.insets = new Insets(0, 0, 5, 5);
		gbc_lblPilotCountryOf.gridx = 1;
		gbc_lblPilotCountryOf.gridy = 4;
		addPilot.add(lblPilotCountryOf, gbc_lblPilotCountryOf);
		
		addPilotCountry = new JTextField();
		GridBagConstraints gbc_addPilotCountry = new GridBagConstraints();
		gbc_addPilotCountry.insets = new Insets(0, 0, 5, 0);
		gbc_addPilotCountry.fill = GridBagConstraints.HORIZONTAL;
		gbc_addPilotCountry.gridx = 2;
		gbc_addPilotCountry.gridy = 4;
		addPilot.add(addPilotCountry, gbc_addPilotCountry);
		addPilotCountry.setColumns(10);
		
		lblPilotCityOf = new JLabel("Pilot City of Birth");
		GridBagConstraints gbc_lblPilotCityOf = new GridBagConstraints();
		gbc_lblPilotCityOf.anchor = GridBagConstraints.WEST;
		gbc_lblPilotCityOf.insets = new Insets(0, 0, 5, 5);
		gbc_lblPilotCityOf.gridx = 1;
		gbc_lblPilotCityOf.gridy = 5;
		addPilot.add(lblPilotCityOf, gbc_lblPilotCityOf);
		
		addPilotCity = new JTextField();
		GridBagConstraints gbc_addPilotCity = new GridBagConstraints();
		gbc_addPilotCity.insets = new Insets(0, 0, 5, 0);
		gbc_addPilotCity.fill = GridBagConstraints.HORIZONTAL;
		gbc_addPilotCity.gridx = 2;
		gbc_addPilotCity.gridy = 5;
		addPilot.add(addPilotCity, gbc_addPilotCity);
		addPilotCity.setColumns(10);
		
		lblPilotWeight = new JLabel("Pilot Weight");
		GridBagConstraints gbc_lblPilotWeight = new GridBagConstraints();
		gbc_lblPilotWeight.anchor = GridBagConstraints.WEST;
		gbc_lblPilotWeight.insets = new Insets(0, 0, 5, 5);
		gbc_lblPilotWeight.gridx = 1;
		gbc_lblPilotWeight.gridy = 6;
		addPilot.add(lblPilotWeight, gbc_lblPilotWeight);
		
		addPilotWeight = new JTextField();
		GridBagConstraints gbc_addPilotWeight = new GridBagConstraints();
		gbc_addPilotWeight.insets = new Insets(0, 0, 5, 0);
		gbc_addPilotWeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_addPilotWeight.gridx = 2;
		gbc_addPilotWeight.gridy = 6;
		addPilot.add(addPilotWeight, gbc_addPilotWeight);
		addPilotWeight.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Pilot Height (CM)");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 7;
		addPilot.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		addPilotHeight = new JTextField();
		GridBagConstraints gbc_addPilotHeight = new GridBagConstraints();
		gbc_addPilotHeight.insets = new Insets(0, 0, 5, 0);
		gbc_addPilotHeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_addPilotHeight.gridx = 2;
		gbc_addPilotHeight.gridy = 7;
		addPilot.add(addPilotHeight, gbc_addPilotHeight);
		addPilotHeight.setColumns(10);
		
		btnAddPilot = new JButton("Add Pilot");
		btnAddPilot.addMouseListener(new MouseAdapter() {
			@Override
			//Adds a pilot
			public void mouseClicked(MouseEvent arg0) {
				
				CargoPilot pilot1= new CargoPilot(addPilotName.getText(),Integer.parseInt(addPilotSSN.getText()), addPilotDOB.getText(), addPilotCountry.getText(), addPilotCity.getText(), Double.parseDouble(addPilotWeight.getText()), Double.parseDouble(addPilotHeight.getText()));
				cargoPilotList.add(pilot1);
				database.writePilotDB(pilot1);
				refreshEditAll();
			}
		});
		GridBagConstraints gbc_btnAddPilot = new GridBagConstraints();
		gbc_btnAddPilot.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddPilot.gridx = 1;
		gbc_btnAddPilot.gridy = 8;
		addPilot.add(btnAddPilot, gbc_btnAddPilot);
		
		lblTailnumber = new JLabel("TailNumber");
		GridBagConstraints gbc_lblTailnumber = new GridBagConstraints();
		gbc_lblTailnumber.anchor = GridBagConstraints.WEST;
		gbc_lblTailnumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblTailnumber.gridx = 1;
		gbc_lblTailnumber.gridy = 10;
		addPilot.add(lblTailnumber, gbc_lblTailnumber);
		
		addTailNumber = new JTextField();
		GridBagConstraints gbc_addTailNumber = new GridBagConstraints();
		gbc_addTailNumber.insets = new Insets(0, 0, 5, 0);
		gbc_addTailNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_addTailNumber.gridx = 2;
		gbc_addTailNumber.gridy = 10;
		addPilot.add(addTailNumber, gbc_addTailNumber);
		addTailNumber.setColumns(10);
		
		lblMake = new JLabel("Make");
		GridBagConstraints gbc_lblMake = new GridBagConstraints();
		gbc_lblMake.anchor = GridBagConstraints.WEST;
		gbc_lblMake.insets = new Insets(0, 0, 5, 5);
		gbc_lblMake.gridx = 1;
		gbc_lblMake.gridy = 11;
		addPilot.add(lblMake, gbc_lblMake);
		
		addMake = new JTextField();
		GridBagConstraints gbc_addMake = new GridBagConstraints();
		gbc_addMake.insets = new Insets(0, 0, 5, 0);
		gbc_addMake.fill = GridBagConstraints.HORIZONTAL;
		gbc_addMake.gridx = 2;
		gbc_addMake.gridy = 11;
		addPilot.add(addMake, gbc_addMake);
		addMake.setColumns(10);
		
		lblModel = new JLabel("Model");
		GridBagConstraints gbc_lblModel = new GridBagConstraints();
		gbc_lblModel.anchor = GridBagConstraints.WEST;
		gbc_lblModel.insets = new Insets(0, 0, 5, 5);
		gbc_lblModel.gridx = 1;
		gbc_lblModel.gridy = 12;
		addPilot.add(lblModel, gbc_lblModel);
		
		addModel = new JTextField();
		GridBagConstraints gbc_addModel = new GridBagConstraints();
		gbc_addModel.insets = new Insets(0, 0, 5, 0);
		gbc_addModel.fill = GridBagConstraints.HORIZONTAL;
		gbc_addModel.gridx = 2;
		gbc_addModel.gridy = 12;
		addPilot.add(addModel, gbc_addModel);
		addModel.setColumns(10);
		
		lblSerial = new JLabel("Serial");
		GridBagConstraints gbc_lblSerial = new GridBagConstraints();
		gbc_lblSerial.anchor = GridBagConstraints.WEST;
		gbc_lblSerial.insets = new Insets(0, 0, 5, 5);
		gbc_lblSerial.gridx = 1;
		gbc_lblSerial.gridy = 13;
		addPilot.add(lblSerial, gbc_lblSerial);
		
		addSerial = new JTextField();
		GridBagConstraints gbc_addSerial = new GridBagConstraints();
		gbc_addSerial.insets = new Insets(0, 0, 5, 0);
		gbc_addSerial.fill = GridBagConstraints.HORIZONTAL;
		gbc_addSerial.gridx = 2;
		gbc_addSerial.gridy = 13;
		addPilot.add(addSerial, gbc_addSerial);
		addSerial.setColumns(10);
		
		lblMaxWeight = new JLabel("Max Weight");
		GridBagConstraints gbc_lblMaxWeight = new GridBagConstraints();
		gbc_lblMaxWeight.anchor = GridBagConstraints.WEST;
		gbc_lblMaxWeight.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaxWeight.gridx = 1;
		gbc_lblMaxWeight.gridy = 14;
		addPilot.add(lblMaxWeight, gbc_lblMaxWeight);
		
		addMaxWeight = new JTextField();
		GridBagConstraints gbc_addMaxWeight = new GridBagConstraints();
		gbc_addMaxWeight.insets = new Insets(0, 0, 5, 0);
		gbc_addMaxWeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_addMaxWeight.gridx = 2;
		gbc_addMaxWeight.gridy = 14;
		addPilot.add(addMaxWeight, gbc_addMaxWeight);
		addMaxWeight.setColumns(10);
		
		lblMaxVolume = new JLabel("Max Volume");
		GridBagConstraints gbc_lblMaxVolume = new GridBagConstraints();
		gbc_lblMaxVolume.anchor = GridBagConstraints.WEST;
		gbc_lblMaxVolume.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaxVolume.gridx = 1;
		gbc_lblMaxVolume.gridy = 15;
		addPilot.add(lblMaxVolume, gbc_lblMaxVolume);
		
		addMaxVolume = new JTextField();
		GridBagConstraints gbc_addMaxVolume = new GridBagConstraints();
		gbc_addMaxVolume.insets = new Insets(0, 0, 5, 0);
		gbc_addMaxVolume.fill = GridBagConstraints.HORIZONTAL;
		gbc_addMaxVolume.gridx = 2;
		gbc_addMaxVolume.gridy = 15;
		addPilot.add(addMaxVolume, gbc_addMaxVolume);
		addMaxVolume.setColumns(10);
		
		btnAddPlane = new JButton("Add Plane");
		btnAddPlane.addMouseListener(new MouseAdapter() {
			@Override
			//Add a new Plane
			public void mouseClicked(MouseEvent e) {
				
				CargoPlane p1= new CargoPlane (addTailNumber.getText(), addMake.getText(), addModel.getText(), addSerial.getText(), 0, 0, 0, Double.parseDouble(addMaxWeight.getText()), Integer.parseInt(addMaxVolume.getText()), 0, 0);
				cargoPlaneList.add(p1);
				database.writePlaneDB(p1);
				refreshEditAll();
				
			}
		});
		GridBagConstraints gbc_btnAddPlane = new GridBagConstraints();
		gbc_btnAddPlane.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddPlane.gridx = 1;
		gbc_btnAddPlane.gridy = 16;
		addPilot.add(btnAddPlane, gbc_btnAddPlane);
		
		JLayeredPane addContainer = new JLayeredPane();
		tabbedPane.addTab("Add Container/Item", null, addContainer, null);
		GridBagLayout gbl_addContainer = new GridBagLayout();
		gbl_addContainer.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_addContainer.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_addContainer.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_addContainer.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		addContainer.setLayout(gbl_addContainer);
		
		JLabel lblCargoContainer = new JLabel("Cargo Container");
		lblCargoContainer.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCargoContainer.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblCargoContainer = new GridBagConstraints();
		gbc_lblCargoContainer.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCargoContainer.insets = new Insets(0, 0, 5, 5);
		gbc_lblCargoContainer.gridx = 1;
		gbc_lblCargoContainer.gridy = 1;
		addContainer.add(lblCargoContainer, gbc_lblCargoContainer);
		
		JLabel lblContainerName_1 = new JLabel("Container Owner Name");
		lblContainerName_1.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblContainerName_1 = new GridBagConstraints();
		gbc_lblContainerName_1.anchor = GridBagConstraints.WEST;
		gbc_lblContainerName_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblContainerName_1.gridx = 2;
		gbc_lblContainerName_1.gridy = 2;
		addContainer.add(lblContainerName_1, gbc_lblContainerName_1);
		
		containerOwner = new JTextField();
		GridBagConstraints gbc_containerOwner = new GridBagConstraints();
		gbc_containerOwner.insets = new Insets(0, 0, 5, 5);
		gbc_containerOwner.fill = GridBagConstraints.HORIZONTAL;
		gbc_containerOwner.gridx = 4;
		gbc_containerOwner.gridy = 2;
		addContainer.add(containerOwner, gbc_containerOwner);
		containerOwner.setColumns(10);
		
		JLabel lblMaximumWeight = new JLabel("Maximum Weight");
		lblMaximumWeight.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblMaximumWeight = new GridBagConstraints();
		gbc_lblMaximumWeight.anchor = GridBagConstraints.WEST;
		gbc_lblMaximumWeight.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaximumWeight.gridx = 2;
		gbc_lblMaximumWeight.gridy = 3;
		addContainer.add(lblMaximumWeight, gbc_lblMaximumWeight);
		
		containerMaxWeight = new JTextField();
		GridBagConstraints gbc_containerMaxWeight = new GridBagConstraints();
		gbc_containerMaxWeight.insets = new Insets(0, 0, 5, 5);
		gbc_containerMaxWeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_containerMaxWeight.gridx = 4;
		gbc_containerMaxWeight.gridy = 3;
		addContainer.add(containerMaxWeight, gbc_containerMaxWeight);
		containerMaxWeight.setColumns(10);
		
		JLabel lblMaximumVolume = new JLabel("Maximum Volume");
		GridBagConstraints gbc_lblMaximumVolume = new GridBagConstraints();
		gbc_lblMaximumVolume.anchor = GridBagConstraints.WEST;
		gbc_lblMaximumVolume.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaximumVolume.gridx = 2;
		gbc_lblMaximumVolume.gridy = 4;
		addContainer.add(lblMaximumVolume, gbc_lblMaximumVolume);
		
		containerMaxVolume = new JTextField();
		GridBagConstraints gbc_containerMaxVolume = new GridBagConstraints();
		gbc_containerMaxVolume.insets = new Insets(0, 0, 5, 5);
		gbc_containerMaxVolume.fill = GridBagConstraints.HORIZONTAL;
		gbc_containerMaxVolume.gridx = 4;
		gbc_containerMaxVolume.gridy = 4;
		addContainer.add(containerMaxVolume, gbc_containerMaxVolume);
		containerMaxVolume.setColumns(10);
		
		JButton btnAddContainer = new JButton("Add Container");
		btnAddContainer.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0) {
				addNewContainerToList();
				refreshEditAll();
			}
		});
		
		GridBagConstraints gbc_btnAddContainer = new GridBagConstraints();
		gbc_btnAddContainer.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddContainer.gridx = 2;
		gbc_btnAddContainer.gridy = 5;
		addContainer.add(btnAddContainer, gbc_btnAddContainer);
		
		lblCargoItem = new JLabel("Cargo Item");
		lblCargoItem.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblCargoItem = new GridBagConstraints();
		gbc_lblCargoItem.insets = new Insets(0, 0, 5, 5);
		gbc_lblCargoItem.gridx = 1;
		gbc_lblCargoItem.gridy = 7;
		addContainer.add(lblCargoItem, gbc_lblCargoItem);
		
		lblItemName = new JLabel("Item Name");
		GridBagConstraints gbc_lblItemName = new GridBagConstraints();
		gbc_lblItemName.anchor = GridBagConstraints.WEST;
		gbc_lblItemName.insets = new Insets(0, 0, 5, 5);
		gbc_lblItemName.gridx = 2;
		gbc_lblItemName.gridy = 8;
		addContainer.add(lblItemName, gbc_lblItemName);
		
		addItemName = new JTextField();
		GridBagConstraints gbc_additemName = new GridBagConstraints();
		gbc_additemName.insets = new Insets(0, 0, 5, 5);
		gbc_additemName.fill = GridBagConstraints.HORIZONTAL;
		gbc_additemName.gridx = 4;
		gbc_additemName.gridy = 8;
		addContainer.add(addItemName, gbc_additemName);
		addItemName.setColumns(10);
		
		lblItemWeight = new JLabel("Item Weight");
		GridBagConstraints gbc_lblItemWeight = new GridBagConstraints();
		gbc_lblItemWeight.anchor = GridBagConstraints.WEST;
		gbc_lblItemWeight.insets = new Insets(0, 0, 5, 5);
		gbc_lblItemWeight.gridx = 2;
		gbc_lblItemWeight.gridy = 9;
		addContainer.add(lblItemWeight, gbc_lblItemWeight);
		
		addItemWeight = new JTextField();
		GridBagConstraints gbc_addItemWeight = new GridBagConstraints();
		gbc_addItemWeight.insets = new Insets(0, 0, 5, 5);
		gbc_addItemWeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_addItemWeight.gridx = 4;
		gbc_addItemWeight.gridy = 9;
		addContainer.add(addItemWeight, gbc_addItemWeight);
		addItemWeight.setColumns(10);
		
		lblItemLength = new JLabel("Item Length");
		GridBagConstraints gbc_lblItemLength = new GridBagConstraints();
		gbc_lblItemLength.anchor = GridBagConstraints.WEST;
		gbc_lblItemLength.insets = new Insets(0, 0, 5, 5);
		gbc_lblItemLength.gridx = 2;
		gbc_lblItemLength.gridy = 10;
		addContainer.add(lblItemLength, gbc_lblItemLength);
		
		addItemLength = new JTextField();
		GridBagConstraints gbc_addItemLength = new GridBagConstraints();
		gbc_addItemLength.insets = new Insets(0, 0, 5, 5);
		gbc_addItemLength.fill = GridBagConstraints.HORIZONTAL;
		gbc_addItemLength.gridx = 4;
		gbc_addItemLength.gridy = 10;
		addContainer.add(addItemLength, gbc_addItemLength);
		addItemLength.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Item Height");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 11;
		addContainer.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		addItemHeight = new JTextField();
		GridBagConstraints gbc_addItemHeight = new GridBagConstraints();
		gbc_addItemHeight.insets = new Insets(0, 0, 5, 5);
		gbc_addItemHeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_addItemHeight.gridx = 4;
		gbc_addItemHeight.gridy = 11;
		addContainer.add(addItemHeight, gbc_addItemHeight);
		addItemHeight.setColumns(10);
		
		lblItemWidth = new JLabel("Item Width");
		GridBagConstraints gbc_lblItemWidth = new GridBagConstraints();
		gbc_lblItemWidth.anchor = GridBagConstraints.WEST;
		gbc_lblItemWidth.insets = new Insets(0, 0, 5, 5);
		gbc_lblItemWidth.gridx = 2;
		gbc_lblItemWidth.gridy = 12;
		addContainer.add(lblItemWidth, gbc_lblItemWidth);
		
		addItemWidth = new JTextField();
		GridBagConstraints gbc_addItemWidth = new GridBagConstraints();
		gbc_addItemWidth.insets = new Insets(0, 0, 5, 5);
		gbc_addItemWidth.fill = GridBagConstraints.HORIZONTAL;
		gbc_addItemWidth.gridx = 4;
		gbc_addItemWidth.gridy = 12;
		addContainer.add(addItemWidth, gbc_addItemWidth);
		addItemWidth.setColumns(10);
		
		btnAddItem = new JButton("Add Item");
		btnAddItem.addMouseListener(new MouseAdapter() {
			@Override
			//Adds a new item to the list
			public void mouseClicked(MouseEvent arg0) {
				
				CargoItem i1= new CargoItem(addItemName.getText(),Double.parseDouble(addItemWeight.getText()),Double.parseDouble(addItemHeight.getText()),Double.parseDouble(addItemLength.getText()),Double.parseDouble(addItemWidth.getText()));
				database.writeItemsDB(i1);
				cargoItemsList.add(i1);
				refreshEditAll();
			}
		});
		GridBagConstraints gbc_btnAddItem = new GridBagConstraints();
		gbc_btnAddItem.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddItem.gridx = 2;
		gbc_btnAddItem.gridy = 13;
		addContainer.add(btnAddItem, gbc_btnAddItem);
		
		
		JLayeredPane addFlight = new JLayeredPane();
		tabbedPane.addTab("Add Flight", null, addFlight, null);
		GridBagLayout gbl_addFlight = new GridBagLayout();
		gbl_addFlight.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_addFlight.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 132, 0, 132, 0};
		gbl_addFlight.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_addFlight.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		addFlight.setLayout(gbl_addFlight);
		
		btnCreateFlight = new JButton("Create Flight");
		btnCreateFlight.addMouseListener(new MouseAdapter() {
			@Override
			//Creates a new flight
			public void mouseClicked(MouseEvent arg0) {
				createNewFlight();
			}
		});
		
		lblId = new JLabel("ID");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 1;
		gbc_lblId.gridy = 0;
		addFlight.add(lblId, gbc_lblId);
		
		flightID = new JTextField();
		GridBagConstraints gbc_flightID = new GridBagConstraints();
		gbc_flightID.insets = new Insets(0, 0, 5, 0);
		gbc_flightID.fill = GridBagConstraints.HORIZONTAL;
		gbc_flightID.gridx = 3;
		gbc_flightID.gridy = 0;
		addFlight.add(flightID, gbc_flightID);
		flightID.setColumns(10);
		
		destinationLBL = new JLabel("Destination");
		GridBagConstraints gbc_destinationLBL = new GridBagConstraints();
		gbc_destinationLBL.insets = new Insets(0, 0, 5, 5);
		gbc_destinationLBL.gridx = 1;
		gbc_destinationLBL.gridy = 1;
		addFlight.add(destinationLBL, gbc_destinationLBL);
		
		destination = new JTextField();
		GridBagConstraints gbc_destination = new GridBagConstraints();
		gbc_destination.fill = GridBagConstraints.HORIZONTAL;
		gbc_destination.insets = new Insets(0, 0, 5, 0);
		gbc_destination.gridx = 3;
		gbc_destination.gridy = 1;
		addFlight.add(destination, gbc_destination);
		destination.setColumns(10);
		
		originLbl = new JLabel("Origin");
		GridBagConstraints gbc_originLbl = new GridBagConstraints();
		gbc_originLbl.insets = new Insets(0, 0, 5, 5);
		gbc_originLbl.gridx = 1;
		gbc_originLbl.gridy = 2;
		addFlight.add(originLbl, gbc_originLbl);
		
		origin = new JTextField();
		GridBagConstraints gbc_origin = new GridBagConstraints();
		gbc_origin.fill = GridBagConstraints.HORIZONTAL;
		gbc_origin.insets = new Insets(0, 0, 5, 0);
		gbc_origin.gridx = 3;
		gbc_origin.gridy = 2;
		addFlight.add(origin, gbc_origin);
		origin.setColumns(10);
		
		lblDepartureDatetime = new JLabel("Departure Date/Time");
		GridBagConstraints gbc_lblDepartureDatetime = new GridBagConstraints();
		gbc_lblDepartureDatetime.insets = new Insets(0, 0, 5, 5);
		gbc_lblDepartureDatetime.gridx = 1;
		gbc_lblDepartureDatetime.gridy = 3;
		addFlight.add(lblDepartureDatetime, gbc_lblDepartureDatetime);
		
		departureDateTime = new JTextField();
		GridBagConstraints gbc_departureDateTime = new GridBagConstraints();
		gbc_departureDateTime.fill = GridBagConstraints.HORIZONTAL;
		gbc_departureDateTime.insets = new Insets(0, 0, 5, 0);
		gbc_departureDateTime.gridx = 3;
		gbc_departureDateTime.gridy = 3;
		addFlight.add(departureDateTime, gbc_departureDateTime);
		departureDateTime.setColumns(10);
		
		lblArrivalDatetime = new JLabel("Arrival Date/Time");
		GridBagConstraints gbc_lblArrivalDatetime = new GridBagConstraints();
		gbc_lblArrivalDatetime.insets = new Insets(0, 0, 5, 5);
		gbc_lblArrivalDatetime.gridx = 1;
		gbc_lblArrivalDatetime.gridy = 4;
		addFlight.add(lblArrivalDatetime, gbc_lblArrivalDatetime);
		
		arrivalDateTime = new JTextField();
		GridBagConstraints gbc_arrivalDateTime = new GridBagConstraints();
		gbc_arrivalDateTime.fill = GridBagConstraints.HORIZONTAL;
		gbc_arrivalDateTime.insets = new Insets(0, 0, 5, 0);
		gbc_arrivalDateTime.gridx = 3;
		gbc_arrivalDateTime.gridy = 4;
		addFlight.add(arrivalDateTime, gbc_arrivalDateTime);
		arrivalDateTime.setColumns(10);
		GridBagConstraints gbc_btnCreateFlight = new GridBagConstraints();
		gbc_btnCreateFlight.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreateFlight.gridx = 1;
		gbc_btnCreateFlight.gridy = 5;
		addFlight.add(btnCreateFlight, gbc_btnCreateFlight);
		
		lblSelectPlane = new JLabel("Select Plane");
		GridBagConstraints gbc_lblSelectPlane = new GridBagConstraints();
		gbc_lblSelectPlane.anchor = GridBagConstraints.WEST;
		gbc_lblSelectPlane.insets = new Insets(0, 0, 5, 0);
		gbc_lblSelectPlane.gridx = 3;
		gbc_lblSelectPlane.gridy = 5;
		addFlight.add(lblSelectPlane, gbc_lblSelectPlane);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 3;
		gbc_scrollPane.gridy = 6;
		addFlight.add(scrollPane, gbc_scrollPane);
		
		cargoPlaneTable = new JTable(cargoPlaneModel);
		cargoPlaneTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(cargoPlaneTable);
		
		lblSelectPilot = new JLabel("Select Pilot");
		lblSelectPilot.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblSelectPilot = new GridBagConstraints();
		gbc_lblSelectPilot.anchor = GridBagConstraints.WEST;
		gbc_lblSelectPilot.insets = new Insets(0, 0, 5, 0);
		gbc_lblSelectPilot.gridx = 3;
		gbc_lblSelectPilot.gridy = 7;
		addFlight.add(lblSelectPilot, gbc_lblSelectPilot);
		
		scrollPane2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane2 = new GridBagConstraints();
		gbc_scrollPane2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane2.gridx = 3;
		gbc_scrollPane2.gridy = 8;
		addFlight.add(scrollPane2, gbc_scrollPane2);
		
		cargoPilotTable = new JTable(cargoPilotModel);
		cargoPilotTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane2.setViewportView(cargoPilotTable);
		
		addItems = new JLayeredPane();
		tabbedPane.addTab("Add Items to Flight", null, addItems, null);
		
		JScrollPane cargoItemsPane = new JScrollPane();
		cargoItemsPane.setBounds(10, 28, 442, 202);
		addItems.add(cargoItemsPane);
		
		cargoItemTable = new JTable(cargoItemModel);
		cargoItemsPane.setViewportView(cargoItemTable);
		
		cargoItemTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		JScrollPane cargoFlightsPane = new JScrollPane();
		cargoFlightsPane.setBounds(10, 263, 585, 69);
		addItems.add(cargoFlightsPane);
		
		cargoFlightTable = new JTable(cargoFlightModel);
		cargoFlightTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cargoFlightsPane.setViewportView(cargoFlightTable);
		
		lblNewLabel = new JLabel("Volume");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(462, 0, 66, 31);
		addItems.add(lblNewLabel);
		
		btnCalculate = new JButton("Calculate Weight");
		btnCalculate.addMouseListener(new MouseAdapter() {
			@Override
			//Calculates the weight and volume for the selected items
			public void mouseClicked(MouseEvent arg0) {
				calculateItems();
			}
		});
		
		
		btnCalculate.setBounds(462, 68, 133, 23);
		addItems.add(btnCalculate);
		
		volumeValue = new JLabel("0");
		volumeValue.setHorizontalAlignment(SwingConstants.CENTER);
		volumeValue.setFont(new Font("Tahoma", Font.PLAIN, 19));
		volumeValue.setBounds(462, 20, 66, 37);
		addItems.add(volumeValue);
		
		errorBox = new JLabel("");
		errorBox.setForeground(Color.RED);
		errorBox.setBackground(Color.LIGHT_GRAY);
		addItems.setLayer(errorBox, 0);
		errorBox.setBounds(462, 282, 133, 69);
		addItems.add(errorBox);
		
		weightLabel = new JLabel("Weight");
		weightLabel.setHorizontalAlignment(SwingConstants.CENTER);
		weightLabel.setBounds(538, 0, 57, 31);
		addItems.add(weightLabel);
		
		weightValue = new JLabel("0");
		weightValue.setHorizontalAlignment(SwingConstants.CENTER);
		weightValue.setFont(new Font("Tahoma", Font.PLAIN, 19));
		weightValue.setBounds(538, 20, 57, 37);
		addItems.add(weightValue);
		
		JLabel lblCargoItems = new JLabel("Cargo Items- Select an item to remove, or an item, flight and container to add");
		lblCargoItems.setBounds(10, 8, 442, 14);
		addItems.add(lblCargoItems);
		
		JLabel lblCargoFlights = new JLabel("Cargo Flights");
		lblCargoFlights.setBounds(10, 238, 87, 14);
		addItems.add(lblCargoFlights);
		frmCargoManagementSystem.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{tabbedPane}));
		
		refreshEditAll();
		
		JButton addItemsButton = new JButton("Add Items");
		addItemsButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				addItemsToFlight();
			}
			
		});
		addItemsButton.setBounds(462, 128, 133, 23);
		addItems.add(addItemsButton);
		
		JLabel lblCargoContainers = new JLabel("Cargo Containers");
		lblCargoContainers.setBounds(10, 343, 87, 14);
		addItems.add(lblCargoContainers);
		
		JScrollPane cargoContainerPane = new JScrollPane();
		cargoContainerPane.setBounds(10, 368, 585, 69);
		addItems.add(cargoContainerPane);
		
		cargoContainerTable = new JTable(cargoContainerModel);
		cargoContainerPane.setViewportView(cargoContainerTable);
		
		btnRemoveItem_1 = new JButton("Remove Item");
		btnRemoveItem_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if (cargoItemTable.getSelectedRowCount()!=0)
				{
					int rowNumsItem[]= cargoItemTable.getSelectedRows();			
			
					if (rowNumsItem[0]!= -1)
					{	
						for (int i=0; i<rowNumsItem.length; i++)
						{
							//database.removeItemsDB(cargoItemsList.get(rowNumsItem[i]));
							//cargoItemsList.remove(rowNumsItem[i]);
							removeItemEdit(); //Removes the item from the container and adds it back to the cargoItems list
						}
						
					}
				}
				
				else
					System.out.println("No Items selected");
				
				refreshEditAll();
			}
			});
		btnRemoveItem_1.setBounds(462, 194, 133, 23);
		addItems.add(btnRemoveItem_1);
		
		JLayeredPane editContainers = new JLayeredPane();
		tabbedPane.addTab("Edit Containers", null, editContainers, null);
		GridBagLayout gbl_editContainers = new GridBagLayout();
		gbl_editContainers.columnWidths = new int[]{0, 0, 0, 12, 0};
		gbl_editContainers.rowHeights = new int[]{0, 0, 0, 42, 0, 0, 0};
		gbl_editContainers.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_editContainers.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		editContainers.setLayout(gbl_editContainers);
		
		lblCargoFlight = new JLabel("Cargo Flight (Select a Flight to remove a flight)");
		GridBagConstraints gbc_lblCargoFlight = new GridBagConstraints();
		gbc_lblCargoFlight.anchor = GridBagConstraints.WEST;
		gbc_lblCargoFlight.insets = new Insets(0, 0, 5, 5);
		gbc_lblCargoFlight.gridx = 1;
		gbc_lblCargoFlight.gridy = 0;
		editContainers.add(lblCargoFlight, gbc_lblCargoFlight);
		
		cargoFlightTablePane = new JScrollPane();
		
		GridBagConstraints gbc_cargoFlightTablePane = new GridBagConstraints();
		gbc_cargoFlightTablePane.insets = new Insets(0, 0, 5, 5);
		gbc_cargoFlightTablePane.fill = GridBagConstraints.BOTH;
		gbc_cargoFlightTablePane.gridx = 1;
		gbc_cargoFlightTablePane.gridy = 1;
		editContainers.add(cargoFlightTablePane, gbc_cargoFlightTablePane);
		
		cargoFlightEditTable = new JTable(cargoFlightModel);
		cargoFlightEditTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cargoFlightEditTable.addMouseListener(new MouseAdapter() 
			{
			@Override
			//If a click is detected on the cargoFlightEditTable (Eg. a flight is selected)
			public void mouseClicked(MouseEvent e) {
				
				int selectedRow= cargoFlightEditTable.getSelectedRow();
				CargoFlight f1= cargoFlightList.get(selectedRow);
				
				clearRows(cargoContainerEditModel); //Clear all containers in the table
				
				for (CargoContainer c1 : f1.containerList) //Repopulate all cargo containers in the table for the flight
				{
					
						CargoContainer item= c1;
							
						Object[] data = {item.getownerName(), item.getmaxWeight(), item.getmaxVolume(), item.getcurrentWeight(), item.getcurrentVolume()};
						
						cargoContainerEditModel.addRow(data);

				}
			}
				
			});
		
		cargoFlightTablePane.setViewportView(cargoFlightEditTable);
		
		btnRemoveFlight = new JButton("Remove Flight");
		btnRemoveFlight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				
				removeFlightFromList();
			
			}
		});
		GridBagConstraints gbc_btnRemoveFlight = new GridBagConstraints();
		gbc_btnRemoveFlight.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRemoveFlight.insets = new Insets(0, 0, 5, 5);
		gbc_btnRemoveFlight.gridx = 2;
		gbc_btnRemoveFlight.gridy = 1;
		editContainers.add(btnRemoveFlight, gbc_btnRemoveFlight);
		
		JLabel lblCargoContainer_1 = new JLabel("Cargo Container (Select a Flight and Container to remove Container)");
		GridBagConstraints gbc_lblCargoContainer_1 = new GridBagConstraints();
		gbc_lblCargoContainer_1.anchor = GridBagConstraints.WEST;
		gbc_lblCargoContainer_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCargoContainer_1.gridx = 1;
		gbc_lblCargoContainer_1.gridy = 2;
		editContainers.add(lblCargoContainer_1, gbc_lblCargoContainer_1);
		
		cargoContainerEditTablePane = new JScrollPane();
		
		GridBagConstraints gbc_cargoContainerEditTablePane = new GridBagConstraints();
		gbc_cargoContainerEditTablePane.insets = new Insets(0, 0, 5, 5);
		gbc_cargoContainerEditTablePane.fill = GridBagConstraints.BOTH;
		gbc_cargoContainerEditTablePane.gridx = 1;
		gbc_cargoContainerEditTablePane.gridy = 3;
		editContainers.add(cargoContainerEditTablePane, gbc_cargoContainerEditTablePane);
		
		cargoContainerEditTable = new JTable(cargoContainerEditModel);
		cargoContainerEditTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cargoContainerEditTable.addMouseListener(new MouseAdapter() {
			@Override
			//If there is a click on the cargoContainerEditTable (Eg. a row is selected)
			public void mouseClicked(MouseEvent e) { 
				
				if (cargoContainerEditTable.getSelectedRowCount()!=0 && cargoFlightEditTable.getSelectedRowCount()!=0)
				{
					int selectedContainerRow= cargoContainerEditTable.getSelectedRow();
					int selectedFlightRow= cargoFlightEditTable.getSelectedRow();
					CargoFlight f1= cargoFlightList.get(selectedFlightRow);
					CargoContainer c1= f1.containerList.get(selectedContainerRow);
					
					if(cargoItemEditTable.getRowCount()!=0) //If the cargo Items
					{
						//Clear all rows in the cargoItemEditTable
						clearRows(cargoItemEditModel);
											
						/*for (int i = cargoItemEditTable.getRowCount() - 1; i >= 0; i--) 
						{
							cargoItemEditModel.removeRow(i);
						}*/
						
					}
					
					for (CargoItem i1 : c1.cargoList) //Re-populate the cargo items for the selected flight and container
					{
						
							CargoItem item= i1;
								
							Object[] data = {item.getItemName(), item.getWeight(), item.getHeight(), item.getLength(), item.getWidth()};
							
							cargoItemEditModel.addRow(data);
	
					}
				}
				else
					System.out.println("You did not select a plane and a container");
				
			}
		});
		cargoContainerEditTablePane.setViewportView(cargoContainerEditTable);
		
		
		btnRemoveContainer = new JButton("Remove Container");
		btnRemoveContainer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				//Remove the Container from a flight
				removeContainerEdit();
				
			}
		});
		GridBagConstraints gbc_btnRemoveContainer = new GridBagConstraints();
		gbc_btnRemoveContainer.insets = new Insets(0, 0, 5, 5);
		gbc_btnRemoveContainer.gridx = 2;
		gbc_btnRemoveContainer.gridy = 3;
		editContainers.add(btnRemoveContainer, gbc_btnRemoveContainer);
		
		lblCargoItems_1 = new JLabel("Cargo Item (Select a Flight and Container and item to remove item)");
		GridBagConstraints gbc_lblCargoItems_1 = new GridBagConstraints();
		gbc_lblCargoItems_1.anchor = GridBagConstraints.WEST;
		gbc_lblCargoItems_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCargoItems_1.gridx = 1;
		gbc_lblCargoItems_1.gridy = 4;
		editContainers.add(lblCargoItems_1, gbc_lblCargoItems_1);
		
		cargoItemEditTablePane = new JScrollPane();
		GridBagConstraints gbc_cargoItemEditTablePane = new GridBagConstraints();
		gbc_cargoItemEditTablePane.insets = new Insets(0, 0, 0, 5);
		gbc_cargoItemEditTablePane.fill = GridBagConstraints.BOTH;
		gbc_cargoItemEditTablePane.gridx = 1;
		gbc_cargoItemEditTablePane.gridy = 5;
		editContainers.add(cargoItemEditTablePane, gbc_cargoItemEditTablePane);
		
		cargoItemEditTable = new JTable(cargoItemEditModel);
		cargoItemEditTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cargoItemEditTablePane.setViewportView(cargoItemEditTable);
		
		btnRemoveItemEdit = new JButton("Remove Item");
		btnRemoveItemEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				if (cargoFlightEditTable.getSelectedRow()!=-1 && cargoContainerEditTable.getSelectedRow()!=-1 && cargoItemEditTable.getSelectedRow()!=-1)
				{
					removeItemEdit(); //Remove the item from the cargo container				
				}
				
				else
				{
					System.out.println("You have not selected either a flight, container, or item to remove");
				}
				
			}
		});
		GridBagConstraints gbc_btnRemoveItemEdit = new GridBagConstraints();
		gbc_btnRemoveItemEdit.insets = new Insets(0, 0, 0, 5);
		gbc_btnRemoveItemEdit.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRemoveItemEdit.gridx = 2;
		gbc_btnRemoveItemEdit.gridy = 5;
		editContainers.add(btnRemoveItemEdit, gbc_btnRemoveItemEdit);
		
		
	}
	
	/**
	 * Remove a container from a selected flight, and adds it back to the ContainerList so that it can be added to another flight.
	 * In the process, all items are removed from the containers, and added back to the CargoList so they can be added to another container
	 */
	private void removeContainerEdit()
	{
		if (cargoFlightEditTable.getSelectedRow()!=-1 && cargoContainerEditTable.getSelectedRow()!=-1 )
		{
			int selectedContainer= cargoContainerEditTable.getSelectedRow(); //Get the index of the selected container
			int selectedFlight= cargoFlightEditTable.getSelectedRow(); //Get the index of the selected flight
			
			
			CargoFlight f1 = cargoFlightList.get(selectedFlight); //Get the corresponding flight for the index from the FlightList
			
			cargoFlightList.remove(selectedFlight);
			
			CargoContainer c1= f1.containerList.get(selectedContainer);
			
			
			for (CargoItem i1 : f1.containerList.get(selectedContainer).cargoList)
			{
				cargoItemsList.add(i1);
			}
			
			f1.removeContainer(f1.containerList.get(selectedContainer));
			cargoContainerList.remove(c1);
			c1.clearContainer();
			c1.unloaded();
			cargoContainerList.add(c1); //Add the container back to the container list

			database.writeContainerDB(f1.containerList.get(selectedContainer));
			
			
			
			cargoFlightList.add(f1);
			
			
			System.out.println("Container Sucessfully removed");
			
			cargoItemEditTable.clearSelection();
			cargoContainerEditTable.clearSelection();
			cargoFlightEditTable.clearSelection();
			
			refreshEditAll();
			
			
		}
		
		else
		{
			System.out.println("You have not selected either a flight, container, or item to remove");
		}
	}
	
	/**
	 * Creates a new flight from the text fields on the "Add Flight" pane
	 */
	private void createNewFlight()
	{
		if (flightID.getText().length()!=0 && destination.getText().length()!=0 && origin.getText().length()!=0 && departureDateTime.getText().length()!=0 && arrivalDateTime.getText().length()!=0 && cargoPlaneTable.getSelectedRowCount()!=0 && cargoPilotTable.getSelectedRowCount()!=0)
		{
			int rowNumPlane= cargoPlaneTable.getSelectedRow(); //Get the index of the selected plane
			int rowNumPilot= cargoPilotTable.getSelectedRow(); //Get the index of the selected pilot
			CargoPlane pl1= cargoPlaneList.get(rowNumPlane); //Get the corresponding plane from the Plane List
			CargoPilot pi1= cargoPilotList.get(rowNumPilot); //Get the corresponding pilot from the pilot list
			
			//Create a new flight with the given information
			CargoFlight f1= new CargoFlight(flightID.getText(), pl1, pi1, destination.getText(), origin.getText(), departureDateTime.getText(), arrivalDateTime.getText());
			
			//Add the new Flight to the list
			cargoFlightList.add(f1);
			
			database.writeFlightsDB(f1);
			
			//Refresh all tables
			refreshEditAll();
			
			System.out.println("Flight Added Successfully");
	
			
		}
		else
		{	
			System.out.println("Error. Check input");
	
		}
	}
	
	/**
	 * Adds the selected items into the selected cargo Container and onto the selected flight
	 */
	private void addItemsToFlight()
	{
		
		if (cargoContainerTable.getSelectedRowCount()!=0 && cargoItemTable.getSelectedRowCount()!=0 && cargoFlightTable.getSelectedRowCount()!=0) //Check that a cargo item, container and flight are selected
		{
			int rowNumsItem[]= cargoItemTable.getSelectedRows(); //Array of all the selected items
			int rowNumsFlight= cargoFlightTable.getSelectedRow(); //Index of the selected flight
			int rowNumsContainer= cargoContainerTable.getSelectedRow(); //Index of the selected Container
			boolean result= false;// Result
			
			CargoContainer c1 = cargoContainerList.get(rowNumsContainer); //Get the cargo container that was selected (from the Container List)
	
			if (rowNumsItem[0]!= -1 && rowNumsFlight != -1) //If number of selected items and flight is not -1
			{	
				for (int i=0; i<rowNumsItem.length; i++) //Cycle though all of the items
				{
					//Create new CargoItem from the table
					CargoItem i1= new CargoItem(cargoItemModel.getValueAt(rowNumsItem[i], 0).toString(), Double.parseDouble(cargoItemModel.getValueAt(rowNumsItem[i], 1).toString()), Double.parseDouble(cargoItemModel.getValueAt(rowNumsItem[i], 2).toString()), Double.parseDouble(cargoItemModel.getValueAt(rowNumsItem[i], 3).toString()), Double.parseDouble(cargoItemModel.getValueAt(rowNumsItem[i], 4).toString()));
					result= c1.addItem(i1); //Add the item to cargoContiner
					
					if(result== true) //If the cargo container was added successfully
						{
							//database.removeItemsDB(cargoItemsList.get(rowNumsItem[i]));
							cargoItemsList.remove(rowNumsItem[i]); //Remove the item from the Ite List
							
						}
				}
				
				CargoFlight f1= cargoFlightList.get(rowNumsFlight);
				
				cargoFlightList.remove(f1); //Remove the flight
				
				c1.loaded(); //Mark the container as loaded
				
				f1.addContainer(c1); //Add the container to the fight
				
				cargoFlightList.add(f1); //Add the Flight back to the list
				
				refreshEditAll(); //Refresh all tables
				
			}
		}
		
		else
		{
			System.out.println("Error. Check input");
		}
		
		refreshEditAll();
	}
	
	/**
	 * Calculates the volume and weight for all of the selected items on the "Add Items to Flight" pane
	 */
	private void calculateItems()
	{
		Double volume=0.0, weight=0.0;
		
		if(cargoItemTable.getSelectedRowCount()!=0) //If a cargo item is selected in the table
		{
			messageBar.setText("");
			int rowNums[]= cargoItemTable.getSelectedRows();
			
			for (int i=0; i<rowNums.length; i++)
			{	
			volume= volume +(double) cargoItemModel.getValueAt(i, 2) * (double) cargoItemModel.getValueAt(i, 3) * (double) cargoItemModel.getValueAt(i, 4);
			volumeValue.setText(volume.toString());
			weight= weight +(double) cargoItemModel.getValueAt(i, 1);
			weightValue.setText(weight.toString());
			
			}
		}
		
		else //Else print an error to system
		{
			System.out.println("No Row Selected");
		}
		
		refreshEditAll();
		
	}
	
	/**
	 * Executes all of the Edit refreshes in one function
	 */
	private void refreshEditAll()
	{
		refreshEdiItems();
		refreshEditPilot();
		refreshEditPlane();
		refreshEditFlights();
		refreshEditContainers();
	}
	
	/**
	 * Removes all available Items and adds the Items back to the table of Items on the "Edit Containers" pane
	 */
	private void refreshEdiItems()
	{
		clearRows(cargoItemModel);
		
		for (int i=0; i<cargoItemsList.size(); i++)
		{
			
			CargoItem item= cargoItemsList.get(i);
					
			Object[] data = {item.getItemName(), item.getWeight(), item.getHeight(), item.getLength(), item.getWidth()};
		
			cargoItemModel.addRow(data);
		}
	}
	
	
	/**
	 * Removes all available Planes and adds the Planes back to the table of Planes on the "Edit Containers" pane
	 */
	private void refreshEditPlane()
	{
		clearRows(cargoPlaneModel);
		
		for (int i=0; i<cargoPlaneList.size(); i++)
		{
			
			CargoPlane item= cargoPlaneList.get(i);
			Object[] data = {item.getTailNumber(), item.getMake(), item.getModel(), item.getSerial(), item.getMaxWeight(), item.getMaxVolume()};
		
			cargoPlaneModel.addRow(data);
		}
	}
	
	
	/**
	 * Removes all available Pilots and adds the Pilots back to the table of Pilots on the "Edit Containers" pane
	 */
	private void refreshEditPilot()
	{
		clearRows(cargoPilotModel);
		
		for (int i=0; i<cargoPilotList.size(); i++)
		{
			CargoPilot item= cargoPilotList.get(i);
			Object[] data = {item.getpilotName(), item.getDOB(), item.getCountryOfBirth(), item.getWeight(), item.getHeightCentimeters()};
		
			cargoPilotModel.addRow(data);
		}
	}
	
	
	/**
	 * Removes all available Flights and adds the Flights back to the table of Flights on the "Edit Containers" pane
	 */
	private void refreshEditFlights()
	{
		clearRows(cargoFlightModel);
		
		for (int i=0; i<cargoFlightList.size(); i++)
		{
					
			CargoFlight item= cargoFlightList.get(i);
			
			Object[] data = {item.getID(), item.getDestination(), item.getOrigin(), item.getWeight(), item.getVolume(), item.getRemainingWeight(), item.getRemainingVolume(), item.getDepartureDateTime(), item.getArrivalDateTime()};
		
			cargoFlightModel.addRow(data);
		}
		
	}
	
	/**
	 * Removes all available containers and adds the containers back to the table of Containers on the "Edit Containers" pane
	 */
	private void refreshEditContainers()
	{
		clearRows(cargoContainerModel);
		
		for (int i=0; i<cargoContainerList.size(); i++)
		{
					
			CargoContainer item= cargoContainerList.get(i);
			
			if (item.getLoaded()==false)
			{
				
				Object[] data = {item.getownerName(), item.getmaxWeight(), item.getmaxVolume(), item.getcurrentWeight(), item.getcurrentVolume()};
			
				cargoContainerModel.addRow(data);
			
			}
		}
		
	}
	
	/**
	 * Adds a new new container to the cargoContainerList
	 */
	private void addNewContainerToList()
	{
		CargoContainer c1= new CargoContainer(containerOwner.getText(), Double.parseDouble(containerMaxWeight.getText()), Double.parseDouble(containerMaxVolume.getText()));
		cargoContainerList.add(c1);
		database.writeContainerDB(c1);
		refreshEditAll();
	}
	
	/**
	 * Removes a flight from the flight list. First, all of the items are removed from the containers, and added back into the list of cargo items. 
	 * Next, the containers are removed from the flight, and added to the Container List. Finally, the flight is removed from the Flight list.
	 */
	private void removeFlightFromList()
	{
		int selectedFlight= cargoFlightEditTable.getSelectedRow();
		CargoFlight f1= cargoFlightList.get(selectedFlight);
		CargoItem j;
		
		for (CargoContainer c : f1.containerList)
		{
//			for (CargoItem i: c.cargoList)
//			{
//				cargoItemsList.add(i);
//				c.removeItem(i);
//			}
			
			for (int i=c.cargoList.size(); i>0; i--)
			{
				j=c.cargoList.get(i-1);
				System.out.println(j);
				cargoItemsList.add(j);
				c.removeItem(j);
			}
			
			c.unloaded();
		}
		
		cargoFlightList.remove(selectedFlight);
		
		refreshEditAll();
	}
	
	/**
	 * Removes an item from a specific container/flight, and adds it back into the general CargoItems list so that it can be added to
	 * a new container and flight.
	 */
	private void removeItemEdit()
	{
		int selectedItem= cargoItemEditTable.getSelectedRow();
		int selectedContainer= cargoContainerEditTable.getSelectedRow();
		int selectedFlight= cargoFlightEditTable.getSelectedRow();
		
		CargoFlight f1= cargoFlightList.get(selectedFlight);
		CargoContainer c1= f1.containerList.get(selectedContainer);
		
		cargoItemsList.add(c1.cargoList.get(selectedItem)); //Adds the items back into the general ItemsList
		
		c1.removeItem(c1.cargoList.get(selectedItem)); //Removes the item from the container on the flight
		
		System.out.println("Item Sucessfully removed");
		cargoItemEditTable.clearSelection();
		cargoContainerEditTable.clearSelection();
		cargoFlightEditTable.clearSelection();
		refreshEditAll();
	}
	
	/**
	 * Clears all of the rows of a Table model so that new data can be added
	 * 
	 * @param m1 of DefaultTableModel
	 */
	private void clearRows(DefaultTableModel m1)
	{
		if(m1.getRowCount()!=0)
		{
			for (int i = m1.getRowCount() - 1; i >= 0; i--) 
			{
				m1.removeRow(i);
			}
		}
	}
}

