import java.awt.Cursor;
import java.awt.Point;

import javax.swing.SwingUtilities;

public class CircleTableMouseListener extends javax.swing.event.MouseInputAdapter{

	public CircleTable _circleTable;
	private Point _lastMousePosition;
	
	public CircleTableMouseListener(CircleTable aCircle){
		_circleTable = aCircle;
		
	}
	public void mouseMoved(java.awt.event.MouseEvent e){
		if (_circleTable._circle.contains(e.getPoint()))
		{
			///System.out.println("click");
			//Show slider
			_circleTable._js.setVisible(true);
		}
		
	}
	public void mousePressed(java.awt.event.MouseEvent e){
	    _lastMousePosition=e.getPoint();
	}
	
	public void  mouseDragged(java.awt.event.MouseEvent e){
	       
		if (SwingUtilities.isRightMouseButton(e))
			return;
		
	    	   Point currentPoint=e.getPoint();
	    	   int diffX=currentPoint.x-_lastMousePosition.x;
	    	   int diffY=currentPoint.y-_lastMousePosition.y;
	    	   
	    	 
	    		  // System.out.println(Test.frame.getCursor());
	    		   _circleTable.setLocation(_circleTable.getX()+diffX,_circleTable.getY()+diffY);
	    		   _circleTable._js.setBounds(_circleTable.getX(),_circleTable.getY() + _circleTable._size,_circleTable.getWidth(),15);
	    		  // _table.repaint();
	}
	
}