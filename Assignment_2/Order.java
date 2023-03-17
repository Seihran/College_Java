import java.util.ArrayList;
import java.util.Scanner;

/**
 * Collates all information from the shopping cart, address, customer and
 * payment classes and sends it to the email class.
 * Tells the email class whether to print a successful or not email.
 * Has a method to take user inputted payment details and check whether
 * or not they are valid inputs.
 *
 * @author (Ciarán McCarthy)
 * @version (12/10/2019)
 */

public class Order
{
    private ArrayList<Item> order = new ArrayList<Item>();
    private int index = 0;
    Customer customer;
    Address address = new Address();
    Address billAddress = new Address();
    Payment payment = new Payment();
    Email email = new Email();
    private final long orderNo;
    private float total;
    private String details;
    
    public Order(Customer customer)
    {
        this.customer = customer;
        email.setEmail(customer.getEmailAddress());
        orderNo = makeOrderNo();
    }
    
    public void setOrderDetails()
    {
        //Converts arraylist of objects to a string containing only the name attributes of item objects inside arraylist
        String itemList = "";
        
        for (int index = 0; index < order.size();)
        {
            String name = ((Item) order.get(index)).name;
            itemList = itemList + "\n" + name;
            index++;
        }
        details = itemList;
    }
    
    public long makeOrderNo()
    {
        return (long) (Math.random() * 99999999999999L);
    }
    
    public long getOrderNo()
    {
        return orderNo;
    }
    
    public void addPayment()
    {
        //Allows payment method to be set from a series of user inputs from terminal
        Scanner input = new Scanner(System.in);
        long cardNum = 1;
        int secNum = 1;
        boolean checkOne = false;
        boolean checkTwo = false;
        boolean checkThree = false;
        
        System.out.println("Please enter payment details.");
        System.out.println("MasterCard or Visa?");
        String cardType = input.nextLine();
        
        System.out.println("Enter card number: ");
        String cardNumber = input.nextLine();
        while (checkOne == false)
        {
            //Continues to loop until a valid card number is entered
            if (cardNumber.matches("[0-9]+") && cardNumber.length() == 16)
            {
                //Checks if user entered string contains only numerics
                cardNum = Long.parseLong(cardNumber);
                //Converts user input string to long type number
                checkOne = true;
            }
            else
            {
                System.out.println("Enter a valid card number: ");
                cardNumber = input.nextLine();
            }
        }
        
        System.out.println("Enter securtiy number: ");
        String securityNumber = input.nextLine();
        while (checkTwo == false)
        {
            //Continues to loop until a valid card number is entered
            if (securityNumber.matches("[0-9]+") && securityNumber.length() == 3)
            {
                //Checks if user entered string contains only numerics
                secNum = Integer.parseInt(securityNumber);
                //Converts user input string to integer type number
                checkTwo = true;
            }
            else
            {
                System.out.println("Enter a valid security number: ");
                securityNumber = input.nextLine();
            }
        }
        
        System.out.println("Enter expiry date (dd/MM/yyyy): ");
        String expiryDate = input.nextLine();
        while (checkThree == false)
        {
            //Continues to loop until a valid date in the format specified is entered
            if (expiryDate.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})"))
            {
                checkThree = true;
            }
            else
            {
                System.out.println("Enter valid expiration date (dd/MM/yyyy): ");
                expiryDate = input.nextLine();
            }
        }
        
        //Sets payment values to those entered from user input
        payment.setPayment(customer, cardType, cardNum, secNum, expiryDate);
    }
    
    public void addItem(Item item)
    {
        order.add(item);
    }
    
    public Item getItem(int index)
    {
        return order.get(index);
    }
    
    public void setTotal(float total)
    {
        this.total = total;
    }
    
    public int getNumberOfItems()
    {
        return order.size();
    }
    
    public void sendEmail()
    {
        email.setEmail(customer.getEmailAddress());
        email.setCustName(customer.getFirstName());
        email.setOrderNo(orderNo);
        this.setOrderDetails();
        email.addOrderDetails(details);
        email.setTotal(total);
        email.setDelAddress(address.getAddress());
        email.setBillAddress(billAddress.getAddress());
        //Sends all order information to email class
        
        if (payment.isValid() == true)
        {
            //Tells email class to print successful email and closes method if so
            email.printEmail();
            return;
        }
        
        //Tells emails to print failed order attempt
        email.printFail();
    }
}
