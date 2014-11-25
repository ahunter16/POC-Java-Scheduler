 
public class Heuristic {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//Proof of concept code here
		
		
		
	}
	
	//function for generating an arbitrary set of exercises, tesing purposes only
	static Exercise genex() 
	{	
		//array representing 13 major muscle groups. provisional.
		String[] allgroups = {"Abdominal", "Biceps", 	
				"Deltoids", "Erector Spinae", "Gastrocnemius & Soleus", 
				"Gluteus", "Hamstrings", "Latissimus Dorsi & Rhomboids", 
				"Obliques", "Pectorals", "Quadriceps", "Trapezius", "Triceps"};
		
		
		//temporary array for storing an arbitrary set of exercises
		Exercise[] tmpexercises;			
		tmpexercises = new Exercise[39];
		
		//counts index of tmpexercises as the function adds exercises to it
		int count = 0;
		
		
		//these 3 for loops loop through allgroups 3 times, generating an exercise for each
		//muscle group (13), and looping 3 times (13 x 3 = 39 exercises total)
		for (int i = 0; i < 3; i++)	
		{	count = 0;				
			for (int j = 0; j < allgroups.length; j++)
			{
				String[] groups;
				int elemnum = 10*(int)Math.random();
				groups = new String[elemnum];
				for (int k = 0; k < elemnum; k++)
				{
					int index = 10*(int)Math.random();
					while (index >12)
					{
						index = (int)Math.random();
					}
					
					groups[k] = allgroups[index];
					
					
				}
				String exname = allgroups[j];
				tmpexercises[i * count] = new Exercise(exname, allgroups[j], groups, 10*(int)Math.random(), 'i', 90, 5, 5);
				count ++;
			}
		}
	}

	

}
 

