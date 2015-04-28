import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.concurrent.TimeUnit;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CircleTable extends JPanel {
    private boolean draw;
    private Color color;
    public CircleTable _circleTable;
    public Ellipse2D.Double _circle;
    public JSlider _js;
    public int _size = 100;
    // setter for color
    // setter for draw

    public CircleTable()
    {
    	_circleTable = this;
    	this.setOpaque(false);
    	this.setSize(_size,_size);
    	this.setLocation(200,200);
    	
    	//add circle size jslider
    	_js = new JSlider(JSlider.HORIZONTAL, 100, 350, 100);  
    	_js.setBounds(this.getX(),this.getY() + _size,this.getWidth(),15);
    	_js.setVisible(false);
        _js.addChangeListener(new ChangeListener() {
        	
			public void stateChanged(ChangeEvent e) {
				_size = _js.getValue();
				_circleTable.setSize(_size, _size);
				_js.setBounds(_circleTable.getX(),_circleTable.getY() + _size,_circleTable.getWidth(),15);
				//System.out.println(js.getValue());
				
			}
        });
 
        Main.frame.getContentPane().add(_js);

		CircleTableMouseListener ml = new CircleTableMouseListener(this);
		  this.addMouseListener(ml);
		  this.addMouseMotionListener(ml);
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        // Assume x, y, and diameter are instance variables.
        _circle = new Ellipse2D.Double(0, 0, _size, _size);
        g2d.fill(_circle);
        	//g.setColor(Color.CYAN);
            //g.fillOval(0, 0, _size, _size);
        
    }
}