import java.util.ArrayList;

/**
 * Extends Bus class.
 *
 * @author (Ciarán McCarthy)
 * @version (19/11/19)
 */
public class GoBus extends Bus
{
    public GoBus()
    {
        //Adds multiple trips to this bus company's arraylist
        super();
        name = "GoBus";
        trips = new ArrayList<Trip>();
        Trip galLim = new Trip(4245, "Galway", "Limerick", "22/12/19", "18:00:00", "22/12/19", "19:30:00", 14.00, 45);
        trips.add(galLim);
        Trip galDub = new Trip(4251, "Galway", "Dublin", "12/12/19", "14:00:00", "12/12/19", "16:40:00", 19.00, 45);
        trips.add(galDub);
        Trip galCork = new Trip(4256, "Galway", "Cork", "17/12/19", "11:05:00", "17/12/19", "13:55:00", 21.00, 45);
        trips.add(galCork);
        Trip dubBelf = new Trip(4043, "Dublin", "Belfast", "10/12/19", "15:00:00", "10/12/19", "16:50:00", 18.00, 45);
        trips.add(dubBelf);
        Trip dubGal = new Trip(4025, "Dublin", "Galway", "05/12/19", "23:00:00", "06/12/19", "01:30:00", 25.00, 45);
        trips.add(dubGal);
    }
}