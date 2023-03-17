/*
 * @author (Ciarán McCarthy)
 * @student id: 17102168
 * @version (02/12/2020)
 * 
*/

public class Job
{
	private String name;
	
	//Stores type of job as name of job
	public Job(String name)
	{
		this.name = name;
	}
	
	//Getter method for type of job
	public String getJob()
	{
		return name;
	}
}
