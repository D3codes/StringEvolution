public class Hamming{

	public int getDistance(String x, String goal){
		//Calculates the fitness of a string compared to a given goal using the hamming distance

		if(x.length() != goal.length())
			throw new IllegalArgumentException( "Unequal string lengths");

		int dist = 0;
		for(int i = 0, n = x.length(); i < n; i++)
			if(x.charAt(i) != goal.charAt(i))
				dist++;

		return dist;
	}

	public String mostFit(String[] options, String goal){
		//uses getDistance to return the most fit String in an array, compared to a given goal

		int mostFit = 0;
		int fitness = getDistance(options[0], goal);

		for(int i = 0, n = options.length; i < n; i++)
			if(getDistance(options[i], goal) < fitness){
				fitness = getDistance(options[i], goal);
				mostFit = i;
			}
		
		return options[mostFit];
	}
}
