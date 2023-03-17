/*
 * Converts an inFix expression to postFix expression
 * 
 * Ciarán McCarthy
 * 6/2/20
 */

public class Translation
{
	char[] inFixArray;
	
	public Translation(char[] inFixArray)
	{
		this.inFixArray = inFixArray;
	}
	
	public String Translate()
	{
		ArrayStack stack = new ArrayStack(20);
		OperatorPrecedence prec = new OperatorPrecedence();
		String postFix = "";
		for (int i=0; i<inFixArray.length; i++)
		{
			if (Character.isDigit(inFixArray[i]))
			{
				//If the current element of the array is a numerical digit, attaches it to postFix string
				postFix += inFixArray[i];
			}
			else if (inFixArray[i] == '(')
			{
				//If the current element of the array is an open bracket, pushes it to the stack
				stack.push(inFixArray[i]);
			}
			else if (inFixArray[i] == ')')
			{
				//If the current element of the array is an closed bracket, opens a loop that runs for the size of the stack
				for (int j=0; j<stack.size(); j++)
				{
					if ((char)stack.top() != '(')
					{
						////If the top of the stack is an open bracket, pops it
						postFix += stack.pop();
					}
					else
					{
						//Else pops it and breaks the loop
						stack.pop();
						break;
					}
				}
			}
			else
			{
				if (stack.isEmpty() || prec.Prec(inFixArray[i]) > prec.Prec((char)stack.top()) || inFixArray[i] == '(')
				{
					//If stack is empty, the current element has greater precedence than the top of the stack or the element is an open bracket, push the element
					stack.push(inFixArray[i]);
				}
				else
				{
					for (int j=0; j<stack.size(); j++)
						{
						//Loop for the size of the stack
							if (prec.Prec(inFixArray[i]) <= prec.Prec((char)stack.top()))
								{
								//If the precedence of the current element is less than or equal to the precedence of the element on the top of the stack
								//If the top element of the stack is a bracket
									if ((char)stack.top() == '(' || (char)stack.top() == ')')
									{
										//Push the current element and then break the loop
										stack.push(inFixArray[i]);
										break;
									}
									else
									{
										//Else pop the stack to the postFix string
										postFix += stack.pop();
									}
								}
						}
						stack.push(inFixArray[i]);
				}
			}
		}
		//This loop pops anything remaining in the stack
		for (int j=0; j<=stack.size(); j++)
		{
			if((char)stack.top() != '(' && (char)stack.top() != ')')
			{
				postFix += stack.pop();
			}
		}
		return postFix;
	}
}