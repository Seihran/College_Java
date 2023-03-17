public class DecToBin
{
	String decimal = "";
	
	public String convert(String decimal)
	{
		return Integer.toString(Integer.parseInt(decimal), 2);
	}
}