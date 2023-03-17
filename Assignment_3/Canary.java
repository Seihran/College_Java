
public class Canary extends Bird
{
    // instance variables - replace the example below with your own
    String name; // the name of this Canary

    /**
     * Constructor for objects of class Canary
     */
    public Canary(String name)
    {
        super(); // call the constructor of the superclass Bird
        this.name = name;
        colour = "yellow"; // this overrides the value inherited from Bird
    }
    
    /**
     * Sing method overrides the sing method
     * inherited from superclass Bird
     */
    @Override // good programming practice to use @Override to denote overridden methods
    public void sing()
    {
        System.out.println("Tweet, tweet, tweet");
    }
    
    public String getName()
    {
        return name;
    }
    
    /**
     * toString method returns a String representation of the bird
     * What superclass has Canary inherited this method from? 
     */
    @Override
    public String toString()
    {
        String strng ="";
        strng+= "I am a Canary; \n";
        strng+= "My name is: ";
        strng+= name;
        strng+= "; \n";
        strng+= "I am: ";
        strng+= colour;
        strng+= " in colour; \n";
        strng+= "I have feathers: ";
        strng+= hasFeathers;
        strng+= "; \n";
        strng+= "I have wings: ";
        strng+= hasWings;
        strng+= "; ";
        return strng;
    }

    /**
     * equals method defines how equality is defined between 
     * the instances of the Canary class
     * param Object
     * return true or false depending on whether the input object is 
     * equal to this Canary object
     */
    
    @Override
    public boolean equals(java.lang.Object object)
    {
        //Checks if passed in object is an instance of this class and whether its name and colour are equal to
        //this instance
        if (object instanceof Canary && this.name == ((Canary)object).getName() && this.colour == ((Canary)object).getColour())
        {
            return true;
        }
        
        return false;
    }
}
