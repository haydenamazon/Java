import java.util.*;
public class mySums
{
	public static void main(String[] args)
	{
		System.out.println(iterativeSum(4));
		System.out.println(recurSum(4));
	}
	private static double iterativeSum(int n)
	{
		double val = 0;
		for(int i = n; i > 0; i--)
		{
			val = val + (Math.pow(2, i) + 1);
		}
		return val;
	}
	private static double recurSum(int n)
	{
		double val = Math.pow(2, n) + 1;
		if (n == 1)
		{
			return val;
		}
		else
		{
			return(iterativeSum(n - 1) + val);
		}
	}
}




