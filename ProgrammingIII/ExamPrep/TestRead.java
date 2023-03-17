import java.io.*;
import java.util.ArrayList;

public class TestRead {

	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		try
		{
			ArrayList<Object> employeesRead = new ArrayList<Object>();
			FileInputStream fis = new FileInputStream("Employees.bin");
		    ObjectInputStream ois = new ObjectInputStream(fis);
		    employeesRead = (ArrayList<Object>) ois.readObject();
		    
		    BufferedReader br = new BufferedReader(new FileReader("Pay.csv"));
		    String line = "";
		    String output = "";
		    String outputPay = "WeeklyPay:\n";
		    String[] pay = null;
		    int j = 0;
		    
		    while ((line = br.readLine()) != null)
	    	{
	    		pay = line.split(",");
	    		outputPay += ((Employee) employeesRead.get(j)).getIdNumber() + " ";
	    		outputPay += pay[0].subSequence((pay[0].length()-6), pay[0].length()) + " ";
	    		j++;
	    	}
		    
		    for (int i=0; i<employeesRead.size();i++)
		    {
		    	output += employeesRead.get(i).toString().replace("[", "").replace("]", "") + "\n\n";
		    }
		    
		    br.close();	
		    fis.close();
		    
		    System.out.println(output);
		    System.out.println(outputPay);
		}
		catch (IOException ex)
	    {
	      System.out.println("Some error occured...");
	      ex.printStackTrace();
	    }
	    catch (ClassNotFoundException ex)
	    {
	      System.out.println("Class not found...");
	      ex.printStackTrace();
	    }
	}

}
