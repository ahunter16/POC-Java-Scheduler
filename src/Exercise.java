import java.util.Scanner;


public class Exercise implements Comparable<Exercise>
{
	String name;		//name of exercise
	String mgroup; 		//main muscle group
	String[] egroups;	//other muscle groups
	int repnumb;			//recommended length of a set
	char skill; 		//skill level; b, i, e, (begin int, hard)
	int rest;			//rest time between sets
	int reptime;		//rough time taken to complete a rep
	int sets;			//number of sets
	int comptime;		//time taken to complete all sets of an exercise
	int rating;
	
	public Exercise(String name, String mgroup, String[] egroups, 
			int repnumb, char skill, int rest, int reptime, int sets, int comptime, int rating)
	{
		this.name = name;
		this.mgroup = mgroup;
		this.egroups = egroups;
		this.repnumb = repnumb;
		this.skill = skill;
		this.rest = rest;
		this.reptime = reptime;
		this.sets = sets;
		this.comptime = comptime;
		this.rating = rating;
		
	}
	
	static Exercise genex() 
	{	
		//array representing 13 major muscle groups. provisional.
		String[] allgroups = 
			{	"Abdominal", 
				"Biceps", 	
				"Deltoids", 
				"Erector Spinae", 
				"Gastrocnemius & Soleus", 
				"Gluteus", 
				"Hamstrings", 
				"Latissimus Dorsi & Rhomboids", 
				"Obliques", 
				"Pectorals", 
				"Quadriceps", 
				"Trapezius", 
				"Triceps"
			};
		


		Exercise tmpexercise;			
		String[] groups;
		int elemnum = (int)(10*Math.random())+(int)(3*Math.random());

		groups = new String[elemnum];
		for (int k = 0; k < elemnum; k++)
		{
			int index = (int)(10*Math.random()) + (int)(3*Math.random());
			
			groups[k] = allgroups[index];
		}
		
		String exname = namegen(allgroups[elemnum]);
		
		
		int time = 0;
		tmpexercise= new Exercise(exname, allgroups[elemnum], groups, 
				(int)(10*Math.random()+1), 'i', (int)(100*Math.random()+10), 
				(int)(10*Math.random()+1), (int)(10*Math.random()+1), time, 3);
		
		time = ((tmpexercise.repnumb * tmpexercise.reptime) + tmpexercise.rest)* tmpexercise.sets - tmpexercise.rest;
		tmpexercise.comptime = time;

		return(tmpexercise);
	}

	
	//function for generating names for random exercises
	private static String namegen(String name)
	{
		String[] names =
			{
				"rows",
				"pulls",
				"thrusts",
				"pushes",
				"crunches",
				"curls",
				"raises",
				"pulldowns",
				"twists",
				"jumps"
			};
		
		String[] vowels = {"a", "e", "i", "o", "u" };
		
		String newname;
		
		int chop = 0;
		//System.out.print(name.substring(name.length()-1));
		if ((String)name.substring(name.length()-1) == "s")
		{
			chop = 1;
			System.out.print(name.substring(name.length()-2, name.length()-1));
			for (int i = 0; i < 5; i++)
			{
				if(name.substring(name.length()-2, name.length()-1) == vowels[i])
				{
					chop = 0;
					break;
				}
			}
		}
		
		if (chop == 1)
		{
			newname = name.substring(0, name.length()-1) + " " + names[(int)(10*Math.random())];
		}
		else
		{
			newname = name + " " + names[(int)(10*Math.random())];
		}
		return newname;
		
		
	}
	public int getTime()
	{
		return comptime;
	}
	
	public int compareTo(Exercise compareExercise) 
	{
		 
		int compareTime = ((Exercise) compareExercise).getTime(); 
 
		//ascending order
		return this.comptime - compareTime;
	}
	
	public int rate(Exercise exercise, Scanner scanner)
	{
		System.out.print("\nPlease enter a rating for the exercise: " + "\"" + 
	exercise.name + "\"\nCurrent Rating: " + exercise.rating + "/5");
		int value = scanner.nextInt();
		if (value > 0 && value < 6)
		{
			return value;
		}
		else
		{
			System.out.print("Invalid score entered. Please rate the exercise with 1 - 5 stars");
			return exercise.rating;
		}
		
	}
}