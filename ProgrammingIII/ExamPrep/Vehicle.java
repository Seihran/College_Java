import java.time.LocalDate;
import org.joda.money.*;

public class Vehicle implements Comparable<Vehicle>
{
	private String brand;
	private String name;
	private LocalDate manufactureDate;
	private Money cost;
	CurrencyUnit EUR = CurrencyUnit.of("EUR");
	
	public Vehicle(String brand, String name, Money cost, String date)
	{
		this.brand = brand;
		this.name = name;
		this.cost = cost;
		setManufactureDate(LocalDate.parse(date));
	}

	@Override
	public String toString() {
		return "Vehicle [brand=" + brand + ", name=" + name + ", manufactureDate=" + manufactureDate + ", cost=" + cost
				+ ", EUR=" + EUR + "]";
	}

	public String getBrand()
	{
		return brand;
	}

	public void setBrand(String brand)
	{
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public LocalDate getManufactureDate()
	{
		return manufactureDate;
	}

	public void setManufactureDate(LocalDate manufactureDate)
	{
		this.manufactureDate = manufactureDate;
	}

	public Money getCost()
	{
		return cost;
	}

	public void setCost(Money cost)
	{
		this.cost = cost;
	}

	@Override
	public int compareTo(Vehicle v)
	{
		return (this.cost.compareTo(v.getCost()));
	}
	
	public int hashCode()
	{
		int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Vehicle other = (Vehicle) obj;
		
		if ((this.name == other.getName())   &&
			(this.brand == other.getBrand()) &&
			(this.cost == other.getCost()))
			{
				return true;
			}
		else return false;
	}
}
