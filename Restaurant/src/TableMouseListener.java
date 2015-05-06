import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingUtilities;

public class TableMouseListener extends javax.swing.event.MouseInputAdapter{
	private Table _table;
	private Point _lastMousePosition;
	JPopupMenu menu; 
	boolean resizing = false;
	  static Icon oneIcon = new ImageIcon("walnut.png");
	  static Icon twoIcon = new ImageIcon("mahogany.png");
	  static Icon threeIcon = new ImageIcon("cherry.png");
	  static Icon fourIcon = new ImageIcon("chestnut.png");
	  static Icon fiveIcon = new ImageIcon("beech.png");
	  
	public TableMouseListener(Table aPanel)
	{
		_table = aPanel;
		menu = new JPopupMenu();
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
							_table.setTextureImg(image);
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
		
		JMenuItem colorInfo = new JMenuItem("Change Color");
		 colorInfo.addActionListener(new colorMenuActionListener(_table)); 
		menu.add(colorInfo);
		//menu.add(new JMenuItem("Change Floor Texture"));
		
		
	}
	public void mouseMoved(MouseEvent e) {
		//System.out.println("move");
	      Point curr = e.getPoint();
	      if((_table.getWidth() - curr.x) < 8)
	      {
	    	  Cursor normalCursor = new Cursor(Cursor.E_RESIZE_CURSOR);
	    	  Main.frame.setCursor(normalCursor);
	      }else if(curr.x < 8) {
	    	  Cursor normalCursor = new Cursor(Cursor.W_RESIZE_CURSOR);
	    	  Main.frame.setCursor(normalCursor);
	      }else if(curr.y < 8)
	      {
	    	  Cursor normalCursor = new Cursor(Cursor.N_RESIZE_CURSOR);
	    	  Main.frame.setCursor(normalCursor);
	      }else if(_table.getHeight() - curr.y < 8)
	      {
	    	  Cursor normalCursor = new Cursor(Cursor.S_RESIZE_CURSOR);
	    	  Main.frame.setCursor(normalCursor);
	      }else{
	    	  Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
	    	  Main.frame.setCursor(normalCursor);
	      }
	    }
	
	public void mousePressed(java.awt.event.MouseEvent e){
		if (SwingUtilities.isRightMouseButton(e))
		{
			 menu.show(e.getComponent(), e.getX(), e.getY());
			 return;
		}
	    _lastMousePosition=e.getPoint();
	}
	public void  mouseExited(java.awt.event.MouseEvent e){
		if(!resizing)
		{
	 	 Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
		  Main.frame.setCursor(normalCursor);
		  
		}
	}
	public void  mouseReleased(java.awt.event.MouseEvent e){
		Point currentPoint=e.getPoint();
		if(_lastMousePosition == null)
			return;
 	   int diffX=currentPoint.x-_lastMousePosition.x;
 	   int diffY=currentPoint.y-_lastMousePosition.y;
 	  if(Main.frame.getCursorType() == Cursor.W_RESIZE_CURSOR)
 	  {
 		 _table.setSize(_table.getWidth() - diffX, _table.getHeight());
 		_table.setLocation(_table.getX() + diffX, _table.getY());
 	  }
 	  
 	 if(Main.frame.getCursorType() == Cursor.E_RESIZE_CURSOR)
	  {
		 _table.setSize(_table.getWidth() + diffX, _table.getHeight());
		_table.setLocation(_table.getX(), _table.getY());
	  }

 	if(Main.frame.getCursorType() == Cursor.S_RESIZE_CURSOR)
	  {
		 _table.setSize(_table.getWidth(), _table.getHeight() + diffY);
	  }
 	
 	if(Main.frame.getCursorType() == Cursor.N_RESIZE_CURSOR)
	  {
		 _table.setSize(_table.getWidth(), _table.getHeight() - diffY);
		 _table.setLocation(_table.getX(), _table.getY() + diffY);
	  }
 	  _table.repaint();
 	 Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
	  Main.frame.setCursor(normalCursor);
	}
	 
	public void mouseClicked (MouseEvent e)
	 {
		int tableY = _table.getY(); //the bottom of current table clicked
		
	        if (e.getClickCount()  == 2)
	        {
	      //  _table.setBackground(new Color(0,0,0,200));
	         
	        	
	        	
	        	
	        	/*
PropMenu propertiesMenu = new PropMenu(0, 0);
	        propertiesMenu.setSize(500, 500);
	        propertiesMenu.setVisible(true);
	        	//Main.frame.getGlassPane().setVisible(true);
	        	//Main.frame.getContentPane().setBackground(new Color(0, 0, 0, 0));
	        	//Main.frame.getContentPane()
	        	JPanel blur = new JPanel();
	        	blur.setBounds(0,0,Main.frame.getWidth(), Main.frame.getHeight());
	        	blur.setBackground(new Color(0,0,0,100));
	        	*/
JPanel panel = new JPanel()
	        	{
	
	        	   public void paintComponent(Graphics g)
	        	   {
	        	      //Set the color to with red with a 50% alpha
	        	      g.setColor(new Color(0, 0, 0, 0.70f));
	        	 
	        	      //Fill a rectangle with the 50% red color
	        	      g.fillRect(0, 0, this.getWidth(), this.getHeight());
	        	      
	        	      
	        	   }
	        	};
	        	
	        	//panel.add(propertiesMenu);
	        	panel.setOpaque(false); 
	           Main.frame.setGlassPane(panel);
	       
	        	panel.setVisible(true);
	        	
	        	_table.showProperties();
	            
	        }
	 }
	 
	public void  mouseDragged(java.awt.event.MouseEvent e){
	       
		if (SwingUtilities.isRightMouseButton(e))
			return;
		
	    	   Point currentPoint=e.getPoint();
	    	   int diffX=currentPoint.x-_lastMousePosition.x;
	    	   int diffY=currentPoint.y-_lastMousePosition.y;
	    	   
	    	   
	    	   if(Main.frame.getCursorType() == Cursor.DEFAULT_CURSOR)
	    	   {
	    		  // System.out.println(Test.frame.getCursor());
	    		  resizing = false;
	    		   _table.setLocation(_table.getX()+diffX,_table.getY()+diffY);
	    		   _table.repaint();
	           }else{ resizing = true;}
	}
}