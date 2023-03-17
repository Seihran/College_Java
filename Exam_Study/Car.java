public class Car
{
    public String name;
    public int model;
    
    Car()
    {
        name = "Nissan";
        model = 2005;
    }
    
    public void display()
    {
        System.out.println("Car's info: ");
        System.out.println("Name is: " + name);
        System.out.println("Model is: " + model);
    }
}