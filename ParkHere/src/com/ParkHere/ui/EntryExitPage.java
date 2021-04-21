package com.ParkHere.ui;

import javax.imageio.ImageIO;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;

import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.border.LineBorder;

import com.asif.database.interactionJDBC;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;


public class EntryExitPage
{
	private JFrame EEjf;
	private JLabel EEJL;
	private Icon EEic;
	
	private JPanel EntryPanel;
	private JTextPane EntryPointText;
	private JTextPane EntryVnoText;
	private JTextField EntryVnoField;
	
	private JTextPane Entrywheel;
	private JRadioButton FOUR;
	private JRadioButton TWO;
	private JComboBox<String> EntryType;
	
	private	JTextPane EntryPhno;
	private JTextField EntryPhnoField;
	private JButton Entrybutton;
	
	private JPanel ExitPanel;
	private JTextPane ExitPointText;
	private JTextPane ExitVnoText;
	private JTextField ExitVnoField;
	private	JTextPane ExitPin;
	private JTextField ExitPinField;
	private JButton Exitbutton;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	int flag1=0;
	int flag2=0;
	
	public EntryExitPage()
	{
		initComponents();
	}

	
	
private void initComponents() {


	
	try {
		//main j frame
			
			EEjf = new JFrame("ParkHere_Home Page");
			EEjf.setSize(1400,800);
			EEjf.setLocationRelativeTo(null);
			EEjf.setExtendedState(JFrame.MAXIMIZED_BOTH);
			//EEjf.setExtendedState(JFrame.MAXIMIZED_BOTH);
			//EEjf.setLayout(null);
			
		//background image
			
					URL Background_Icon=EntryExitPage.class.getResource("/images/EntryExit.jpg");
					
					try {
						EEic=new ImageIcon(ImageIO.read(new File(Background_Icon.toURI())).getScaledInstance(1536,864, Image.SCALE_SMOOTH));
					} catch (IOException | URISyntaxException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					EEjf.getContentPane().setLayout(null);
					EEJL = new JLabel(EEic);
					EEJL.setBounds(0, 0, 1536,864);
					EEjf.getContentPane().add(EEJL);
		
		//Entry Point
					
					
					EntryPanel = new JPanel();
					EntryPanel.setOpaque(false);
					EntryPanel.setBorder(new LineBorder(new Color(0, 255, 0), 10, true));
					EntryPanel.setBackground(Color.WHITE);
					EntryPanel.setBounds(176, 145, 415, 515);
					EntryPanel.setLayout(null);
					EEJL.add(EntryPanel);
					
					EntryPointText = new JTextPane();
					EntryPointText.setForeground(new Color(0, 255, 0));
					EntryPointText.setEditable(false);
					EntryPointText.setFont(new Font("Tahoma", Font.BOLD, 30));
					EntryPointText.setOpaque(false);
					EntryPointText.setText("Entry Point \u2B07");
					EntryPointText.setBounds(276, 55, 236, 63);
					EEJL.add(EntryPointText);
					
					EntryVnoText = new JTextPane();
					EntryVnoText.setForeground(new Color(0, 0, 128));
					EntryVnoText.setEditable(false);
					EntryVnoText.setOpaque(false);
					EntryVnoText.setFont(new Font("Tahoma", Font.BOLD, 18));
					EntryVnoText.setText("Vehicle No :");
					EntryVnoText.setBounds(42, 35, 114, 28);
					EntryPanel.add(EntryVnoText);
					
					EntryVnoField = new JTextField();
					EntryVnoField.setFont(new Font("Tahoma", Font.BOLD, 20));
					EntryVnoField.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
					EntryVnoField.setBounds(166, 32, 218, 38);
					EntryVnoField.setColumns(10);
					EntryPanel.add(EntryVnoField);
					
					Entrywheel = new JTextPane();
					Entrywheel.setText("Wheel -");
					Entrywheel.setOpaque(false);
					Entrywheel.setForeground(Color.BLACK);
					Entrywheel.setFont(new Font("Tahoma", Font.BOLD, 18));
					Entrywheel.setEditable(false);
					Entrywheel.setBounds(26, 111, 114, 28);
					EntryPanel.add(Entrywheel);
					
					EntryType = new JComboBox();
					EntryType.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					EntryType.addItem("Type");
					EntryType.setBounds(239, 123, 145, 38);
					
					
					FOUR = new JRadioButton("Four");
					FOUR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					FOUR.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							EntryType.removeAllItems();
							EntryType.addItem("Type");
							EntryType.addItem("SUV");
							EntryType.addItem("Hatchback");
							EntryType.addItem("Sedan");
							flag1++;
							if(flag1%2==0) {
								buttonGroup.clearSelection();
								EntryType.removeAllItems();
								EntryType.addItem("Type");
								flag1=0;
							}
							
						}
					});
					buttonGroup.add(FOUR);
					FOUR.setFocusable(false);
					FOUR.setFont(new Font("Tahoma", Font.BOLD, 14));
					FOUR.setForeground(Color.WHITE);
					FOUR.setOpaque(false);
					FOUR.setBounds(26, 134, 66, 38);
					EntryPanel.add(FOUR);
					
					TWO = new JRadioButton("Two");
					TWO.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					TWO.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							EntryType.removeAllItems();
							EntryType.addItem("Type");
							EntryType.addItem("BIKE");
							flag2++;
							if(flag2%2==0) {
								buttonGroup.clearSelection();
								EntryType.removeAllItems();
								EntryType.addItem("Type");
								flag2=0;
							}
						}
					});
					buttonGroup.add(TWO);
					TWO.setFocusable(false);
					TWO.setForeground(Color.WHITE);
					TWO.setFont(new Font("Tahoma", Font.BOLD, 14));
					TWO.setOpaque(false);
					TWO.setBounds(84, 134, 56, 38);
					EntryPanel.add(TWO);
					
					EntryPhno = new JTextPane();
					EntryPhno.setText("PH No :");
					EntryPhno.setOpaque(false);
					EntryPhno.setForeground(new Color(220, 20, 60));
					EntryPhno.setFont(new Font("Tahoma", Font.BOLD, 18));
					EntryPhno.setEditable(false);
					EntryPhno.setBounds(68, 218, 88, 28);
					EntryPanel.add(EntryPhno);
					
					EntryPhnoField = new JTextField();
					EntryPhnoField.setFont(new Font("Tahoma", Font.ITALIC, 15));
					EntryPhnoField.setColumns(10);
					EntryPhnoField.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
					EntryPhnoField.setBounds(166, 213, 218, 28);
					EntryPanel.add(EntryPhnoField);
					
					EntryPhnoField.addKeyListener(new KeyAdapter() {
				         public void keyPressed(KeyEvent ke) {
				            
				            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' ||ke.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
				            	EntryPhnoField.setEditable(true);
				            	
				            } else {
				            	EntryPhnoField.setEditable(false);
				            	JOptionPane.showMessageDialog(new JFrame(),"Entry Fields must not be empty", "Error !",JOptionPane.ERROR_MESSAGE);
				            	EntryPhnoField.setEditable(true);
				            }
				         }
				      });
					
					
					
					
					Entrybutton = new JButton("IN");
					Entrybutton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String str=EntryVnoField.getText();
							boolean str1=TWO.isSelected()|FOUR.isSelected();
							String str2=EntryType.getSelectedItem().toString();
							String str3=EntryPhnoField.getText();
							
							if(str.equals("")||str1==false||str2.equals("Type")||str3.equals("")) {
								JOptionPane.showMessageDialog(new JFrame(),"Entry Fields must not be empty", "Error !",JOptionPane.ERROR_MESSAGE);	
							}
							else {
								try {
									boolean val=new interactionJDBC().verifyLogin(str);
									
									if(val==true) {
										
										if(TWO.isSelected()==true) {
											new BikeParkingMap(str , "Two",str2, str3);
										}
										else{
											if(str2.equals("SUV")) {
												new SParkingMap(str , "Four",str2, str3);
											}
											else if(str2.equals("Hatchback")||str2.equals("Sedan")) {
												new HSParkingMap(str , "Four",str2, str3);
											}
											
										}
									}
									else {
										JOptionPane.showMessageDialog(new JFrame(),"Car already Parked!", "Failed",JOptionPane.WARNING_MESSAGE);
									}
								
								
								
								
								} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}
					});
					Entrybutton.setFocusable(false);
					Entrybutton.setForeground(new Color(255, 255, 255));
					Entrybutton.setFont(new Font("Tahoma", Font.BOLD, 20));
					Entrybutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					Entrybutton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
					Entrybutton.setBackground(new Color(50, 205, 50));
					Entrybutton.setBounds(152, 374, 114, 49);
					EntryPanel.add(Entrybutton);
					
					
					
					
					
					
		//Exit Point
					
					ExitPanel = new JPanel();
					ExitPanel.setOpaque(false);
					ExitPanel.setBorder(new LineBorder(new Color(220, 20, 60), 10, true));
					ExitPanel.setBackground(Color.WHITE);
					ExitPanel.setBounds(900, 145, 415, 515);
					ExitPanel.setLayout(null);
					EEJL.add(ExitPanel);
					
					ExitPointText = new JTextPane();
					ExitPointText.setForeground(new Color(220, 20, 60));
					ExitPointText.setEditable(false);
					ExitPointText.setFont(new Font("Tahoma", Font.BOLD, 30));
					ExitPointText.setOpaque(false);
					ExitPointText.setText("Exit Point \u2B06");
					ExitPointText.setBounds(1000, 55, 236, 63);
					EEJL.add(ExitPointText);
					
					ExitVnoText = new JTextPane();
					ExitVnoText.setForeground(new Color(0, 0, 139));
					ExitVnoText.setEditable(false);
					ExitVnoText.setOpaque(false);
					ExitVnoText.setFont(new Font("Tahoma", Font.BOLD, 18));
					ExitVnoText.setText("Vehicle No :");
					ExitVnoText.setBounds(42, 35, 114, 28);
					ExitPanel.add(ExitVnoText);
					
					ExitVnoField = new JTextField();
					ExitVnoField.setFont(new Font("Tahoma", Font.BOLD, 20));
					ExitVnoField.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
					ExitVnoField.setBounds(166, 32, 218, 38);
					ExitVnoField.setColumns(10);
					ExitPanel.add(ExitVnoField);

					
					ExitPin = new JTextPane();
					ExitPin.setText("Pin :");
					ExitPin.setOpaque(false);
					ExitPin.setForeground(new Color(220, 20, 60));
					ExitPin.setFont(new Font("Tahoma", Font.BOLD, 18));
					ExitPin.setEditable(false);
					ExitPin.setBounds(68, 137, 88, 28);
					ExitPanel.add(ExitPin);
					
					ExitPinField = new JTextField();
					ExitPinField.setFont(new Font("Tahoma", Font.BOLD, 15));
					ExitPinField.setColumns(10);
					ExitPinField.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
					ExitPinField.setBounds(166, 137, 114, 38);
					ExitPanel.add(ExitPinField);
					
					Exitbutton= new JButton("OUT");
					Exitbutton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String str=ExitVnoField.getText();
							String str1=ExitPinField.getText();
							
							if(str.equals("")||str1.equals("")) {
								JOptionPane.showMessageDialog(new JFrame(),"Exit Fields must not be empty", "Error !",JOptionPane.ERROR_MESSAGE);	
							}
							else {
								try {
									Boolean Vehicle_Exist =new interactionJDBC().verifyLogin(str);
									if(!Vehicle_Exist) {
										Boolean Pin_Exist=	new interactionJDBC().checkPin(str, str1);
										if(!Pin_Exist) {
											
											new GetTotalCost(str);	
										}
										else {
											
											JOptionPane.showMessageDialog(new JFrame(),"Incorrect Pin", "Error !",JOptionPane.ERROR_MESSAGE);	
										}
									}
									else {
										JOptionPane.showMessageDialog(new JFrame(),"Vehicle is not parked", "Oops !",JOptionPane.WARNING_MESSAGE);	

									}
									
								} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}
					});
					Exitbutton.setFocusable(false);
					Exitbutton.setForeground(new Color(255, 255, 255));
					Exitbutton.setFont(new Font("Tahoma", Font.BOLD, 20));
					Exitbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					Exitbutton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
					Exitbutton.setBackground(new Color(220, 20, 60));
					Exitbutton.setBounds(152, 374, 114, 49);
					ExitPanel.add(Exitbutton);
					
					
					
					
					
					
			
			
			
//Username textfield
			
					EntryType.setBounds(239, 123, 145, 38);
					EntryPanel.add(EntryType);
EEjf.setVisible(true);
	} catch (HeadlessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
}

}
