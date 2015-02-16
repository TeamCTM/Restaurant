import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Test {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Resturant Management v1.0");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.pack();
        frame.getContentPane().setBackground(Color.RED);
        frame.getContentPane().add(new Canvas());
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        
	}
}

class Canvas extends JComponent
{
	public void paint(Graphics g){
		//g.setBackground(Color.BLUE);
		//g.setFillColor(Color.CYAN);
		g.setColor(Color.BLUE);
		
		g.drawRect(10, 10, 200, 800);

	}
}
