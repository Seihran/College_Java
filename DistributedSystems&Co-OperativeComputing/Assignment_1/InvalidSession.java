/*
 * @author (Ciarán McCarthy)
 * @student id: 17102168
 * @version (13/03/2021)
 * 
*/
//Exception for invalid session ID
public class InvalidSession extends Exception
{
	private static final long serialVersionUID = -7223668232634157986L;
	
	public InvalidSession(String message)
	{
	   super(message);
	}
}
