
/**
 * Collates the information from the car, engine and wheel classes to
 * demonstrate the efficiency and performance of different configurations
 *
 * @ Ciaran
 * @ 23/09/2019
 */
public class TestCar
{
    public static void main(String[] args)
    {
        //Sends the configuration values to the relevant class'
        Car car = new Car("R7");
        Engine engine = new Engine("QT6", 17);
        if(engine.getRotationsPerLitre() <= 0)
        {
            //Checks if the value for rotations per litre is greater than zero
            //if not, stops program, then prints to the screen and requests a new value
            System.out.printf("This is an invalid value, please enter a value ");
            System.out.printf("for the rotations per litre that is greater than zero.");
            return;
        }
        car.add(engine);
        //Calls a method in the car class to allow it access to the engine
        Wheel wheel = new Wheel("Wichelin26", 26);
        if(wheel.getRadius() <= 0)
        {
            //Checks if the value for radius is greater than zero, if not,
            //stops program, then prints to the screen and requests a new value
            System.out.printf("This is an invalid value, please enter a value ");
            System.out.printf("for the radius that is greater than zero.");
            return;
        }
        engine.setFuel(72);
        //sets fuel value
        car.drive();
        //tells Car class to run the drive command to test current configuration
        car.printConfig();
        //Prints current configuration to the screen
        car.printState();
        //Prints result of test
        System.out.printf("\n ");
        //Repeats process with different fuel value
        engine.setFuel(-5);
        car.drive();
        car.printConfig();
        car.printState();
        System.out.println();
    }
}
