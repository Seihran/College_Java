import java.util.ArrayList;

/**
 * Creates an arraylist to store item objects that can be added or removed.
 * Is linked to a specific customer and can lock itself to prevent changes.
 *
 * @author (Ciarán McCarthy)
 * @version (12/10/2019)
 */

public class ShoppingCart
{
    private final long cartID;
    private int time;
    private float total;
    private boolean lock = false;
    Customer customer;
    //Creates an arraylist to hold objects of class Item
    private ArrayList<Item> shoppingCart;
    
    public ShoppingCart(Customer customer)
    {
        cartID = makeCartID();
        this.customer = customer;
        shoppingCart = new ArrayList<Item>();
    }
    
    public long makeCartID()
    {
        //Creates an id of type long for each shopping cart object
        return (long) (Math.random() * 99999999999999L);
    }
    
    public void addItem(Item item)
    {
        //Allows adding of items to shopping cart arraylist so long as the cart is not locked
        if (lock == false)
        {
            shoppingCart.add(item);
            total = total + item.getPrice();
            System.out.println("Item added.");
            System.out.printf("Total price is now: €%.2f \n", total);
        }
        else
        {
            //Apologises if the cart is locked
            System.out.println("Apologies, the shopping cart is locked.");
        }
    }
    
    public void removeItem(int index)
    {
        //Removes item from shopping cart and updates total so long as the cart is not locked
        if (lock == false)
        {
            total = total - (shoppingCart.get(index).getPrice());
            shoppingCart.remove(index);
        }
        else
        {
            System.out.println("Apologies, the shopping cart is locked.");
        }
    }
    
    public void removeSpecificItem(int index)
    {
        //Allows calling of remove item method, so long as item selected is a valid item in the cart and it is not locked
        if (index >= 0 && index < this.getNumberOfItems())
        {
            this.removeItem(index);
            System.out.printf("Item removed, your total is now €%.2f \n", this.getTotal());
        }
        else if (index == -1)
        {
            
        }
        else if (lock == true)
        {
            System.out.println("Apologies, the cart is locked.");
        }
        else
        {
            System.out.println("No valid item specified.");
        }
    }
    
    public int getNumberOfItems()
    {
        return shoppingCart.size();
    }
    
    public void listAllItems()
    {
        //Lists contents of shopping cart array list
        System.out.println(shoppingCart);
    }
    
    public void setLock()
    {
        lock = true;
    }
    
    public void lockCart()
    {
        //Calls setLock method to lock cart to prevent any more items being added or removed
        setLock();
    }
    
    public Item getItem(int index)
    {
        return shoppingCart.get(index);
    }
    
    public float getTotal()
    {
        return total;
    }
    
    public void transfer(int index)
    {
        //Facilitates the transfer of items from the cart array list to the order array list
        this.getItem(index);
        this.removeItem(index);
    }
}
