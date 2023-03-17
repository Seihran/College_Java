/**
 * Creates fields for all details of a trip and sets a toString method for return these values.
 *
 * @author (Ciarán McCarthy)
 * @version (19/11/19)
 */
public class Trip
{
    private int id;
    private String startingLocation;
    private String destination;
    private String dateOfDeparture;
    private String timeOfDeparture;
    private String dateOfArrival;
    private String timeOfArrival;
    private double fare;
    private int noOfSeats;
    
    public Trip(int id, String start, String dest, String dateDep, String timeDep, String dateArr, String timeArr, double fare, int numSeats)
    {
        this.id = id;
        startingLocation = start;
        destination = dest;
        dateOfDeparture = dateDep;
        timeOfDeparture = timeDep;
        dateOfArrival = dateArr;
        timeOfArrival = timeArr;
        this.fare = fare;
        noOfSeats = numSeats;
    }
    
    @Override
    public String toString()
    {
        //Returns details of trip in an override method
        String out = "\nTrip ID: " + id + "\nStart: " + startingLocation;
        out += "\nDestination: " + destination;
        out += "\nDeparture Date: " + dateOfDeparture;
        out += "\nDeparture Time: " + timeOfDeparture;
        out += "\nArrival Date: " + dateOfArrival;
        out += "\nArrival Time: " + timeOfArrival;
        out += "\nFare: €" + fare + " per passenger";
        out += "\nAvailable Seats: " + noOfSeats;
        out += "\n";
        return out;
    }
    
    public double getFare()
    {
        return fare;
    }
    
    public int getNoOfSeats()
    {
        return noOfSeats;
    }
    
    public int getID()
    {
        return id;
    }
    
    public String getStart()
    {
        return startingLocation;
    }
    
    public String getDest()
    {
        return destination;
    }
    
    public String getDepTime()
    {
        String dep = dateOfDeparture + " " + timeOfDeparture;
        return dep;
    }
    
    public String getArrTime()
    {
        String arr = dateOfArrival + timeOfArrival;
        return arr;
    }
    
    public void setNoOfSeats(int seats)
    {
        noOfSeats = seats;
    }
}
