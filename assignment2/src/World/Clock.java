package World;

public class Clock {
	private int hour;
	private int minute;
	
	public Clock()
	{
		hour=0;
		minute= 0;
	}
	
	public static String customFormat(String hour, int mins)
	{
		if(Integer.parseInt(hour)>=100)
		{
			if(mins ==0)
			{
				return hour+ ":" +"00 ";
			}
			else
			{
				return hour+ ":" +mins + " ";
			}
		}
		else
		{
			if(Integer.parseInt(hour) >=10)
			{
				if(mins ==0)
				{
					return "0"+hour+ ":" +"00 ";
				}
				else
				{
					return "0"+hour+ ":" +mins + " ";
				}
			}
			else
			{
				if(mins ==0)
				{
					return "00"+hour+ ":" +"00 ";
				}
				else
				{
					return "00"+hour+ ":" +mins + " ";
				}
			}
		}
		
	}
	
	public String getTime()
	{
		return ""+hour;
	}
	
	public int getMinute()
	{
		return minute;
	}
	
	public void increase()
	{
		minute+=10;
		if(minute== 60)
		{
			minute=0;
			hour++;
		}
			
	}
	
}
