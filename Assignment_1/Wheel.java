
/**
 * Specifies the radius, type and circumference of wheel and allows other classes
 * to access and assign values to them
 *
 * @ Ciaran
 * @ 21/09/2019
 */
public class Wheel
{
    //Initialising all variables used in Wheel class
    private String wheelType = "";
    private float radius;
    private double circumference;

    public Wheel(String wheelType, float radius)
    {
        //Assigns incoming arguments (wheel type and radius of wheel) to
        //their corresponding variables
        this.wheelType = wheelType;
        this.radius = radius;
    }
    
    public void setWheelType(String name)
    {
        //Allows assigning of values to wheel type from another class
        wheelType = name;
    }
    
    public void setRadius(float radius)
    {
        //Allows assigning of values to radius from another class
        this.radius = radius;
    }
    
    public String getWheelType()
    {
        //Allows reading of value from wheel type from another class
        return wheelType;
    }
    
    public float getRadius()
    {
        //Allows reading of value from radius from another class
        return radius;
    }
    
    public double turn()
    {
        //Calculates the circumference and gives access for its value to be read
        //from another class
        circumference = 2 * Math.PI * radius;
        return circumference;
    }
}
