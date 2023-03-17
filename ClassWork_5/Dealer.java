public class Dealer
{
    public Dealer()
    {
    }
    
    public static void main(String[] args)
    {
        Dealer test = new Dealer();
        
        test.test1();
        test.testCompareTo();
    }
    
    public void test1()
    {
        Card card1 = null;
        Card card2 = null;
        Card card3 = null;
        
        try
        {
            card1 = new Card(0,1);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
        
        try
        {
            card2 = new Card(0,-11);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
        
        try
        {
            card3 = new Card(0,2);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
        
        System.out.println(card1);
        System.out.println(card2);
        System.out.println(card3);
    }
    
    public void testCompareTo()
    {
        Card card1 = new Card(1,2);
        Card card2 = new Card(1,2);
        
        int result = card1.compareTo(card2);
        assert(result == 0);
        
        Card card3 = new Card(2,3);
        Card card4 = new Card(1,2);
        
        result = card3.compareTo(card4);
        assert(result == 1);
        
        result = card4.compareTo(card3);
        assert(result == -1);
    }
}