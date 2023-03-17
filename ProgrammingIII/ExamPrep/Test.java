import java.io.*;
import java.util.ArrayList;

public class Test
{
	public static void main(String[] args)
	{
		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		Employee em1 = new Employee("John Smith", "Manager", (float) 1200.00);
		employees.add(em1);
		Employee em2 = new Employee("Greg James", "Secretary", (float) 750.00);
		employees.add(em2);
		Employee em3 = new Employee("Alice Levine", "HR", (float) 920.00);
		employees.add(em3);
		Employee em4 = new Employee("Emily Friggs", "IT Supervisor", (float) 840.00);
		employees.add(em4);
		Employee em5 = new Employee("Alan Reese", "Cleaner", (float) 550.00);
		employees.add(em5);
		
		try
		{
			FileOutputStream fos = new FileOutputStream("Employees.bin");
		    ObjectOutputStream oos = new ObjectOutputStream(fos);		    
		    FileOutputStream fosPay = new FileOutputStream("Pay.csv");
		    ObjectOutputStream oosPay = new ObjectOutputStream(fosPay);
		    
		    oos.writeObject(employees);
		    for (int i=0; i<employees.size(); i++)
		    {
		    	oosPay.writeObject(Integer.toString(employees.get(i).getIdNumber())
		    			+ Float.toString(employees.get(i).getWeeklyPay()) + "\n");
		    }
		    
		    oos.close();
		    oosPay.close();
		}
		catch (IOException ex)
	    {
	      System.out.println("Some error occured...");
	      ex.printStackTrace();
	    }
	}
}
