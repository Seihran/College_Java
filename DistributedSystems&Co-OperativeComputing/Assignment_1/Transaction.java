/*
 * @author (Ciarán McCarthy)
 * @student id: 17102168
 * @version (13/03/2021)
 * 
*/
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction implements Serializable
{
	//Transaction object to store date, amount and type of transaction
	private static final long serialVersionUID = 8803216572303579376L;
	private BigDecimal amount;
	private LocalDate transactionDate;
	private String description;
	
	public Transaction(BigDecimal amount, String description)
	{
		this.amount = amount;
		transactionDate = LocalDate.now();
		this.description = description;
	}
	
	public BigDecimal getAmount()
	{
		return amount;
	}
	
	public LocalDate getDate()
	{
		return transactionDate;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public String toString()
	{
		String out = description;
		out += "\t €" + amount;
		return out;
	}
}
