/*
 * @author (Ciarán McCarthy)
 * @student id: 17102168
 * @version (13/03/2021)
 * 
 * Bank account
*/
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

public class Account
{
	private String accName;
	private String password;
	private int accNum;
	private BigDecimal balance;
	private Calendar creationDate;
	private ArrayList<Transaction> transactions = new ArrayList<Transaction>();

	//Sets up account details given name, password, initial balance and account number
	public Account(String accName, String password, BigDecimal balance, int accNum)
	{
		this.setAccName(accName);
		this.setPass(password);
		this.setBalance(balance);
		creationDate = Calendar.getInstance();
		this.accNum = accNum;
	}

	public String getAccName()
	{
		return accName;
	}

	private void setAccName(String accName)
	{
		this.accName = accName;
	}

	public String getPass()
	{
		return password;
	}

	private void setPass(String password)
	{
		this.password = password;
	}

	public int getAccNum()
	{
		return accNum;
	}

	public BigDecimal getBalance()
	{
		return balance;
	}

	public void setBalance(BigDecimal balance)
	{
		this.balance = balance;
	}

	public Calendar getCreationDate()
	{
		return creationDate;
	}

	public void addTransaction(Transaction t)
	{
		transactions.add(t);
	}

	//Returns list of transactions based on given dates
	public ArrayList<Transaction> getTransactions(LocalDate startDate, LocalDate endDate)
	{
		ArrayList<Transaction> t = new ArrayList<Transaction>();

		//Loops over all transactions stored
		for (int i=0;i<transactions.size();i++)
		{
			//If the start date is equal to or before the date of the first transaction
			if (transactions.get(i).getDate().equals(startDate)
				|| transactions.get(i).getDate().isAfter(startDate))
			{
				//If the end date is equal to the current transaction date
				if (transactions.get(i).getDate().equals((endDate)))
				{
					//While this is the case, adds transactions
					while (transactions.get(i).getDate().equals((endDate)) && i<transactions.size())
					{
						t.add(transactions.get(i));
						i++;
					}
					return transactions;
				}
				//If the end date is after the start date
				else
				{
					//While the current transaction date is before the end date
					while (transactions.get(i).getDate().isBefore((endDate)) && i<transactions.size())
					{
						t.add(transactions.get(i));
						i++;
					}
					if (transactions.get(i).getDate().equals((endDate)))
					{
						//While the current transaction date is the same as the end date
						while (transactions.get(i).getDate().equals((endDate)) && i<transactions.size())
						{
							t.add(transactions.get(i));
							i++;
						}
						return transactions;
					}
					return transactions;
				}
			}
		}
		return null;
	}
}
