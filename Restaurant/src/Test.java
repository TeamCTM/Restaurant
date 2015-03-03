import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Test {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Resturant Management v1.0");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      

        frame.pack();
        frame.getContentPane().setBackground(new Color(200,100,30));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        
        String input = "";
        
        String rex = "^[1-9]\\d*$";
       
        do{
         input = JOptionPane.showInputDialog(frame  ,"How many tables are in your restaurant?:");
        }while(!input.matches(rex));
        
        int number = Integer.parseInt(input);
        
        for(int i = 0; i < number; i++)
        {
        	frame.getGraphics().drawRect((i*205), 0, 200, 200);
        }
        
        frame.setVisible(true);
        
	}
}

class Table extends JPanel {
	private int _x, _y;

	
		public Table(int x, int y)
		{
			_x = x;
			_y = y;
		}
		
	  protected void paintComponent(Graphics g) {
	    super.paintComponent(g);  
	    g.drawRect(_x,_y,50,50);  
	    g.setColor(Color.BLACK);  
	    g.setColor(Color.RED);
	    g.fillRect(_x,_y,50,50);  
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
