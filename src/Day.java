import java.util.*;

public class Day 
{
	String name;	//Name of the day; Monday, Tuesday, etc...
	int freetime;	//number of seconds user is free for on that day
	int dayno;		//Number of day of the week: Mon = 0, Tue = 1,[...] Sun = 6
	
	//constructor for the Day object
	public Day(String name, int freetime, int dayno)
	{
		this.name = name;
		this.freetime = freetime;
		this.dayno = dayno;
	}
	
	//function that returns an array of Day objects corresponding to
	//days on which the user is free
	static Day[] freetimes(Scanner scanner2)
	{
		//initialise array of Day objects to be returned
		Day[] schedule;
		
		//list of all the days of the week
		String[] days = {
				"Monday",
				"Tuesday",
				"Wednesday",
				"Thursday",
				"Friday",
				"Saturday",
				"Sunday"
		};
		//string array that stores names of days on which the user is free
		String[] free = new String[7];
		
		//stores the value of the 
		String value; 
		
		//counts how many days on which there are workouts
		int counter = 0; 
		//stores the ids of the days of the week, where Monday = 0, Friday = 4, Sunday = 6
		int[] dayarray = new int[7];
		
		
		//loop checks if user is free on a day, and adds the day name to free[i],
		//and the id of the day to dayarray[i]
		for(int i = 0; i < 7; i ++)
		{
			System.out.print("\nare you free on " + days[i] + "? (y/n)\n");
			value = scanner2.next();

			boolean check = false;

			while(check != true)
			{ 
				
				if("y".equals(value) || "n".equals(value))
				{
					check = true;
					break;
				}
				else
				{
					System.out.println("Invalid Input, please only enter \"y\" or \"n\"\n");

				}
				value = scanner2.next();
				
			}
			if ("y".equals(value))
			{

				free[counter] = days[i];
				counter ++;


			}
			else if ("n".equals(value)){
				//System.out.println("We completely understand that.");
				
			}
				
		}

		//array of Day objects long enough to hold all free days
		schedule = new Day[counter];

		//loop asks user how much time they're free for, on each day they're free,
		//then puts the day name, the amount of time they're free for,  
		//and the day id into a Day object, which is stored in schedule[i]
		for (int i = 0; i < counter; i ++)
		{
			System.out.print("\nhow many hours are you free for on " + free[i] + "\n");
			schedule[i] = new Day(free[i], 3600*scanner2.nextInt(), dayarray[i]);//CHANGE
			
		}
		
		//returns the array of Day objects
		return schedule;
	}
	
	
	
}
