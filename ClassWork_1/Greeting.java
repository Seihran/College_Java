
public class Greeting
{
    // instance variables - replace the example below with your own
    String message = "";

    /**
     * Constructor for objects of class Greeting
     */
    public Greeting()
    {
        // initialise instance variables
        System.out.println("Hello World!");
    }
    
    public Greeting(String msg)
    {
        message = msg;
        System.out.println(message);
    }

}
