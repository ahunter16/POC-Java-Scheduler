 import java.util.Scanner;
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
				System.out.print(exercises.name+"\n");
				
				
			}
		}
		
		//System.out.print(exercises[1].mgroup);
		

		scanner1.close();

		
		
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
		
		
		
		tmpexercise= new Exercise(exname, allgroups[elemnum], groups, 
				(int)(10*Math.random()), 'i', (int)(100*Math.random()), 
				(int)(10*Math.random()), (int)(10*Math.random()));

		return(tmpexercise);
	}

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
			System.out.print("YUP");
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
 

