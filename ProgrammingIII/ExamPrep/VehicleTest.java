import org.joda.money.*;
import java.util.*;

public class VehicleTest
{
	public static void main(String[] args)
	{
		CurrencyUnit EUR = CurrencyUnit.of("EUR");
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		
		Vehicle v1 = new Vehicle("Toyota", "Yaris", Money.of(EUR, 25000), "1995-06-01");
		Vehicle v2 = new Vehicle("Toyota", "Yaris", Money.of(EUR, 25000), "1995-08-01");
		Vehicle v3 = new Vehicle("Nissan", "Juke", Money.of(EUR, 17000), "2007-02-12");
		Vehicle v4 = new Vehicle("Mercedes", "M5", Money.of(EUR, 56000), "2012-07-17");
		Vehicle v5 = new Vehicle("Ford", "Focus", Money.of(EUR, 12000), "2018-12-26");
		
		vehicles.add(v1);
		vehicles.add(v2);
		vehicles.add(v3);
		vehicles.add(v4);
		vehicles.add(v5);
		
		Collections.sort(vehicles);
		
		Comparator<Vehicle> compareManufactureDate = new Comparator<Vehicle>()
		{
			@Override
			public int compare(Vehicle p, Vehicle r)
			{
				return p.getManufactureDate().compareTo(r.getManufactureDate());
			}
		};
		
		Collections.sort(vehicles, compareManufactureDate.reversed());
		
		System.out.println(vehicles);
		
		Comparator<Vehicle> compareBrand = (Vehicle p, Vehicle r) ->
		  p.getBrand().compareTo(r.getBrand());
		  
		Collections.sort(vehicles, compareBrand);
		
		System.out.println(vehicles);
		
		Collections.sort(vehicles);
		
		Vehicle v6 = new Vehicle("Fiat", "Panda", Money.of(EUR, 11000), "2014-10-03");
		
		vehicles.add(v6);
		
		int index = Collections.binarySearch(vehicles, v6);
		
		Map<Money, Vehicle> map = new HashMap<Money, Vehicle>();

		for (int i=0; i<vehicles.size(); i++)
		{
			map.put(vehicles.get(i).getCost(), vehicles.get(i));
			Collections.sort(vehicles);
		}
		
		System.out.println(vehicles);
		System.out.println(index + " " + v6);
	}
}
