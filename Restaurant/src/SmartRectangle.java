

public class SmartRectangle extends java.awt.geom.Rectangle2D.Double 
{
   private java.awt.Color _borderColor, _fillColor,_myColor,_currColor;
   private int _rotation;
   private final int STROKE_WIDTH=2;
   private java.awt.Point _lastMousePosition;
   
 
   
   
   public SmartRectangle(java.awt.Color aColor)
{
       super();
       _myColor=java.awt.Color.BLUE;
       _currColor=java.awt.Color.WHITE;
       _borderColor=java.awt.Color.PINK;
       _fillColor=java.awt.Color.RED;
       _rotation=0;
       
       _lastMousePosition=new java.awt.Point();
       this.setLocation(x,y);
   
}
public void setBorderColor(java.awt.Color aColor)
{ _borderColor=java.awt.Color.PINK;
}
public void setFillColor(java.awt.Color aColor)
{ _fillColor=java.awt.Color.PINK;
}

public void setLocation(double x, double y)
{ this.setFrame(x,y,this.getWidth(),this.getHeight());
}
public void setSize(int aWidth, int aHeight)
   { this.setFrame(this.getX(),this.getY(), aWidth, aHeight);
   }
public void fill(java.awt.Graphics2D aBetterBrush)
   { java.awt.Color oldColor=aBetterBrush.getColor();
       aBetterBrush.setColor(_fillColor);
       aBetterBrush.fill(this);
       aBetterBrush.setColor(oldColor);
   }
public void draw(java.awt.Graphics2D aBetterBrush)
   { java.awt.Color oldColor=aBetterBrush.getColor();
       aBetterBrush.setColor(_borderColor);
       java.awt.Stroke oldStroke=aBetterBrush.getStroke();
       aBetterBrush.setStroke(new java.awt.BasicStroke(STROKE_WIDTH));
       aBetterBrush.draw(this);
       aBetterBrush.setStroke(oldStroke);
       aBetterBrush.setColor(oldColor);
   }

}
