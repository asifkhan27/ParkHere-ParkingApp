package com.ParkHere.ui;

import java.awt.Color;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class splashFile {

	public splashFile() throws IOException, URISyntaxException {
		
		initComponents();
	}
	
	private void initComponents() throws IOException, URISyntaxException {
		
		JWindow w=new JWindow();
		w.setSize(400,250);
		w.setLocationRelativeTo(null);
		
		URL str=splashFile.class.getResource("/images/splashScreen.jpg");
		
		
		
		w.getContentPane().setLayout(null);
		JLabel l =new JLabel( new ImageIcon(ImageIO.read(new File(str.toURI())).getScaledInstance(400,216, Image.SCALE_SMOOTH)));
		l.setBorder(new LineBorder(new Color(0, 0, 0)));
		l.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		l.setBounds(0, 20, 400, 216);
		w.getContentPane().add(l);
		
		JProgressBar p= new JProgressBar();
		p.setStringPainted(true);
		p.setLocation(0, 240);
		p.setPreferredSize(new Dimension(146, 10));
		p.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		p.setBorder(null);
		p.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN,12));
		p.setMaximum(100);
		p.setBackground(Color.LIGHT_GRAY);
		p.setSize(400,10);
		p.setForeground(new Color(255, 0, 0));
		
		w.getContentPane().add(p);
		
		JFormattedTextField StartingTF = new JFormattedTextField();
		StartingTF.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		StartingTF.setBorder(null);
		StartingTF.setBounds(0, 0, 400, 20);
		StartingTF.setMinimumSize(new Dimension(3, 19));
		StartingTF.setSelectionColor(new Color(0, 0, 0));
		StartingTF.setHorizontalAlignment(SwingConstants.LEFT);
		StartingTF.setForeground(new Color(245, 255, 250));
		StartingTF.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		StartingTF.setBackground(new Color(255, 69, 0));
		StartingTF.setEditable(false);
		//StartingTF.setText("  ParkHere_Starting.....");
		w.getContentPane().add(StartingTF);
		

		w.setVisible(true);
		String dots="";
		for(int i=0;i<=100;i+=2)
		{	
			if(i%12!=0)dots=dots+" .";
			else dots="";
			StartingTF.setText("  ParkHere_Starting"+dots);
			
			p.setValue(i);
			
			try {
				Thread.sleep(80);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(p.getValue()==100)
		{
			w.dispose();
			new EntryExitPage();
		}
	}
	public static void main(String[] args) throws IOException, URISyntaxException {
		new splashFile();
	}

}
