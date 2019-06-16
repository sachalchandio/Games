package FinalProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullets {

	 int speed; 
	 int x;
	 int y;
	 Color col;
	 int height;
	 int width;
	  public Bullets(int x, int y,int width,int height)
	  {
		    this.x=x;
			this.y=y;
			this.height=height;
			this.width=width;  
	  }
	  public void setX(int x)
	  {
		  this.x=x;
	  }
	  public void setY(int y)
	  {
		  this.y=y;
	  }
	  public int getX()
	   {
			return x;
	   }
	 public int getY()
	   {
			return y;
	   }
	 public Rectangle getRectangle()
		{
			Rectangle r = new Rectangle(x,y,height,width);
			return r;
		}
	 public void fireRight(int speed)
	 {
		 this.speed=speed;
		 x=x+speed;
	 }
	 public void fireLeft(int speed)
	 {
		 this.speed=speed;
		 x=x-speed;
	 }
	 public void fireUp(int speed)
	 {
		 this.speed=speed;
		 y=y-speed;
	 }
	 public void fireDown(int speed)
	 {
		 this.speed=speed;
		 y=y+speed;
	 }
	 public void paint(Graphics g)
		{
			g.setColor(Color.WHITE);
			g.fillRoundRect(x,y , height,width, 20, 20);
		}
	 
}
