import java.util.ArrayList;

public class FancyDressRunner extends AmateurRunner
{
    private String costume;
    
    public FancyDressRunner(int id, String costume)
    {
        super(id);
        this.costume = costume;
    }
    
    public String getCostume()
    {
        return costume;
    }
}