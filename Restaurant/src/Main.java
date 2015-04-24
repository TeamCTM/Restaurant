import java.awt.*;
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
import javax.swing.filechooser.FileNameExtensionFilter;



import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
//Madhu: We should rename this 'table' and 'tableTest' 

public class Main {
	 static JFrame frame;
	 static boolean properties = false; //tells if properties menu is open
	public static void main(String[] args) {
		
		frame = new JFrame("Resturant Management v1.0");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        //frame.getContentPane().setLocation(0,100);
        frame.getContentPane().setBackground(new Color(200,100,30));

        try {
    		frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("darkwood.jpg")))));
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	frame.pack();
    	frame.setVisible(true);
        
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setTitle("Restaurant Manager Genie");
        JOptionPane.showMessageDialog(frame, "Welcome to Restaurant Manager Genie! Let's get started.");
       
    	String first_name;
		first_name=JOptionPane.showInputDialog("First Name");
		
		String restaurant_name;
		restaurant_name=JOptionPane.showInputDialog("Restaurant Name");
			
		String sentence1;
		sentence1="Hello, "+first_name+". Welcome to Restaurant Genie! "
		+ "I look forward to helping you make "+restaurant_name+" a "
		+ "successful business!";
		
		String sentence2;
		sentence2=first_name+", you will need to set up your virtual restaurant!";
		
		JOptionPane.showMessageDialog(null, sentence1);
		JOptionPane.showMessageDialog(null, sentence2);
		//System.exit(0);
        
		
        
		
        
        
        /*
        String input = "";
        String rex = "^[1-9]\\d*$";
       
        do{
         input = JOptionPane.showInputDialog(frame  ,"How many tables are in your restaurant?:");
        }while(!input.matches(rex));
        
        int number = Integer.parseInt(input);
        */
        
       // JPanel mainp = new JPanel();
        //mainp.setBounds(50,50,100,100);
        //mainp.setBackground(Color.CYAN);
      
     //   JPanel maind = new JPanel();
       // maind.setBounds(200,50,100,100);
        //maind.setBackground(Color.CYAN);
     
       // frame.getContentPane().add(mainp);
       // frame.getContentPane().add(new Table(10,10));
       // frame.getContentPane().add(new Table(10,200));
       // frame.getContentPane().add(new Table(10,200));
    	
    	
         frame.addMouseListener(new PopupTriggerListener());
        //frame.getContentPane().add(jScrollPane);
        // frame.repaint();
        
	}
}
class SayHello extends TimerTask {
	private Table _panel;
	public SayHello(JPanel aPanel)
	{
		
	}
    public void run() {
       System.out.println("Hello World!"); 
    }
 }
class textureMenuActionListener implements ActionListener {
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

class colorMenuActionListener implements ActionListener {
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

class TableMouseListener extends javax.swing.event.MouseInputAdapter{
	private JPanel _table;
	private Point _lastMousePosition;
	JPopupMenu menu; 
	boolean resizing = false;
	public TableMouseListener(JPanel aPanel)
	{
		_table = aPanel;
		menu = new JPopupMenu("Popup");
		menu.add(new JMenuItem("Seat New People [TODO]"));
		menu.add(new JMenuItem("Place Order [TODO]"));
		JMenuItem textureInfo = new JMenuItem("Change Texture");
		textureInfo.addActionListener(new textureMenuActionListener((Table)_table)); 
		menu.add(textureInfo);
		JMenuItem colorInfo = new JMenuItem("Change Color");
		 colorInfo.addActionListener(new colorMenuActionListener(_table)); 
		menu.add(colorInfo);
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
	            BufferedImage bufImg = new BufferedImage(Main.frame.getContentPane().getSize().width, Main.frame.getContentPane().getSize().height,BufferedImage.TYPE_INT_RGB);  
	            Main.frame.paint(bufImg.createGraphics());  
	            
	           // BufferedImage dest = bufImg.getSubimage(0, tableY, Main.frame.getSize().width, 50);
	            File imageFile = new File("test.jpg");  
	         try{  
	             imageFile.createNewFile();  
	             ImageIO.write(bufImg, "jpeg", imageFile);  
	         }catch(Exception ex){  
	         }  
	         */
	         
	        PropMenu propertiesMenu = new PropMenu(0, 0);
	        propertiesMenu.setSize(500, 500);
	        propertiesMenu.setVisible(true);
	        	//Main.frame.getGlassPane().setVisible(true);
	        	//Main.frame.getContentPane().setBackground(new Color(0, 0, 0, 0));
	        	//Main.frame.getContentPane()
	        	JPanel blur = new JPanel();
	        	blur.setBounds(0,0,Main.frame.getWidth(), Main.frame.getHeight());
	        	blur.setBackground(new Color(0,0,0,200));
	        	
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
	        	JDialog pop = new JDialog(Main.frame, "CHEAAAA", Dialog.ModalityType.DOCUMENT_MODAL);
	        	//pop.setLocationRelativeTo(Main.frame.getContentPane());
	        	pop.setBounds(0,_table.getY() + 50 + _table.getHeight(),Main.frame.getWidth(),175);

	        	pop.setUndecorated(true);
	        	pop.setVisible(true);
	        	//Main.frame.repaint();
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
class PropMenu extends JPanel {

	private int xClick, yClick;
	private Table _table;
	public long startTime;
	public Image img;
	private JLabel timeLabel;

		public PropMenu(int x, int y)
		{
		
			this.setBounds(x,y,Main.frame.getWidth(),300);
			this.setBackground(Color.GRAY);
		}
		
		public void setTextureImg(Image aimg)
		{
			img = aimg;
		}
		
		@Override
		  protected void paintComponent(Graphics g) {
		    super.paintComponent(g);
		        g.drawImage(img, 0, 0,this.getWidth(), this.getHeight(), null);
		}
}

 class Table extends JPanel {

	private int xClick, yClick;
	private Table _table;
	public long startTime;
	public Image img;
	private JLabel timeLabel;

		public Table(int x, int y)
		{
			_table = this;
			try{
			img = ImageIO.read(new File("wood"));
			}catch(Exception e)
			{	
			}
			
			//this.setLayout(null);
			timeLabel = new JLabel();
			this.add(timeLabel);
			 startTime = System.currentTimeMillis();
			 
			 int delay = 1000; //milliseconds
		      ActionListener taskPerformer = new ActionListener() {
		          public void actionPerformed(ActionEvent evt) {
		        	//  timeLabel.setVisible(false);
		        	  long millis = System.currentTimeMillis() - startTime;
		        	    String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
		        	            TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
		        	            TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
		        	    if(!Main.properties)
		        	    	timeLabel.setText(hms);
		          }
		      };
		      new javax.swing.Timer(delay, taskPerformer).start();
		   
			this.setBounds(x,y,100,100);
			this.setBackground(Color.PINK);
			// img = Toolkit.getDefaultToolkit().createImage("wood.png");
			TableMouseListener ml=new TableMouseListener(this);
			  this.addMouseListener(ml);
			  this.addMouseMotionListener(ml);
		}
		
		public void setTextureImg(Image aimg)
		{
			img = aimg;
		}
		
		@Override
		  protected void paintComponent(Graphics g) {
		    super.paintComponent(g);
		        g.drawImage(img, 0, 0,this.getWidth(), this.getHeight(), null);
		}
}
class CircleTable extends JPanel {

	private int xClick, yClick;
	private CircleTable _cirtable;
	public long startTime;
	private Image img;
	private JLabel timeLabel;
		public CircleTable(int x, int y)
		{
			_cirtable = this;
			try{
			//img = ImageIO.read(new File("wood"));
			}catch(Exception e)
			{	
			}
			
			timeLabel = new JLabel();
			this.add(timeLabel);
			 startTime = System.currentTimeMillis();
			 
			 int delay = 1000; //milliseconds
		      ActionListener taskPerformer = new ActionListener() {
		          public void actionPerformed(ActionEvent evt) {
		        	  long millis = System.currentTimeMillis() - startTime;
		        	    String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
		        	            TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
		        	            TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
		        	    _cirtable.setToolTipText(hms);
		        	    timeLabel.setText(hms);
		          }
		      };
		      new javax.swing.Timer(delay, taskPerformer).start();
		      
			this.setBounds(x,y,100,100);
			this.setBackground(Color.PINK);
			// img = Toolkit.getDefaultToolkit().createImage("wood.png");
			TableMouseListener ml=new TableMouseListener(this);
			  this.addMouseListener(ml);
			  this.addMouseMotionListener(ml);
		}
		
		@Override
		  protected void paintComponent(Graphics g) {
		    super.paintComponent(g);
		        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
		}
}
class sqMenuActionListener implements ActionListener {
	  public void actionPerformed(ActionEvent e) {
	   // System.out.println("Selected: " + e.getActionCommand());
		Main.frame.getContentPane().add(new Table(400, 400));
		Main.frame.repaint();
	  }
	}


class cirMenuActionListener implements ActionListener {
	  public void actionPerformed(ActionEvent e) {
	    //System.out.println("Selected: " + e.getActionCommand());
		  
		Main.frame.getContentPane().add(new Table(400, 400));
		Main.frame.repaint();
	  }
	}

class PopupTriggerListener extends MouseAdapter {
	JPopupMenu menu = new JPopupMenu("Popup"); 
	 public PopupTriggerListener()
	 {
		 
		 JMenuItem sqMenuItem = new JMenuItem("New Square Table");
		 JMenuItem cirMenuItem = new JMenuItem("New Circle Table");
		   sqMenuItem.addActionListener(new sqMenuActionListener()); 
		   cirMenuItem.addActionListener(new cirMenuActionListener());
		 menu.add(sqMenuItem);
		 menu.add(cirMenuItem);
		
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
