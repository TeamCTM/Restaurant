import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class FloorPanel extends JPanel {
	private Image _img;
	FloorPanel()
	{
		try {
			_img = ImageIO.read(new File("darkwood.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setBackground(Color.CYAN);
		this.setLayout(null);
		this.setBounds(0,0,Main.frame.getWidth(),Main.frame.getHeight());
	//	System.out.println(Main.frame.getWidth());
	}
	
	public void setBackgroundImage(Image aImg)
	{
		_img = aImg;
		this.repaint();
	}
	@Override
	  protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	       g.drawImage(_img, 0, 0,this.getWidth(), this.getHeight(), null);
	}
	
}
