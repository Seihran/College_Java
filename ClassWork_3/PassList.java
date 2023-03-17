
public class PassList
{
    String[] passList = new String[100];
    private int counter;
    
    public PassList()
    {
    }
    
    public void setPassList(String pass)
    {
        passList[counter] = pass;
    }
    
    public int getCounter()
    {
        return counter;
    }
    
    public String getPass()
    {
        return passList[counter];
    }
    
    public String checkPass(String pass)
    {
        while (counter >= 0)
        {
            if ((pass).equals(passList[counter]))
            {
                return pass;
            }
            else
            {
                counter = counter - 1;
            }
        }
        
        return "Not found";
    }
}
