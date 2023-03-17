import javax.swing.*;

/*
 * Takes in and validates user input
 * 
 * Ciarán McCarthy
 * 6/2/20
 */

public class Scan
{
	String inFix;
	
	public char[] scan()
	{
		inFix = JOptionPane.showInputDialog(null, "Please enter an infix numerical expression between 3 and 20 characters:");
		int i = 0;
		//Creates a character array with number of elements equivalent to the length of the user inputted string
		char[] inFixArray = new char[inFix.length()];
		while (i<inFix.length())
		{
			//Loop to evaluate the inFix expression entered
			//Checks that the string is of the right size
			if (inFix.length() >= 3 && inFix.length() <= 20)
			{
				//Checks each element of the string to make sure it is a valid character
				if (Character.isDigit(inFix.charAt(i)) || inFix.charAt(i) == '+' || inFix.charAt(i) == '-' || inFix.charAt(i) == '*' || inFix.charAt(i) == '/' || inFix.charAt(i) == '^' || inFix.charAt(i) == '(' || inFix.charAt(i) == ')')
				{
					inFixArray[i] = inFix.charAt(i);
					i++;
				}
				else
				{
					//If an invalid character is found, displays it to the user and what characters are valid, then requests the user to re-enter
					JOptionPane.showMessageDialog(null, inFix.charAt(i) + " is an invalid character. Please re-enter expression.");
					JOptionPane.showMessageDialog(null, "Only the following characters are valid: +,-,*,/,^,(,) and numbers 0-9");
					i = 0;
					inFix = JOptionPane.showInputDialog(null, "Please enter an infix numerical expression between 3 and 20 characters:");
					inFixArray = new char[inFix.length()];
				}
			}
			else
			{
				//If the string is of invalid size, requests the user to re-enter
				inFix = JOptionPane.showInputDialog(null, "Invalid. Please enter an expression between 3 and 20 characters:");
			}
		}
		return inFixArray;
	}
	
	//Accessor method for the inFix expression entered
	public String getInFix()
	{
		return inFix;
	}
}