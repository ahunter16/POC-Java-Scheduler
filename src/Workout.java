
public class Workout 
{
	//char skill;
	int count;
	int time;
	Exercise[] exercises;
	int maxtime;
	
	public static int timecalc(Exercise[] exercises)	//calculates time taken to do a workout
	{
		int total= 0;
		for (int i = 0; i < exercises.length; i++)
		{
			total += exercises[i].reptime * exercises[i].repnumb;
			total += exercises[i].rest * (exercises[i].sets -1);	
		}
		return total;
		
	}
	
	public Workout(int mymaxtime, int exlength)
	{
		//skill = myskill;
		count = 0;
		time = 0;
		exercises = new Exercise[exlength];
		maxtime = mymaxtime;
		
	}
	
}
