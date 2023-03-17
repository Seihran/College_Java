/*
 * @author (Ciarán McCarthy)
 * @student id: 17102168
 * @version (13/03/2021)
 * 
 * Creates a statement based on transactions of given dates
*/
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Statement implements Serializable
{
	private static final long serialVersionUID = 893903911882004409L;
	private int accNum;
	private LocalDate startDate;
	private LocalDate endDate;
	private String accName;
	private ArrayList<Transaction> transactions;
	
	//Parses the given dates and obtains the transactions by requesting the account
	public Statement(String startDate, String endDate, Account acc)
	{
		this.startDate = LocalDate.parse(startDate);
		this.endDate = LocalDate.parse(endDate);
		accNum = acc.getAccNum();
		accName = acc.getAccName();
		transactions = acc.getTransactions(this.startDate, this.endDate);
	}
	
	//ToString method that formats the statement
	public String toString()
	{
		String out = "Account holder: " + accName;
		out += "\nAccount number: " + accNum;
		out += "\nTransaction history from " + startDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
		       + " to " + endDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		out += "\n" + transactions;
		return out;
	}
}
