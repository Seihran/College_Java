/*
 *Loops through the numbers 0 to 1000000 and checks if they are palindromic for base
 *10 and base 2 using 4 methods: Reversal of a string check, element by element check,
 *stack vs queue check and a recursion reversal of a string check. The number of operations
 *and the time taken to run these methods is calculated and displayed for every 50000
 *numbers and for the total run.
 *
 *Ciarán McCarthy
 *28/02/2020 
 * */

public class Main
{
	public static long operationsCounter[] = {0,0,0,0};
	
	public static void main(String[] args)
	{
		String dec = "";
		//Creates arrays to store time taken for each method and method names
		double time[] = {0,0,0,0};
		double decTime[] = {0,0,0,0};
		double binTime[] = {0,0,0,0};
		String methodName[] = {"Reverse","Element","StackQueue","Recursion"};
		//Checks for whether or not numbers are palindromes and how many of them there are
		int countCheck = 0;
		int countDec = 0;
		int countBin = 0;
		boolean checkDec = true;
		boolean checkBin = true;
		int j = 0;
		//A loop to run through the numbers 0 to 1000000
		for (int i=0;i<=1000000;i++)
		{
			//Sets the value of the string dec to the value of i
			dec += i;
			//Converts the decimal string to a binary string
			String bin = convert(dec);
			//Loops through each method
			for (j=0;j<4;j++)
			{
				//Sets a value in the deciaml time array to the system time in nanoseconds
				decTime[j] = System.nanoTime();
				//Calls a method which calls one of the palindrome checking methods
				//based on the value of j and sends it the decimal string
				checkDec = Main.callMethod(j, dec);
				//Sets another value in the deciaml time array to the system time in nanoseconds
				//Overwrites the first value with the difference of the two measured times 
				decTime[j] = (System.nanoTime() - decTime[j]);
				//Increases the operations counter for the relevant method by 2
				//to correspond with the conversion of the decimal string to binary
				operationsCounter[j] += 2;
				binTime[j] = System.nanoTime();
				//Calls a method which calls one of the palindrome checking methods
				//based on the value of j and sends it the binary string
				checkBin = Main.callMethod(j, bin);
				binTime[j] = (System.nanoTime() - binTime[j]);
				time[j] += (decTime[j] + binTime[j])/100000;
			}
			//Sets the value of dec to null
			dec = "";
			//Increases a value if both the decimal and binary number are palindromes
			if (checkDec && checkBin)
			{
				countCheck ++;
			}
			//Increases a value if the decimal number is a palindrome
			if (checkDec)
			{
				countDec ++;
			}
			//Increases a value if the binary number is a palindrome
			if (checkBin)
			{
				countBin ++;
			}
			//If the current number is divisible by 50000, enter loop
			if (i % 50000 == 0)
			{
				//Loops for each method
				for (j=0;j<4;j++)
				{
					//If number = 0, prints the number of operations and time taken
					if (i == 0)
					{
						System.out.println("No. of Operations for the first number '0'. " + methodName[j] + " method: " + operationsCounter[j]);
						System.out.println("Time taken for the first number '0' (ms). " + methodName[j] + " method: " + time[j]);
						System.out.println();
					}
					//Else prints the total number of operations and time taken
					else
					{
						System.out.println("No. of Operations for first " + i + " numbers. " + methodName[j] + " method: " + operationsCounter[j]);
						System.out.printf("Time taken for first %d numbers (ms). " + methodName[j] + " method: %.2f\n",i, time[j]);
						System.out.println();
					}
				}
			}
		}
		//For each method, prints the methods name and the total operations undertaken
		//and the total time taken for both decimal and binary combined
		for (j=0;j<4;j++)
		{
			System.out.println(methodName[j] + " Method:");
			System.out.println("Total Operations: " + operationsCounter[j]);
			System.out.printf("Total Time taken (ms): %.2f\n", time[j]);
		}
		//Prints the number of palindromic numbers for decimal, binary and both
		System.out.println("Number of palindromic decimal numbers: " + countDec);
		System.out.println("Number of palindromic binary numbers: " + countBin);
		System.out.println("Number of palindromic numbers for both: " + countCheck);
	}
	
	public static boolean reversion(String number)
	{
		String revNumber = "";
		//Increases operations counter for method 1 by 4,
		//Create string and assign value to it (1),
		//create int j (1), assign it calculated length (1), minus that value (1)
		operationsCounter[0] += 4;
		for (int j=number.length()-1;j>=0;j--)
		{
			//Create reverse string
			revNumber += number.charAt(j);
			//Compare j (1), assign value (1), calculate position (1), decrease j (1)
			operationsCounter[0] += 4;
		}
		operationsCounter[0] ++;
		//Return boolean value of compared strings (1)
		return number.contentEquals(revNumber);
	}
	
	public static boolean elementByElement(String number)
	{
		operationsCounter[1] ++;;
		for (int k=0;k<number.length();k++)
		{
			//Compare k (1), calculate value to compare with k(1),
			//compare (1) character at position k (1)
			//calculate value to compare with k: position at (1), length of (1)
			//minus (1), k +1 (1)
			operationsCounter[1] += 8;
			if (number.charAt(k) != number.charAt(number.length()-(k+1)))
			{
				return false;
			}
			//Increase k (1)
			operationsCounter[1] ++;
		}
		return true;
	}
	
	public static boolean stackQueue(String number)
	{
		ArrayStack stack = new ArrayStack(number.length());
		ArrayQueue queue = new ArrayQueue(number.length());
		//Increase counter by number of operations to create a new stack and a new queue
		//and give them a size of the calculated length
		operationsCounter[2] += 15;
		for (int l=0;l<number.length();l++)
		{
			stack.push(number.charAt(l));
			queue.enqueue(number.charAt(l));
			//Increase counter by number of operations to push and enqueue a character
			//found at a calculated position
			operationsCounter[2] += 17;
		}
		boolean check = true;
		operationsCounter[2] += 2;
		for (int l=0;l<number.length();l++)
		{
			//Increases counter by number of operations determined to be in the
			//pop and dequeue methods. The dequeue method's number of operations
			//is n-1 for n loops i.e. 5*5 for loop 1, 5*4 for loop 2 etc
			operationsCounter[2] += (18 + 5*(number.length()-l));
			if (stack.pop() != queue.dequeue())
			{
				check = false;
			}
		}
		return check;
	}
	
	public static boolean recursion(String number)
	{
		//Calls the recursion method and then checks the subsequent string against the initial
		operationsCounter[3] += 2;
		if (number.contentEquals(reverse(number)))
		{
			return true;
		}
		return false;
	}
	
	public static String reverse(String number)
	{
		operationsCounter[3] += 3;
		//If the string is empty or of length 1 or less, return the string
		if ((number == null) || (number.length() <= 1))
		{
			return number;
		}
		operationsCounter[3] += 3;
		//Else, return a recursive call + a series of characters. Calls itself with a string
		//which is the initial string minus the first character, this continues until the
		//string is empty and then the characters that were removed are returned as
		//a string which is in reverse order to the initial string
		return reverse(number.substring(1)) + number.charAt(0);
	}
	
	public static boolean callMethod(int j, String num)
	{
		//A series of if statements which call one of the palindromic methods
		//specified by the value of j
		if (j == 0)
		{
			return Main.reversion(num);
		}
		else if (j == 1)
		{
			return Main.elementByElement(num);
		}
		else if (j == 2)
		{
			return Main.stackQueue(num);
		}
		return Main.recursion(num);
	}
	
	public static String convert(String decimal)
	{
		//Converts an incoming string to an integer and then back into a string of a
		//different base system, in this case base 2, binary
		return Integer.toString(Integer.parseInt(decimal), 2);
	}
}