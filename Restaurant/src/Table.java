import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Table extends JPanel {

	private int xClick, yClick;
	private Table _table;
	public long startTime;
	public Image img;
    public JLabel timeLabel, propertiesTimeLabel, currentTimeLabel,customerLabel;
    public String _currentTime;
    
		public Table(int x, int y)
		{
	
			_table = this;
			//img = Toolkit.getDefaultToolkit().createImage("wood_1.jpeg");
		
			timeLabel = new JLabel();
        	propertiesTimeLabel = new JLabel("Current Sitting Time: " + _table.getTableTime(), SwingConstants.RIGHT);
            propertiesTimeLabel.setVerticalAlignment(SwingConstants.TOP);
            currentTimeLabel = new JLabel("", SwingConstants.RIGHT);
            //currentTimeLabel.setVerticalAlignment(SwingConstants.CENTER);
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
		      timeLabel.setText(hms);
		      propertiesTimeLabel.setText("Current Sitting Time: " +  hms);
		      _currentTime = hms;
		        	    	
		      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		      Date date = new Date();
		      
		      //currentTimeLabel.setText(dateFormat.format(date));
		 
		      }

		
		          
		      };
		      new javax.swing.Timer(delay, taskPerformer).start();
		   
			this.setBounds(x,y,100,100);
			this.setBackground(Color.PINK);
			
			TableMouseListener ml=new TableMouseListener(this);
			  this.addMouseListener(ml);
			  this.addMouseMotionListener(ml);
			  
		}
		
		public void showProperties()
		{
			JDialog pop = new JDialog(Main.frame, "", Dialog.ModalityType.DOCUMENT_MODAL);
        	pop.setBounds(0,_table.getY() + 50 + _table.getHeight(),Main.frame.getWidth(),175);
        	pop.getRootPane().setBorder(new EmptyBorder(10, 10, 10, 10) );
       
        
            pop.getContentPane().add(propertiesTimeLabel);
           // pop.getContentPane().add(currentTimeLabel);
            
            pop.setUndecorated(true);
        	pop.setVisible(true);
        	
		}
		public void setTextureImg(Image aimg)
		{
			img = aimg;
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