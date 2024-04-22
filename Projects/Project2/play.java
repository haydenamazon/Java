import java.util.*;
import java.io.*;

public class play
{
	public static ArrayList<LibraryBook> books = new ArrayList<LibraryBook>(50);
	//////array made for all the libray.dat books	

	public static void main(String[] args) //main method
	{
		ArrayList<String>dList = new ArrayList<String>();
		//The array dList is short for .datList which will be used to store all the files in the Project 2 directory
		File curDir = new File(".");
                String[] fileNames = curDir.list();

                for(String f:fileNames)
                {
 	               if(f.endsWith(".dat"))
	                       {
    	                           dList.add(f);
                               }
                }
		/////////The above code reads all the files in the directory and filters out the ones ending in ".dat" and add them to .datList or dList
		Scanner in = new Scanner(System.in);
		System.out.println("Data Files Available: ");
		for (int i = 0; i < dList.size(); i++)
		{
			System.out.print(dList.get(i) + " ");
		}
		System.out.println("\nSelect a file: ");
		
		inputBooks(in.nextLine(), books);
		System.out.println("15 files imported.");
		menu();
		//menu is the only method needing to be called in main as the rest exist in the menu method itself
	}
	public static void menu()
        {
                System.out.println("\u001b[H\u001b[2J"); //code to clear screen
		Scanner in3 = new Scanner(System.in);
		String choice;	//used in the switch which allows for all types of input even though it is only looking for a number 1, 2, or 3
		sortBooks();
		int x = 0;
                while(x == 0) //set the while loop parameter to "while x == 0" when case three occurs it changes x to 1 thereby breaking the code. System.exit would work too.
                {
                        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n^^^ WELCOME TO THE GREAT BOOKS LIBRARY ^^^\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			System.out.println(" ");
                        System.out.println("Select an option: ");
			System.out.println(" ");
                        System.out.println("1. Display Records. ");
                        System.out.println("2. Search for a Great Book title. ");
                        System.out.println("3. Exit. ");
			System.out.println(" ");
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                        System.out.print("> ");
                        choice = in3.nextLine();
                        switch(choice)
			//switch allows for any input to not crash or mess up the program. Until 1, 2, or 3 is entered the switch will loop
                        {
                                case"1": showBooks();
                                System.out.println("\u001b[H\u001b[2J");
                                break;
				//this case print all the records by calling the showBooks method

                                case"2": System.out.println("\u001b[H\u001b[2J");
				System.out.print("Enter Greak Book Title: ");
                                search(in3.nextLine());
				//System.out.println("\u001b[H\u001b[2J");
                                break;
				//this case allows for indexing of a book name and calls the search method

                                case"3": System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
				System.out.println("Have a good day!");
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                                x = 1;
                                break;
				//this case is the end which "breaks" the code in the intended way
                        }
                }
        }
	public static void inputBooks(String inputFile, ArrayList<LibraryBook> books)
	{
	//	int numBooks = 0;
		try	//to pull in file
		{
			Scanner in6 = new Scanner(new File(inputFile));	//pulled from help worksheet
			while(in6.hasNext())
			{
				Scanner lsc = new Scanner(in6.nextLine()).useDelimiter(";"); //pulled from help worksheet, delimiter tells the code the boundary is at each ";"
				String title = lsc.next();
				String name = lsc.next();
				int copyright = lsc.nextInt();
				double price = lsc.nextDouble();
				String genre = lsc.next();
				books.add(new LibraryBook(title, name, copyright, price, genre));
				//printRecord(books, numBooks);
				//numBooks++;
			}
		}
		catch (IOException e)	//incase no file is found a catch statement is implemented
		{
			System.out.println(e.getMessage());
		}
//		return numBooks;
	}
	public static void printRecord(ArrayList<LibraryBook>books, int location)
	{
		System.out.println("Record #" + (location + 1) + " :\n");
		System.out.println("Title:            " + books.get(location).getTitle());
		System.out.println("Author's Name:    " + books.get(location).getAuthor());
		System.out.println("Copyright:        " + books.get(location).getCopyright());
		System.out.println("Price:            " + books.get(location).getPrice());
		System.out.println("Genre:            " + books.get(location).getGenre());
		System.out.println("");
	}	
//the above body looks for each of the wanted option like Title and Genre by looking at the book location and then grabbing the information from the file
	public static void search(String title)
	{
		int firstBook = 0;
		int lastBook = books.size() - 1;
		int midValue;
		//the above integers are used to get the highest, lowest, and middle value
		//this will be used in the while loop to serve as a binary search, the lowest value and highest value will be divded by 2 to allow for proper and fast searching.
		boolean value = true;	
		while(firstBook <= lastBook)
		{
			midValue = ((firstBook + lastBook) / 2); //binary search
			if(books.get(midValue).getTitle().compareTo(title) < 0)
			{
				firstBook = (midValue + 1);
			}
			else if(books.get(midValue).getTitle().compareTo(title) > 0)
			{
				lastBook = (midValue - 1);
			}
			else
			{
				printRecord(books, midValue);
				break;
			}
		}
		if(firstBook > lastBook)	//code that prints if a title was not in the arrayList
		{
			if (value == true)
			{
				System.out.println("\u001b[H\u001b[2J");
				System.out.println(title + ": was not in the library.");
			}
			System.out.println(" ");
			//prints a line beneath the title to make the format look better
		}
		//this method allows for searching the library catalogue
	}
	public static void sortBooks()
	{
//		for(String b: books)
//		{
//			System.out.print("");
//		}
		LibraryBook l;

		for(int i = 0; i < books.size(); i++)
		{
			for(int j = 1 + i; j < books.size(); j++)
			{
				/////////
				if(books.get(i).compareTo(books.get(j)) > 0)
				{
					l = books.get(j);
					books.set(j, books.get(i));
					books.set(i, l);
				}
			}
		}
		//this puts the books in alphabetical order
	}
	public static void showBooks()
	{
		Scanner in7 = new Scanner(System.in);
		//I lost track of which scanner number I was on and knew I had not used 7 yet
		int num = 0;	//to be used as a limit for the arrayList
		System.out.println("\u001b[H\u001b[2J");
		printRecord(books, num);
		
		num++;

		System.out.println("Press enter to continue...");
		String s = in7.nextLine();

		while(s.equals("") && num < books.size())	//While the value "num" is less than the size of the arrayList this will continue to execute
		{
			System.out.println("\u001b[H\u001b[2J");
			printRecord(books, num);
			System.out.println("Press enter to continue...");
			num++;
			s = in7.nextLine();
		}
		//displays the books from the library.dat file
	}
}
		


