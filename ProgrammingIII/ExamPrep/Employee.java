import java.io.*;
import java.time.LocalDate;

public class Employee implements Serializable
{
	private static final long serialVersionUID = 8091904743354453581L;
	private static int baseId;
	private int idNumber;
	private String name;
	private LocalDate startDate;
	private String jobTitle;
	transient private float weeklyPay;
	
	public Employee(String name, String jobTitle, float weeklyPay)
	{
		this.name = name;
		this.jobTitle = jobTitle;
		this.weeklyPay = weeklyPay;
		setStartDate();
        setIdNumber(baseId + 1);
	}

	public int getIdNumber()
	{
		return idNumber;
	}

	public void setIdNumber(int idNumber)
	{
		this.idNumber = idNumber;
		baseId = baseId + 1;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public LocalDate getStartDate()
	{
		return startDate;
	}

	public void setStartDate()
	{
		startDate = LocalDate.now();
	}

	public String getJobTitle()
	{
		return jobTitle;
	}

	public void setJobTitle(String jobTitle)
	{
		this.jobTitle = jobTitle;
	}

	public float getWeeklyPay()
	{
		return weeklyPay;
	}

	public void setWeeklyPay(float weeklyPay)
	{
		this.weeklyPay = weeklyPay;
	}
	
	private void readObject(ObjectInputStream inputStream)
			throws ClassNotFoundException, IOException
	{
		inputStream.defaultReadObject();
		idNumber = inputStream.readInt();
		name = inputStream.readUTF();
		jobTitle = inputStream.readUTF();
		startDate = (LocalDate)inputStream.readObject();
	}
	
	private void writeObject(ObjectOutputStream outputStream)
			throws IOException
	{
		outputStream.defaultWriteObject();
		outputStream.writeInt(idNumber);
		outputStream.writeUTF(name);
		outputStream.writeUTF(jobTitle);
		outputStream.writeObject(startDate);
	}

	@Override
	public String toString() {
		return "Employee [idNumber=" + idNumber + ", name=" + name + ", startDate=" + startDate + ", jobTitle="
				+ jobTitle + ", weeklyPay=" + weeklyPay + "]";
	}
}
