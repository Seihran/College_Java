public class SportsCar extends Car
{
    private int topSpeed;
    
    SportsCar()
    {
        super();
        name = "Lambourghini";
        model = 430;
        topSpeed = 230;
    }
    
    public void display()
    {
        System.out.println("Car's info: ");
        System.out.println("Name is: " + name);
        System.out.println("Model is: " + model);
        System.out.println("Top Speed is: " + topSpeed + " km/h");
    }
}