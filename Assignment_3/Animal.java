
public abstract class Animal
{
    // instance variables
    boolean hasSkin;
    boolean breathes;
    boolean eats;
    String colour;
    String name;
    
    /**
     * Constructor for objects of class Animal
     */
    public Animal()
    {
        breathes = true; //all the subclasses of Animal inherit this property and value
        hasSkin = true; // all the subclasses of Animal inherit this property and value
        colour = "grey"; //all the subclasses of Animal inherit this property and value
        name = "";
        eats = true; //all the subclasses of Animal inherit this property and value
    }
    
    /**
     * move method
     * param int distance - the distance the Animal should move
     * All subclasses inherit this method
     */
    public abstract void move(int distance);
        
    /**
     * getter method for colour field
     * All subclasses inherit this method
     */
    public String getColour()
    {
        return colour;
    }
    
    /**
     * creates an abstract getter method for the name string for all subclasses to inherit
     */
    public abstract String getName();
    
    /**
    * 'getter' method for haSkin field
    * All subclasses inherit this method
    */
    
    public boolean hasSkin()
    {
        return hasSkin;
    }
}
