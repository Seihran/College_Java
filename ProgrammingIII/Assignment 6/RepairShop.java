/*
 * @author (Ciarán McCarthy)
 * @student id: 17102168
 * @version (02/12/2020)
 * 
 * Simulates the operation of a repair shop using multi-threaded processing and
 * linked blocking queues
*/

import java.util.concurrent.LinkedBlockingQueue;
import java.io.*;
import java.util.Scanner;

public class RepairShop
{	
	public static void main(String args[])
	{
		//Creates a linked queue for issues read in from file and
		//A queue for jobs to be fixed
		LinkedBlockingQueue<String> issues = new LinkedBlockingQueue<String>();
		LinkedBlockingQueue<Object> toFix = new LinkedBlockingQueue<Object>();
		try
		{
			//Creates file from txt file
			File file = new File("issueList.txt");
			//Creates scanner using file
			Scanner sc = new Scanner(file);
			//Assigns lines from file to linked queue until
			//There are no more lines to be read
			while (sc.hasNextLine())
			{
				issues.add(sc.nextLine());
			}
			//Closes scanner
			sc.close();
		}
		//Catches errors when reading file
		catch (IOException ex)
		{
		     System.out.println("Some error occured...");
		     ex.printStackTrace();
		}
		
		//Creates Assistants and Technicians
		Assistant Mark = new Assistant("Mark", issues, toFix);
		Assistant Kate = new Assistant("Kate", issues, toFix);
		
		Technician Andrew = new Technician("Andrew", toFix);
		Technician Emily = new Technician("Emily", toFix);
		
		//Starts threads
		Mark.start();
		Kate.start();
		Andrew.start();
		Emily.start();
		
		try
		{
			//While there are still issues to be assigned, sleeps
			while (issues.isEmpty() != true)
			{
				Thread.sleep(1000);
			}
			//Outputs results at end and exits
			System.out.println(Mark);
			System.out.println(Kate);
			System.out.println(Andrew);
			System.out.println(Emily);
			System.exit(1);
		}
		//Catches interruptions thrown
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
