/*
 * Evaluates a postFix expression and returns a final answer
 * 
 * Ciarán McCarthy
 * 6/2/20
 */

public class Evaluation
{
	String postFix;
	
	public Evaluation(String postFix)
	{
		this.postFix = postFix;
	}
	
	public double Evaluate()
	{
		ArrayStack stack = new ArrayStack(20);
		//Loops from 0 to the length of the postFix expression
		for (int i=0; i<postFix.length(); i++)
		{
			//If the current element of the string is a number from '0' to '9'
			if(Character.isDigit(postFix.charAt(i)))
			{
				//casts the current string element to a character and subtracts the ASCII value of '0' to convert it to a number
				double z = (char)postFix.charAt(i)-'0';
				stack.push(z);
			}
			//If the stack size is greater than 1
			else if(stack.size()>1)
			{
				//Pops the top two values, casts them as doubles and assigns them to two variables 'x' and 'y'
				double x = (double)stack.pop();
				double y = (double)stack.pop();
				if (postFix.charAt(i) == '^')
				{
					//If string element is a power notation, uses Math.pow to evaluate and pushes to the stack
					stack.push(Math.pow(y, x));
				}
				else if (postFix.charAt(i) == '*')
				{
					//If string element is a multiplication, evaluates and pushes to the stack
					stack.push(y * x);
				}
				else if (postFix.charAt(i) == '/')
				{
					//If string element is a division, evaluates and pushes to the stack
					stack.push(y / x);
				}
				else if (postFix.charAt(i) == '+')
				{
					//If string element is an addition, evaluates and pushes to the stack
					stack.push(y + x);
				}
				else
				{
					//If string element is a subtraction, evaluates and pushes to the stack
					stack.push(y - x);
				}
			}
		}
		//returns the top of the stack, which by this point is the final answer
		return (double)stack.top();
	}
}