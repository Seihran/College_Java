import java.util.ArrayList;

/**
 * Abstract class Bus, establishes the fields and classes for each bus company
 *
 * @author (Ciarán McCarthy)
 * @version (19/11/19)
 */
public abstract class Bus
{   
    //An arraylist to hold trip objects
    ArrayList<Trip> trips;
    String name;
    
    public void displayTrips()
    {
        //Prints the details of each trip in the arraylist and the name of the company that the array belongs to
        for (Trip trip : trips)
        {
            System.out.println(name + trip);
        }
    }
    
    public boolean bookingTrip(Booking booking)
    {
        if (booking.getTrip() != null)
        {
            //Reduces the no. of available seats by number of passengers if the trip object is not null
            booking.getTrip().setNoOfSeats((booking.getTrip().getNoOfSeats() - booking.getNoOfPassengers()));
	    return true;
        }
        
        return false;
    }
    
    public Trip getTrip(int iD)
    {
        for (int i = 0; i < trips.size(); i++)
        {
            if (trips.get(i).getID() == iD)
            {
                //Searches array for trip object with specified id and returns it
                return trips.get(i);
            }
        }
        
        return null;
    }
}