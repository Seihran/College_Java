
/**
 * Write a description of class Bicycle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bicycle
{
    // instance variables - replace the example below with your own
    private int speed;
    private int gear;
    private int cadence;
    private Wheel front;
    private Wheel back;

    /**
     * Constructor for objects of class Bicycle
     */
    public Bicycle(int spd, int gr, int cad)
    {
        speed = spd;
        gear = gr;
        cadence = cad;
        front = new Wheel (5);
        back = new Wheel (5);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
}
