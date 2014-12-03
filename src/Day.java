import java.util.*;


//import java.util.*;
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
		String[] frees = new String[7];
		
		//ArrayList<String> free = new ArrayList<String>();
		//ArrayList<Integer> daynums = new ArrayList<Integer>();
		String value;
		
		int counter = 0;
		
		
		//HashMap free = new HashMap();
		for(int i = 0; i < 7; i ++)
		{
			System.out.print("\nare you free on " + days[i] + "? (y/n)\n");
			value = scanner2.next();
			
			if ("y".equals(value))
			{
				//free.put(counter, days[i]);
				frees[counter] = days[i];
				counter ++;
				/*free.add(days[i]);
				daynums.add(i);*/
			}
		}
		
		schedule = new Day[counter];//free.size()];
		for (int i = 0; i < counter; i ++)//free.size(); i ++)
		{
			
			System.out.print("\nhow many hours are you free for on " + frees[i]/*free.get(i)*/ + "\n");
			schedule[i] = new Day(frees[i], 3600*scanner2.nextInt(), i);//free.get(i).toString(), 3600*scanner2.nextInt(), daynums.get(i).toString());
			
		}
		

		
		return schedule;
	}
	
	
	
}
