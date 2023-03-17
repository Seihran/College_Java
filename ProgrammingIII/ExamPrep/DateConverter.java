import java.util.*;

public class DateConverter
{	
	public static void main(String[] args)
	{
		String date = "17-07-2018";
		
		StringTokenizer string = new StringTokenizer(date, "-");
		while (string.hasMoreTokens())
		{
			int num = Integer.parseInt(string.nextToken());
			System.out.println(num);
		}
	}
}
