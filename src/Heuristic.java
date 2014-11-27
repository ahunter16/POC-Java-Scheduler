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

		Exercise exercises; 
		while (value != 0)
		{	
			System.out.print("\nMake how many exercises? (0 terminates):\n");
			value = scanner1.nextInt();
			for (int i = 0; i < value; i ++)
			{
				exercises = Exercise.genex();
				System.out.print(exercises.name+", "+exercises.comptime+"\n");
				
				
			}
		}
		
		//System.out.print(exercises[1].mgroup);
		

		scanner1.close();
		scanner2.close();

		
		
	}
	

}
 

