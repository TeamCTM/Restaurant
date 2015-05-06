import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class textureMenuActionListener implements ActionListener {
	Table _table;
	public textureMenuActionListener(Table aTable)
	{
		_table = aTable;
	}
	  public void actionPerformed(ActionEvent e) {
		  JFileChooser chooser = new JFileChooser();
		  FileNameExtensionFilter filter = new FileNameExtensionFilter(
		      "JPG & PNG", "jpg", "png");
		  chooser.setFileFilter(filter);
		  chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
		  int returnVal = chooser.showOpenDialog(null);
		  if(returnVal == JFileChooser.APPROVE_OPTION) {
	
			  try{
					_table.img = ImageIO.read(chooser.getSelectedFile());
					_table.repaint();
					}catch(Exception ex)
					{	
					}		
		  }
	  }
	}