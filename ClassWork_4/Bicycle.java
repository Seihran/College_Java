
/**
 * Simple Bicycle class.
 */
public class Bicycle
{
    private int speed; //field for speed value
    private int gear; // field for gear value

    public static void main(String[] args)
    {
        Bicycle bike1 = new Bicycle(4, 20);
        Bicycle bike2 = new Bicycle(2, 10);
        
        /*
        if (bike2.equals(bike1))
        {
            System.out.println("True");
        }
        else
        {
            System.out.println("False");
        }
        */
        
        System.out.println(bike2.equals(bike1)? "True" : "False");
    }

    /**
     * Constructor for objects of class Bicycle
     * Constructor takes two parameters
     * 
     */
    public Bicycle(int speed, int gear)
    {
        this.speed = speed; // initialises speed field
        this.gear = gear; // initialises gear field
    }
    
    /**
     * accessor method for speed field
     */
    public int getSpeed(){
        return speed ;
    }
    
    /**
     * accessor method for gear field
     */
    public int getGear(){
        return gear;
    }

    /**
     * mutator method for gear field
     */
    public void setGear(int gear){
        this.gear=gear;
    }
    
    /**
     * mutator method for speed field
     */
    public void setSpeed(int speed){
        this.speed=speed;
    }
    
    /**
     * Version 1 of an equals method
     * @param  object a parameter of type Bicycle
     * @returns true or false
     */
    public boolean equals(Object obj)
    { 
        /*
        if (speed == bike.getSpeed() && gear == bike.getGear())
        {
            return true;
        }
        return false;  //default return value
        */
       
        if (obj == null)
        {
            return false;
        }
        
        if (obj instanceof Bicycle)
        {
            Bicycle bike = (Bicycle)obj;
            
            if (this.speed == bike.getSpeed() && this.gear == bike.getGear())
            {
                return true;
            }
        }
        return false;
    }
}
    