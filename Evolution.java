/**
*The Evolution program implements an application that
*takes in an input string, defined by the user, and
*then uses that string as an end goal for the evolution
*of a randomly generated strig of the same length.
*@author David Freeman
*@version 1.0
*/

public class Evolution
{
	/**
	*This is the main method which only calls the
	*go method.
	*@param args Unused.
	*@return Nothing.
	*/
	public static void main(String[] args){
	
		go();
	}

	/**
	*This method gets a string from the user using
	*the an InOut object, it then generates a random
	*string of the same length using an Evolve {@literal object.}
	*It then uses the Evolve object to make new generations
	*of the random string, which are compared using a
	*Hamming {@lieral object.} This is looped until the
	*a string matching the goal string is {@literal generated.}
	*The most fit string of every generation is printed to the screen.
	*@param Nothing.
	*@return Nothing.
	*/
	static void go(){
		
		InOut io = new InOut();
		io.print("Goal String: ");
		String goal = io.getString();

		Hamming ham = new Hamming();
		Evolve evo = new Evolve();
		String next = evo.randString(goal.length());
		int gen = 1;
		while(true){
		
			io.printLine("Gen: " + gen + "\t| Fitness: " + ham.getDistance(next, goal) + "\t| "+ next);
			if(ham.getDistance(next,goal) == 0) 
				break;

			next = evo.nextGen(next,goal);
			gen++;
		}
	}
}
