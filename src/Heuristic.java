import java.util.*;
public class Heuristic {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{	
		Scanner scanner2 = new Scanner( System.in);
		Day[] freedays = Day.freetimes(scanner2);
		System.out.print(freedays.length);
		//Proof of concept code here
		
		
		Scanner scanner1 = new Scanner( System.in );
	
		int value =1;

		Exercise exercise;
		Exercise[] exercises;
		
		//while (value != 0)
		//{	
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
			
	
			
			//print workouts[0].
		//}
		
		//System.out.print(exercises[1].mgroup);
		

		scanner1.close();
		scanner2.close();

		
		
	}
	
	static Workout[] algorithm(Day[] days, Exercise[] exercises)
	{
		Workout[] workouts = new Workout[days.length];
		
		for (int i = 0; i < days.length; i ++)
		{
			//System.out.print("\n" + i + days[i].name);
			workouts[i] = new Workout(days[i].freetime, exercises.length);
		}
		
		Arrays.sort(exercises);
		int count = 0;
		int j = 0;
		for (int i = 0; i < exercises.length; i++)
		{
			if (count < workouts.length)
			{
				j = count; 
			}
			else
			{
				j = 0;
				count = 0;
			}
			if (workouts[j].time + exercises[i].comptime < workouts[j].maxtime)
			{
				workouts[j].exercises[workouts[j].count] = exercises[i];
				workouts[j].count++;
				workouts[j].time += exercises[i].comptime;
				count++;
			}
		}
		for (int i = 0; i < workouts.length; i++)
		{
			System.out.print("\n==============================\n");
			System.out.print("\n" + days[i].name + ": " + workouts[i].count + " exercises, "+ workouts[i].time + " seconds: \n ");
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
 

