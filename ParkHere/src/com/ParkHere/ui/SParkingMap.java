package com.ParkHere.ui;

import java.awt.Dimension;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.ParkHere.codes.GetCurrentTime;
import com.asif.database.interactionJDBC;

import javax.swing.JScrollPane;
import java.awt.ComponentOrientation;
import java.awt.Cursor;

import net.miginfocom.swing.MigLayout;


public class SParkingMap 
{
//////////////////////////////////////////////////////////////////initComponents/////////////////////////////////////////////////////////////////////////////////////////////////
static JDialog mapframe;
///////////////////////////////////////////////////////////////////////List//////////////////////////////////////////////////////////////////////////////////////////////////////
private JPanel mappanel;
private JScrollPane mapscrollpane;
private JLabel mapJlabel;
private JButton Donebutton;
private String loc;

public SParkingMap( String Vno ,String Wheel,String type,String phno)
{

initComponents(Vno , Wheel, type, phno);

}



private void initComponents( String Vno ,String Wheel,String type,String phno){

try {
////////////////////////////////////////////////////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////main jframe
mapframe = new JDialog();
mapframe.setTitle("Choose Location");
mapframe.setType(Type.POPUP);
mapframe.setAlwaysOnTop(true);
mapframe.getContentPane().setBackground(new Color(47, 79, 79));
//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
mapframe.setSize(1300,700);// width=1536,Height=864
mapframe.setLocationRelativeTo(null);
//mapframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
mapframe.getContentPane().setLayout(null);

//////Jpanel

mappanel = new JPanel();
mappanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
mapscrollpane=new JScrollPane(mappanel);
mappanel.setLayout(new MigLayout("", "[][]", "[][]"));

///////Locations//////////////////////////////////////////////////////

int tot=40;
int i=0;
int j=0;
int k=0;
JLabel[] objects=new JLabel[tot];

while(tot>0) {

char name=(char)('A'+j);
String name1=Character.toString(name);
name1="SUV-"+name1+(i+1);

///////creating jlabels

mapJlabel = new JLabel(name1);
objects[k]=mapJlabel;

boolean check=new interactionJDBC().FindLoc(name1);
if(check==true) {
objects[k].setBackground(Color.RED);
}
else {

mapJlabel.setBackground(new Color(50, 205, 50));
final int kkk=k;

objects[k].addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent e) {
Donebutton.setVisible(true);
set(objects[kkk].getText());


objects[kkk].addMouseListener(new MouseAdapter() {
@Override
public void mouseEntered(MouseEvent e) {
objects[kkk].setBackground(new Color(0, 128, 128));
}
@Override
public void mouseExited(MouseEvent e) {
objects[kkk].setBackground(new Color(0, 128, 128));
}
});


}
@Override

public void mouseEntered(MouseEvent e) {
objects[kkk].setBackground(new Color(0, 128, 128));
}
@Override
public void mouseExited(MouseEvent e) {
objects[kkk].setBackground(new Color(50, 205, 50));
}
});
k++;

}



mapJlabel.setHorizontalAlignment(SwingConstants.CENTER);
mapJlabel.setOpaque(true);
mapJlabel.setMaximumSize(new Dimension(200, 300));
mapJlabel.setPreferredSize(new Dimension(200, 300));
String ss="cell"+" "+i+" "+j;
mappanel.add(mapJlabel,ss);
tot--;

i+=1;
if(i==10)
{
j+=1;
i=0;
}
new interactionJDBC().close();
}


mapscrollpane.setBounds(10, 10,1265,600);
mapscrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
mapscrollpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
//mapscrollpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//mapscrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
mapframe.getContentPane().add(mapscrollpane);

//////Done Button///////////////////////////////////////////////////////////////////////////////////////////////////////

Donebutton = new JButton("Done");
Donebutton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {

try {
String pin=""+(int)(Math.random()*(10000-1000+1)+1000);
String Entrytime=new GetCurrentTime().gettime();
if(new interactionJDBC().insert(Vno , Wheel, type, phno, pin,get(),Entrytime)) {
mapframe.setAlwaysOnTop(false);
String ss="Car Parked Successfully"+"\n"+"\t\tSecurity pin: "+pin;
JOptionPane.showMessageDialog(new JFrame(),ss,"Welcome!!!",JOptionPane.PLAIN_MESSAGE);
mapframe.dispose();
}
else {

JOptionPane.showMessageDialog(new JFrame(),"Unable to add details", "Failed",JOptionPane.WARNING_MESSAGE);
}
} catch (HeadlessException e1) {
//TODO Auto-generated catch block
e1.printStackTrace();
} catch (ClassNotFoundException e1) {
//TODO Auto-generated catch block
e1.printStackTrace();
} catch (SQLException e1) {
//TODO Auto-generated catch block
e1.printStackTrace();
}
}
});
Donebutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
Donebutton.setFocusable(false);
Donebutton.setForeground(new Color(255, 255, 255));
Donebutton.setFont(new Font("Tahoma", Font.PLAIN, 14));
Donebutton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
Donebutton.setBackground(new Color(0, 128, 128));
Donebutton.setBounds(615, 620, 100, 33);
Donebutton.setVisible(false);
mapframe.getContentPane().add(Donebutton);




mapframe.setVisible(true);
new interactionJDBC().close();
} catch (SecurityException e) {
//TODO Auto-generated catch block
e.printStackTrace();
} catch (ClassNotFoundException e1) {
//TODO Auto-generated catch block
e1.printStackTrace();
} catch (SQLException e1) {
//TODO Auto-generated catch block
e1.printStackTrace();
}
}
public void set(String loca) {
loc=loca;

}
public String get() {
return loc;

}

}
