import java.util.ArrayList;
import java.util.Scanner;

//import java.util.*;
public class Day 
{
	//Hashtable times = new Hashtable();
	String name;
	int freetime;
	
	public Day(String myname, int mytime)
	{
		name = myname;
		freetime = mytime;
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
		ArrayList<String> free = new ArrayList<String>();
		String value;

		
		for(int i = 0; i < 7; i ++)
		{
			System.out.print("\nare you free on " + days[i] + "? (y/n)\n");
			value = scanner2.next();
			
			if ("y".equals(value))
			{
				free.add(days[i]);
			}
			
		}
		schedule = new Day[free.size()];
		for (int i = 0; i < free.size(); i ++)
		{
			System.out.print("\nhow many hours are you free for on " + free.get(i) + "\n");
			schedule[i] = new Day(free.get(i).toString(), 3600*scanner2.nextInt());

		}
		

		
		return schedule;
	}
	
	
	
}
