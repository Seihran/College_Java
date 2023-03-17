/*
 * @author (Ciarán McCarthy)
 * @student id: 17102168
 * @version (02/12/2020)
 * 
*/

import java.util.concurrent.LinkedBlockingQueue;

public class Technician extends Thread
{
	//Variables to store name of assistant, finished flag and
	//Array for amounts of each job assigned and the total
	private String name;
	private int[] jobs = {0, 0, 0};
	private int jobsTotal = 0;
	private boolean finished;
	private LinkedBlockingQueue<Object> toFix;
	
	//Assigns linked queue sent in of jobs to be fixed and flag
	public Technician(String name, LinkedBlockingQueue<Object> toFix)
	{
		this.name = name;
		this.toFix = toFix;
		finished = false;
	}
	
	//Overrides the run function
	@Override
	public synchronized void run()
	{
		//While finished flag hasn't been set to true
		while (finished == false)
		{
			try
			{
				//If to be fixed queue is not empty
				if (toFix.isEmpty() != true)
				{
					//Casts queue object as job
					Job job = (Job)toFix.take();
					//Checks type of job and increases counter accordingly
					if (job.getJob().contains("Battery"))
					{
						jobs[0]++;
					}
					else if (job.getJob().contains("Screen"))
					{
						jobs[1]++;
					}
					else if (job.getJob().contains("Keyboard"))
					{
						jobs[2]++;
					}
					//Checks if job is the "Done" flag
					else if (job.getJob().contains("Done"))
					{
						sleep(10);
						finished = true;
					}
					
					jobsTotal++;
					//Outputs the job details
					System.out.println("Technician " + name + " is fixing " + job.getJob());
					//Sleeps for a random amount of time between 0 and 1/100 of a second
					sleep((int)Math.random()*10);
				}
				//If to be fixed queue is empty, sleeps for a period of time
				sleep((int)Math.random()*10);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	//Output of overall for end result
	@Override
	public String toString()
	{
		return "Technician " + name + " finished fixing " + jobsTotal
				+ " orders including " + jobs[0] + " battery issues, "
				+ jobs[1] + " screen cracks and " + jobs[2] + " keyboard issues.";
	}
}
