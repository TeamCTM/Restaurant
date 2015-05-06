import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class colorMenuActionListener implements ActionListener {
	JPanel _table;
	public colorMenuActionListener(JPanel aTable)
	{
		_table = aTable;
	}
	  public void actionPerformed(ActionEvent e) {
		  Color background = JColorChooser.showDialog(null,
		            "Choose Color", Color.RED);
		  if(background != null)
		  {
			  _table.setBackground(background);
		  }
	  }
	}