/*
 * Creates a list of different types of employee and calculates their monthly earnings
 * with an exception if those earnings are below 100
 * 
 * @author (Ciarán McCarthy)
 * @student id: 17102168
 * @version (17/10/2020)
*/
// Driver for Employee hierarchy

// Java extension packages
import java.util.ArrayList;
import javax.swing.JOptionPane;

import java.math.RoundingMode;
import java.time.LocalDate;
import org.joda.money.*;

public class Test
{

    // test Employee hierarchy
    public static void main(String args[])
    {
        //Creates array to store employee objects
        ArrayList<Employee> employees = new ArrayList<Employee>();
        //Creates variable with now's date
        LocalDate date = LocalDate.now();
        Money earnings = null;
        
        String output = "";

        Boss boss = new Boss("John", "Smith", "1997-03-04", 800.0);
        employees.add(boss);

        CommissionWorker commissionWorker = new CommissionWorker("Sue", "Jones", "2004-12-12", 400.0, 3.0, 150);
        employees.add(commissionWorker);

        PieceWorker pieceWorker = new PieceWorker("Bob", "Lewis", "2011-07-01", 2.5, 2);
        employees.add(pieceWorker);

        HourlyWorker hourlyWorker = new HourlyWorker("Karen", "Price", "2018-01-02", 13.75, 40);
        employees.add(hourlyWorker);
        
        //Loops through all employees
        for (int i=0; i<employees.size(); i++)
    	{
        	try
        	{
        		//Adds €200 bonus if they have been employed for > 5 years
        		//Uses an implemented class method
        		earnings = employees.get(i).earnings(employees.get(i));
        		earnings = (employees.get(i).getJoinDate().isBefore(date.plusYears(-5)) == true ?
        				    earnings.plus(200) : earnings);
        		output += employees.get(i).toString() + " earned " + earnings + "\n";
        	}
        	catch (LowWageException ex)
        	{
        		//Catches exception and prints error message with details
        		output += ex.getMessage() + "\n";
        		ex.printStackTrace();
    		}
        }
        
        output += "\n";
        
        //Anonymous inner class to calculate tax at 30%
        TaxCalculator anonInner = new TaxCalculator()
        {
			@Override
			public Money calculateTax(Money earnings, Money taxCredits)
			{
				return earnings.multipliedBy(0.3d, RoundingMode.DOWN).minus(taxCredits);
			}
		};
		
		for (int i=0; i<employees.size(); i++)
    	{
        	try
        	{
        		//Adds €200 bonus if they have been employed for > 5 years
        		//Uses an anonymous inner class method
        		earnings = employees.get(i).earnings(anonInner);
        		earnings = (employees.get(i).getJoinDate().isBefore(date.plusYears(-5)) == true ?
        				    earnings.plus(200) : earnings);
        		output += employees.get(i).toString() + " earned " + earnings + "\n";
        	}
        	catch (LowWageException ex)
        	{
        		//Catches exception and prints error message with details
        		output += ex.getMessage() + "\n";
        		ex.printStackTrace();
    		}
        }
		
		output += "\n";
		
		//Lambda expression to calculate tax at 50%
		TaxCalculator lambdaFun = (earning, taxCredits) ->
		{
			return earning.multipliedBy(0.5d, RoundingMode.DOWN).minus(taxCredits);
		};
		
		for (int i=0; i<employees.size(); i++)
    	{
        	try
        	{
        		//Adds €200 bonus if they have been employed for > 5 years
        		//Uses a lambda expression
        		earnings = employees.get(i).earnings(lambdaFun);
        		earnings = (employees.get(i).getJoinDate().isBefore(date.plusYears(-5)) == true ?
        				    earnings.plus(200) : earnings);
        		output += employees.get(i).toString() + " earned " + earnings + "\n";
        	}
        	catch (LowWageException ex)
        	{
        		//Catches exception and prints error message with details
        		output += ex.getMessage() + "\n";
        		ex.printStackTrace();
    		}
        }

        JOptionPane.showMessageDialog(null, output.replace("EUR", "€"),
                "Demonstrating Polymorphism",
                JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
} // end class Test
