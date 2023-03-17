
public class Ostrich extends Bird
{
    String name; // the name of this Ostrich
    boolean isTall;
    boolean hasThinLongLegs;

    /**
     * Constructor for objects of class Ostrich
     */
    public Ostrich(String name)
    {
        super(); // call the constructor of the superclass Bird
        this.name = name;
        colour = "brown"; // this overrides the value inherited from Bird
        isTall = true;
        flies = false;
        hasThinLongLegs = true;
    }
    
    public String getName()
    {
        return name;
    }
    
    /**
     * Sing method overrides the sing method
     * inherited from superclass Bird
     */
    @Override // good programming practice to use @Override to denote overridden methods
    public void sing()
    {
        System.out.println("Bark, bark, bark");
        //Ostriches apparently either chirp, bark, hiss or hum
    }
    
    /**
     * toString method returns a String representation of the bird
     * What superclass has Ostrich inherited this method from? 
     */
    @Override
    public String toString()
    {
        String strng ="";
        strng+= "I am an Ostrich; \n";
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
        strng+= "; \n";
        strng+= "I am tall: ";
        strng+= isTall;
        strng+= "; \n";
        strng+= "I have thin long legs: ";
        strng+= hasThinLongLegs;
        strng+= "; ";
        return strng;
    }

    /**
     * equals method defines how equality is defined between 
     * the instances of the Ostrich class
     * param Object
     * return true or false depending on whether the input object is 
     * equal to this Ostrich object
     */
    
    @Override
    public boolean equals(java.lang.Object object)
    {
        if (object instanceof Ostrich && this.name == ((Ostrich)object).getName() && this.colour == ((Ostrich)object).getColour())
        {
            return true;
        }
        
        return false;
    }
}