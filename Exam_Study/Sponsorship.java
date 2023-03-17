public class Sponsorship
{
    private String name;
    private String amount;
    
    public Sponsorship(String name, String amount)
    {
        this.name = name;
        this.amount = amount;
    }
    
    @Override
    public String toString()
    {
        return name + " for $" + amount;
    }
    
    public double getAmount()
    {
        return Double.parseDouble(amount);
    }
}
