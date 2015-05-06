import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class squareMenuActionListener implements ActionListener {
	  public void actionPerformed(ActionEvent e) {
	   Table newTable = new Table(400,400);
		Main.frame.getContentPane().add(newTable);
		Main.frame.repaint();
	  }
	}
