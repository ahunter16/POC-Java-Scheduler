import java.util.*;

public class Heuristic {

	public static void main(String[] args) 
	{	
		//create scanner to get user input
		Scanner scanner1 = new Scanner( System.in);
		//prompt user to either rate exersises or make a schedule
		System.out.print("Would you like to rate exercises, or make a schedule? \n" +
				"(type \"rate\" to rate exercises, or \"make\" to make a workout " +
				"schedule with default ratings \n(\"end\" terminates)");
		//stores the name of the function the user wishes to carry out
		String mode;
		mode = scanner1.next();
		//checks for valid input
		while (!("rate".equals(mode)) && !("make".equals(mode))&& !("end".equals(mode)))
		{
			System.out.print("\nInvalid input, please type \"rate\" to rate exercises, " +
					"or \"make\" to make a workout schedule with default ratings\n");
			mode = scanner1.next();
		}
		//makes program run unless "end" is typed when prompted
		while (!("end".equals(mode)))
		{
			Exercise[] exercises = Exercise.genexlist(scanner1);
			//allows user to rate the list of exercises before making a schedule
			if ("rate".equals(mode))
			{
				for (int i = 0; i < exercises.length; i ++)
				{
					exercises[i].rating = Exercise.rate(exercises[i], scanner1);
				}
				for (int i = 0; i < exercises.length; i++)
				{
					System.out.print(exercises[i].name+", "+exercises[i].comptime+"s, Rating: " + exercises[i].rating + "/5\n");
				}
			}
			//makes workout schedule for user
			Day[] freedays = Day.freetimes(scanner1);
			System.out.print("Number of days: " + freedays.length);
			
			
			Workout[] workouts = algorithm(freedays, exercises);
			//allows program to either be run again or terminated
			System.out.print("\nType \"rate\" to rate new exercises, " +
					"\"make\" to make a new schedule, or \"end\" to terminate\n");
			mode = scanner1.next();
		}
		scanner1.close();
		
	}
	
	//method for generating and printing a workout schedule 
	static Workout[] algorithm(Day[] days, Exercise[] exercises)
	{
		
		Workout[] workouts = new Workout[days.length];
		
		for (int i = 0; i < days.length; i ++)
		{

			workouts[i] = new Workout(days[i].freetime, exercises.length, 
					days[i].name, days[i].dayno);
		}
		
		//the main body of the heuristic follows.
		//it will later be extended to work with the user's ratings, as well as preventing
		//workouts being scheduled on consecutive days.
		Arrays.sort(exercises);
		
		int j = 0;
		for (int i = 0; i < exercises.length; i++)
		{
			if (!(j < workouts.length))
			{
				j = 0; 
			}

			if (workouts[j].time + exercises[i].comptime < workouts[j].maxtime)
			{
				workouts[j].exercises[workouts[j].count] = exercises[i];
				workouts[j].count++;
				workouts[j].time += exercises[i].comptime;

				j++;
			}
		}
		//heuristic over: this section prints out the workout schedule
		for (int i = 0; i < workouts.length; i++)
		{
			System.out.print("\n==============================\n");
			System.out.print("\n" + workouts[i].dayname + ": " + workouts[i].count + 
					" exercises, "+ workouts[i].time + " seconds: \n ");
			if (workouts[i].count > 0)
			{
				for(int k = 0; k < workouts[i].count; k++)
				{
					System.out.print("\n" + workouts[i].exercises[k].name + " - " + 
				workouts[i].exercises[k].comptime + "s");
				}
				System.out.print("\n");
			}
		}
		return workouts;
	}
}
 

