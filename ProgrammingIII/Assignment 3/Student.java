/*
 * @author (Ciarán McCarthy)
 * @student id: 17102168
 * @version (28/10/2020)
*/

import java.time.LocalDate;
import java.util.ArrayList;
import java.io.*;

public class Student implements Serializable
{
	//List of variables including serial id
	private static final long serialVersionUID = 4612067019553788491L;
	private int id;
	private String name;
	private String address;
	private String course;
	private LocalDate dateOfBirth;
	//Transient to prevent serialisation
	transient private ArrayList<Grade> grades;
	
	public Student(int id, String name, String address,
			       String course, String dateOfBirth)
	{
		this.name = name;
		this.id = id;
		this.address = address;
		this.course = course;
		//Sets date of birth by parsing the incoming date string
		setDateOfBirth(LocalDate.parse(dateOfBirth));
		//Creates list to store grades
		grades = new ArrayList<Grade>();
	}
	
	//Getter and setter methods for various variables
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return address;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	public String getCourse()
	{
		return course;
	}
	
	public void setCourse(String course)
	{
		this.course = course;
	}
	
	public LocalDate getDateOfBirth()
	{
		return dateOfBirth;
	}
	
	public void setDateOfBirth(LocalDate dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}
	
	public ArrayList<Grade> getGrades()
	{
		return grades;
	}
	
	public void setGrades(String moduleCode, LocalDate date,
			              short percentage)
	{
		//Creates new grade object and sets attributes before adding to list
		Grade grade = new Grade(moduleCode, date, percentage);
		grades.add(grade);
	}
	
	@Override
	public String toString()
	{
		return "ID: " + id + "\nName: " + name + "\nAddress: " + address 
				+ "\nCourse: " + course + "\nDate of birth: " + dateOfBirth;
	}
	
	//Serialise method to read an objects data from file
	private void readObject(ObjectInputStream inputStream)
			throws ClassNotFoundException, IOException
	{
		inputStream.defaultReadObject();
		id = inputStream.readInt();
		name = inputStream.readUTF();
		address = inputStream.readUTF();
		course = inputStream.readUTF();
		//Reads in object and casts to a date
		dateOfBirth = (LocalDate)inputStream.readObject();
	}
	
	//Serialise method to write an objects data to a file
	private void writeObject(ObjectOutputStream outputStream)
			throws IOException
	{
		outputStream.defaultWriteObject();
		outputStream.writeInt(id);
		outputStream.writeUTF(name);
		outputStream.writeUTF(address);
		outputStream.writeUTF(course);
		outputStream.writeObject(dateOfBirth);
	}
}
