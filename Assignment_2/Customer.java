/**
 * Write a description of class Greeting here.
 *
 * @author (Ciarán McCarthy)
 * @version (12/10/2019)
 */

public class Customer
{
    private String firstName;
    private String surname;
    private String emailAdd;
    private final long customerID;
    
    public Customer(String fName, String sName, String email)
    {
        firstName = fName;
        surname = sName;
        emailAdd = email;
        customerID = makeCustomerID();
    }
    
    public long makeCustomerID()
    {
        return (long) (Math.random() * 99999999999999L);
    }
    
    public long getId()
    {
        return customerID;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getSurName()
    {
        return surname;
    }
    
    public String getEmailAddress()
    {
        return emailAdd;
    }
    
    public void setFirstName(String first)
    {
        firstName = first;
    }
    
    public void setSurName(String surname) {
        this.surname = surname;
    }

    public void setEmailAddress(String emailAdd) {
        this.emailAdd = emailAdd;
    }
}
