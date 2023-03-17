/**
 * Write a description of class Greeting here.
 *
 * @author (Ciarán McCarthy)
 * @version (12/10/2019)
 */

public class Item
{
    String name;
    private float price;
    private long itemId;

    public Item(String itemName, long id, float price)
    {
        name = itemName;
        itemId = id;
        this.price = price;
    }
    
    public void setPrice(float price)
    {
        this.price = price;
    }

    public float getPrice()
    {
        return price;
    }
    
    @Override
    public String toString()
    {
        String out = name + "\tItem Id: " + itemId +"\tPrice: €" + price;
        return out;
    }
}