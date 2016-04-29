import java.util.*;

public class Evolve
{
	private final String alphabet = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789,./;:'\"<>?!@#$%^&*()_+=-~`\\|{}[]";

	public String randString(int length){
		//Returns a random string of a specified length

		Random rand = new Random();
		String random = "";

		for(int i = 0; i < length; i++)
			random += alphabet.charAt(rand.nextInt(alphabet.length()));

		return random;
	}

	public String nextGen(String start, String goal){
		//creates an array of strings based off of a given string
		//first index is a random string of same length
		//the first goal.length/2 strings are the given string with one char replaced randomly
		//the second goal.length/2 string are the given string with two chars replaced randomly
		//returns the most fit of the generated strings

		String[] next = new String[goal.length()*10];
		next[0] = randString(start.length());
		int length = next.length;

		for(int i = 1; i < length; i++)
			next[i] = start;

		for(int i = 1; i < length; i++)
			next[i] = replaceRandomChar(next[i]);

		for(int i = length/2; i < length; i++)
			next[i] = replaceRandomChar(next[i]);

		Hamming ham = new Hamming();
		return ham.mostFit(next, goal);
	}

	private String replaceRandomChar(String x){
		//Replaces a random character in a string and then returns the new string

		Random rand = new Random();

		char[] tmp = x.toCharArray();
		tmp[rand.nextInt(x.length())] = alphabet.charAt(rand.nextInt(alphabet.length()));
		return String.valueOf(tmp);
	}
}
