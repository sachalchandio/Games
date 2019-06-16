package FinalProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;





public class SaveData {

	public static void saveGame()
	{
		Board s;
		try {
		 s = new Board();
		 File f = new File("save.txt");
		FileOutputStream fos= new FileOutputStream(f);
	    ObjectOutputStream obj = new ObjectOutputStream(fos);
	    obj.writeObject(s);
		}catch(IOException e1)
		{
		  //e1.printStackTrace();	
		  System.out.println("graphics not found");
		}
	}
	
	public static void LoadGame() throws IOException, ClassNotFoundException
	{
		try {
			File f=new File("save.txt");
			FileInputStream fos1 = new FileInputStream(f);
			 ObjectInputStream obj1 = new ObjectInputStream(fos1);
			    Board obje1 = (Board) obj1.readObject();
			    System.out.println(obje1);
			    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("graphics not found");
		}
	   
	  	
	}
		
	
	
}
