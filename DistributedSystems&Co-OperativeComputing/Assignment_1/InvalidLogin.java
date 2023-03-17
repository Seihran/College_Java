/*
 * @author (Ciarán McCarthy)
 * @student id: 17102168
 * @version (13/03/2021)
 * 
*/
//Exception for invalid login credentials
public class InvalidLogin extends Exception
{
	private static final long serialVersionUID = -7599514687910701613L;

	public InvalidLogin(String message)
	{
		super(message);
	}
}
