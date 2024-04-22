import java.math.BigInteger;

public class bifacotrial
{
	public static void main (String [] args)
	{
	int value;
	if (args.length == 1)
	{
		try
		{
			value = Integer.parseInt (args[0]);
		}
		catch (Exception e)
		{
			System.err.println("The integer wasnt recognized, using 7");
			value = 7;
		}
	}
	else
	{
		System.err.println("You need one command line parameter, using 7.");
		value = 7;
	}
	BigInteger result = fact(value);
	System.out.println(value + "!= " + result);
	}
	private static BigInteger fact (int n)
	{
		BigInteger product = BigInteger.ONE;
		for (int i = 2; i <= n; i++)
		{
			product = product.multiply(BigInteger.valueOf(i));
		}
		return product;
	}
}
