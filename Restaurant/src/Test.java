import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

//Madhu: We should rename this 'table' and 'tableTest' 

public class Test {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Resturant Management v1.0");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      

       // frame.pack();
        frame.getContentPane().setBackground(new Color(200,100,30));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);
        frame.setVisible(true);
        
        /*
        String input = "";
        String rex = "^[1-9]\\d*$";
       
        do{
         input = JOptionPane.showInputDialog(frame  ,"How many tables are in your restaurant?:");
        }while(!input.matches(rex));
        
        int number = Integer.parseInt(input);
        */
        
        JPanel mainp = new JPanel();
        mainp.setBounds(50,50,100,100);
        mainp.setBackground(Color.CYAN);
      
        JPanel maind = new JPanel();
        maind.setBounds(200,50,100,100);
        maind.setBackground(Color.CYAN);
        
       // frame.getContentPane().add(mainp);
        frame.getContentPane().add(new Table(10,10));
        frame.getContentPane().add(new Table(10,200));
        frame.getContentPane().add(new Table(10,200));
        frame.repaint();
        
	}
}

class TableMouseListener extends javax.swing.event.MouseInputAdapter{
	private JPanel _table;
	private Point _lastMousePosition;
	
	public TableMouseListener(JPanel aPanel)
	{
		_table = aPanel;
	}
	
	public void mousePressed(java.awt.event.MouseEvent e){
	    _lastMousePosition=e.getPoint();
	}
	
	public void  mouseDragged(java.awt.event.MouseEvent e){
	       
	    	   Point currentPoint=e.getPoint();
	    	   int diffX=currentPoint.x-_lastMousePosition.x;
	    	   int diffY=currentPoint.y-_lastMousePosition.y;
	           _table.setLocation(_table.getX()+diffX,_table.getY()+diffY);
	           _table.repaint();
	           }
	}

class Table extends JPanel {

	private int xClick, yClick;
	private Image img;
		public Table(int x, int y)
		{
			try{
			img = ImageIO.read(new File("H:\\baf.jpg"));
			}catch(Exception e)
			{
				
			}
			
			this.setBounds(x,y,100,100);
			this.setBackground(Color.CYAN);
			TableMouseListener ml=new TableMouseListener(this);
			  this.addMouseListener(ml);
			  this.addMouseMotionListener(ml);
		}
		
		@Override
		  protected void paintComponent(Graphics g) {
		    super.paintComponent(g);
		        g.drawImage(img, 0, 0, null);
		}
}




















/*
class Table extends JComponent
{
	public void paint(Graphics g){
		//g.setBackground(Color.BLUE);
		//g.setFillColor(Color.CYAN);
		g.setColor(Color.BLUE);
		g.drawRect(10, 10, 200, 800);

	}
}
*/
