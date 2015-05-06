import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;


class PopupTriggerListener extends MouseAdapter {
	
	static Icon oneIcon = new ImageIcon("walnut.png");
	  static Icon twoIcon = new ImageIcon("mahogany.png");
	  static Icon threeIcon = new ImageIcon("cherry.png");
	  static Icon fourIcon = new ImageIcon("chestnut.png");
	  static Icon fiveIcon = new ImageIcon("beech.png");
	  
	private static final String DATE_FORMAT_NOW = null;
	JPopupMenu menu = new JPopupMenu("Popup"); 
	 public PopupTriggerListener()
	 {
		 
		 JMenuItem sqMenuItem = new JMenuItem("New Square Table");
		 JMenuItem cirMenuItem = new JMenuItem("New Circle Table");
		   sqMenuItem.addActionListener(new squareMenuActionListener()); 
		   cirMenuItem.addActionListener(new circleMenuActionListener());
		 menu.add(sqMenuItem);
		 menu.add(cirMenuItem);
		 
			JMenu textureInfo = new JMenu("Change Texture");
			
			//textureInfo.addActionListener(new textureMenuActionListener((Table)_table)); 
			 JRadioButtonMenuItem walnutOption = new JRadioButtonMenuItem("Walnut",oneIcon,false);
			 JRadioButtonMenuItem mahoganyOption = new JRadioButtonMenuItem(
				        "Mahogany", twoIcon, true);
			 JRadioButtonMenuItem cherryOption = new JRadioButtonMenuItem(
				        "Cherry", threeIcon);
			 JRadioButtonMenuItem chesnutOption = new JRadioButtonMenuItem(
				        "Chestnut", fourIcon, true);
			 JRadioButtonMenuItem beechOption = new JRadioButtonMenuItem("Beech",fiveIcon,true);
			 
			 textureInfo.add(walnutOption);
			 textureInfo.add(mahoganyOption);
			 textureInfo.add(cherryOption);
			 textureInfo.add(chesnutOption);
			 textureInfo.add(beechOption);
			 
			menu.add(textureInfo);
			
		    ActionListener listener = new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					 JRadioButtonMenuItem selected = (JRadioButtonMenuItem)e.getSource();
				  String path = ((ImageIcon)selected.getIcon()).toString();
					 File file = new File(path);
					         try {
								Image image = ImageIO.read(file);
								Main.floorPanel.setBackgroundImage(image);
							
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

				}

		      };
		      

		      walnutOption.addActionListener(listener);
		      mahoganyOption.addActionListener(listener);
		      cherryOption.addActionListener(listener);
		      chesnutOption.addActionListener(listener);
		      beechOption.addActionListener(listener);
	 }
	
	
    public void mousePressed(MouseEvent ev) {
      if (ev.isPopupTrigger()) {
       menu.show(ev.getComponent(), ev.getX(), ev.getY());
      }
    }

    public void mouseReleased(MouseEvent ev) {
      if (ev.isPopupTrigger()) {
       menu.show(ev.getComponent(), ev.getX(), ev.getY());
      }
    }

    public void mouseClicked(MouseEvent ev) {
    }
}