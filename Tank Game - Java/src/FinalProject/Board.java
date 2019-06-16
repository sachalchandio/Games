package FinalProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import sun.audio.*;
import java.io.*;

public class Board extends JPanel implements KeyListener,ActionListener,Serializable {
	
    BufferedImage image;
    BufferedImage image1;
    JButton b1;
    JButton b2;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel label6;
    JLabel label7;
    JLabel label8;
    JLabel label9;
    JLabel label10;
    JLabel label11;
    JLabel label12;
    JLabel label13;
    JLabel label14;
    JLabel label15;
    JLabel label16;
    int more=0;
    int more1=0;
    int incr=0;
    Timer time=new Timer(5,this);
    int x=0; int y=550;
    int x1=700; int y1=0;
    int vx;
    int vy;
    int ax;
    int ay;
    int turn;
    int turn1;
    int speed;
    int limit=20;
    int limit1=20;
    boolean fire2;
    boolean fire;
    boolean collision=true;
    boolean intersect=true;
    int power=0;
    int power1=0;
    int speed1;
    String score="";
    String score1="";
   BulletList b;
   JFrame frame;
   int decr=0;
   ArrayList<DestructiveWalls> myList;
   UndestructiveWalls wall2;
   UndestructiveWalls wall4;
   UndestructiveWalls wall5;
   int pack=0;
   int pack1=0;
   AudioPlayer mgp;
   ContinuousAudioDataStream loop;
   AudioPlayer bp;
   ContinuousAudioDataStream loop1;
   PowerPack p;
	public Board()
	{
	    
	b1 = new JButton("Save");
    	b2= new JButton("Pause");
    	label1= new JLabel("Player1");
    	label1.setFont(new Font("Serif", Font.PLAIN, 30));
    	label2= new JLabel("Bullets");
    	label2.setFont(new Font("Serif", Font.PLAIN, 30));
    	label3 = new JLabel("");
    	label3.setFont(new Font("Serif", Font.PLAIN, 30));
    	label4 = new JLabel("Player2");
    	label4.setFont(new Font("Serif", Font.PLAIN, 30));
    	label5 = new JLabel("Bullets");
    	label5.setFont(new Font("Serif", Font.PLAIN, 30));
    	label6 = new JLabel("");
    	label6.setFont(new Font("Serif", Font.PLAIN, 30));
    	label7= new JLabel("Player1");
    	label7.setFont(new Font("Serif", Font.PLAIN, 30));
    	label8= new JLabel("Life");
    	label8.setFont(new Font("Serif", Font.PLAIN, 30));
    	label9= new JLabel("");
    	label9.setFont(new Font("Serif", Font.PLAIN, 30));
    	label10= new JLabel("player2");
    	label10.setFont(new Font("Serif", Font.PLAIN, 30));
    	label11= new JLabel("Life");
    	label11.setFont(new Font("Serif", Font.PLAIN, 30));
    	label12= new JLabel("");
    	label12.setFont(new Font("Serif", Font.PLAIN, 30));
    	label13= new JLabel("Player1");
    	label13.setFont(new Font("Serif", Font.PLAIN, 30));
    	label14= new JLabel("");
    	label14.setFont(new Font("Serif", Font.PLAIN, 30));
    	label15= new JLabel("Player2");
    	label15.setFont(new Font("Serif", Font.PLAIN, 30));
    	label16= new JLabel("");
    	label16.setFont(new Font("Serif", Font.PLAIN, 30));
    	
    	   frame = new JFrame();
    	     
    	     frame.setSize(1000, 1000);
    	     
    
    	     this.setLayout(new BorderLayout());
    	     this.setPreferredSize(new Dimension(700, 800));
    	     this.setBackground(Color.BLACK);
    	     
    	     JPanel p2 = new JPanel();
    	     p2.setPreferredSize(new Dimension(130, 650));
    	     p2.setBackground(Color.GRAY);
    	     p2.add(label1);
    	     p2.add(label2);
    	     p2.add(label3);
    	     p2.add(label4);
    	     p2.add(label5);
    	     p2.add(label6);
    	     p2.add(label7);
    	     p2.add(label8);
    	     p2.add(label9);
    	     p2.add(label10);
    	     p2.add(label11);
    	     p2.add(label12);
    	     p2.add(label13);
    	     p2.add(label14);
    	     p2.add(label15);
    	     p2.add(label16);
    	     
    	     JPanel p3 = new JPanel();
    	     p3.setPreferredSize(new Dimension(650, 100));
    	     p3.setBackground(Color.red);
    	     p3.add(b1);
    	     p3.add(b2);
    	     
    	     this.add(p2,BorderLayout.EAST);
    	     this.add(p3,BorderLayout.SOUTH);
    	      b1.addActionListener(this);
    	      b2.addActionListener(this);
    	     
    	     frame.add(this);
    	     play();
    	     music();
    	     frame.setVisible(true);
    	     frame.setResizable(false);
	}
	public void music()
	{
		
	AudioPlayer mgp = AudioPlayer.player;
    	AudioStream bgm;
    	AudioData md;
    	ContinuousAudioDataStream loop= null;
    	try {
    	bgm = new AudioStream(new FileInputStream("dt_32bars_89rap.wav"));
    	AudioPlayer.player.start(bgm);
    	}catch(IOException e)
    	{
    		e.printStackTrace();
    	}
    	mgp.start(loop);
	}
	public void BulletMusic()
	{
		mgp = AudioPlayer.player;
    	AudioStream as;
    	AudioData ad;
    	loop= null;
    	try {
    	as = new AudioStream(new FileInputStream("gun6.wav"));
    	ad=as.getData();
    	loop= new ContinuousAudioDataStream(ad); 
    	}catch(IOException e)
    	{
    		e.printStackTrace();
    	}
    	mgp.start(loop);
		
		
	}
	public void play()
	{
		p=new PowerPack(400,300);
		b= new BulletList();
		myList = new ArrayList<DestructiveWalls>();
		
		wall2= new UndestructiveWalls(400,500);
		wall4= new UndestructiveWalls(700,500);
       		wall5 = new UndestructiveWalls(400,100);
        
    
        myList.add(new DestructiveWalls(230,65));
        myList.add(new DestructiveWalls(275,65));
        myList.add(new DestructiveWalls(230,80));
        myList.add(new DestructiveWalls(275,80));
        myList.add(new DestructiveWalls(230,95));
        myList.add(new DestructiveWalls(275,95));
        myList.add(new DestructiveWalls(275,110));
        myList.add(new DestructiveWalls(230,110));
        myList.add(new DestructiveWalls(275,125));
        myList.add(new DestructiveWalls(230,125));
		myList.add(new DestructiveWalls(275,140));
		myList.add(new DestructiveWalls(230,140));
		myList.add(new DestructiveWalls(275,155));
		myList.add(new DestructiveWalls(230,155));
		myList.add(new DestructiveWalls(275,170));
		myList.add(new DestructiveWalls(230,170));
		myList.add(new DestructiveWalls(275,185));
		myList.add(new DestructiveWalls(230,185));
		myList.add(new DestructiveWalls(275,200));
		myList.add(new DestructiveWalls(230,200));
		myList.add(new DestructiveWalls(230,215));
		myList.add(new DestructiveWalls(275,215));
		myList.add(new DestructiveWalls(230,230));
		myList.add(new DestructiveWalls(275,230));
		myList.add(new DestructiveWalls(230,245));
		myList.add(new DestructiveWalls(275,245));
		myList.add(new DestructiveWalls(230,260));
		myList.add(new DestructiveWalls(275,260));
		myList.add(new DestructiveWalls(230,275));
		myList.add(new DestructiveWalls(275,275));
		myList.add(new DestructiveWalls(275,290));
		myList.add(new DestructiveWalls(230,290));
		myList.add(new DestructiveWalls(275,350));
		myList.add(new DestructiveWalls(230,350));
		myList.add(new DestructiveWalls(275,365));
		myList.add(new DestructiveWalls(230,365));
		myList.add(new DestructiveWalls(275,383));
		myList.add(new DestructiveWalls(230,383));
		myList.add(new DestructiveWalls(275,400));
		myList.add(new DestructiveWalls(230,400));
		myList.add(new DestructiveWalls(275,415));
		myList.add(new DestructiveWalls(230,415));
		myList.add(new DestructiveWalls(275,430));
		myList.add(new DestructiveWalls(230,430));
		myList.add(new DestructiveWalls(275,445));
		myList.add(new DestructiveWalls(230,445));
		myList.add(new DestructiveWalls(230,460));
		myList.add(new DestructiveWalls(275,460));
		myList.add(new DestructiveWalls(230,480));
		myList.add(new DestructiveWalls(275,480));	
		myList.add(new DestructiveWalls(230,500));
		myList.add(new DestructiveWalls(275,500));
		myList.add(new DestructiveWalls(230,515));
		myList.add(new DestructiveWalls(275,515));
		myList.add(new DestructiveWalls(230,530));
		myList.add(new DestructiveWalls(275,530));
		myList.add(new DestructiveWalls(230,545));
		myList.add(new DestructiveWalls(275,545));
		myList.add(new DestructiveWalls(230,560));
		myList.add(new DestructiveWalls(275,560));
		myList.add(new DestructiveWalls(230,575));
		myList.add(new DestructiveWalls(275,575));
		myList.add(new DestructiveWalls(230,593));
		myList.add(new DestructiveWalls(275,593));
		myList.add(new DestructiveWalls(230,610));
		myList.add(new DestructiveWalls(275,610));
		
		myList.add(new DestructiveWalls(580,60));
		myList.add(new DestructiveWalls(540,60));
		myList.add(new DestructiveWalls(540,75));
		myList.add(new DestructiveWalls(580,75));
		myList.add(new DestructiveWalls(580,90));
		myList.add(new DestructiveWalls(540,90));
		myList.add(new DestructiveWalls(580,105));
		myList.add(new DestructiveWalls(540,105));
		myList.add(new DestructiveWalls(580,120));
		myList.add(new DestructiveWalls(540,120));
		myList.add(new DestructiveWalls(580,135));
		myList.add(new DestructiveWalls(540,135));
		myList.add(new DestructiveWalls(580,150));
		myList.add(new DestructiveWalls(540,150));
		myList.add(new DestructiveWalls(580,165));
		myList.add(new DestructiveWalls(540,165));
		myList.add(new DestructiveWalls(580,180));
		myList.add(new DestructiveWalls(540,180));
		myList.add(new DestructiveWalls(540,200));
		myList.add(new DestructiveWalls(580,200));
		myList.add(new DestructiveWalls(540,215));
		myList.add(new DestructiveWalls(580,215));
		myList.add(new DestructiveWalls(540,230));
		myList.add(new DestructiveWalls(580,230));
		myList.add(new DestructiveWalls(540,245));
		myList.add(new DestructiveWalls(580,245));
		myList.add(new DestructiveWalls(540,260));
		myList.add(new DestructiveWalls(580,260));
		myList.add(new DestructiveWalls(540,275));
		myList.add(new DestructiveWalls(580,275));
		
		myList.add(new DestructiveWalls(540,350));
		myList.add(new DestructiveWalls(580,350));
		myList.add(new DestructiveWalls(540,365));
		myList.add(new DestructiveWalls(580,365));
		myList.add(new DestructiveWalls(540,380));
		myList.add(new DestructiveWalls(580,380));
		myList.add(new DestructiveWalls(540,395));
		myList.add(new DestructiveWalls(580,395));
		myList.add(new DestructiveWalls(540,410));
		myList.add(new DestructiveWalls(580,410));
		myList.add(new DestructiveWalls(540,425));
		myList.add(new DestructiveWalls(580,425));
		myList.add(new DestructiveWalls(540,440));
		myList.add(new DestructiveWalls(580,440));
		myList.add(new DestructiveWalls(540,455));
		myList.add(new DestructiveWalls(580,455));
		myList.add(new DestructiveWalls(540,470));
		myList.add(new DestructiveWalls(580,470));
		myList.add(new DestructiveWalls(540,485));
		myList.add(new DestructiveWalls(580,485));
		myList.add(new DestructiveWalls(540,500));
		myList.add(new DestructiveWalls(580,500));
		myList.add(new DestructiveWalls(540,515));
		myList.add(new DestructiveWalls(580,515));
		myList.add(new DestructiveWalls(540,530));
		myList.add(new DestructiveWalls(580,530));
		myList.add(new DestructiveWalls(540,545));
		myList.add(new DestructiveWalls(580,545));
		myList.add(new DestructiveWalls(540,560));
		myList.add(new DestructiveWalls(580,560));
		myList.add(new DestructiveWalls(540,575));
		myList.add(new DestructiveWalls(580,575));
		myList.add(new DestructiveWalls(540,590));
		myList.add(new DestructiveWalls(580,590));
		myList.add(new DestructiveWalls(540,605));
		myList.add(new DestructiveWalls(580,605));
		myList.add(new DestructiveWalls(580,620));
		myList.add(new DestructiveWalls(540,620));
		
		try {
			image=ImageIO.read(getClass().getResourceAsStream("Up1.png"));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		try {
			image1=ImageIO.read(getClass().getResourceAsStream("down1.png"));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		time.start();
		addKeyListener(this);
		setFocusable(true);
	}
	public void paintComponent(Graphics g)
	{
	super.paintComponent(g);
   	 g.drawImage(image,x,y,80,80, this);
   	 g.drawImage(image1,x1,y1,80,80, this);
   	 for(DestructiveWalls w :myList)
         w.paint(g);
    
   	 wall2.paint(g);
  	 wall4.paint(g);
  	 wall5.paint(g);
  	 b.paint(g);
  	 p.paint(g);
     
	}
	public Rectangle get2Rectangle()
	{
		Rectangle r = new Rectangle(x1,y1,80,80);
		return r;
	}
	public Rectangle refRectangle()
	{
		Rectangle r3= new Rectangle(x,y,80,80);
		return r3;
	}
	public void PowerPackCollision()
	{
		
		Rectangle r1 = refRectangle();
		Rectangle r2 = get2Rectangle();
		Rectangle r3 = p.getRectangle();
		if(r1.intersects(r3))
		{
			p.x=-1000;
			p.y=-1000;
			label14.setText("PowerPack");
			pack=1;
			JOptionPane.showConfirmDialog(null, "Player1 have 20 more fires,click fire button to fire", "PowerPack active", JOptionPane.OK_CANCEL_OPTION);
	
		}
		if(r2.intersects(r3))
		{
			p.x=-1000;
			p.y=-1000;
			label16.setText("PowerPack");
			pack1=1;
			JOptionPane.showConfirmDialog(null, "Player2 have 20 more fires,click fire button to fire", "PowerPack active", JOptionPane.OK_CANCEL_OPTION);
		}
	}
	public void PowerPackFiring()
	{
		Rectangle r = p.getRectangle();
		Rectangle rec;
		for(Bullets j:b.fireList2)
		{
					
          rec=b.fireList2.get(b.fireList2.size()-1).getRectangle();
          if(r.getBounds().intersects(rec))
          {
              j.x=-1000;
              j.y=-1000;
              speed1=0;
          }
		}
		for(Bullets j:b.fireList)
		{
					
          rec=b.fireList.get(b.fireList.size()-1).getRectangle();
          if(r.getBounds().intersects(rec))
          {
              j.x=-1000;
              j.y=-1000;
              speed=0;
          }
		}
		
	}
	public void WallCollison()
	{
		Rectangle rec= get2Rectangle();
		Rectangle r = refRectangle();
		Rectangle r2 = wall2.getRectangle();
		Rectangle r4 = wall4.getRectangle();
		Rectangle r5= wall5.getRectangle();
		
		if(r.intersects(r5))
		{
			ax=1;
		}
		if(rec.intersects(r4))
		{
			vy=-1;
		}
		if(r.intersects(r5) || r.intersects(r2))
		{
		   	ax=-1;
		}
		if(rec.intersects(r5) || rec.intersects(r2))
		{
			vx=1;
		}
		
	}
	public void TankDestruction()
	{
		Rectangle r= get2Rectangle();
		Rectangle rec;
		for(Bullets j:b.fireList)
		{
					
          rec=b.fireList.get(b.fireList.size()-1).getRectangle();
          
          if(r.getBounds().intersects(rec))
          {  
        	  j.x=-1000;
        	  j.y=-1000;
        	  speed=0;
        	  label9.setText("3");
        	  incr++;
        	  
        	  if ((incr > 20) || (incr >30))
        	  {
        		  x1=-1500;
        		  y1=-1500;
        		  vx=0;
        		  vy=0;
        		  collision=false;
        		  label9.setText("1");
        		  int Close = JOptionPane.showConfirmDialog(null, "Game Over", "Player1 wins", JOptionPane.OK_CANCEL_OPTION);
      			
      	        if (Close == JOptionPane.CANCEL_OPTION) 
      	        {
      	        	 time.stop();
      	        	 frame.setVisible(false);
      	        	 new Menue();
      	        }
        	  }
        	  else label9.setText("2");
        	  break;
          
		}
          
			}
	}
	public void TankDestruction2()
	{
		Rectangle r= refRectangle();
		Rectangle rec;
		for(Bullets j:b.fireList2)
		{
					
          rec=b.fireList2.get(b.fireList2.size()-1).getRectangle();
          if(r.getBounds().intersects(rec))
          { 
        	  j.x=-1000;
        	  j.y=-1000;
        	  speed1=0;
        	  label12.setText("3");
        	  decr++;
        	  
        	  intersect=false;
              if(decr>40 || decr>50)
              {
            	  x=-1000;
            	  y=-1000;
            	  speed=0;
            	  label12.setText("1");
            	  int Close = JOptionPane.showConfirmDialog(null, "Game Over", "Player2 wins", JOptionPane.OK_CANCEL_OPTION);
        			
        	        if (Close == JOptionPane.CANCEL_OPTION) 
        	        {
        	        	 time.stop();
        	        	 frame.setVisible(false);
        	        	 new Menue();
        	        }
              }
              else label12.setText("2");
          }
          break;
          
		}
		
	}
	public void collisionDetection()
	{
		Rectangle r=null;
		for( DestructiveWalls l :myList)
		{
			Rectangle r1=l.getRectangle();
			for(Bullets k:b.fireList)
			{	
				 r =b.fireList.get(b.fireList.size()-1).getRectangle();
				 if(r1.getBounds().intersects(r))
					{
						l.x=-100;
						l.y=-100;
						k.x=-1000;
						k.y=-1000;
						speed=0;
					}
				 
			}		
      }
		
	}
	public void collisionDetection2()
	{
		Rectangle r=null;
		for( DestructiveWalls l :myList)
		{
			Rectangle r1=l.getRectangle();
			for(Bullets k:b.fireList2)
			{	
				 r =b.fireList2.get(b.fireList2.size()-1).getRectangle();
				 if(r1.getBounds().intersects(r))
					{
						l.x=-100;
						l.y=-100;
						k.x=-1000;
						k.y=-1000;
						speed1=0;
					}
				 
			}		
      }
		
	}
	public void UndestructiveCollision()
	{
		Rectangle r;
		Rectangle r1= wall2.getRectangle();
		Rectangle r2 = wall5.getRectangle();
		Rectangle r3 = wall4.getRectangle();
		for(Bullets k:b.fireList)
		{	
			 r =b.fireList.get(b.fireList.size()-1).getRectangle();
			 if(r1.getBounds().intersects(r))
				{
					k.x=-1000;
					k.y=-1000;
					speed=0;		
				}
			  if(r2.getBounds().intersects(r))
			  {
				    k.x=-1000;
					k.y=-1000;
					speed=0;
			  }
			  if(r3.getBounds().intersects(r))
			  {
				    k.x=-1000;
					k.y=-1000;
					speed=0;
			  }
		}
		
	}
	public void UndestructiveCollision2()
	{
		Rectangle r;
		Rectangle r1= wall2.getRectangle();
		Rectangle r2 = wall5.getRectangle();
		Rectangle r3 = wall4.getRectangle();
		for(Bullets k:b.fireList2)
		{	
			 r =b.fireList2.get(b.fireList2.size()-1).getRectangle();
			 if(r1.getBounds().intersects(r))
				{
					k.x=-1000;
					k.y=-1000;
					speed1=0;		
				}
			  if(r2.getBounds().intersects(r))
			  {
				    k.x=-1000;
					k.y=-1000;
					speed1=0;
			  }
			  if(r3.getBounds().intersects(r))
			  {
				    k.x=-1000;
					k.y=-1000;
					speed1=0;
			  }
		}
		
	}
	public void destructiveCollision()
	{
		Rectangle rec1= get2Rectangle();
		Rectangle rec=refRectangle();
		Rectangle r;
		for(DestructiveWalls w: myList)
		{
			r=w.getRectangle();
			if(r.intersects(rec))
			{
				ax=-1;
			}
			if(r.intersects(rec1))
			{
				vx=1;
			}
			
		}
		
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_A:
		{
			vx=-1;
			vy=0;
			turn1=1;
			try {
				image1=ImageIO.read(getClass().getResourceAsStream("left1.png"));
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}break;
		case KeyEvent.VK_D:
		{
			vx=1;
			vy=0;
			turn1=2;
			try {
				image1=ImageIO.read(getClass().getResourceAsStream("right1.png"));
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}break;
		case KeyEvent.VK_W:
		{
			vy=-1;
			vx=0;
			turn1=3;
			try {
				image1=ImageIO.read(getClass().getResourceAsStream("Up1.png"));
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}break;
		case KeyEvent.VK_S:
		{
			vy=1;
			vx=0;
			turn1=4;
			try {
				image1=ImageIO.read(getClass().getResourceAsStream("down1.png"));
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
		}break;
		case KeyEvent.VK_B:{
			if(pack1==1)
			{
				if(more1<=power1 && more1>0)
				   {
					   fire=true;
						b.fireList2.add(new Bullets(x1+50,y1+50,10,10));
						more1--;
						score1=Integer.toString(more1);
						label6.setText(score1);
						 BulletMusic();				   
					      
				   }
				
			}
			else  {
			if(limit1<=20 && limit1>0)
			{		
			fire2=true;
			b.fireList2.add(new Bullets(x1+50,y1+50,10,10));
			limit1--;
			 power1=20+limit1;
			 more1=power1;
			score1=Integer.toString(limit1);
			label6.setText(score1);
			BulletMusic();
			}
			}
		}break;
		case KeyEvent.VK_LEFT:
		{
			
			turn=2;
			ax=-1;
			ay=0;
			try {
				image=ImageIO.read(getClass().getResourceAsStream("left1.png"));
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
		} break;
		case KeyEvent.VK_RIGHT:
		{
			
			turn=1;
			ax=1;
			ay=0;
			try {
				image=ImageIO.read(getClass().getResourceAsStream("right1.png"));
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}break;
		case KeyEvent.VK_UP:
		{
			
			turn=3;
			ay=-1;
			ax=0;
			try {
				image=ImageIO.read(getClass().getResourceAsStream("Up1.png"));
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}break;
		case KeyEvent.VK_DOWN:
		{
			
			turn=4;
			ay=1;
			ax=0;
			try {
				image=ImageIO.read(getClass().getResourceAsStream("down1.png"));
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}break;
		case KeyEvent.VK_F:
		{
			if(pack==1)
			{
			   if(more<=power && more>0)
			   {
				   fire=true;
					b.fireList.add(new Bullets(x+50,y+50,10,10));
					more--;
					score=Integer.toString(more);
					label3.setText(score);
					 BulletMusic();				   
				      
			   }
			}
			else {
			if(limit<=20 && limit>0)
			{	
			 fire=true;
			b.fireList.add(new Bullets(x+50,y+50,10,10));
			limit--;
		    power=20+limit;
		    more=power;
			score=Integer.toString(limit);
			label3.setText(score);
			 BulletMusic();
			}
			}
		}break;
	    default:
			System.out.println("Enter right key");
		break;
		}

		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		ay=0;
		ax=0;
		vx=0;
		vy=0;
		if(e.getKeyCode()==KeyEvent.VK_F)
		{	mgp.stop(loop);
			fire=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_B)
		{
			mgp.stop(loop);
			fire2=false;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			SaveData.saveGame();
		}
		if(e.getSource()==b2)
		{
			time.stop();
		}
		if(turn==1)
		{
		  speed=18;	
		b.fireRight(speed);
		repaint();
		b.rightRestriction(0);
		}
		if(turn==2)
		{
			speed=18;
			b.fireLeft(speed);
			repaint();
			b.leftRestriction(0);
		}
		if(turn==3)
		{
			speed=18;
			b.fireUp(speed);
			repaint();
			b.UpRestriction(0);
		}
		if(turn==4)
		{
			speed=18;
			b.fireDown(speed);
			repaint();
			b.DownRestriction(0);
		}
		if(turn1==1)
		{
			speed1=18;
		   b.fireLeft2(speed1);
		   repaint();
		   b.leftRestriction2(0);
		}
		if(turn1==2)
		{
			speed1=18;
			b.fireRight2(speed1);
			repaint();
			b.rightRestriction2(0);
		}
		if(turn1==3)
		{
			speed1=18;
			b.fireUp2(speed1);
			repaint();
			b.UpRestriction2(0);
		}
		if(turn1==4)
		{
			speed1=18;
			b.fireDown2(speed1);
			repaint();
			b.DownRestriction2(0);
		}
		if(intersect)
		{
		if(y>565)
			ay=-1;
		if(x>725)
			ax=-1;
		if(y<0)
			ay=1;
		if(x<0)
			ax=1;
		}
		if(collision)
		{		
		if(y1>565)
			vy=-1;
		if(x1>770)
			vx=-1;
		if(y1<0)
			vy=1;
		if(x1<0)
			vx=1;
		}
		x=x+ax;
		y=y+ay;
		x1=x1+vx;
		y1=y1+vy;
		collisionDetection();
		collisionDetection2();
		TankDestruction();
		TankDestruction2();
		WallCollison();
		PowerPackCollision();
		PowerPackFiring();
		destructiveCollision();
		UndestructiveCollision();
		UndestructiveCollision2();
		repaint();
	}
	

}
