import java.util.ArrayList;

/**
 * Extends Bus class.
 *
 * @author (Ciarán McCarthy)
 * @version (19/11/19)
 */
public class CityLink extends Bus
{
    public CityLink()
    {
        //Adds multiple trips to this bus company's arraylist
        super();
        name = "CityLink";
        trips = new ArrayList<Trip>();
        Trip galLim = new Trip(2245, "Galway", "Limerick", "22/12/19", "12:00:00", "22/12/19", "13:30:00", 9.00, 70);
        trips.add(galLim);
        Trip galDub = new Trip(2251, "Galway", "Dublin", "12/12/19", "09:00:00", "12/12/19", "11:40:00", 20.00, 70);
        trips.add(galDub);
        Trip galCork = new Trip(2256, "Galway", "Cork", "17/12/19", "20:05:00", "17/12/19", "22:55:00", 16.00, 70);
        trips.add(galCork);
        Trip dubBelf = new Trip(2043, "Dublin", "Belfast", "10/12/19", "06:00:00", "10/12/19", "07:50:00", 15.00, 70);
        trips.add(dubBelf);
        Trip dubGal = new Trip(2025, "Dublin", "Galway", "05/12/19", "23:55:00", "06/12/19", "02:25:00", 18.00, 70);
        trips.add(dubGal);
    }
}