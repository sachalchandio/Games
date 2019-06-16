package FinalProject;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class DestructiveWalls {
	
	
	BufferedImage image;
	int x;
	int y;
	public DestructiveWalls(int x, int y)
	{
		this.x=x;
		this.y=y;
		try {
			image=ImageIO.read(getClass().getResourceAsStream("brick.jpg"));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public Rectangle getRectangle()
	{
	    Rectangle r1 = new Rectangle(x,y,60,20);
	    return r1;
	}
	public void paint(Graphics g)
	{
		g.drawImage(image, x, y,60,20, null);
		
		
	}

}
