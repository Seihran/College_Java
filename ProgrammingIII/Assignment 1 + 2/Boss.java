/*
 * @author (Ciarán McCarthy)
 * @student id: 17102168
 * @version (17/10/2020)
*/

// Boss class derived from Employee.
import java.math.RoundingMode;
import org.joda.money.Money;

public final class Boss extends Employee
{
    private Money weeklySalary;

    // constructor for class Boss
    public Boss(String first, String last, String date, double salary)
    {
        super(first, last, date); // call superclass constructor
        setWeeklySalary(salary);
    }

    // set Boss's salary
    public void setWeeklySalary(double salary)
    {
        weeklySalary = (salary > 0 ? Money.of(EUR, salary) : Money.of(EUR, 0));
    }

    // get Boss's pay
    @Override
    public Money earnings(TaxCalculator calc) throws LowWageException
    {
    	//Calculates monthly earnings by multiplying weekly salary by 4 and rounding down
    	Money monthlyEarnings = weeklySalary.multipliedBy(4d, RoundingMode.DOWN);
    	//Calculates tax credits to be 5% of earnings if monthly earnings are above 3000
    	//And 10% of earnings otherwise
    	setTaxCredits(monthlyEarnings.isGreaterThan(Money.of(EUR, 3000))
    			      ? monthlyEarnings.multipliedBy(0.05d, RoundingMode.DOWN)
    			      : monthlyEarnings.multipliedBy(0.1d, RoundingMode.DOWN));
    	
    	//Throws exception if earnings are less than 100
    	if (monthlyEarnings.isLessThan(Money.parse("EUR 100.00"))) throw new LowWageException
    	("Boss: " + super.toString() + " Monthly earning are " + monthlyEarnings
    	 + " which is below €100.\nThis is ignoring any bonuses due to long term employement.");
    	
    	//Calculates earnings minus tax
        return monthlyEarnings.minus(calc.calculateTax(monthlyEarnings, getTaxCredits()));
    }

    // get String representation of Boss's name
    public String toString()
    {
        return "Boss: " + super.toString();
    }
} // end class Boss
