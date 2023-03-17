/**
 * Creates multiple test scenarios.
 *
 * @author (Ciarán McCarthy)
 * @version (19/11/19)
 */
public class Travel_Ireland
{
    public static void main(String args[])
    {
        Travel_Ireland test = new Travel_Ireland();
        
        test.test1();
        test.test2();
        test.test3();
    }
    
    public void test1()
    {
        //Checks if programme works with correct values
        BusEireann bE = new BusEireann();
        
        bE.displayTrips();

        Trip chosenTrip = bE.getTrip(3025);
        
        if (chosenTrip != null)
        {
            //Checks if a correct trip id was chosen
            System.out.println("Your chosen trip is: \n" + bE.getTrip(3025));
        }
        else
        {
            System.out.println("No valid trip chosen.\n");
        }
        
        Booking book = new Booking(chosenTrip, 10);
        
        boolean success = bE.bookingTrip(book);
        
        if (success)
        {
            //If the trip was successfully booked
            System.out.println("Your booking was successful.");
            System.out.println("++++++++++++++++++++++++++++++++++++");
            System.out.println("Trip ID: " + book.getTrip().getID());
            System.out.println("Number of Passengers: " + book.getNoOfPassengers());
            System.out.println("Trip details: (" + book.getTrip().getStart() + ") to (" + book.getTrip().getDest() + ")\n"
            + "Departure: (" + book.getTrip().getDepTime() + ")\nArrival: (" + book.getTrip().getArrTime() + ")");
            System.out.println("Total Fare: " + book.getTotalFare());
            System.out.println("++++++++++++++++++++++++++++++++++++");
        }
        else
        {
            System.out.println("\nBooking has failed.\n\n");
        }
        
        if (chosenTrip != null && success == true)
        {
            //Prints details of chosen trip, only if it is not null and the booking was made
            System.out.println(chosenTrip);
        }
    }
    
    public void test2()
    {
        //Checks if programme works with incorrect id value
        GoBus gB = new GoBus();
        
        gB.displayTrips();
        
        Trip chosenTrip = gB.getTrip(3025);
        
        if (chosenTrip != null)
        {
            System.out.println("Your chosen trip is: \n" + gB.getTrip(3025));
        }
        else
        {
            System.out.println("No valid trip chosen.\n");
        }
        
        Booking book = new Booking(chosenTrip, 5);
        
        boolean success = gB.bookingTrip(book);
        
        if (success)
        {
            System.out.println("Your booking was successful.");
            System.out.println("++++++++++++++++++++++++++++++++++++");
            System.out.println("Trip ID: " + book.getTrip().getID());
            System.out.println("Number of Passengers: " + book.getNoOfPassengers());
            System.out.println("Trip details: (" + book.getTrip().getStart() + ") to (" + book.getTrip().getDest() + ")\n"
            + "Departure: (" + book.getTrip().getDepTime() + ")\nArrival: (" + book.getTrip().getArrTime() + ")");
            System.out.println("Total Fare: " + book.getTotalFare());
            System.out.println("++++++++++++++++++++++++++++++++++++");
        }
        else
        {
            System.out.println("\nBooking has failed.\n\n");
        }
        
        if (chosenTrip != null && success == true)
        {
            System.out.println(chosenTrip);
        }
    }
    
    public void test3()
    {
        //Checks if programme works with more passengers than seats
        CityLink cL = new CityLink();
        
        cL.displayTrips();
        
        Trip chosenTrip = cL.getTrip(2251);
        
        if (chosenTrip != null)
        {
            System.out.println("Your chosen trip is: \n" + cL.getTrip(2251));
        }
        else
        {
            System.out.println("No valid trip chosen.\n");
        }
        
        Booking book = new Booking(chosenTrip, 72);
        
        boolean success = cL.bookingTrip(book);
        
        if (success)
        {
            System.out.println("Your booking was successful.");
            System.out.println("++++++++++++++++++++++++++++++++++++");
            System.out.println("Trip ID: " + book.getTrip().getID());
            System.out.println("Number of Passengers: " + book.getNoOfPassengers());
            System.out.println("Trip details: (" + book.getTrip().getStart() + ") to (" + book.getTrip().getDest() + ")\n"
            + "Departure: (" + book.getTrip().getDepTime() + ")\nArrival: (" + book.getTrip().getArrTime() + ")");
            System.out.println("Total Fare: " + book.getTotalFare());
            System.out.println("++++++++++++++++++++++++++++++++++++");
        }
        else
        {
            System.out.println("\nBooking has failed.\n\n");
        }
        
        if (chosenTrip != null && success == true)
        {
            System.out.println(chosenTrip);
        }
    }
}