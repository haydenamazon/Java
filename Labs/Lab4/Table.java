
public class Table
{
  	private static final int ROWS = 3;
  	private static final int COLS = 3;
	
	public static void main(String[] args)
	{
		int[][] table = new int[ROWS][COLS];
		int[][] myTable = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
		int factor = 5;
		initialize (table);

		//print (table);

		scale (table,factor);
	print (table);
	}

	private static void initialize (int[][] table)
	{
           // Post : Each element of Table is initialized to the sum
           //        of its components

	   for (int i = 0;  i < table.length;  i++)
	   	for (int j = 0;  j < table[i].length;  j++)
			table[i][j] = i + j;
	}

	private static void print (int[][] table)
	{
	   // Post : The contents of Table are printed to the screen
           //        in tabular format

	  System.out.println("\t[0]\t[1]\t[2]");

	   for (int i = 0;  i < table.length;  i++)
	   {
		System.out.print("[" + i  + "]");
	   	for (int j = 0;  j < table[i].length;  j++)
			System.out.print("\t" + table[i][j]);
		System.out.println();
	   }
	}
	private static void scale(int[][] table, int factor)
	{
		//System.out.println("\t[0]\t[1]\t[2]");

				for(int i = 0; i < table.length; i++)
		{
			System.out.print("[" + i + "]");
			for(int j = 0; j < table[i].length; j++)
			{
				table[i][j] = (i + j) * factor;
				System.out.print("\t" + table[i][j]);
			}
		System.out.println();
		}
	}
}
