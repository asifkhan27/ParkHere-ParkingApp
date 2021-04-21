package com.ParkHere.ui;

import javax.swing.JLabel;


import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.ParkHere.SendMail.interactionEmail;
import com.ParkHere.codes.GetAbsoluteDate;
import com.ParkHere.codes.GetDataFromProperties;
import com.ParkHere.codes.Receipt;
import com.asif.FileManagement.CreateReceipt;
import com.asif.FileManagement.FileManagement;
import com.asif.database.interactionJDBC;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GetTotalCost 
{
//////////////////////////////////////////////////////////////////initComponents/////////////////////////////////////////////////////////////////////////////////////////////////
	static JDialog TCframe;
	///////////////////////////////////////////////////////////////////////List//////////////////////////////////////////////////////////////////////////////////////////////////////
	private Icon TCic;
	private JLabel TClb;
	private JTextPane txtpnVehicleNo;
	private JPanel panel;
	private JTextPane SidetextPane;
	private JTextField emailtextField;
	private JButton btnNewButton;
	private JTextPane txtpnSendReceipt;
	private JTextPane txtpnParkingSlot;
	private JTextField txtEntry;
	private JTextField txtEntryTime;
	private JTextField txtExitTime;
	private JTextField txtExit;
	private JTextField WheelTP;
	private JTextField WheelTPField;
	private JTextField TypeTP;
	private JTextField TypeTPField;
	private JTextField PhnoTPField;
	private JTextField PhnoTP;
	private JTextPane txtpnParkingTimeinHrs;
	private JTextPane TotalCostTP;
	///////////////////////////////////////////////////////////////////////Variables//////////////////////////////////////////////////////////////////////////////////////////////////////
	private String VehicleNo;
	private String NoOfWheels;
	private String TypeOfVehicle;
	private String Phno;
	private String ParkingLocation;
	private String EntryTime;
	private String ExitTime;
	private String ParkingHours;
	private String TotalCost;

	private String SuvCost;
	private String SedanCost;
	private String HatchbackCost;
	private String BIKECost;
	///////////////////////////////////////////////////////////////////////Variables//////////////////////////////////////////////////////////////////////////////////////////////////////

	public GetTotalCost(String Vno)
	{
		initComponents(Vno);
	}
	
private void initComponents(String Vno){
	
/////main jframe
TCframe=new JDialog();
TCframe.setTitle("Receipt");
TCframe.setAlwaysOnTop(true);
TCframe.setResizable(false);
TCframe.setSize(543,448);
TCframe.setLocationRelativeTo(null);

/////Background Image

TCic = new ImageIcon(GetTotalCost.class.getResource("/images/Bill.png"));
TCframe.getContentPane().setLayout(null);
TClb =new JLabel(TCic);
TClb.setSize(543, 407);
TCframe.getContentPane().add(TClb);

/////////////////////////////////////////////////////////////////Components////////////////////////////////////////////////////////////////////////

/////////////Dynamic Values////////////////////////////////////////////////////////////////////////////////

ArrayList<String> AllAttributes=(ArrayList<String>) new Receipt().getCost(Vno);


VehicleNo = AllAttributes.get(0);
NoOfWheels = AllAttributes.get(1);
TypeOfVehicle = AllAttributes.get(2);
Phno = AllAttributes.get(3);
ParkingLocation = AllAttributes.get(4);
EntryTime = AllAttributes.get(5);
	EntryTime=new GetAbsoluteDate().ProperDate(EntryTime);
ExitTime = AllAttributes.get(6);
	ExitTime=new GetAbsoluteDate().ProperDate(ExitTime);
ParkingHours = AllAttributes.get(7);
TotalCost = AllAttributes.get(8);

SuvCost = new GetDataFromProperties().get("SuvCost");
SedanCost = new GetDataFromProperties().get("SedanCost");
HatchbackCost = new GetDataFromProperties().get("HatchbackCost");
BIKECost = new GetDataFromProperties().get("BIKECost");


txtpnVehicleNo = new JTextPane();
txtpnVehicleNo.setFont(new Font("Tahoma", Font.PLAIN, 13));
txtpnVehicleNo.setForeground(new Color(255, 255, 255));
txtpnVehicleNo.setText("Vehicle No. "+VehicleNo);
txtpnVehicleNo.setEditable(false);
txtpnVehicleNo.setBackground(new Color(25, 25, 112));
txtpnVehicleNo.setBounds(40,18, 465,25);
TClb.add(txtpnVehicleNo);


panel = new JPanel();
panel.setBackground(new Color(255, 255, 255));
panel.setBounds(145, 55, 360, 315);
TClb.add(panel);
panel.setLayout(null);



txtpnSendReceipt = new JTextPane();
txtpnSendReceipt.setForeground(new Color(0, 139, 139));
txtpnSendReceipt.setEditable(false);
txtpnSendReceipt.setOpaque(false);
txtpnSendReceipt.setText("Get Receipt! (optional)");
txtpnSendReceipt.setBounds(10, 267, 146, 19);
panel.add(txtpnSendReceipt);


SidetextPane = new JTextPane();
SidetextPane.setEditable(false);
SidetextPane.setForeground(new Color(255, 255, 255));
SidetextPane.setBackground(new Color(0, 139, 139));
SidetextPane.setBounds(41, 52, 91, 308);
String t="\n\nCost / Hr :- "+"\n\n"+"SUV = ₹ "+SuvCost+"/hr\n\n"+"Sedan = ₹ "+SedanCost+"/hr\n\n"+"Hatchback = ₹ "+HatchbackCost+"/hr\n\n"+"Bike = ₹ "+BIKECost+"/hr\n";
SidetextPane.setText(t);
TClb.add(SidetextPane);



///////////Set Values///////////////////////////////////////////////////////////////////////////////////////
txtpnParkingSlot = new JTextPane();
txtpnParkingSlot.setEditable(false);
txtpnParkingSlot.setText("Parking Slot. "+ParkingLocation);
txtpnParkingSlot.setBounds(5,5, 146, 19);
panel.add(txtpnParkingSlot);

txtEntry = new JTextField();
txtEntry.setEditable(false);
txtEntry.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
txtEntry.setOpaque(false);
txtEntry.setText(EntryTime);
txtEntry.setBounds(20, 48, 136, 21);
panel.add(txtEntry);
txtEntry.setColumns(10);

txtEntryTime = new JTextField();
txtEntryTime.setForeground(new Color(0, 128, 0));
txtEntryTime.setOpaque(false);
txtEntryTime.setFont(new Font("Tahoma", Font.BOLD, 9));
txtEntryTime.setFocusable(false);
txtEntryTime.setEditable(false);
txtEntryTime.setBorder(null);
txtEntryTime.setText("Entry Time.");
txtEntryTime.setBounds(10,32, 96, 19);
panel.add(txtEntryTime);

txtEntryTime.setColumns(10);
txtExitTime = new JTextField();
txtExitTime.setText("Exit Time.");
txtExitTime.setOpaque(false);
txtExitTime.setForeground(new Color(255, 0, 0));
txtExitTime.setFont(new Font("Tahoma", Font.BOLD, 9));
txtExitTime.setFocusable(false);
txtExitTime.setEditable(false);
txtExitTime.setColumns(10);
txtExitTime.setBorder(null);
txtExitTime.setBounds(198, 32, 96, 19);
panel.add(txtExitTime);

txtExit = new JTextField();
txtExit.setEditable(false);
txtExit.setText(ExitTime);
txtExit.setOpaque(false);
txtExit.setColumns(10);
txtExit.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
txtExit.setBounds(208, 48, 136,21);
panel.add(txtExit);

WheelTP = new JTextField();
WheelTP.setText("Wheel  -");
WheelTP.setOpaque(false);
WheelTP.setForeground(new Color(0, 0, 0));
WheelTP.setFont(new Font("Tahoma", Font.BOLD, 9));
WheelTP.setFocusable(false);
WheelTP.setEditable(false);
WheelTP.setColumns(10);
WheelTP.setBorder(null);
WheelTP.setBounds(52, 98, 54, 19);
panel.add(WheelTP);

WheelTPField = new JTextField();
WheelTPField.setEditable(false);
WheelTPField.setText(NoOfWheels);
WheelTPField.setOpaque(false);
WheelTPField.setColumns(10);
WheelTPField.setBorder(new LineBorder(new Color(128, 128, 128), 2, true));
WheelTPField.setBounds(103, 98, 96, 19);
panel.add(WheelTPField);

TypeTP = new JTextField();
TypeTP.setText("Type    -");
TypeTP.setOpaque(false);
TypeTP.setForeground(new Color(0, 0, 0));
TypeTP.setFont(new Font("Tahoma", Font.BOLD, 9));
TypeTP.setFocusable(false);
TypeTP.setEditable(false);
TypeTP.setColumns(10);
TypeTP.setBorder(null);
TypeTP.setBounds(52, 134, 54, 19);
panel.add(TypeTP);

TypeTPField = new JTextField();
TypeTPField.setEditable(false);
TypeTPField.setText(TypeOfVehicle);
TypeTPField.setOpaque(false);
TypeTPField.setColumns(10);
TypeTPField.setBorder(new LineBorder(new Color(128, 128, 128), 2, true));
TypeTPField.setBounds(103, 134, 96, 19);
panel.add(TypeTPField);

PhnoTPField = new JTextField();
PhnoTPField.setFont(new Font("Tahoma", Font.BOLD, 10));
PhnoTPField.setEditable(false);
PhnoTPField.setText(Phno);
PhnoTPField.setOpaque(false);
PhnoTPField.setColumns(10);
PhnoTPField.setBorder(new LineBorder(new Color(0, 128, 128), 1, true));
PhnoTPField.setBounds(243, 113, 77, 19);
panel.add(PhnoTPField);

PhnoTP = new JTextField();
PhnoTP.setText("Ph.no.");
PhnoTP.setOpaque(false);
PhnoTP.setForeground(new Color(0, 0, 139));
PhnoTP.setFont(new Font("Tahoma", Font.BOLD, 9));
PhnoTP.setFocusable(false);
PhnoTP.setEditable(false);
PhnoTP.setColumns(10);
PhnoTP.setBorder(null);
PhnoTP.setBounds(230, 98, 96, 19);
panel.add(PhnoTP);

txtpnParkingTimeinHrs = new JTextPane();
txtpnParkingTimeinHrs.setEditable(false);
txtpnParkingTimeinHrs.setForeground(new Color(0, 0, 0));
txtpnParkingTimeinHrs.setFont(new Font("Tahoma", Font.PLAIN, 12));
txtpnParkingTimeinHrs.setText("Parking Time(In hrs) : "+ParkingHours);
txtpnParkingTimeinHrs.setBounds(182, 190, 168, 19);
panel.add(txtpnParkingTimeinHrs);

TotalCostTP = new JTextPane();
TotalCostTP.setFont(new Font("Tahoma", Font.BOLD, 12));
TotalCostTP.setEditable(false);
TotalCostTP.setText("Total Cost : ₹ "+TotalCost);
TotalCostTP.setBounds(192, 219, 168, 36);
panel.add(TotalCostTP);

emailtextField = new JTextField();
emailtextField.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
emailtextField.setBackground(new Color(255, 255, 255));
emailtextField.setText(" \u2709    Email");
emailtextField.setToolTipText("Email\r\n");
emailtextField.setBounds(15, 286, 222, 19);
emailtextField.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		emailtextField.setText("");
	}
});

panel.add(emailtextField);
emailtextField.setColumns(10);




btnNewButton = new JButton("Send \u21B5");
btnNewButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		String str=emailtextField.getText();
		if(str.equals("")||str.equals(" \u2709    Email")) {
			TCframe.setAlwaysOnTop(false);
        	JOptionPane.showMessageDialog(new JFrame(),"Email Fields must not be empty", "Error !",JOptionPane.ERROR_MESSAGE);
		}
		
		else
		{	TCframe.setAlwaysOnTop(false);
			boolean flag=new interactionEmail().mailReceipt(emailtextField.getText(), VehicleNo,ParkingLocation, EntryTime, ExitTime, NoOfWheels, TypeOfVehicle, Phno, ParkingHours, TotalCost);
			if(flag==true)TCframe.dispose();
			
		}
		TCframe.setAlwaysOnTop(true);
	}
});
btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
btnNewButton.setFocusable(false);
btnNewButton.setForeground(new Color(255, 255, 255));
btnNewButton.setBackground(new Color(0, 128, 128));
btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
btnNewButton.setBounds(259, 285, 67, 21);
panel.add(btnNewButton);




TCframe.setVisible(true);
	
	try {
		new interactionJDBC().Delete(VehicleNo);
		File file=new FileManagement().FindRoot(VehicleNo);
		new CreateReceipt(file).writeIntoReceipt(VehicleNo, ParkingLocation,EntryTime,ExitTime, NoOfWheels, TypeOfVehicle, Phno, ParkingHours,TotalCost);
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
