/*
 * @author (Ciarán McCarthy)
 * @student id: 17102168
 * @version (17/10/2020)
*/
// PieceWorker class derived from Employee
import java.math.RoundingMode;

import org.joda.money.Money;

public final class PieceWorker extends Employee
{
    private Money wagePerPiece; // wage per piece output
    private int quantity; // output for week

    // constructor for class PieceWorker
    public PieceWorker(String first, String last, String date,
            double wage, int numberOfItems)
    {
        super(first, last, date); // call superclass constructor
        setWage(wage);
        setQuantity(numberOfItems);
    }

    // set PieceWorker's wage
    public void setWage(double wage)
    {
        wagePerPiece = (wage > 0 ? Money.of(EUR, wage) : Money.of(EUR, 0));
    }

    // set number of items output
    public void setQuantity(int numberOfItems)
    {
        quantity = (numberOfItems > 0 ? numberOfItems : 0);
    }

    // determine PieceWorker's earnings
        //return quantity * wagePerPiece;
    
    @Override
    public Money earnings(TaxCalculator calc) throws LowWageException
    {
    	//Calculates monthly earnings by multiplying wages per item by quantity and then by 4 and rounding down
    	Money monthlyEarnings = (wagePerPiece.multipliedBy(quantity).multipliedBy(4, RoundingMode.DOWN));
    	//Calculates tax credits to be 5% of earnings if monthly earnings are above 3000
    	//And 10% of earnings otherwise
    	setTaxCredits(monthlyEarnings.isGreaterThan(Money.of(EUR, 3000))
			      ? monthlyEarnings.multipliedBy(0.05d, RoundingMode.DOWN)
			      : monthlyEarnings.multipliedBy(0.1d, RoundingMode.DOWN));
    	
    	//Throws exception if earnings are less than 100
    	if (monthlyEarnings.isLessThan(Money.parse("EUR 100.00"))) throw new LowWageException
    	("Piece Worker: " + super.toString() + " Monthly earning are " + monthlyEarnings
    	 + " which is below €100.\nThis is ignoring any bonuses due to long term employement.");
    	
    	//Calculates earnings minus tax
    	return monthlyEarnings.minus(calc.calculateTax(monthlyEarnings, getTaxCredits()));
    }

    public String toString()
    {
        return "Piece worker: " + super.toString();
    }
}
