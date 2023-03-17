
public class NameList
{
    private String[] nameList = new String[100];
    private int counter;
    
    public NameList()
    {
    }
    
    public void setNameList(String name)
    {
        nameList[counter] = name;
    }
    
    public int getCounter()
    {
        return counter;
    }
    
    public String getName()
    {
        return nameList[counter];
    }
    
    public String checkName(String name)
    {
        while (counter >= 0)
        {
            if ((name).equals(nameList[counter]))
            {
                return name;
            }
            else
            {
                counter = counter - 1;
            }
        }
        
        return "Not found";
    }
}
