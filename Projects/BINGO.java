import java.util.*;
import java.io.*;

public class BINGO {

	static int [][] bingoBoard = new int [5][5];
	//static int [][] bingoBoard = {{12, 28, 31, 49, 66}, {3, 26, 45, 53, 75}, {10, 17, 33, 59, 67}, {7, 19, 42, 55, 74}, {2, 23, 37, 46, 70}};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BINGO myBingo = new BINGO();
		myBingo.fillCard(bingoBoard);
		myBingo.printCard(bingoBoard);
		myBingo.markGame(bingoBoard);
		//myBingo.changeX();
		myBingo.printCard(bingoBoard);
		//myBingo.winCheck(bingoBoard);
	}
	public BINGO()
	{

	}
	private static void fillCard (int[][] bingoBoard)
	{
		try {
			Scanner in = new Scanner(new File("bingo.in"));
			for (int i = 0; i < bingoBoard.length; i++)
			{
				for (int j = 0; j < bingoBoard[0].length; j++)
				{
					bingoBoard[i][j] = in.nextInt();
				}
			}
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	public static void printCard(int[][] bingoBoard)
	{
		System.out.println("-------------------------");
		System.out.println("B  |  I  |  N  |  G  |  O");
		System.out.println("-------------------------");
		for (int i = 0; i < bingoBoard.length; i++)
		{
			for (int j = 0; j < bingoBoard[i].length; j++)
			{
				if (bingoBoard[i][j] == 0)
					System.out.print("X | ");
				else
					System.out.print(bingoBoard[i][j] + " | ");
			}
			System.out.println(" ");
		}
		System.out.println("-------------------------");
		System.out.println(" ");
	}
	public static void markGame(int[][] bingoBoard)
	{
		int []randNums = new int [75];
		int win = 0;
		int min = 1; int max = 75;
		int numCalled = 0;
		int h = 0;
		//BitSet game=new BitSet(76);
		System.out.println("Numbers Picked: ");
		while (win == 0)
		{
			numCalled++;
			int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
			String repeat = ("r");
			while (repeat == "r")
			{
				repeat = "notIt";
				for (int rand: randNums)
				{
					if (rand == random_int)
					{
						random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
						repeat = "r";
					}
				}
			}
			randNums[h] = random_int;
			h++;
			System.out.print(random_int + "      ");
			for (int i = 0; i < bingoBoard.length; i++)
			{
				for (int j = 0; j < bingoBoard[i].length; j++)
				{
					if (bingoBoard[i][j] == random_int)
					{
						bingoBoard[i][j]= 0;
					}
				}
			}
			win = winCheck(bingoBoard);
		}
		System.out.println("You won after: '" + numCalled + "' picks.");
		System.out.println(" ");
	}
	public static int winCheck(int[][] bingoBoard)
	{
		int diag = 0;
		int vert = 0;
		int hor = 0;

		int diagWin = 0;
		int vertWin = 0;
		int horWin = 0;
		int win = 0;

		for (int i = 0; i < bingoBoard.length; i++)
		{
			if(bingoBoard[i][i] == 0)
			{
				diag++;
			}
		}
		if (diag < 5)
		{
			diag = 0;
		}
		for (int i = 0; i < bingoBoard.length; i++)
		{
			int x = 4-i;
			if (bingoBoard[i][x] == 0)
			{
				diag++;
			}
		}
		if (diag < 5)
		{
			diag = 0;
		}
		for (int i = 0; i < bingoBoard.length; i++)
		{
			for (int j = 0; j < bingoBoard[i].length; j++)
			{
				if (bingoBoard[j][i] == 0)
					vert++;
			}
			if (vert < 5)
			{
				vert = 0;
			}
		}
		for (int i = 0; i < bingoBoard.length; i++)
		{
			for (int j = 0; j < bingoBoard[i].length; j++)
			{
				if (bingoBoard[i][j] == 0)
					hor++;
			}
			if (hor < 5)
			{
				hor = 0;
			}
		}
		////////////////////////////////////////////
		if (diag >= 5)
		{
			diagWin = 1;
			System.out.println(" ");
			System.out.println("You got 'bingo' from a diagonal.");
		}
		if (vert >= 5)
		{
			vertWin = 1;
			System.out.println(" ");
			System.out.println("You got 'bingo' from a vertical.");
		}
		if (hor >= 5)
		{
			horWin = 1;
			System.out.println(" ");
			System.out.println("You got 'bingo' from a horizontal.");
		}
		win = vertWin + diagWin + horWin;
		if (win != 0)
		{
			return(1);
		}
		else
		{
			return(0);
		}
	}
}

