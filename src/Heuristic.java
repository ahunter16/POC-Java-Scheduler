import java.util.*;
public class Heuristic {

	public static void main(String[] args) 
	{	
		Scanner scanner2 = new Scanner( System.in);
		Day[] freedays = Day.freetimes(scanner2);
		
		System.out.print("Number of days: " + freedays.length);

		Scanner scanner1 = new Scanner( System.in );
	
		int value =1;

		Exercise exercise;
		Exercise[] exercises;
		

		System.out.print("\nMake how many exercises? (0 terminates):\n");
		value = scanner1.nextInt();
		exercises = new Exercise[value];
		for (int i = 0; i < value; i ++)
		{
			exercise = Exercise.genex();
			System.out.print(exercise.name+", "+exercise.comptime+"\n");
			exercises[i] = exercise;
			
		}
		Workout[] workouts = algorithm(freedays, exercises);
	
		scanner1.close();
		scanner2.close();
	}
	
	static Workout[] algorithm(Day[] days, Exercise[] exercises)
	{
		Workout[] workouts = new Workout[days.length];
		
		for (int i = 0; i < days.length; i ++)
		{
			//System.out.print("\n" + i + days[i].name);
			workouts[i] = new Workout(days[i].freetime, exercises.length, days[i].name, days[i].dayno);
		}
		
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
		for (int i = 0; i < workouts.length; i++)
		{
			System.out.print("\n==============================\n");
			System.out.print("\n" + workouts[i].dayno + workouts[i].dayname + ": " + workouts[i].count + 
					" exercises, "+ workouts[i].time + " seconds: \n ");
			if (workouts[i].count > 0)
			{
				for(int k = 0; k < workouts[i].count; k++)
				{
					System.out.print("\n" + workouts[i].exercises[k].name + " - " + workouts[i].exercises[k].comptime + "s");
				}
				System.out.print("\n");
			}
		}
		return workouts;
	}
}
 

