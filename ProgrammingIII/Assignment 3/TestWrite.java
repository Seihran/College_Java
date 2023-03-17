/*
 * @author (Ciarán McCarthy)
 * @student id: 17102168
 * @version (28/10/2020)
 * 
 * Creates five different students and adds them a list and serialises that list
 * Also creates a series of grades for each student and writes them to a csv file in text format
*/

import java.time.LocalDate;
import java.util.ArrayList;
import java.io.*;

public class TestWrite
{
	public static void main(String[] args)
	{
		//Creates date for grade objects
		LocalDate date = LocalDate.now();
		//Creates list for student objects
		ArrayList<Student> students = new ArrayList<Student>();
		
		//Creates five students and adds them to list
		Student John = new Student(15234856, "John", "23 Mulcahy Drive", "GY301",
				                   "1997-05-12");
		students.add(John);
		Student Alice = new Student(16293488, "Alice", "15 Autumn Lane", "GY320",
                                    "1998-11-02");
		students.add(Alice);
		Student Oscar = new Student(18235273, "Oscar", "2 Spring Avenue", "GY319",
                                    "2000-02-23");
		students.add(Oscar);
		Student Clarice = new Student(14837482, "Clarice", "44 Summer Street", "GY321",
                                      "1996-07-28");
		students.add(Clarice);
		Student Brian = new Student(20123875, "Brian", "102 Winter Corner", "GY350",
                                    "2002-01-03");
		students.add(Brian);
		
		//Creates grades for each student
		John.setGrades("M121", date, (short) 54);
		John.setGrades("B412", date, (short) 68);
		John.setGrades("C213", date, (short) 51);
		Alice.setGrades("M121", date, (short) 67);
		Alice.setGrades("PH234", date, (short) 74);
		Oscar.setGrades("M121", date, (short) 78);
		Oscar.setGrades("CP220", date, (short) 44);
		Clarice.setGrades("M121", date, (short) 32);
		Clarice.setGrades("L327", date, (short) 62);
		Clarice.setGrades("L346", date, (short) 82);
		Brian.setGrades("M121", date, (short) 66);
		Brian.setGrades("CP220", date, (short) 71);
		
		try
		{
			//Opens output streams to serialise student list and grades
			//Names of files specified in command line upon execution
			FileOutputStream fos = new FileOutputStream(args[0]);
		    ObjectOutputStream oos = new ObjectOutputStream(fos);		    
		    FileOutputStream fosGrades = new FileOutputStream(args[1]);
		    ObjectOutputStream oosGrades = new ObjectOutputStream(fosGrades);
		    //Serialises students list
		    oos.writeObject(students);
		    
		    //Loops through students list and grades list of each student object
		    //And serialises the resultant grades toString method plus
		    //A string version of that students id number
		    for (int i=0; i<students.size(); i++)
			{	
		    	for (int j = 0; j < students.get(i).getGrades().size(); j++)
			    {
			    	oosGrades.writeObject(Integer.toString(students.get(i).getId())
			    			+ students.get(i).getGrades().get(j).toString() + "\n");
			    }
			}
		    
		    //Closes streams
		    oos.close();
		    oosGrades.close();
		}
		//Catches errors occurring during serialisation
		catch (IOException ex)
	    {
	      System.out.println("Some error occured...");
	      ex.printStackTrace();
	    }
	}
}
