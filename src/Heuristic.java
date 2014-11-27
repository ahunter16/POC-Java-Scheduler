 import java.util.*;
public class Heuristic {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//Proof of concept code here
		Scanner scanner1 = new Scanner( System.in );
		

		int value =1;

		Exercise exercises; 
		while (value != 0)
		{	
			System.out.print("\nMake how many exercises? (0 terminates):\n");
			value = scanner1.nextInt();
			for (int i = 0; i < value; i ++)
			{
				exercises = genex();
				System.out.print(exercises.name+", "+exercises.comptime+"\n");
				
				
			}
		}
		
		//System.out.print(exercises[1].mgroup);
		

		scanner1.close();

		
		
	}
	
	static Day[] freetimes()
	{
		Day[] schedule;
		Scanner scanner2 = new Scanner( System.in);
		String[] days = {
				"Monday",
				"Tuesday",
				"Wednesday",
				"Thursday",
				"Friday",
				"Saturday",
				"Sunday"
		};
		ArrayList free = new ArrayList();
		String value;
		for(int i = 0; i < 7; i ++)
		{
			System.out.print("\nare you free on" + days[i] + "? (y/n)");
			value = scanner2.next();
			if (value == "y")
			{
				free.add(days[i]);
			}
			
		}
		schedule = new Day[free.size()];
		for (int i = 0; i < free.size(); i ++)
		{
			System.out.print("\nhow many hours are you free for on " + free.get(i));
			schedule[i] = new Day(free.get(i).toString(), scanner2.nextInt());

		}
		
		scanner2.close();
		
		return schedule;
	}
	
	
	
	
	
	//function for generating an arbitrary set of exercises, tesing purposes only
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
				(int)(10*Math.random()+1), (int)(10*Math.random()+1), time);
		
		time = ((tmpexercise.setlen * tmpexercise.reptime) + tmpexercise.rest)* tmpexercise.sets - tmpexercise.rest;
		tmpexercise.comptime = time;

		return(tmpexercise);
	}

	
	//function for generating names for random exercises
	static String namegen(String name)
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
	

}
 

