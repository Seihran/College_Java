/*
 * @author (Ciarán McCarthy)
 * @student id: 17102168
 * @version (06/11/2020)
 * 
 * Reads product details from a csv file called products.csv and returns that list
*/

import java.io.*;
import org.joda.money.*;
import java.util.ArrayList;

public class CsvReader
{
	CurrencyUnit EUR = CurrencyUnit.of("EUR");
	
	public ArrayList<Product> readFile()
	{
		//List to store details as individual product objects
		ArrayList<Product> products = new ArrayList<Product>();
		
		try
		{
			//Accesses csv file
			BufferedReader br = new BufferedReader(new FileReader("products.csv"));
			String line = "";
			String[] product = null;
			
			//While there is still information in file, loop
			while ((line = br.readLine()) != null)
			{
				product = line.split(",");
				//Creates a new product object and passes the read information from file into
				//it's constructor
				//Parses the first as a long for itemCode, substrings the third to remove currency
				//before parsing as a double and then converts to Money of currency EUR
				//Parse the fifth as an integer for quantity of inventory
				Product pro = new Product(Long.parseLong(product[0]), product[1],
						                  Money.of(EUR, Double.parseDouble(product[2].substring(4))),
						                  product[3], Integer.parseInt(product[4]));
				//Adds new product object to list
				products.add(pro);
			}
			
			//Closes stream
			br.close();
		}
		//Catches errors when reading file
		catch (IOException ex)
		{
			System.out.println("Some error occured...");
			ex.printStackTrace();
		}
		
		return products;
	}
}
