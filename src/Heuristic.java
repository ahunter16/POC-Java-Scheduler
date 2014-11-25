 
public class Heuristic {

	/**
	 * @param args
	 */
	public static void main(String[] args) //Proof of concept code here
	{

		
		
		
	}
	static Exercise genex() //function for generating an arbitrary set of exercises, tesing purposes only
	{
		String[] allgroups = {"Abdominal", "Biceps", 	//array representing 13 major muscle groups. provisional.
				"Deltoids", "Erector Spinae", "Gastrocnemius & Soleus", 
				"Gluteus", "Hamstrings", "Latissimus Dorsi & Rhomboids", 
				"Obliques", "Pectorals", "Quadriceps", "Trapezius", "Triceps"};
		//String[] groups = {allgroups[5], allgroups[3]};
		Exercise[] tmpexercises;			//temporary array for storing an arbitrary set of exercises
		tmpexercises = new Exercise[39];	
		int count = 0;	//counts index of tmpexercises
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
 

