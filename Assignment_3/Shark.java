
public class Shark extends Fish
{
    // instance variables - replace the example below with your own
    String name; // the name of this Shark
    boolean isDangerous;
    String bites;
    
    public Shark(String name)
    {
        super(); // call the constructor of the superclass Fish
        this.name = name;
        colour = "grey"; // this overrides the value inherited from Fish
        isDangerous = true;
        bites = canBite();
    }
    
    public String getName()
    {
        return name;
    }
    
    public String canBite()
    {
        //Outputs the force of a shark's bite if canBite is called
        return "I can bite with a force of 4000 psi;";
    }
    
    /**
     * toString method returns a String representation of the bird
     * What superclass has Shark inherited this method from? 
     */
    @Override
    public String toString()
    {
        String strng ="";
        strng+= "I am a Shark; \n";
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
        strng+= "I am dangerous: ";
        strng+= isDangerous;
        strng+= "; \n";
        strng+= canBite();
        return strng;
    }

    /**
     * equals method defines how equality is defined between 
     * the instances of the Shark class
     * param Object
     * return true or false depending on whether the input object is 
     * equal to this Shark object
     */
    
    @Override
    public boolean equals(java.lang.Object object)
    {
        if (object instanceof Shark && this.name == ((Shark)object).getName() && this.colour == ((Shark)object).getColour())
        {
            return true;
        }
        
        return false;
    }
}
