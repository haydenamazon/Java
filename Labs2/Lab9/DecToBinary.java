
public class DecToBinary
{
	public static void main(String[] args)
	{
		decToBinary (25);
		System.out.println();
	}

	private static void decToBinary (int num)
	{
		if (num > 0)
		
		{
			System.out.println(num % 2);
			decToBinary (num / 2);
		}
	}
}
