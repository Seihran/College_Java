
/**
 * Takes the wheel size, fuel and times the wheel can be rotated per litre
 * to calculate the total number of times that the wheel can rotate based
 * on fuel supplied.
 *
 * @ Ciaran
 * @ 21/09/2019
 */
public class Engine
{
    //Initialising all variables used in Engine class
    private String engModel = "";
    private int rotPerLitre;
    private int rotations;
    //Counter for no. of times the turn() method has been called
    private int totalRotate;
    //Number of times the wheel has been turned in total
    private int fuel;
    private double distanceMoved;
    private double totalMove;
    Wheel wheel = new Wheel("Wichelin15", 15);
    //Creates an instance of the wheel class to allow Engine to access its objects

    public Engine(String engModel, int rotPerLitre)
    {
        this.engModel = engModel;
        this.rotPerLitre = rotPerLitre;
    }
    
    public void setEngineModel(String name)
    {
        engModel = name;
    }
    
    public void setRotationsPerLitre(int rotPerLitre)
    {
        this.rotPerLitre = rotPerLitre;
    }
    
    public void setFuel(int fuel)
    {
        //Allows fuel value to be set from another class, however if the value is
        //zero or less, prints to screen that there is no fuel
        this.fuel = fuel;
        if (fuel > 0)
        {
            System.out.printf("Current fuel: %d", fuel);
            System.out.println();
        }
        else
        {
            System.out.printf("There is no fuel!");
            System.out.println();
        }
    }
    
    public void setTotalRotations(int totalRotate)
    {
        this.totalRotate = totalRotate;
    }
    
    public int getFuel()
    {
        return fuel;
    }
    
    public String getEngineModel()
    {
        return engModel;
    }
    
    public int getRotationsPerLitre()
    {
        return rotPerLitre;
    }
    
    public int getTotalRotate()
    {
        return totalRotate;
    }
    
    public void systemState()
    {
        //Prints to screen the current status of the wheel
        System.out.printf("Wheel's total rotations: %d \n ", totalRotate);
        System.out.printf("Wheel name: %s \n ", wheel.getWheelType());
        System.out.printf("Wheel radius: %.2f \n ", wheel.getRadius());
        System.out.printf("Wheel circumference: %.2f \n ", wheel.turn());
    }
    
    public double rotate()
    {
        //Calculates the total rotations of the wheel and how much distance that
        //covers, only so long as there is fuel remaining
        rotations = 0;
        if (fuel > 0)
        {
            while (fuel >= 1)
            {
                fuel = fuel - 1;
                rotations = rotations + 1;
                distanceMoved = wheel.turn();
                totalMove = totalMove + distanceMoved;
            }
            totalRotate = rotations * rotPerLitre;
            this.setTotalRotations(totalRotate);
            return totalMove;
        }
        else
        {
            return 0;
        }
    }
}
