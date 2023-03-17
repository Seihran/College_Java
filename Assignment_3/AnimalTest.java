public class AnimalTest
{
    public static void main(String[] args)
    {
        AnimalTest test = new AnimalTest(); //Creates an instance of the AnimalTest class
        
        test.test1(); //Calls test method one
        test.test2(); //Calls test method two
    }
    
    public void test1()
    {
        //Creates an array of type Animal and fills it with the four different types of animal being tested
        Animal[] animals = new Animal[4];
        animals[0] = new Canary("Tweetie");
        animals[1] = new Ostrich("Madame Upanova");
        animals[2] = new Shark("Bruce");
        animals[3] = new Trout("Troupple");
        int i = 0;
        
        for (Animal animal: animals)
        {
            //Loops for each object in the array
            if (animals[i] instanceof Canary)
            {
                //If the object is a Canary runs this section
                System.out.println(animal);
                System.out.println("I can sing: ");
                //Casts object as a Canary so that the sing method in Canary can be called
                ((Canary)animals[i]).sing();
                animals[i].move(5);
                System.out.println();
                //Increases the value of i
                i++;
            }
            else if (animals[i] instanceof Ostrich)
            {
                //If the object is an Ostrich, runs this section
                System.out.println(animal);
                System.out.println("I can't sing but I can: ");
                //Casts object as an Ostrich to call the sing method in Ostrich
                ((Ostrich)animals[i]).sing();
                animals[i].move(5);
                System.out.println();
                i++;
            }
            else
            {
                //If the object is neither a Canary nor an Ostrich, runs this section
                System.out.println(animal);
                animals[i].move(5);
                System.out.println();
                i++;
            }
        }
    }
    
    public void test2()
    {
        //Creates an array of each different animal
        Animal[] animals = new Animal[4];
        animals[0] = new Canary("Tweetie");
        animals[1] = new Ostrich("Madame Upanova");
        animals[2] = new Shark("Bruce");
        animals[3] = new Trout("Troupple");
        
        //Creates a second array of each different animal in different positions and with some differing names
        Animal[] animals2 = new Animal[4];
        animals2[0] = new Canary("Sylvester");
        animals2[1] = new Ostrich("Madame Upanova");
        animals2[2] = new Trout("Bruce");
        animals2[3] = new Shark("Troupple");
        
        for (int i = 0; i < animals.length; i++)
        {
            //Loops from 0 to the length of the array
            //Checks if both objects are instances of the same Class
            System.out.println("Is " + animals[i].getName() + " a/an " + animals[i].getClass().getName() + " and ");
            System.out.println("is " + animals2[i].getName() + " a/an " + animals[i].getClass().getName() + ": ");
            String check = (animals[i].getClass().getName());
            String check2 = (animals2[i].getClass().getName());
            
            if (check == check2)
            {
                //If both objects are instances of the same animal class, checks if they are the same instance
                System.out.println("True");
                System.out.println("Is " + animals[i].getName() + " the same " + animals[i].getClass().getName() + " as " + animals2[i].getName());
                System.out.println(animals[i].equals(animals2[i]));
                System.out.println();
            }
            else
            {
                //If the objects are instances of different animals, outputs what animal type they are
                System.out.println("False");
                System.out.println();
                System.out.println(animals[i].getName() + " is a/an " + animals[i].getClass().getName() + " while, ");
                System.out.println(animals2[i].getName() + " is a/an " + animals2[i].getClass().getName());
                System.out.println();
            }
        }
    }
}