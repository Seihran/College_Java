
public class Student implements Comparable<Student>
{
	private static long baseId = 0;
	private long id;
	private String fName;
	private String lName;
	
	public Student(String fName, String lName)
	{
		this.fName = fName;
		this.lName = lName;
		setID(baseId + 1);
	}
	
	public long getID()
    {
		return id;
	}

	public void setID(long id)
	{
		this.id = id;
		baseId = baseId + 1;
	}
	
	public String getFName()
	{
		return fName;
	}
	
	public String getLName()
	{
		return lName;
	}
	
	public String toString()
	{
		return fName + " " + lName + " " + id;
	}
	
	@Override
	public int compareTo(Student o)
	{
		int lNum = this.lName.compareTo(o.getLName());
		int fNum = this.fName.compareTo(o.getFName());
		if (lNum != 0)
		{
			return lNum;
		}
		else
		{
			return fNum;
		}
	}
}
