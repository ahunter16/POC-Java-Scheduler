import java.util.*;

public class Day 
{
	String name;
	int freetime;
	int dayno;
	
	public Day(String name, int freetime, int dayno)
	{
		this.name = name;
		this.freetime = freetime;
		this.dayno = dayno;
	}
	
	static Day[] freetimes(Scanner scanner2)
	{
		Day[] schedule;

		String[] days = {
				"Monday",
				"Tuesday",
				"Wednesday",
				"Thursday",
				"Friday",
				"Saturday",
				"Sunday"
		};
		String[] free = new String[7];
		
		//ArrayList<String> free = new ArrayList<String>();
		//ArrayList<Integer> daynums = new ArrayList<Integer>();
		String value;
		
		int counter = 0;
		
		
		//Map<Integer, String> free = new HashMap<Integer, String>();
		for(int i = 0; i < 7; i ++)
		{
			System.out.print("\nare you free on " + days[i] + "? (y/n)\n");
			value = scanner2.next();
			
			if ("y".equals(value))
			{

				free[counter] = days[i];
				counter ++;

			}
		}
		
		schedule = new Day[counter];
		for (int i = 0; i < counter; i ++)
		{
			System.out.print("\nhow many hours are you free for on " + free[i] + "\n");
			schedule[i] = new Day(free[i], 3600*scanner2.nextInt(), i);//CHANGE
			
		}
		

		
		return schedule;
	}
	
	
	
}
