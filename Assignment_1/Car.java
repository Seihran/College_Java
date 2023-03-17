
/**
 * Specifies the car model, fuel capacity and distance to be travelled.
 *
 * @ Ciaran
 * @ 21/09/2019
 */
public class Car
{
    // instance variables - replace the example below with your own
    private String carModel = "";
    private double totalDistance;
    private double distance;
    Engine engine;
    //Creates instances of the engine class
    
    public Car(String carModel)
    {
        this.carModel = carModel;
    }
    
    public void setCarModel(String name)
    {
        carModel = name;
    }
    
    public void add(Engine engine)
    {
        //Allows the Car class to have access to the Engine class' methods using
        //the variable engine
        this.engine = engine;
    }
        
    public void printState()
    {
        // Simulates output from a car dash board computer.
        System.out.printf("Distance This Trip: %.2f \n ", distance);
        System.out.printf("Total Distance Travelled: %.2f \n ", totalDistance);
        System.out.printf("Fuel Remaining : %d \n ", engine.getFuel());
    }
    
    public void printConfig()
    {
        //Prints to screen the configuration of the car, the engine and then calls
        //the engine to print the configuration of the wheel
        System.out.printf(" Configuration: Car Body %s \n ", carModel);
        System.out.printf("Engine name: %s \n ", engine.getEngineModel());
        System.out.printf("Engine rotations / litre: %d \n ", engine.getRotationsPerLitre());
        engine.systemState();
    }
    
    public double drive()
    {
        //Calculates the total distance travelled by the car. Calls the engine
        //to get the distance covered by the rotations of the wheel and then
        //multiplies it by rotations per litre to get the total distance the
        //car has moved
        double wheelDistance = engine.rotate();
        distance = wheelDistance * engine.getRotationsPerLitre();
        totalDistance = totalDistance + distance;
        return totalDistance;
    }
}
