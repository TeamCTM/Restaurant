import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Table extends JPanel {

	private int xClick, yClick;
	private Table _table;
	public long startTime;
	public Image img;
    public JLabel timeLabel, propertiesTimeLabel, currentTimeLabel,capacityLabel, customerLabel, seatedLabel;
    public String _currentTime;
    public int _capacity, _customers;
    
		public Table(int x, int y)
		{
			_capacity = 0;
			_customers = 0;
			_table = this;
			//img = Toolkit.getDefaultToolkit().createImage("wood_1.jpeg");
		
			timeLabel = new JLabel();
			seatedLabel = new JLabel("Seated: " + _customers + "/" + _capacity);
        	propertiesTimeLabel = new JLabel("Current Sitting Time: " + _table.getTableTime(), SwingConstants.RIGHT);
           // propertiesTimeLabel.setVerticalAlignment(SwingConstants.TOP);
        	propertiesTimeLabel.setBounds(1000,0,200,20);
            currentTimeLabel = new JLabel("", SwingConstants.RIGHT);
            //currentTimeLabel.setVerticalAlignment(SwingConstants.CENTER);
			 this.add(timeLabel);
			 this.add(seatedLabel);
			 startTime = System.currentTimeMillis();
			  int delay = 1000; //milliseconds
		      ActionListener taskPerformer = new ActionListener() {
		      public void actionPerformed(ActionEvent evt) {
		      //  timeLabel.setVisible(false);
		      long millis = System.currentTimeMillis() - startTime;
		      String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
		      TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
		      TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
		      timeLabel.setText(hms);
		     //_table.repaint();
		      propertiesTimeLabel.setText("Current Sitting Time: " +  hms);
		      _currentTime = hms;
		        	    	
		      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		      Date date = new Date();
		 
		      }
  
		      };
		      new javax.swing.Timer(delay, taskPerformer).start();
		   
			this.setBounds(x,y,100,100);
			Color customColor = new Color(227,212,148);
			this.setBackground(customColor);
			
			TableMouseListener ml=new TableMouseListener(this);
			  this.addMouseListener(ml);
			  this.addMouseMotionListener(ml);
			  
		}
		
		public void showProperties()
		{
			final JDialog pop = new JDialog(Main.frame, "", Dialog.ModalityType.DOCUMENT_MODAL);
        	pop.setBounds(10,200,Main.frame.getWidth()-10,275);
        	pop.getRootPane().setBorder(new EmptyBorder(10, 10, 10, 10) );
        	pop.setLayout(null);
        	  Color customColor = new Color(227,212,148);
          	pop.getContentPane().setBackground( customColor );
          	
            pop.getContentPane().add(propertiesTimeLabel);
        	
            JButton dashcloseButton= new JButton("Back to Virtual Restaurant");
            dashcloseButton.setBounds(0,220,200,30);
            pop.getContentPane().add(dashcloseButton); //adds close button to pop window
            dashcloseButton.addActionListener(new ActionListener(){
            
            	public void actionPerformed(ActionEvent e){
            		 pop.setVisible(false); //Gets rid of pop window
            		 Main.frame.getGlassPane().setVisible(false); //Gets rid of dimmed background
            		 Main.frame.repaint();
            	}
            });
            
            
        	capacityLabel = new JLabel("Table Seating Capacity:");
        	capacityLabel.setBounds(0,0,150,25);
        	
        	customerLabel = new JLabel("Number of Customers:");
        	customerLabel.setBounds(0,25,150,25);
        	
        	
        	SpinnerModel model = new SpinnerNumberModel(0, 0, 30, 1);     
        	final JSpinner spinner = new JSpinner(model);
        	spinner.setEditor(new JSpinner.DefaultEditor(spinner));
        	spinner.setBounds(150,0,100,25);
        	
        	final JComboBox customers = new JComboBox();
        	customers.setBounds(150,25,100,25);
        	
        	
        	ChangeListener listener = new ChangeListener() {

				public void stateChanged(ChangeEvent e) {
					_capacity = (Integer) spinner.getValue(); //get new spinner value
					
					customers.removeAllItems(); //remove all items from dropdown
					for(int i = 1; i <= _capacity; i++)
					{
						customers.addItem(i); //repopulate the dropdown
					}
					seatedLabel.setText("Seated: " + _customers + "/" + _capacity);
				}
        	    }; 
            	    
                customers.addItemListener(new ItemListener() {

					public void itemStateChanged(ItemEvent e) {
						if(customers.getItemCount() == 0)
						{
							_customers = 0;
							seatedLabel.setText("Seated: " + _customers + "/" + _capacity);
							return;
						}
						_customers = (Integer)customers.getSelectedItem();
						seatedLabel.setText("Seated: " + _customers + "/" + _capacity);
					}
                });
                
        	    spinner.addChangeListener(listener);
        	
        	pop.getContentPane().add(propertiesTimeLabel);
        	pop.getContentPane().add(spinner);
        	pop.getContentPane().add(customerLabel);
        	pop.getContentPane().add(capacityLabel);
        	pop.getContentPane().add(customers);
        	
            pop.setUndecorated(true);
        	pop.setVisible(true);
        	
		}
		public void setTextureImg(Image aimg)
		{
			img = aimg;
			this.repaint();
		}
		
	    public String getTableTime()
	    {
	    	return _currentTime;
	    }
	    
		@Override
		  protected void paintComponent(Graphics g) {
		    super.paintComponent(g);
		        g.drawImage(img, 0, 0,this.getWidth(), this.getHeight(), null);
		}
}