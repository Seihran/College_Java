import java.time.format.DateTimeFormatter;

public abstract class Runner
{
    int idNumber;
    String time;
    
    public void results(boolean finished, String time)
    {
        if (finished)
        {
            String[] timeSplit = time.split(":");
            System.out.println("Finished in " + timeSplit[0] + ":"
            + timeSplit[1] + ":" + timeSplit[2]);
        }
        else
        {
            System.out.println("Not finished");
        }
    }
}
