/*
 * @author (Ciar�n McCarthy)
 * @student id: 17102168
 * @version (06/11/2020)
 * 
 * Gets list of products from a file and then uses various methods
 * (class implementation, anonymous inner class, lambda expression)
 * to sort them using collections in ascending and descending order,
 * then displays each
*/

import java.util.*;
import javax.swing.*;
import org.joda.money.*;

public class Test
{
	public static void main(String[] args)
	{
		CurrencyUnit EUR = CurrencyUnit.of("EUR");
		ArrayList<Product> products = new ArrayList<Product>();
		//Calls class to read file
		CsvReader file = new CsvReader();
		products = file.readFile();
		
		//Sorts the list in natural order (itemCode)
		Collections.sort(products);
		//Assigns sorted list to text area
		JTextArea textArea = new JTextArea(products.toString().replace("[", "")
		           .replace("]", "").replace(", ", "\n"));
		
		//Anonymous inner class method to compare products by cost
		Comparator<Product> compareCost = new Comparator<Product>()
		{
			@Override
			public int compare(Product p, Product r)
			{
				return p.getItemCost().compareTo(r.getItemCost());
			}
		};
		
		//Sorts products using anonymous class in descending order
		Collections.sort(products, compareCost.reversed());
		//Assigns sorted list to text area
		JTextArea textArea1 = new JTextArea(products.toString().replace("[", "")
		           .replace("]", "").replace(", ", "\n"));
		
		//Lambda expression method to compare products by inventory quantity
		Comparator<Product> compareInv = (Product p, Product r) ->
										  Integer.compare(p.getInventory(), r.getInventory());
										  
		//Sorts products using lambda method in ascending order
		Collections.sort(products, compareInv);
		JTextArea textArea2 = new JTextArea(products.toString().replace("[", "")
		           .replace("]", "").replace(", ", "\n"));
		
		//Creates new Product
		Product newProduct = new Product(14326661356L, "Red Wine", Money.of(EUR, 34),
										 "Cabernet Sauvignon", 140);
		//Adds new product to list
		products.add(newProduct);
		
		//Sorts list by cost
		Collections.sort(products, compareCost);
		//Searches list for new added product and returns it's index value
		int index = Collections.binarySearch(products, newProduct, compareCost);
		
		//Creates a hashmap where itemCode is key and Product object is value
		Map<Long, Product> map = new HashMap<Long, Product>();
		//Loops to add list of products to map
		for (int i=0; i<products.size(); i++)
		{
			map.put(products.get(i).getItemCode(), products.get(i));
		}
		//Adds index found using binary search to string
		//Adds products found using map.get(key) method to string
		String out = "Red Wine at index: " + index + "\n\n"
					 + map.get(14326661356L) + "\n" + map.get(29301001122L);
		JTextArea textArea3 = new JTextArea(out);
		
		//Creates a new class to display output and passes each textArea
		new OutputGUI(textArea, textArea1, textArea2, textArea3);
	}
}
