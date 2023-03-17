/*
 * @author (Ciarán McCarthy)
 * @student id: 17102168
 * @version (28/10/2020)
 * 
 * Reads in data from a specified student information file and
 * their grades from a separate csv file and then displays this
 * information.
*/

import java.util.ArrayList;
import java.awt.*;
import java.io.*;
import javax.swing.*;

public class TestRead
{
	//Suppresses warnings about unchecked casts when reading objects as an ArrayList
	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		try
		{
			//Creates a list to store list read from file
			ArrayList<Object> students = new ArrayList<Object>();
			//Reads from file specified in command line when executed
		    FileInputStream fis = new FileInputStream(args[0]);
		    ObjectInputStream ois = new ObjectInputStream(fis);
		    students = (ArrayList<Object>) ois.readObject();
		    //Reads from csv file specified in command line
		    BufferedReader br = new BufferedReader(new FileReader(args[1]));
		    
		    //Creates strings to store read information
		    String line = "";
		    String output = "";
		    String outputGrades = "Grades:\n";
		    String[] grade = null;
		    
		    //While reading from csv file, continue until no information found
	    	while ((line = br.readLine()) != null)
	    	{
	    		//Splits information read to string based on commas found
	    		grade = line.split(",");
	    		//Appends to string the student id and grade information from each line
	    		outputGrades += grade[0].subSequence((grade[0].length()-8), grade[0].length())
	    				        + ":\n\b\b\b\b" + grade[1] + ", " + grade[2] + ", " + grade[3] + "\n\n";
	    	}
	    	
	    	//Closes streams
	    	br.close();	
		    fis.close();
		    
		    //Loops over student list to extract information and append to string
		    //Also removes square brackets created by ArrayList
		    for (int i=0; i<students.size();i++)
		    {
		    	output += students.get(i).toString().replace("[", "").replace("]", "") + "\n\n";
		    }
		    
		    //Creates text areas filled with the strings created when files were read
		    JTextArea textArea = new JTextArea(output);
		    JTextArea textAreaGrades = new JTextArea(outputGrades);
		    //Creates two side by side panels to hold text
		    JPanel panel = new JPanel(new GridLayout(0, 2));
		    panel.add(textArea);
		    panel.add(textAreaGrades);
		    //Creates a scroll pane and adds text panels
		    JScrollPane scrollPane = new JScrollPane(panel);
		    //Specifies size of pane
		    scrollPane.setPreferredSize( new Dimension( 380, 400 ) );
		    JOptionPane.showMessageDialog(null, scrollPane, "Reading student information from file storage",  
		                                           JOptionPane.INFORMATION_MESSAGE);
		}
		//Catches errors when reading file
		catch (IOException ex)
	    {
	      System.out.println("Some error occured...");
	      ex.printStackTrace();
	    }
		//Catches error if class expected in file not found
	    catch (ClassNotFoundException ex)
	    {
	      System.out.println("Class not found...");
	      ex.printStackTrace();
	    }
	}
}
