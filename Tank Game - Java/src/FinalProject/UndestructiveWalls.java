package FinalProject;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class UndestructiveWalls {
	
	
	   int x;
	   int y; 
	   BufferedImage image;
	   public UndestructiveWalls(int x, int y)
	   {
		    this.x=x;
			this.y=y;
			try {
				image=ImageIO.read(getClass().getResourceAsStream("image02.jpg"));
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		   
	   }
	   public Rectangle getRectangle()
		{
			Rectangle r1 = new Rectangle(x,y,100,130);
			return r1;
		}
	   public void paint(Graphics g)
		{
			g.drawImage(image, x,y, 100,130, null);
			
		}

}
