/*
 * @author (Ciarán McCarthy)
 * @student id: 17102168
 * @version (02/12/2020)
 * 
*/

import java.util.concurrent.LinkedBlockingQueue;

public class Assistant extends Thread
{
	//Variables to store name of assistant and
	//Array for amounts of each job assigned and the total
	private String name;
	private int[] jobs = {0, 0, 0};
	private int jobsTotal = 0;
	private LinkedBlockingQueue<String> issues;
	private LinkedBlockingQueue<Object> toFix;
	
	//Assigns linked queues sent in of issues and jobs to be fixed
	public Assistant(String name, LinkedBlockingQueue<String> issueList,
					 LinkedBlockingQueue<Object> toFix)
	{
		this.name = name;
		issues = issueList;
		this.toFix = toFix;
	}
	
	//Overrides the run function
	@Override
	public synchronized void run()
	{
		//While there are still issues to be assigned
		while (issues.isEmpty() != true)
		{
			try
			{
				//Creates job and assigns issue at head of queue
				//while removing head
				Job job = new Job(issues.take());
				//Outputs the details of the job
				System.out.println("Assistant " + name + " is receiving " + job.getJob());
				//Increases counters based on type of job
				if (job.getJob().contains("Battery"))
				{
					jobs[0]++;
				}
				else if (job.getJob().contains("Screen"))
				{
					jobs[1]++;
				}
				else
				{
					jobs[2]++;
				}
				//Increases total
				jobsTotal++;
				//Assigns job to the to be fixed queue
				toFix.add(job);
				//Sleeps for 1/10 of a second
				sleep(100);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		//Assigns a "Done" job once the issues are all assigned
		Job job = new Job("Done");
		toFix.add(job);
	}
	
	//Output of overall for end result
	@Override
	public String toString()
	{
		return "Assistant " + name + " finished receiving " + jobsTotal
				+ " orders including " + jobs[0] + " battery issues, "
				+ jobs[1] + " screen cracks and " + jobs[2] + " keyboard issues.";
	}
}
