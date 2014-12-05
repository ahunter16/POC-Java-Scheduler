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
	
	//constructor for Exercise object
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
	
	//generates a list of n exercises using the genex() function
	static Exercise[] genexlist(Scanner scanner)
	{
		int value = 1;

		Exercise exercise;
		Exercise[] exercises;
		
		
		System.out.print("\nMake how many exercises? (0 terminates):\n");
		value = scanner.nextInt();
		exercises = new Exercise[value];
		for (int i = 0; i < value; i ++)
		{
			exercise = genex();
			System.out.print(exercise.name+", " + exercise.comptime+"s, Rating: " +exercise.rating + "/5\n");
			exercises[i] = exercise;
			
		}
		return exercises;
	}
	
	//generates a single random exercise, with random fields and a random name 
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
		
		//the following removes "s" from body part names that
		//don't have a vowel before, making names more realistic
		if (name.substring(name.length()-1).equals("s"))
		{
			chop = 1;
			
			for (int i = 0; i < 5; i++)
			{
				if(name.substring(name.length()-2, name.length()-1).equals(vowels[i]))
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
	
	//returns the time in seconds to complete all sets of an exercise
	public int getTime()
	{
		return comptime;
	}
	
	//compares times taken to complete exercises
	
	public int compareTo(Exercise compareExercise) 
	{
		 
		int compareTime = ((Exercise) compareExercise).getTime(); 
 
		//descending order
		return compareTime - this.comptime;
	}
	
	static int rate(Exercise exercise, Scanner scanner)
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
			System.out.print("Invalid score entered. Please rate the exercise with 1 - 5 stars\n");
			int rating = rate(exercise, scanner);
			return rating;
		}
		
	}
}