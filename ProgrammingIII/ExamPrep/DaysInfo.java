enum WorkWeekDays
{
	Sunday,
	Monday,
	Tuesday,
	Wednesday,
	Thursday,
	Friday,
	Saturday;
	
	public int dayNum()
	{
		return ordinal() + 1;
	}
	
	public String dayWork()
	{
		String work;
		if (ordinal() == 0 || ordinal() == 6)
		{
			work = "false";
		}
		else
		{
			work = "true";
		}
		return work;
	}
}

public class DaysInfo
{
	public static void main(String[] args)
	{
		WorkWeekDays d1 = WorkWeekDays.Sunday;
		WorkWeekDays d2 = WorkWeekDays.Monday;
		WorkWeekDays d3 = WorkWeekDays.Tuesday;
		WorkWeekDays d4 = WorkWeekDays.Wednesday;
		WorkWeekDays d5 = WorkWeekDays.Thursday;
		WorkWeekDays d6 = WorkWeekDays.Friday;
		WorkWeekDays d7 = WorkWeekDays.Saturday;
		
		String output = "Sun = " + d1.dayNum() + " & Sun = " + d1.dayWork();
		output += "\nMon = " + d2.dayNum() + " & Mon = " + d2.dayWork();
		output += "\nTue = " + d3.dayNum() + " & Tue = " + d3.dayWork();
		output += "\nWed = " + d4.dayNum() + " & Wed = " + d4.dayWork();
		output += "\nThur = " + d5.dayNum() + " & Thur = " + d5.dayWork();
		output += "\nFri = " + d6.dayNum() + " & Fri = " + d6.dayWork();
		output += "\nSat = " + d7.dayNum() + " & Sat = " + d7.dayWork();
		System.out.println(output);
	}
}
