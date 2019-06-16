package FinalProject;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Menue extends JPanel implements ActionListener {

	private JButton load,start,exit;
	private static JFrame frame;
	Board b;
	public Menue()
	{
		// New game button
		start= new JButton("New Game");
		start.setSize(200, 70);
		start.setLocation(200, 10);
		// continue
		load = new JButton("Continue");
		load.setSize(200, 70);
		load.setLocation(200,100 );
		// exit button
		exit = new JButton("Exit");
		exit.setSize(200, 70);
		exit.setLocation(200, 200);
		
		 frame = new JFrame();
		 frame.add(start);
			frame.add(load);
			frame.add(exit);
		 frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());
        frame.add(this, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		// actionListener
		start.addActionListener(this);
		load.addActionListener(this);
		exit.addActionListener(this);
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==start)
		{
			 b = new Board();
			 frame.setVisible(false);
		}
		if(e.getSource()==load)
		{
			try {
				SaveData.LoadGame();
			} catch (ClassNotFoundException | IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("Graphics not found");
			}
		}
		if(e.getSource()==exit)
		{
             int Close = JOptionPane.showConfirmDialog(null, "Do you want to Quit?", "Yes & No", JOptionPane.YES_NO_OPTION);
			
	        if (Close == JOptionPane.YES_OPTION) 
	        {
		        System.exit(0);
	        }
		}
		
	}


        
	

}
