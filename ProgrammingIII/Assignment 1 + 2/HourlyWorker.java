/*
 * @author (Ciarán McCarthy)
 * @student id: 17102168
 * @version (17/10/2020)
*/
// Definition of class HourlyWorker
import java.math.RoundingMode;
import org.joda.money.Money;

public final class HourlyWorker extends Employee
{
    private Money wage; // wage per hour
    private double hours; // hours worked for week

    // constructor for class HourlyWorker
    public HourlyWorker(String first, String last, String date,
            double wagePerHour, double hoursWorked)
    {
        super(first, last, date); // call superclass constructor
        setWage(wagePerHour);
        setHours(hoursWorked);
    }

    // Set the wage
    public void setWage(double wagePerHour)
    {
        wage = (wagePerHour > 0 ? Money.of(EUR, wagePerHour) : Money.of(EUR, 0));
    }

    // Set the hours worked
    public void setHours(double hoursWorked)
    {
        hours = (hoursWorked >= 0 && hoursWorked < 168
                ? hoursWorked : 0);
    }

    // Get the HourlyWorker's pay
    @Override
    public Money earnings(TaxCalculator calc) throws LowWageException
    {
    	//Calculates monthly earnings by multiplying wage by hours worked and then multiplying by 4 and rounding down
    	Money monthlyEarnings = (wage.multipliedBy(hours, RoundingMode.DOWN).multipliedBy(4, RoundingMode.DOWN));
    	//Calculates tax credits to be 5% of earnings if monthly earnings are above 3000
    	//And 10% of earnings otherwise
    	setTaxCredits(monthlyEarnings.isGreaterThan(Money.of(EUR, 3000))
			      ? monthlyEarnings.multipliedBy(0.05d, RoundingMode.DOWN)
			      : monthlyEarnings.multipliedBy(0.1d, RoundingMode.DOWN));
    	
    	//Throws exception if earnings are less than 100
    	if (monthlyEarnings.isLessThan(Money.parse("EUR 100.00"))) throw new LowWageException
    	("Hourly Worker: " + super.toString() + " Monthly earning are " + monthlyEarnings
    	 + " which is below €100.\nThis is ignoring any bonuses due to long term employement.");
    	
    	//Calculates earnings minus tax
    	return monthlyEarnings.minus(calc.calculateTax(monthlyEarnings, getTaxCredits()));
    }

    public String toString()
    {
        return "Hourly worker: " + super.toString();
    }
}
