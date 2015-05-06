import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class circleMenuActionListener implements ActionListener {
	  public void actionPerformed(ActionEvent e) {
		Main.frame.getContentPane().add(new CircleTable());
		Main.frame.repaint();
	  }
	}