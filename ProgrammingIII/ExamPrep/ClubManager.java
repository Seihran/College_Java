import java.io.*;

public class ClubManager {

	public static void main(String[] args)
	{
		SportsClub manU = new SportsClub("Manchester United");
		
		manU.addMember("John Smith");
		manU.addMember("Tom Scott");
		manU.addMember("Terry Williams");
		
		manU.listOfMembers();
		
		manU.removeMember("Tom Scott");
		
		manU.listOfMembers();
		
		try
		{
			FileOutputStream fos = new FileOutputStream("SportsClub.bin");
		    ObjectOutputStream oos = new ObjectOutputStream(fos);
		    oos.writeObject(manU);
		    oos.close();
		}
		catch (IOException ex)
	    {
	      System.out.println("Some error occured...");
	      ex.printStackTrace();
	    }
		
		try
		{
			FileInputStream fis = new FileInputStream("SportsClub.bin");
		    ObjectInputStream ois = new ObjectInputStream(fis);
		    
		    SportsClub manURead;
		    manURead = (SportsClub) ois.readObject();
		    
		    manURead.listOfMembers();
		    
		    ois.close();
		}
		//Catches errors when reading file
		catch (IOException ex)
	    {
	      System.out.println("Some error occured...");
	      ex.printStackTrace();
	    }
		//Catches error if class expected in file not found
	    catch (ClassNotFoundException ex)
	    {
	      System.out.println("Class not found...");
	      ex.printStackTrace();
	    }
	}
}
