/*
 * @author (Ciarán McCarthy)
 * @student id: 17102168
 * @version (17/10/2020)
*/

// Abstract base class Employee.
import java.math.RoundingMode;
import java.time.LocalDate;
import org.joda.money.*;

public abstract class Employee implements TaxCalculator
{
    private String firstName;
    private String lastName;
    private LocalDate joinDate;
    private static int baseIdNum = 0;
    private int idNum;
    private Money taxCredits;
    CurrencyUnit EUR = CurrencyUnit.of("EUR");

    // constructor
    public Employee(String first, String last, String date)
    {
        firstName = first;
        lastName = last;
        setJoinDate(LocalDate.parse(date));
        setIdNum(baseIdNum + 1);
    }

    // get first name
    public String getFirstName()
    {
        return firstName;
    }

    // get last name
    public String getLastName()
    {
        return lastName;
    }

    public String toString()
    {
        return firstName + ' ' + lastName + ", ID: " + getIdNum() + ", Joined: " + getJoinDate();
    }

    public LocalDate getJoinDate()
    {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate)
	{
		this.joinDate = joinDate;
	}
	
	public int getIdNum()
    {
		return idNum;
	}

	public void setIdNum(int idNum)
	{
		this.idNum = idNum;
		baseIdNum = baseIdNum + 1;
	}
	
	public Money getTaxCredits()
	{
		return taxCredits;
	}
	
	public void setTaxCredits(Money taxCredits)
	{
		this.taxCredits = taxCredits;
	}
	
    public abstract Money earnings(TaxCalculator calc) throws LowWageException;
    
    //Calculates a tax value of 20% of earnings minus tax credits
    @Override
	public Money calculateTax(Money earnings, Money taxCredits)
	{
		return earnings.multipliedBy(0.2d, RoundingMode.DOWN).minus(taxCredits);
	}
}
