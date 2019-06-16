package FinalProject;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;





public class BulletList {


	ArrayList<Bullets> fireList;
	ArrayList<Bullets> fireList2;
	int speed;
	public BulletList()
	{
		fireList= new ArrayList<Bullets>();
		fireList2= new ArrayList<Bullets>();
	}
	 public void fireRight(int speed)
	 {
		 this.speed=speed;
		 for(Bullets b:fireList)
			 b.x=b.x+speed;
	 }
	 public void fireRight2(int speed)
	 {
		 this.speed=speed;
		 for(Bullets b:fireList2)
			 b.x=b.x+speed;
	 }
	 public void fireLeft(int speed)
	 {
		 this.speed=speed;
		 for(Bullets b:fireList)
			 b.x=b.x-speed;
	 }
	 public void fireLeft2(int speed)
	 {
		 this.speed=speed;
		 for(Bullets b:fireList2)
			 b.x=b.x-speed;
	 }
	 public void fireUp(int speed)
	 {
		 this.speed=speed;
		 for(Bullets b:fireList)
			 b.y=b.y-speed;
	 }
	 public void fireUp2(int speed)
	 {
		 this.speed=speed;
		 for(Bullets b:fireList2)
			 b.y=b.y-speed;
	 }
	 
	 public void fireDown(int speed)
	 {
		 this.speed=speed;
		 for(Bullets b:fireList)
			 b.y=b.y+speed;
	 }
	 public void fireDown2(int speed)
	 {
		 this.speed=speed;
		 for(Bullets b:fireList2)
			 b.y=b.y+speed;
	 }
	 public void paint(Graphics g)
	 {
		 for(Bullets gt :fireList)
		   	 fireList.get(fireList.size()-1).paint(g);
		 for(Bullets gt :fireList2)
		   	 fireList2.get(fireList2.size()-1).paint(g);
		 
	 }
	 
	 public void leftRestriction(int speed)
	 {
		 for(Bullets h:fireList)
			{
				if(h.getX()<0)
				{	
					this.speed=speed;
					h.x=-1000;
					h.y=-1000;
				}    
			}
	 }
	 public void leftRestriction2(int speed)
	 {
		 for(Bullets h:fireList2)
			{
				if(h.getX()<0)
				{	
					this.speed=speed;
					h.x=-1000;
					h.y=-1000;
				}    
			}
		 
	 }
	 public void rightRestriction(int speed)
	 {
		 for(Bullets h:fireList)
			{
				if(h.getX()>750)
				{	
					this.speed=speed;
					h.x=-1000;
					h.y=-1000;
				}    
			}
	 }
	 public void rightRestriction2(int speed)
	 {
		 
		 for(Bullets h:fireList2)
			{
				if(h.getX()>725)
				{	
					this.speed=speed;
					h.x=-1000;
					h.y=-1000;
				}    
			}
		 
	 }
	 public void UpRestriction(int speed)
	 {
		 for(Bullets h:fireList)
			{
				if(h.getY()<0)
				{	
					this.speed=speed;
					h.x=-1000;
					h.y=-1000;		
				}    
			}
	 }
	 public void UpRestriction2(int speed)
	 {
		 
		 for(Bullets h:fireList2)
			{
				if(h.getY()<0)
				{	
					this.speed=speed;
					h.x=-1000;
					h.y=-1000;		
				}    
			}
	 }
	 public void DownRestriction(int speed)
	 {
		 for(Bullets h:fireList)
			{
				if(h.getY()>565)
				{	
					this.speed=speed;
					h.x=-1000;
					h.y=-1000;		
				}    
			}
		 
	 }
	 public void DownRestriction2(int speed)
	 {
		 
		 for(Bullets h:fireList2)
			{
				if(h.getY()>565)
				{	
					this.speed=speed;
					h.x=-1000;
					h.y=-1000;		
				}    
			}
	 }

}
