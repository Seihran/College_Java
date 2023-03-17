/**
 * Has different methods that correspond to different scenarios.
 * Runs a main method that calls each scenario in turn.
 *
 * @author (Ciarán McCarthy)
 * @version (12/10/2019)
 */

public class TransactionTest
{
    public TransactionTest()
    {
    }
    
    public static void main(String[] args)
    {
        TransactionTest test = new TransactionTest();
        test.transaction1();
        test.transaction2();
        test.transaction3();
        test.transaction4();
        test.transaction5();
    }
    
    public void transaction1()
    {
        //Creates new customer object
        Customer customer = new Customer("Frank", "Glavin", "frank.glavin@nuigalway.ie");
        ShoppingCart cart = new ShoppingCart(customer);
        //Prints the name of the customer
        System.out.println("User is " + customer.getFirstName() + " " + customer.getSurName());
        //Adds items to shopping cart
        cart.addItem(new Item("Broom", 123456, 12.50F));
        cart.addItem(new Item("Computer", 123457, 480.00F));
        cart.addItem(new Item("Banana", 123458, 0.60F));
        //Lists all items in shopping cart
        cart.listAllItems();
        //Prints total price of everything in cart
        System.out.printf("Your total is €%.2f\n", cart.getTotal());
        int itemNum;
        //Specifies what item to be removed eg. item 1,2,...,n
        itemNum = 1;
        //Sets index value to 1 less than item number
        int index = itemNum - 1;
        //Prints number of items in cart
        System.out.printf("%d items in cart.\n", cart.getNumberOfItems());
        cart.listAllItems();
        //Creates order only if there are 1 or more items in the cart
        if (cart.getNumberOfItems() == 0)
        {
            System.out.println("There are no items in the cart,");
            System.out.println("no order can be created.");
            return;
        }
        else
        {
            System.out.println("An order is being created.\n");
        }
        Order order = new Order(cart.customer);
        //Transfers total price to order class
        order.setTotal(cart.getTotal());
        //Sets index to zero
        index = 0;
        //Transfers items one by one from the cart to the order class array list
        while (cart.getNumberOfItems() > index)
        {
            order.addItem(cart.getItem(index));
            cart.removeItem(index);
        }
        //Locks cart to prevent changes
        cart.lockCart();
        //Sets payment details
        order.payment.setPayment(customer, "Visa", 1234567812345678L, 345, "14/05/2022");
        //Sets billing address
        order.billAddress.setAddress("12 Maple Ave.", "Rock Cliff", "Cran", "H91K33E", "Ireland");
        //sets delivery address
        order.address.setAddress("12 Maple Ave.", "Rock Cliff", "Cran", "H91K33E", "Ireland");
        //Sends email, either a successful purchase or a failed one
        order.sendEmail();
    }
    
    public void transaction2()
    {
        Customer customer = new Customer("Arland", "Greene", "arland.greene@nuigalway.ie");
        ShoppingCart cart = new ShoppingCart(customer);
        System.out.println("User is " + customer.getFirstName() + " " + customer.getSurName());
        cart.addItem(new Item("Tea Bags", 123456, 48.50F));
        cart.addItem(new Item("DVDs", 123457, 17.00F));
        cart.addItem(new Item("Whiskey", 123458, 38.50F));
        cart.listAllItems();
        System.out.printf("Your total is €%.2f\n", cart.getTotal());
        int itemNum;
        //Specifies what item to be removed eg. item 1,2,...,n
        itemNum = 2;
        //Sets index value to 1 less than item number
        int index = itemNum - 1;
        //Removes item from shopping cart in position number index
        cart.removeSpecificItem(index);
        System.out.printf("%d items in cart.\n", cart.getNumberOfItems());
        cart.listAllItems();
        if (cart.getNumberOfItems() == 0)
        {
            System.out.println("There are no items in the cart,");
            System.out.println("no order can be created.");
            return;
        }
        else
        {
            System.out.println("An order is being created.\n");
        }
        Order order = new Order(cart.customer);
        order.setTotal(cart.getTotal());
        index = 0;
        while (cart.getNumberOfItems() > index)
        {
            order.addItem(cart.getItem(index));
            cart.removeItem(index);
        }
        cart.lockCart();
        order.payment.setPayment(customer, "MasterCard", 98765432987654321L, 345, "18/09/2102");
        order.billAddress.setAddress("27 Beech Ave.", "Rock Cliff", "Cran", "H91K48F", "Ireland");
        order.address.setAddress("11 Oak Ave.", "Rock Meadow", "Cran", "H91K72F", "Ireland");
        order.sendEmail();
    }
    
    public void transaction3()
    {
        Customer customer = new Customer("Susan", "Freeley", "susan.freeley@nuigalway.ie");
        ShoppingCart cart = new ShoppingCart(customer);
        System.out.println("User is " + customer.getFirstName() + " " + customer.getSurName());
        cart.addItem(new Item("Shower Gel", 123456, 6.25F));
        cart.addItem(new Item("Shampoo", 123457, 8.00F));
        cart.addItem(new Item("Conditioner", 123458, 9.50F));
        cart.addItem(new Item("Toothbrush", 123458, 4.50F));
        cart.addItem(new Item("Toothpaste", 123458, 2.49F));
        cart.listAllItems();
        System.out.printf("Your total is €%.2f\n", cart.getTotal());
        int itemNum;
        itemNum = 0;
        int index = itemNum - 1;
        cart.removeSpecificItem(index);
        System.out.printf("%d items in cart.\n", cart.getNumberOfItems());
        if (cart.getNumberOfItems() == 0)
        {
            System.out.println("There are no items in the cart,");
            System.out.println("no order can be created.");
            return;
        }
        else
        {
            System.out.println("An order is being created.\n");
        }
        Order order = new Order(cart.customer);
        order.setTotal(cart.getTotal());
        index = 0;
        while (cart.getNumberOfItems() > index)
        {
            order.addItem(cart.getItem(index));
            cart.removeItem(index);
        }
        cart.lockCart();
        cart.addItem(new Item("Toothpicks", 123458, 0.99F));
        cart.removeSpecificItem(index);
        order.payment.setPayment(customer, "MasterCard", 8462037281943057L, 830, "18/09/1998");
        order.billAddress.setAddress("6 Ash Ave.", "Rock Cliff", "Cran", "H91K62E", "Ireland");
        order.address.setAddress("32 Willow Ave.", "Rock Meadow", "Cran", "H91K12F", "Ireland");
        order.sendEmail();
    }
    
    public void transaction4()
    {
        Customer customer = new Customer("Mark", "Ranner", "mark.ranner@gmail.com");
        ShoppingCart cart = new ShoppingCart(customer);
        System.out.println("User is " + customer.getFirstName() + " " + customer.getSurName());
        cart.addItem(new Item("Microwave Oven", 127800, 365.00F));
        cart.listAllItems();
        System.out.printf("Your total is €%.2f\n", cart.getTotal());
        int itemNum;
        itemNum = 1;
        int index = itemNum - 1;
        cart.removeSpecificItem(index);
        System.out.printf("%d items in cart.\n", cart.getNumberOfItems());
        if (cart.getNumberOfItems() == 0)
        {
            System.out.println("There are no items in the cart,");
            System.out.println("no order can be created.\n");
            return;
        }
        else
        {
            System.out.println("An order is being created.\n");
        }
    }
    
    public void transaction5()
    {
        Customer customer = new Customer("Megan", "Tegan", "megan.tegan76@yahoo.co.uk");
        ShoppingCart cart = new ShoppingCart(customer);
        System.out.println("User is " + customer.getFirstName() + " " + customer.getSurName());
        cart.addItem(new Item("Chair", 123456, 22.5F));
        cart.addItem(new Item("Chair", 123456, 22.5F));
        cart.addItem(new Item("Table", 123457, 40.00F));
        cart.listAllItems();
        System.out.printf("Your total is €%.2f\n", cart.getTotal());
        int itemNum;
        itemNum = 0;
        int index = itemNum - 1;
        cart.removeSpecificItem(index);
        System.out.printf("%d items in cart.\n", cart.getNumberOfItems());
        if (cart.getNumberOfItems() == 0)
        {
            System.out.println("There are no items in the cart,");
            System.out.println("no order can be created.");
            return;
        }
        else
        {
            System.out.println("An order is being created.\n");
        }
        Order order = new Order(cart.customer);
        order.setTotal(cart.getTotal());
        index = 0;
        while (cart.getNumberOfItems() > index)
        {
            order.addItem(cart.getItem(index));
            cart.removeItem(index);
        }
        cart.lockCart();
        //Requests user to input payment details
        order.addPayment();
        order.billAddress.setAddress("4 Mahogony Dr.", "Rock Cliff", "Cran", "H91K34D", "Ireland");
        order.address.setAddress("84 Sycamore Rd.", "Rock Meadow", "Cran", "H91K69D", "Ireland");
        order.sendEmail();
    }
}
