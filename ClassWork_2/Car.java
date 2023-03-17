public class Car
{
    private int totalDistance;
    private Engine engine;
    
    public Car(int kpg)
    {
        engine = new Engine (kpg);
    }
}