/**
 * Checks if trip object is valid and if so, books trip.
 * Creates a value for total fare.
 *
 * @author (Ciarán McCarthy)
 * @version (19/11/19)
 */
public class Booking
{
    private int noOfPassengers;
    private double totalFare;
    private Trip trip;
    
    public Booking(Trip trip, int numPass)
    {
        noOfPassengers = numPass;
        makeBooking(trip, numPass);
    }
    
    public boolean makeBooking(Trip trip, int numPass)
    {
        if (trip != null && noOfPassengers > 0)
        {
            //If passed trip object is not null and has passengers > 0 update fare total and return true
            if (trip.getNoOfSeats() > 0 && trip.getNoOfSeats() >= numPass)
            {
                this.trip = trip;
                totalFare = trip.getFare() * numPass;
                return true;
            }
            
            System.out.println("Number of passengers selected: " + noOfPassengers);
            System.out.println("Apologies, there are only " + trip.getNoOfSeats() + " seats left.");
            return false;
        }
        
        return false;
    }
    
    public int getNoOfPassengers()
    {
        return noOfPassengers;
    }
    
    public double getTotalFare()
    {
        return totalFare;
    }
    
    public Trip getTrip()
    {
        return trip;
    }
}
