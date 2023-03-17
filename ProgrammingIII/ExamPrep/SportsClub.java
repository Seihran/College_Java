import java.util.*;
import java.io.*;

public class SportsClub implements Serializable
{
	private static final long serialVersionUID = 1L;
	private ArrayList<Member> members;
	private String clubName;
	
	public SportsClub(String clubName)
	{
		this.clubName = clubName;
		members = new ArrayList<Member>();
	}
	
	public void addMember(String name)
	{
		Member mem = new Member(name);
		System.out.println(mem);
		members.add(mem);
		Collections.sort(members);
	}
	
	public void removeMember(String name)
	{
		for (int i=0; i<members.size(); i++)
		{
			if(members.get(i).getName().equals(name))
			{
				members.remove(i);
				Collections.sort(members);
			}
		}
	}
	
	public void listOfMembers()
	{
		System.out.println(clubName + "\nList of Members: " + members);
	}
	
	private void readObject(ObjectInputStream inputStream)
			throws ClassNotFoundException, IOException
	{
		inputStream.defaultReadObject();
	}
	
	//Serialise method to write an objects data to a file
	private void writeObject(ObjectOutputStream outputStream)
			throws IOException
	{
		outputStream.defaultWriteObject();
	}
}
