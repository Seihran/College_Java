import java.util.Scanner;

/*
 * A program to receive user input, one char at a time and compare forwards or backwards
 * with a char array filled with the alphabet. The time taken is also recorded and displayed.
 * 
 * Ciarán McCarthy
 * 23/01/2020
 * */

public class TestTyping
{
	public static void main(String[] args)
	{
		TestTyping test = new TestTyping();
		
		test.test();
	}
	
	//Suppresses warnings about scanner input being left open for future inputs
	@SuppressWarnings("resource")
	public void test()
	{
		Scanner input = new Scanner(System.in);
		char alphabet[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		
		System.out.println("Type the alphabet in order (hit enter between letters");
		boolean check = true;
		boolean pass = true;
		//Loops until a direction is correctly chosen
		while (check)
		{
			System.out.printf("Forwards or Backwards (f/b)?: ");
			char dirCheck = input.next().charAt(0);
			
			if (dirCheck == 'f') {check = false;}
			else if (dirCheck == 'b') {pass = false; check = false;}
			else 
			{
				//Invalid entry message
				System.out.println("Invalid. You must enter either 'f' or 'b' to start.");
			}
		}
		
		int i = 0;
		int j = 1;
		System.out.println("Timer will now start!");
		//Starts the timer after informing the user about it
		long startTime = System.nanoTime();
		while (i < 26 && j < 27)
		{
			//Continues the loop until either direction run through of the alphabet has been completed
			char letter = input.next().charAt(0);
			if (pass)
			{
				//Only enters if the char entered by the user is the current required letter
				//and not the last required letter (to prevent errors about out of bounds index with [i+1])
				if (letter == alphabet[i] && letter != alphabet[25])
				{
					System.out.println("[" + alphabet[i] + ": Correct! Now type " + alphabet[i+1] + "]");
					i++;
				}
				//Increments i to break the loop once the letter required is the last
				else if (letter == alphabet[25])
				{
					i++;
				}
			}
			else
			{
				if (letter == alphabet[26-j] && letter != alphabet[0])
				{
					System.out.println("[" + alphabet[26-j] + ": Correct! Now type " + alphabet[25-j] + "]");
					j++;
				}
				else if (letter == alphabet[0])
				{
					j++;
				}
			}
		}
		//Ends timer and converts to milliseconds
		long endTime = System.nanoTime();
		float duration = (endTime - startTime)/1000000;
		//Converts time to float and seconds
		duration = duration / (float)1000;
		
		System.out.println("Correct! Well done!]");
		//Prints out time taken to 3 decimal places
		System.out.printf("\nTime taken: %.3f seconds", duration);
	}
}