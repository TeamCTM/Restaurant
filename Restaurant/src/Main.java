import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
/////////////
Version 1.1.0
May 8, 2015
/////////////
Please Read before running this program:

This program was made to assist a restaurant manager in keeping track of his or her 
customers in a busy setting. Right-click the screen to 
A.Make a square table
B.Make a circle table
C.Change the background

You can also:
A.Right-click a table to change it texture. 
B.Resize square tables by clicking and dragging the edges.
C.Double-click a table to view the number of guests at each table.
*/

public class Main {
	 static JFrame frame;
	 static boolean properties = false; //tells if properties menu is open
	 static FloorPanel floorPanel;
	 //public String _firstName;
	public static String _resturantName, _firstName;
	public static void main(String[] args) {
		
		frame = new JFrame("Restaurant Manager Genie");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        
    	frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().setLayout(null);
        
        
        frame.setVisible(true);
        
        floorPanel = new FloorPanel();
        frame.setContentPane(floorPanel);

        //Madhu: This section of code adds a Real Time JLabel to the JFrame
        final JPanel realTimePanel = new JPanel();
        Color timeColor = new Color(237,221,152);
        realTimePanel.setBackground(timeColor);
        realTimePanel.setSize(250, 40);
        realTimePanel.setLocation(900, 20);
        JLabel dateTime = new JLabel();
        dateTime.setText(JFrameDate.timeNow());
        realTimePanel.add(dateTime);
       floorPanel.add(realTimePanel, BorderLayout.CENTER);
       
       JButton closeButton= new JButton("HIDE");
       realTimePanel.add(closeButton, BorderLayout.SOUTH);
       closeButton.addActionListener(new ActionListener(){
       	public void actionPerformed(ActionEvent e){
       	realTimePanel.setVisible(false);
       	}
       });
       
   	_firstName = JOptionPane.showInputDialog("First Name");
	
	//put user name on frame
	JPanel usernamePanel=new JPanel();
	usernamePanel.setSize(200,40);
	 Color customColor = new Color(227,212,148);
	 usernamePanel.setBackground(customColor);
	JLabel usernameLabel = new JLabel("User: "+ _firstName);
	usernamePanel.add(usernameLabel);
	usernamePanel.setLocation(500,20);
	
	frame.getContentPane().add(usernamePanel,BorderLayout.CENTER);
	
	//String restaurant_name;
	_resturantName = JOptionPane.showInputDialog("Restaurant Name");
	
	//put restaurant name on frame
	JPanel rnamePanel=new JPanel();
	rnamePanel.setSize(200,40);
	Color customColor2 = new Color(227,205,107);
	rnamePanel.setBackground(customColor2);
	JLabel rnameLabel = new JLabel("Restaurant Name: "+ _resturantName);
	rnamePanel.add(rnameLabel);
	rnamePanel.setLocation(700, 20);
	frame.getContentPane().add(rnamePanel,BorderLayout.CENTER);
	frame.setVisible(true);
	frame.repaint();
    	
	//adds the right click menu to the main frame
         frame.addMouseListener(new PopupTriggerListener());
        
	}
}



