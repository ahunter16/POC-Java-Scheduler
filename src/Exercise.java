
public class Exercise
{
	String name;		//name of exercise
	String mgroup; 		//main muscle group
	String[] egroups;	//other muscle groups
	int setlen;			//recommended length of a set
	char skill; 		//skill level; b, i, e, (begin int, hard)
	int rest;			//rest time between sets
	int reptime;		//rough time taken to complete a rep
	int sets;
	
	public Exercise(String myname, String mymgroup, String[] myegroups, 
			int mysetlen, char myskill, int myrest, int myreptime, int mysets)
	{
		name = myname;
		mgroup = mymgroup;
		egroups = myegroups;
		setlen = mysetlen;
		skill = myskill;
		rest = myrest;
		reptime = myreptime;
		sets = mysets;
		
	}
}