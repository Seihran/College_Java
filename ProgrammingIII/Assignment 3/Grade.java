/*
 * @author (Ciarán McCarthy)
 * @student id: 17102168
 * @version (28/10/2020)
*/

import java.io.*;
import java.time.LocalDate;

public class Grade implements Externalizable
{
	//List of variables including serial id
	private static final long serialVersionUID = -554164395869226843L;
	private String moduleCode;
	private LocalDate date;
	private short percentage;
	
	public Grade(String moduleCode, LocalDate date, short percentage)
	{
		this.moduleCode = moduleCode;
		this.date = date;
		this.percentage = percentage;
	}
	
	//Getter and setter methods for various variables
	public String getModuleCode()
	{
		return moduleCode;
	}
	
	public void setModuleCode(String moduleCode)
	{
		this.moduleCode = moduleCode;
	}
	
	public LocalDate getDate()
	{
		return date;
	}
	
	public void setDate(LocalDate date)
	{
		this.date = date;
	}
	
	public short getPercentage()
	{
		return percentage;
	}
	
	public void setPercentage(short percentage)
	{
		this.percentage = percentage;
	}
	
	//ToString method customised for writing to csv file.
	@Override
	public String toString()
	{
		return "," + moduleCode + "," + date +
				     "," + percentage + ",";
	}

	//Serialise method to write an objects data to a file
	//Customised to write only specific variables
	@Override
	public void writeExternal(ObjectOutput out) throws IOException
	{
		out.writeUTF(moduleCode);
		out.writeObject(date);
		out.writeShort(percentage);
	}

	//Serialise method to read an objects data from file
	//Customised to read only specific variables
	@Override
	public void readExternal(ObjectInput in)
		   throws IOException, ClassNotFoundException
	{
		moduleCode = in.readUTF();
		date = (LocalDate)in.readObject();
		percentage = in.readShort();
	}
}
