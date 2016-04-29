import java.util.*;

public class InOut
{
	public void printLine(String output)
	{
		System.out.println(output);
	}

	public void print(String output)
	{
		System.out.print(output);
	}

	public String getString()
	{
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
}
