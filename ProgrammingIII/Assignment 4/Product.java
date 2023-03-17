/*
 * @author (Ciarán McCarthy)
 * @student id: 17102168
 * @version (06/11/2020)
*/

import org.joda.money.*;

public class Product implements Comparable<Product>
{
	public long itemCode;
	public String itemName;
	public Money itemCost;
	public String description;
	public int inventory;
	CurrencyUnit EUR = CurrencyUnit.of("EUR");
	
	public Product(long itemCode, String itemName,
			       Money itemCost, String description, int inventory)
	{
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.itemCost = itemCost;
		this.description = description;
		this.inventory = inventory;
	}
	
	//Getter methods
	public long getItemCode()
	{
		return itemCode;
	}
	
	public String getItemName()
	{
		return itemName;
	}
	
	public Money getItemCost()
	{
		return itemCost;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public int getInventory()
	{
		return inventory;
	}
	
	@Override
	public String toString()
	{
		String output = "Item Code: " + itemCode + "\nItem Name: " + itemName
				+ "\nItem Cost: " + itemCost + "\nDescription: " + description
				+ "\nInventory Left: " + inventory + "\n";
		return output.replace("EUR", "€");
	}
	
	//Equals method
	public boolean equals(Object o)
	{
		//If incoming object is this object return equal
		if (this == o) return true;
		//If object is empty return not equal or
		//if object is not the same class return not equal
		if (o == null || getClass() != o.getClass()) return false;
		
		//Cast object as this class
		Product p = (Product) o;
		//If object's itemCode, itemName and itemCost are equal to this' values
		if ((this.itemCode == p.getItemCode()) &&
			(this.itemName == p.getItemName()) &&
			(this.itemCost == p.getItemCost()))
		{
			return true;
		}
		else return false;
	}
	
	//Overrides hashcode method for determining whether two instances are equal
	public int hashcode()
	{
		int prime = 31;
		int result = 1;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
	    result = prime * result + ((description == null) ? 0 : description.hashCode());    
	    return result;
	}

	//Overrides compare method from interface Comparable
	@Override
	public int compareTo(Product p)
	{
		//Compares the values of itemCode
		return Long.compare(this.itemCode, p.getItemCode());
	}
}
