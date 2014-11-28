
public class Workout 
{
	char skill;
	double time;
	Exercise[] exercises;
	int maxtime;
	
	public int timecalc(Exercise[] exercises)	//calculates time taken to do a workout
	{
		int total= 0;
		for (int i = 0; i < exercises.length; i++)
		{
			total += exercises[i].reptime * exercises[i].repnumb;
			total += exercises[i].rest * (exercises[i].sets -1);	
		}
		return total;
		
	}
	
	public Workout(char myskill, Exercise[] myexercises, int mymaxtime)
	{
		skill = myskill;
		time = timecalc(myexercises);
		exercises = myexercises;
		maxtime = mymaxtime;
		
	}
	
}
