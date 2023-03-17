/*
 * @author (Ciarán McCarthy)
 * @student id: 17102168
 * @version (17/10/2020)
*/

import java.math.RoundingMode;
import org.joda.money.Money;

// CommissionWorker class derived from Employee

public final class CommissionWorker extends Employee
{

    private Money salary; // base salary per week
    private Money commission; // amount per item sold
    private int quantity; // total items sold for week

    // constructor for class CommissionWorker
    public CommissionWorker(String first, String last, String date,
            double salary, double commission, int quantity)
    {
        super(first, last, date); // call superclass constructor
        setSalary(salary);
        setCommission(commission);
        setQuantity(quantity);
    }

    // set CommissionWorker's weekly base salary
    public void setSalary(double weeklySalary)
    {
        salary = (weeklySalary > 0 ? Money.of(EUR, weeklySalary) : Money.of(EUR, 0));
    }

    // set CommissionWorker's commission
    public void setCommission(double itemCommission)
    {
        commission = (itemCommission > 0 ? Money.of(EUR, itemCommission) : Money.of(EUR, 0));
    }

    // set CommissionWorker's quantity sold
    public void setQuantity(int totalSold)
    {
        quantity = (totalSold > 0 ? totalSold : 0);
    }
    
    @Override
    public Money earnings(TaxCalculator calc) throws LowWageException
    {
    	//Calculates monthly earnings by adding weekly salary plus commission times quantity and then multiplying by 4 and rounding down 
    	Money monthlyEarnings = (salary.plus(commission.multipliedBy(quantity)).multipliedBy(4, RoundingMode.DOWN));
    	//Calculates tax credits to be 5% of earnings if monthly earnings are above 3000
    	//And 10% of earnings otherwise
    	setTaxCredits(monthlyEarnings.isGreaterThan(Money.of(EUR, 3000))
			      ? monthlyEarnings.multipliedBy(0.05d, RoundingMode.DOWN)
			      : monthlyEarnings.multipliedBy(0.1d, RoundingMode.DOWN));
    	
    	//Throws exception if earnings are less than 100
    	if (monthlyEarnings.isLessThan(Money.parse("EUR 100.00"))) throw new LowWageException
    	("Commission Worker: " + super.toString() + " Monthly earning are "
    	 + monthlyEarnings + " which is below €100.\nThis is ignoring any bonuses due to long term employement.");
    	
    	//Calculates earnings minus tax
    	return monthlyEarnings.minus(calc.calculateTax(monthlyEarnings, getTaxCredits()));
    }

    // get String representation of CommissionWorker's name
    public String toString()
    {
        return "Commission worker: " + super.toString();
    }
} // end class CommissionWorker
