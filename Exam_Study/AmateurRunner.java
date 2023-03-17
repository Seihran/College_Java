import java.util.ArrayList;

public class AmateurRunner extends Runner
{
    ArrayList<Sponsorship> sponsors;
    private double total;
    
    public AmateurRunner(int id)
    {
        super();
        sponsors = new ArrayList<Sponsorship>();
    }
    
    public void addSponsor(Sponsorship sponsor)
    {
        sponsors.add(sponsor);
        total = total + sponsor.getAmount();
    }
    
    public void dispSponsors()
    {
        System.out.println("This runner is sponsored by: ");
        
        for (int i = 0; i < sponsors.size(); i++)
        {
            System.out.println(sponsors.get(i));
        }
        
        System.out.print("For a total of: " + total + "\n");
    }
}
