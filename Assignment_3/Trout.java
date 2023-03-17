
public class Trout extends Fish
{
    // instance variables - replace the example below with your own
    String name; // the name of this Trout
    boolean hasSpikes;
    boolean isEdible;
    
    public Trout(String name)
    {
        super(); // call the constructor of the superclass Fish
        this.name = name;
        colour = "brown"; // this overrides the value inherited from Fish
        hasSpikes = true;
        isEdible = true;
    }
    
    public String getName()
    {
        return name;
    }
    
    /**
     * toString method returns a String representation of the bird
     * What superclass has Trout inherited this method from? 
     */
    @Override
    public String toString()
    {
        String strng ="";
        strng+= "I am a Trout; \n";
        strng+= "My name is: ";
        strng+= name;
        strng+= "; \n";
        strng+= "I am: ";
        strng+= colour;
        strng+= " in colour; \n";
        strng+= "I have fins: ";
        strng+= hasFins;
        strng+= "; \n";
        strng+= "I have gills: ";
        strng+= hasGills;
        strng+= "; \n";
        strng+= "I have spikes: ";
        strng+= hasSpikes;
        strng+= "; \n";
        strng+= "I am edible: ";
        strng+= isEdible;
        strng+= "; \n";
        strng+= "I swim upriver to lay eggs.";
        return strng;
    }

    /**
     * equals method defines how equality is defined between 
     * the instances of the Trout class
     * param Object
     * return true or false depending on whether the input object is 
     * equal to this Trout object
     */
    
    @Override
    public boolean equals(java.lang.Object object)
    {
        if (object instanceof Trout && this.name == ((Trout)object).getName() && this.colour == ((Trout)object).getColour())
        {
            return true;
        }
        
        return false;
    }
}
