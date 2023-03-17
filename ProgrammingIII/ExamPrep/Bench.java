import java.util.ArrayList;

public class Bench
{
	private Customer customer;
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	
	public Customer get()
	{
		Customer c = customer;
		customers.remove(0);
		return c;
	}
	
	public void add(Customer customer)
	{
		this.customer = customer;
		customers.add(customer);
	}
}
