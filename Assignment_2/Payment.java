import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Takes in payment details and checks whether they are valid or not.
 *
 * @author (Ciarán McCarthy)
 * @version (12/10/2019)
 */

public class Payment
{
    private Customer customer;
    private String cardType;
    private long cardNum;
    private int securityNum;
    private String expDate;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public Payment()
    {
        
    }
    
    public void setPayment(Customer c, String cT, long cN, int sN, String d)
    {
        customer = c;
        cardType = cT;
        cardNum = cN;
        securityNum = sN;
        expDate = d;
    }

    public boolean isValid()
    {    
        LocalDate date = LocalDate.now();
        //Creates date object with current system date
        LocalDate expD = LocalDate.parse(expDate, formatter);
        //Converts string to date object in order to compare it
        
        if (cardType.equals("Visa") || cardType.equals("MasterCard"))
        {
            //Checks if card type is valid
            if ((int)(Math.log10(cardNum) + 1) == 16)
            {
                //Checks if card number has correct number of digits
                if (expD.isAfter(date) == true || expD.isEqual(date) == true)
                {
                    //Checks if expiration date entered is today or a future date
                    //Returns true as everything has passed validity check
                    return true;
                }
                System.out.println("This card has expired.");
                return false;
            }
            System.out.println("Invalid card number.");
            return false;
        }
        System.out.println("Please enter valid card type.");
        return false;
    }
}
