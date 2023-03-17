
public abstract class Fish extends Animal
{
    //instance variables (fields)
    boolean hasFins;
    boolean hasGills;
    boolean swims;
    
    public Fish()
    {
        super(); //calls the constructor of its superclass  - Animal
        colour = "silver"; //overrides the value of colour inherited from Animal
        hasFins = true; //all the subclasses of Fish inherit this property and value
        hasGills = true; //all the subclasses of Fish inherit this property and value
        swims = true; //all the subclasses of Fish inherit this property and value
    }

    /**
     * move method overrides the move method
     * inherited from superclass Animal
     */
    @Override // good programming practice to use @Override to denote overridden methods
    public void move(int distance)
    {
        System.out.printf("I swim %d metres. \n", distance);
    }
    
    /**
     * 'getter' method for the hasGills field
     */
    public boolean hasGills()
    {
        return hasGills;
    }
    
    /**
     * 'getter' method for the hasFins field
     */
    public boolean hasFins(){
        return hasFins;
    }
}