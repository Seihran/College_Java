/**
 * Takes all order information and sends a detailed email if its successful
 * or an apology email if it is unsuccessful
 *
 * @author (Ciarán McCarthy)
 * @version (12/10/2019)
 */

public class Email
{
    private String emailAddress;
    private long orderNumber;
    private String CustomerName;
    private float total;
    private String deliveryAddress;
    private String billingAddress;
    private String orderDetails;
    
    public Email()
    {
        
    }    
    
    public void setEmail(String email)
    {
        //Takes email from order class
        emailAddress = email;
    }
    
    public void setCustName(String name)
    {
        //Takes customer's first name from order class
        CustomerName = name;
    }
    
    public void setOrderNo(long num)
    {
        orderNumber = num;
    }
    
    public void addOrderDetails(String details)
    {
        //Takes string which contains list of all items in order
        orderDetails = details;
    }
    
    public void setTotal(float total)
    {
        this.total = total;
    }
    
    public void setDelAddress(String address)
    {
        deliveryAddress = address;
    }
    
    public void setBillAddress(String address)
    {
        billingAddress = address;
    }
    
    public void printEmail()
    {
        //Prints email containing all details of the order if it was successful
        System.out.println("Dear " + CustomerName + ",");
        System.out.println("Your order was successful.");
        System.out.println("Your order no. is: #" + orderNumber);
        System.out.println("You have ordered, \n" + orderDetails);
        System.out.println("Your total came to: €" + total);
        System.out.println("This order will be delivered to: \n" + deliveryAddress);
        System.out.println("This will be billed to: \n" + billingAddress);
        System.out.println("Thanks for shopping with us,");
        System.out.println("We hope to see you again!\n");
    }
    
    public void printFail()
    {
        //Prints email apologising that the order was unsuccessful due to a payment failure
        System.out.println("Dear " + CustomerName + ",");
        System.out.println("Unfortunately this order was unsuccessful.");
        System.out.println("This was due to an invalid payment.");
        System.out.println("\nPlease try again with a valid payment method.\n");
    }
}
