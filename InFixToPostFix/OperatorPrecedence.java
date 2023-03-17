/*
 * Creates a switch case for operator precedence
 * 
 * Ciarán McCarthy
 * 6/2/20
 */

public class OperatorPrecedence
{
	//Sets up a switch case to return differing values based on operator precedence
	public int Prec(char a)
	{
		switch (a)
		{
		//Lowest precedence, lower value
			case '+':
			case '-':
			return 1;
			
			case '*':
			case '/':
			return 2;
			
			//Highest precedence, highest value
			case '^':
			return 3;
		}
		//if character received is none of these returns a negative value, lowest value
		return -1;
	}
}