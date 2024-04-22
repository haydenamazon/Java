import java.util.*;
import java.io.*;
import java.text.DecimalFormat;
public class Personnel
{
	public static DecimalFormat fmt = new DecimalFormat("############.##");	//Decimal Formatting for numeric elements so it prints ("0000000000.00")
	//String Employee[];
	public static ArrayList<Employee> Employees = new ArrayList<Employee>();	//ArrayList to be filled with employees
	
	public static void main(String[] args)
	{
		//System.out.print("");
		menu();		//menu is the only needed method
	}
	public static void printEmployees()	//method to print employees that were added to the arrayList
	{
		for(int i = 0; i < Employees.size(); i++)
		{
//			System.out.println(fmt.format(Employees.get(i)));
			System.out.println(Employees.get(i));
		}
	}
	public static void clearScreen()	//to clear screen after each method
	{
		System.out.println("\u001b[H\u001b[2J");
	}
	public static void downloadData()	//to download data, code pulled from Canvas
	{
		String fileName = "employee.dat";
		String[] e = new String[Employees.size()];
		for (int i = 0; i < e.length; i++)
		{
			e[i] = " " + Employees.get(i);
		}
		try
		{
			FileOutputStream fileOut = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(e);
			out.close();
			System.out.println("File Downloaded");
		}
		catch (IOException xxx)
		{
			System.out.println(xxx.getMessage());
		}
	}
	public static void uploadData() 	//to upload files that have the name "employee.dat" again pulled from Canvas
	{
		String fileName = "employee.dat";
		String[] a = null;
		try
		{
		FileInputStream fileIn = new FileInputStream(fileName);
		ObjectInputStream in =new ObjectInputStream(fileIn);
		a = (String[]) in.readObject();
		in.close();
		System.out.println("File Uploaded");
		}
		catch (IOException xxx)
		{
			System.out.println(xxx.getMessage());
		}
		catch (ClassNotFoundException xxx)
		{
			System.out.println(xxx.getMessage());
		}
		for (int i = 0; i < a.length; i++)
		{
			System.out.println(a[i]);
		}
	}
	public static void menu()	//menu with all options that sometimes prints twice
	{
		clearScreen();
		String choice;		//choice for the major switch case
		String payChoice;	//choice for the inner switch case

		Scanner in = new Scanner(System.in);
		int x = 0;

		while (x == 0)		//condition that allows for the while loop to break
		{
			System.out.println("-----------------------------------");
			System.out.println("| Commands: n - New Employee      |");
			System.out.println("|           c - Compute Paychecks |");
			System.out.println("|           r - Raise Wages       |");
			System.out.println("|           l - Lower Wages       |");	//additional method to allow I made that allows for lowering of employee wages
			System.out.println("|           p - Print Records     |");
			System.out.println("|           d - Download Data     |");
			System.out.println("|           u - Upload Data       |");
			System.out.println("|           q - Quit              |");
			System.out.println("-----------------------------------");
			




			System.out.println("⡆⡆⡔⡐⣜⣞⢮⡳⣅⢀⢀⢠⡐⠌⡜⡼⣕⠯⡀⠀⠀⢀⠀⢀⠀⡀⠀⢀⢐⢐⠄⠐⡐⣌⣞⢮⢇⢧⡪⣎⢆⢕⡸⡜⡕⡕⡡⠊⡘⡕⡏⢎⠀⡀⢀⢀⠠⠐⢕⠐⡁⠄⠀⠠⡀⢂⠀⡂⢐⠀⠀⠀⠀⠀⢀⠠⠐⠀⠄⡢⡊⠀⠀⢄⢀⠂⠄⠀⠄⠀⠄⠀⠠⠀⠀⠀⠠⠀⠀⠄\r\n"
			+ "⡪⢮⣫⢯⣞⢾⣽⢽⣳⣗⣗⣯⢾⢜⢮⡫⡪⡪⡢⢅⠢⡢⢪⢢⠡⡀⡀⢄⢂⢂⠄⠁⡐⡕⡎⣏⢗⣝⢮⣗⢯⠺⢜⢗⣕⢕⢆⢅⠢⣃⡂⡥⡇⡆⡂⠂⠀⠈⠀⠀⠠⢀⠄⠡⠊⠔⡠⠀⠄⠠⠀⠄⠠⠐⠠⠀⠐⠈⡀⠣⢂⠠⠈⡂⠢⠑⠔⡀⠀⠀⠠⢈⠀⡀⠁⠈⠀⠀⠀⠀\r\n"
			+ "⡝⡕⣕⢗⡕⣟⢞⡯⣷⡳⣝⣞⣝⢕⡕⡕⠁⡁⠃⠁⠈⢜⢘⠨⢹⢚⢮⢗⢷⢕⡼⡼⣼⢮⡳⣕⣗⣗⡯⡞⡥⣑⢱⢱⠸⡘⡔⠠⢁⠲⡹⡸⠨⢊⢜⢌⠔⠀⠠⠐⡐⡐⠨⢐⢁⢁⠠⠀⠄⠀⠂⠅⠡⠀⠀⠀⠀⠀⠀⠈⠐⠠⢈⢂⠅⠠⢑⢔⢐⠠⡡⠢⡂⡂⢀⠠⠀⠐⠈⡀\r\n"
			+ "⡧⡫⣪⢮⣺⣪⢯⣞⢷⢝⢎⢎⢮⣳⢽⢬⠀⠀⠀⠀⠀⠐⠀⠄⡱⡱⡑⠕⡉⡳⡹⣝⢽⡽⣝⡮⣗⢯⢟⣜⣒⢞⢎⢇⢑⡑⣌⢪⢢⢣⢲⢰⢡⠢⡊⡔⡡⡑⡐⡰⡐⢌⠌⢔⠰⠐⠨⠨⡨⠂⠡⠈⠠⠀⠠⠀⡀⠀⠀⠀⠀⠀⡐⠔⡈⡈⡐⢌⢎⢇⠅⠁⠂⠐⠀⠀⡐⠄⢅⠄\r\n"
			+ "⣗⡽⡮⡗⣗⢵⣻⣺⠝⠈⠀⠸⡽⡾⡙⠈⠀⠀⠀⠀⠀⠀⠂⠡⠱⡑⠕⢅⢂⢐⢱⣱⢽⣞⡷⣝⣎⢇⢗⠕⡌⡆⢧⡪⣇⢧⢧⢳⢱⢣⠣⡣⠣⡙⢜⢜⢜⢼⡰⡢⡪⢒⢍⠢⠊⢈⠠⡁⡂⡈⠠⡈⡐⠈⠀⠁⡂⠐⠀⡀⠐⠠⠨⡪⡰⡐⡕⡕⢕⠅⠄⠀⠀⠀⠀⠁⠀⠨⡰⡱\r\n"
			+ "⡷⣯⢣⠣⡱⣻⣺⡺⣅⠀⠀⠀⡈⠣⢈⠀⠀⠀⠀⠀⠀⠐⠈⡈⡐⡄⣇⣗⣵⣳⣻⣺⣟⣮⣻⡺⢜⢪⢢⢣⠣⡃⡣⢑⠜⠨⢂⠃⡑⠠⠁⡐⠀⠂⠁⠨⠘⢘⠘⠕⡕⡕⡌⡎⡪⢀⠪⡊⠐⠈⡌⡂⠀⠀⠀⠀⡀⡂⣐⠠⠐⢈⢪⠪⡆⠅⠂⠐⠀⢈⠀⠈⠀⠀⠀⠁⠀⠁⢮⢯\r\n"
			+ "⢟⣮⢧⡣⡏⡮⡪⡮⡂⠡⢀⢅⢄⡂⡅⡔⡀⣐⢔⡕⣕⠡⡀⢦⡳⣝⣞⢾⣳⣟⣞⢞⢞⡞⡎⣪⢪⢎⡎⡊⡐⡀⢂⠐⢈⠐⢀⠐⢀⠐⠀⠄⠐⠀⠁⠀⠐⠀⠀⠂⠀⠑⢕⢌⢢⢂⢂⠂⡅⡢⡣⠂⡐⢔⢆⠢⢒⠈⠂⠣⢑⠐⢀⠣⢀⠀⠀⠀⠠⠀⡀⠀⠀⠀⠀⠀⠄⠈⠨⡳\r\n"
			+ "⠫⢗⢕⠡⡱⡱⡣⠳⡹⡸⡜⡮⣳⢽⢮⣣⢳⢱⠣⡋⡎⡮⠪⢓⢝⢵⢳⡫⡗⢇⠣⡡⡱⡱⣱⣳⡫⡗⡅⡂⢂⠐⠠⠈⠄⢐⠀⢂⠠⠀⡁⠄⠂⠀⡁⠀⠂⠀⠄⠀⡀⠄⠀⠑⢔⠡⢂⢢⢣⢯⡪⡀⢀⠘⠘⠌⠐⠈⠀⠀⠀⠀⠀⠐⠀⠂⡀⠠⠐⠐⠀⠀⠀⠠⠀⠠⠀⠀⠈⠸\r\n"
			+ "⠈⢀⠂⢕⢜⢼⣐⢅⢪⡺⣪⣫⢾⢕⢗⢗⣽⣪⣪⢢⠊⢄⠡⢐⠠⡡⢱⢸⠨⡂⡌⡖⡵⡽⣵⡳⡽⣕⢅⢂⠂⠌⠌⠨⠐⠠⢈⠀⠄⠂⡀⠄⢀⠁⢀⠐⠈⠀⠠⠀⡀⢀⠀⢁⠨⢪⠠⠈⢊⢷⡱⣐⢀⠀⠀⠐⡈⡠⢐⠠⠁⢌⠄⠄⠠⡐⡠⠀⢀⢈⢐⠀⡂⡀⠀⠀⠀⠀⠀⠡\r\n"
			+ "⢐⢐⠌⣎⢮⡳⡳⣓⢗⡝⣮⡺⣽⡪⡧⣫⢞⣞⢾⢵⢹⢰⢱⣱⡱⣕⢧⡳⣝⢼⢜⡮⣫⣞⢧⢏⡯⣪⢂⠢⢈⢂⠡⠁⡁⠅⠐⡀⠂⡁⠠⠐⢀⠐⠀⡀⠂⠁⠐⡀⠄⠠⠀⠄⠀⢅⢇⠄⠀⢑⢝⢮⡲⡠⠀⡁⠂⡪⠐⢌⢊⢆⢇⢣⠑⡁⢊⢎⢖⡢⡣⡱⢐⢀⠀⠀⠀⠄⠀⠨\r\n"
			+ "⡧⡣⣓⢮⣳⢽⢮⡳⣣⡟⡮⡺⣕⢯⡻⣺⢽⣪⢏⢷⣝⢮⢗⡧⣯⡺⣵⣻⢾⣽⢽⡺⣕⢷⢝⣗⣝⢎⠢⡑⢐⢀⠂⠡⠐⢈⠠⠐⢀⠐⠠⠈⡀⠄⠂⠀⠂⠁⠠⠀⠂⢁⠀⠂⡈⡐⡕⡄⡀⡂⡇⡏⡎⠄⡂⡀⣂⠢⡁⣂⢪⠸⡸⡸⣰⡰⡱⣝⢵⢑⠁⠊⡐⠀⠀⠀⠀⠀⠄⠂\r\n"
			+ "⣏⢎⢪⡪⡎⣗⡕⢝⢜⢮⣣⢫⡪⡧⣫⢯⣻⢮⢯⢗⡗⢝⢝⣽⡳⣝⡷⣯⢿⡺⢝⢝⡮⡫⣗⢵⢮⠣⡑⠄⠅⡐⢈⠐⢈⠠⠠⢈⠠⠐⠀⢂⠀⠄⢀⠁⠄⠁⡀⠂⢈⠀⠄⢁⠀⡢⡳⡑⡌⡎⡎⡎⡪⡨⡢⡣⡱⡱⣸⢰⡱⣱⢕⣕⢧⢯⠺⡸⢑⠡⠐⠠⢀⠀⠀⠀⠀⠀⡀⢁\r\n"
			+ "⣞⡮⣞⣮⢯⣞⣞⣮⠮⡃⠫⣇⢗⢝⢵⣻⣺⢽⣱⡫⣞⣜⡮⣞⡽⡽⣝⢯⢇⢇⢱⢕⡯⣝⢮⢯⠪⢊⠄⠅⡂⠔⠠⠨⠠⡐⡠⢂⢐⢈⢈⠠⠐⢈⢀⠐⡀⢂⠐⠈⡀⠄⠂⡀⢂⠸⣜⠘⢜⣜⢼⡘⡎⡮⡳⢱⢱⠽⣜⢢⡣⣗⢯⢞⠡⠀⠁⡀⡂⠄⠁⠀⠠⠠⡡⡂⡠⢐⢰⠰\r\n"
			+ "⣗⣿⣻⣽⢿⣽⡯⣟⣧⡢⣱⣳⡵⣱⣕⢷⢽⢽⣺⡺⣕⡷⣽⣳⢽⢮⢳⡹⡪⢷⢕⡯⡯⢮⢳⠣⠃⡅⠬⠨⡂⡣⡑⢍⠪⡪⡺⡸⡢⡣⢂⠂⠅⡐⢄⢢⢢⢱⡨⡢⡐⡀⡂⠠⠀⢪⡺⡠⡓⣗⢓⠀⠂⠨⠠⢱⢰⢩⢪⡣⡏⡎⡏⡧⡡⣂⢢⠢⡊⡀⠄⡌⡦⣣⢧⡳⣕⣗⢽⢕\r\n"
			+ "⡽⣞⣷⡻⡯⡳⣻⢝⠗⠽⡯⡷⣟⡷⡽⣹⣺⣳⡳⡯⣗⡯⣷⣻⣽⡳⣕⡇⢕⠄⡑⡑⢭⡫⡣⢃⢑⢐⠅⡣⡑⣆⢕⡥⣣⡕⡎⡎⡆⡎⡪⡘⠈⠰⣡⠱⡠⡱⡘⢜⠌⢆⠪⡨⢂⠡⣏⢎⠜⠜⠐⠠⣡⢱⠨⡘⢎⠧⡓⡵⡳⣕⢕⢗⡽⡪⢎⡮⣗⡧⣗⡽⣺⢽⢵⣫⣞⢮⢯⢯\r\n"
			+ "⢯⣳⡳⡯⡪⡢⣳⣣⢃⢱⡹⣽⣳⡫⡯⣞⣞⢮⡫⡯⣞⡽⣗⣿⣗⣟⢗⡧⢑⠅⡂⢂⢱⢹⠨⢐⢐⢁⢂⠑⢌⠔⡡⠩⡊⠜⢌⠣⡣⡑⠅⠠⠈⠀⢪⢪⢺⢸⢝⡲⣕⢕⢕⢌⠢⢘⡜⡆⡣⡡⠨⡐⠕⢕⢕⠌⠄⠡⠑⠨⢘⢌⢎⢪⠠⠀⡡⡫⣳⢯⡳⡯⣯⣟⡯⡷⡽⣝⣽⣳\r\n"
			+ "⢢⡣⣫⡫⡳⣝⢜⢮⢳⡳⣝⢞⢮⡺⣽⣳⢯⣷⣻⣞⣯⡿⣽⢞⡎⡎⠪⢘⢐⢐⠨⡐⢸⠸⡈⡐⠄⠂⠄⠡⢂⠨⠈⠌⠌⡊⠌⢌⠂⡂⠅⢂⠠⠁⠂⢅⠣⡱⡐⡅⢕⢑⢑⢑⠌⠐⡜⠈⠊⠪⢊⢐⠁⠐⢐⢁⠈⠀⢀⠀⠄⡱⡱⡕⡕⣕⢮⡺⡵⡯⡯⣻⣺⢞⡽⡽⣽⣺⢞⣾\r\n"
			+ "⣕⢧⡣⡫⣝⢼⡸⣕⢯⢺⢕⡝⡜⡮⡺⣪⣫⣞⢷⣻⢽⢹⢵⣻⢼⢌⡂⡂⡂⡂⢕⠨⢈⠇⡂⡂⠅⠡⠁⠅⡀⢂⠁⡁⠂⠄⢅⢂⢂⠂⠅⠠⠀⠄⢁⢂⠐⡈⠌⠨⢈⠐⠀⠂⠄⢁⠪⡰⡑⡡⡱⡰⡨⠠⡣⡢⢀⠀⠄⢕⢜⡼⣕⣯⡺⡵⣫⣺⡹⣪⢯⣗⣯⢯⢯⣟⣗⡯⣿⡺\r\n"
			+ "⣯⢷⢯⢯⣞⡷⣽⣚⠨⢈⢧⢳⣹⣪⣟⡮⣞⣮⡻⣮⡳⣳⣳⣟⣿⢽⣪⢮⢐⠠⢑⠈⠔⡐⡐⠄⠅⠅⠅⠅⡂⡢⡨⡢⢣⠩⡂⡐⠠⠡⠨⠐⡀⢂⠐⡀⠥⡠⠐⡀⠄⢀⢁⠈⡀⠂⡑⠔⣡⡳⡝⣕⢎⡎⡎⡢⡑⢌⢮⢮⡳⣝⣞⢮⡺⣝⢵⣣⢏⢎⠪⣺⣺⣽⣻⣺⡳⡯⣗⡯\r\n"
			+ "⡽⣽⣫⣟⡾⣽⣗⠇⠂⠀⡳⣝⣞⡾⣺⡽⣗⣗⢽⣣⢏⢗⡯⣟⡾⣻⣽⡳⠡⡈⡂⢅⢑⠌⡐⡡⢡⢑⢅⠕⡌⡆⡇⡊⡢⢑⠌⡎⢎⢎⡊⡆⡪⡢⣅⢢⢘⢜⠬⡐⡐⠠⡀⢂⠠⠨⠨⢂⠧⡻⡺⣜⢎⢮⢪⠂⠂⠁⢪⡳⣫⢷⢝⣵⣫⢞⡵⡳⣝⢦⡳⡓⡗⡗⡯⣺⢜⠕⡑⢝\r\n"
			+ "⣽⣺⣺⣺⣽⡳⡯⡧⡢⣜⡮⣗⢷⣻⣽⢽⣳⡳⣽⡺⡽⣕⢯⣗⡿⣯⢿⣽⣬⡢⡪⡢⡣⢈⠢⠨⡂⢕⠰⡑⡕⢕⠌⢆⠪⢐⠑⢌⢊⠆⡕⢕⠝⡜⡪⢊⠔⢅⢇⢇⢎⢂⢂⢂⠂⠅⠁⣎⢮⡪⡯⡮⣫⡳⡣⡣⠡⡈⠀⠍⠎⠇⢋⠪⠪⡫⡺⡪⡮⡣⠃⠡⡂⡢⡱⣕⢧⡣⣪⡪\r\n"
			+ "⣳⣳⣻⢞⡮⡯⣯⢯⣟⣗⢯⣫⢯⢷⢯⢳⢱⣻⢵⢯⣻⢮⢗⣗⡽⣯⢿⣺⢷⣝⡮⣣⡣⢁⠪⡐⠌⡂⡑⠌⢜⢰⢱⡱⡌⢆⢕⠡⡢⡑⢌⠢⡑⢌⢐⠅⡊⢆⢣⢕⢜⠔⡅⡕⠌⠄⠑⡽⣕⢯⢮⣫⢞⣮⡺⡈⠠⠐⡀⠂⠀⠀⠀⠀⠀⢘⢮⡳⡽⡐⡀⢄⢗⡵⣳⢝⣗⡯⣞⡽\r\n"
			+ "⣳⢳⢝⣝⡮⣯⢯⢻⢺⣳⣳⣳⢯⢯⡳⣕⢷⢽⣝⢽⣺⢽⣻⢮⢯⢯⢿⣻⣯⢷⢯⣳⠥⡑⡨⢐⠡⢂⢊⠌⡂⡢⢑⠱⡨⡀⢂⠁⢂⠈⡂⠑⡁⠣⢑⠵⣕⢕⠕⡜⢌⠪⠢⡑⡡⢐⠠⡱⡫⣗⢗⡽⣝⡞⣞⢜⢄⢕⢄⢕⠡⠀⢀⢀⠠⡱⡯⡯⡯⣳⣳⢽⢽⣝⣞⡽⣳⢯⢷⣻\r\n"
			+ "⣺⡯⣗⣷⣻⢯⡯⡪⠪⣻⢺⡺⡽⣫⢿⢽⣻⡽⣾⢽⣞⡿⣽⣽⣳⣟⣯⢿⣺⡽⣕⢗⡕⡐⢔⠡⡊⢔⢐⠌⠔⡐⡁⡂⡢⠑⠕⠕⠆⢆⢔⢄⢆⢎⠔⠍⡊⠔⡑⡨⠂⢕⢑⠌⣔⢵⣕⢧⢯⢮⡳⣝⢜⡎⡎⡧⣧⣳⢽⣪⡊⡈⢀⢢⢣⡳⣝⢾⣝⡷⣽⣫⣟⣞⣮⢯⡿⣽⢯⡿\r\n"
			+ "⣳⣟⣟⣾⣺⢯⡏⡐⠈⢜⢵⣫⢞⡽⣹⣝⡧⣫⣺⢽⣺⣝⢷⢝⣞⣞⣗⡯⣗⡯⣗⣟⠆⢌⠢⡱⢨⠢⡑⠌⢌⢂⢂⢂⠢⠡⠡⠡⡁⡂⡂⢄⢂⢐⠨⡐⡐⠅⡂⢆⢣⢡⠱⣑⣞⢷⢽⣽⢱⢑⢙⠘⢘⠨⢊⢽⢺⠑⢏⠞⡕⡧⡆⡇⡇⡯⣺⣳⣳⢯⣗⡷⣻⢾⡽⣽⢯⢯⢯⣻\r\n"
			+ "⡷⣯⢷⣳⢯⢗⣇⢆⢬⡪⣯⡺⣝⢮⡳⡵⣝⡲⣕⣟⣞⡮⣯⡳⣕⢧⢷⢯⢷⢝⡎⡎⠇⡂⢅⠪⡢⡱⡈⡪⡐⡐⡐⠄⠅⠕⡡⢃⠪⡰⡘⢔⠢⡑⡐⠔⡨⢨⢸⢨⢢⢣⡣⡷⡽⣝⢗⢕⠕⢅⠄⠠⠀⡐⠌⢎⠢⠡⡢⢨⢐⢅⢇⢮⢺⡺⡺⣺⣺⢽⢮⢯⡫⣗⠯⡯⢯⢯⡳⠡\r\n"
			+ "⣟⣯⢿⡽⣝⡽⣪⢏⢇⢯⢺⢜⢜⢜⢮⡫⣺⡪⣗⣗⣗⡯⣞⡾⣵⣟⡯⡯⡫⡳⠑⢁⠐⢌⠐⠌⠜⡔⡕⡔⢌⢂⠢⡁⠅⡑⠠⠡⢑⠐⠌⠢⢑⠨⢐⠡⢨⠪⡸⡸⣸⣺⣺⡽⣝⢮⡳⣱⢩⡲⠡⠀⠀⠀⠠⠀⠈⢘⠜⠜⠕⣕⢗⡽⡱⡱⡹⣜⢮⢯⢯⣗⡯⣎⢇⢊⢪⢳⢹⡐\r\n"
			+ "⡻⡪⣟⣞⣗⣯⢧⡱⣰⡱⣝⣗⡵⣝⢵⢝⢮⣺⢳⢝⢮⡫⡾⡽⡳⠯⡻⢜⢔⠡⠐⠐⠅⢅⠊⢌⢊⠌⡎⡎⣎⢎⢢⢂⠅⡂⠅⡊⠠⡈⠄⠅⠂⠌⢄⢊⢆⢇⡧⣯⢷⣻⣞⡽⣪⡳⣝⢮⡳⡑⠅⠐⢈⠀⠀⠀⠀⡂⡀⠀⠀⡱⣳⡹⣮⣳⡽⡾⣽⢽⡽⡮⡯⣞⡵⣣⢣⢱⠱⣕\r\n"
			+ "⢎⢇⡗⡯⣗⢯⣗⢯⢮⣫⡳⣳⡻⡮⡳⡹⣕⣗⣕⣕⣵⣵⣗⣷⣾⣶⣾⣶⣦⣦⣄⣈⢌⢂⠕⡐⠄⢕⠨⡊⡎⡺⡜⣆⢇⢪⠨⡂⡇⢌⢌⢌⢬⢸⡰⡕⡗⣯⢿⡽⣯⢷⣗⣯⡺⣺⡪⡇⡏⡊⠀⠐⢰⠠⠀⠀⠀⢀⢓⢦⢮⢾⢵⢯⣗⣷⣻⢯⢿⢽⡽⡯⣟⣗⡯⡷⣝⡜⣞⢮\r\n"
			+ "⢯⡺⣜⡮⡮⣳⣳⢽⣕⡧⣻⡪⣫⣞⣼⢾⣻⣽⣿⣿⣿⣿⢿⣿⣟⣯⣿⣿⣿⢿⣿⣿⣷⣷⣬⡢⡑⡐⠅⡪⠨⡊⢎⢪⢓⢗⢽⢼⢼⢼⢜⡮⣺⢪⢺⠸⣸⢽⢝⡽⡽⣽⣺⣞⢾⢵⣻⡪⡎⡆⡥⣣⣳⢽⢵⣣⢅⡢⣪⢯⣟⢽⠍⠃⠑⢽⣞⣿⢽⢯⢯⣟⢷⢽⡺⡽⡮⡯⣪⣳\r\n"
			+ "⣿⡯⣗⡯⡯⡳⣳⢽⢮⣻⢮⣯⢷⣻⣞⣯⣷⢷⣗⣯⣷⢿⡿⣿⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣧⣑⢌⠪⡘⢌⢪⠪⡪⡱⡱⡹⡸⡱⡹⡘⡜⢌⢊⢮⣳⢯⣞⣝⢞⢼⡪⣗⢝⡮⡯⡯⡯⣫⢷⢽⢽⢽⣺⢽⡾⣽⣳⢇⠅⠀⠀⠐⢈⢾⡽⡽⣝⣵⣫⡫⡪⡪⡫⣏⢯⢗⡷\r\n"
			+ "⡯⣿⡽⣮⣳⢽⣮⣯⢿⣾⣻⣾⡿⣯⣟⣷⢿⣟⣿⣿⣽⣿⢿⣷⣿⣿⣯⣿⣟⣿⣿⢿⣿⣻⣿⣿⢿⣻⣿⣾⣬⢪⢨⠢⢣⢱⢘⢌⢎⢪⠪⡪⡸⠨⡢⡱⣵⣿⡽⡾⣾⣽⢵⣫⢮⢗⡯⡯⡯⣯⣫⢯⢯⢯⣟⡾⣯⣟⣷⡫⡎⡆⡐⢠⢡⣢⣻⣺⢽⣺⣺⣺⡺⣪⣞⡵⡽⣵⣻⡺\r\n"
			+ "⡻⡽⡽⡾⣽⢿⣷⡿⣿⣻⣽⣷⢿⣿⣽⣟⣿⣿⡿⣟⣯⣿⣿⣿⣿⣟⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢶⣱⢱⢡⢣⢣⢣⢣⢣⢣⢣⢑⢮⣾⢿⣾⣿⣻⣽⣾⣿⣳⣯⢯⢯⣻⡽⣗⣯⢿⣽⣻⢾⣝⣗⢗⣗⡯⣗⡵⣪⢮⣻⣞⢷⢽⣻⣞⣾⣺⣺⢵⣳⢯⣟⡾⣺⢽\r\n"
			+ "⢼⢹⡹⡝⡾⢽⢮⢟⣟⢿⣽⣟⣿⣯⣿⢿⣻⣷⣿⣿⣿⣿⣿⣿⣯⣿⣿⣿⣷⣿⣿⣟⣿⣿⣟⣿⣿⢿⣿⣿⣯⣿⣿⣿⣿⣾⣮⣮⣪⡺⣜⣎⣮⣾⢿⣻⢿⣽⣾⣗⣿⢾⣻⣽⣾⢿⣽⢾⢽⢯⣯⢿⡾⣽⣻⣞⣮⣟⡾⣝⡷⣻⡽⡽⡾⣽⢽⢝⣾⣳⣗⣗⡽⣝⡮⣗⢷⣫⢯⢯\r\n"
			+ "⢬⢥⢥⣭⣪⣱⣙⠹⠺⢝⢮⢯⢷⢿⣻⣿⣿⣿⣿⣿⣿⣿⡿⣟⣿⣿⣿⣽⣿⣟⣿⣿⣿⣿⣿⢿⣿⣿⣿⣿⣽⣿⣿⣿⢿⣻⣽⣾⣷⣿⣻⣾⣻⣾⢿⣻⣟⣿⢾⡿⣾⢿⣻⣽⡾⡿⣽⣻⢯⡷⡯⣟⡿⣯⡿⣞⣷⣻⣞⣗⡯⣗⡿⡽⣯⡳⣝⢽⣺⣗⡿⣮⣟⢷⢽⡺⣝⣞⢽⡹\r\n"
			+ "⡿⡽⡽⣯⣗⡿⣞⡿⣞⣦⣆⣅⡉⠋⠛⢯⢷⣿⣿⣽⣿⡿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣿⣽⣷⣿⣿⣿⣿⣽⣿⣿⣿⡿⣿⣿⣿⣿⣿⣿⣾⣷⣿⣯⣿⢿⣿⢿⣾⣿⣽⣯⣿⣽⣾⣻⣟⣷⣿⣽⡯⣿⡽⣞⣗⡿⡽⣗⣿⢾⣺⡽⡯⣿⢽⢷⣻⣞⣯⡷⣯⢿⡽⣞⣯⣳⢽⣳⣽⣳⢯\r\n"
			+ "⢯⢯⢯⣿⡾⣽⣗⣟⣿⡽⣯⡿⣿⣿⢾⣤⣌⡈⠙⠻⠽⣿⣿⣿⡿⣿⣷⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣾⣿⣯⣿⣿⣿⣿⣿⣟⣯⣿⣿⣯⣿⣿⢿⣻⣽⣾⣿⣯⣿⢯⣷⡯⣿⡹⢝⢿⢽⡽⣯⢿⣽⣻⣽⢯⡷⣟⣯⣿⣽⢯⡷⡯⡯⣗⡷⣿⢽\r\n"
			+ "⣯⢿⢽⢾⣟⣷⣻⣞⢿⣯⢷⣿⣻⡾⣟⣷⣻⣟⣿⢶⣤⣄⡑⡙⠻⠿⣟⣿⣿⣻⣿⣿⣿⡿⣿⣿⡿⣿⣟⣿⣿⣿⣿⣿⣿⣽⣿⣿⣾⣿⣿⣽⣿⣿⡿⣷⣿⣿⢿⣿⣿⣿⣽⣿⣿⣿⣿⣿⣿⣻⣽⣾⣿⢿⣽⡷⣝⢼⡸⣜⢽⢽⣳⣟⣾⢽⡿⣽⣻⢾⣾⡽⣝⢽⣽⣺⡵⣯⣟⣯\r\n"
			+ "⣞⣯⢿⡽⣿⣗⡷⣿⢽⢯⣿⣺⢷⣟⣿⣳⣗⣿⣺⣯⢯⡿⣿⣷⣷⣦⣬⣈⡋⠟⢿⢿⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣻⣿⣿⣿⣿⡿⣟⣿⣿⣻⣿⣿⣿⣿⣿⣿⣯⣿⣿⣻⣷⣿⣿⣽⣿⢿⣿⣟⣿⣟⣯⢯⡺⣪⢞⣼⣮⣟⣷⣻⣞⣯⢿⡵⣯⡿⣷⣻⣗⣿⣺⣳⡿⣯⡿⣽\r\n"
			+ "⣮⢿⡽⣞⣯⣿⣽⢽⣯⣟⣷⣻⣻⣽⡾⣗⣿⣺⣗⣯⡿⣽⢯⣷⢿⣻⣿⣿⣿⣿⣶⣬⣌⡙⠫⠿⡾⣿⣿⡿⣟⣯⣷⣿⣿⣿⣿⣿⣾⣿⣿⣿⣿⣿⣿⢿⣷⣿⣷⣿⣿⣻⣽⣿⣿⣽⣾⣿⡿⣿⣟⣿⣯⣿⢏⣗⢽⡪⠃⣸⣞⣗⢿⣽⢾⡯⣿⢽⣯⣯⡳⣕⣗⣟⡾⣯⢿⡽⣯⡯\r\n"
			+ "⣯⢿⡽⣗⣷⣳⢿⡽⣞⣷⣳⡯⣿⣺⣿⣯⣷⢿⡾⡷⣟⣯⣿⣽⢿⣽⣾⣻⡿⣿⣿⣿⣿⣿⣿⣶⣦⣥⣩⢛⠻⢻⢿⣿⣿⡿⣿⣾⣿⣿⣿⣿⣟⣿⣾⣿⣿⣿⣻⣽⣿⡿⣿⣿⣽⡿⣿⣷⣿⣿⡿⣿⣽⡯⣗⡯⠋⢀⣼⣳⢷⢯⣻⣺⣫⡯⣗⣟⣞⣾⣳⢷⣳⢯⢯⢯⣟⣿⣳⣟\r\n"
			+ "⣯⢯⡿⣽⣞⡾⡽⣽⢽⣽⡾⣽⣳⢯⣷⢿⡾⣿⢽⣻⣽⣻⢾⡽⣿⢽⡾⣯⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣦⣦⣑⡝⡛⢟⢿⢿⣷⡿⣿⣿⣿⣿⢿⣻⡿⡿⢟⠿⠻⠝⠯⠛⠛⠓⠛⠓⠻⠛⠫⠚⣑⣠⢮⣟⡮⣯⣟⣿⣽⣾⢾⣝⣗⣗⣗⣟⡾⡯⣿⢽⢯⣟⣞⣷⣻⣞\r\n"
			+ "⢯⡿⣽⣗⣯⢿⢽⣳⡯⣷⢿⣻⣞⣯⢿⣽⣟⣿⡯⣷⣻⣞⣯⢿⡽⣯⣟⣯⢿⣻⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⣴⣭⣫⣻⣛⣻⣙⣎⣍⣅⣔⣠⣄⣔⣤⣢⣦⣦⣵⣮⣾⣾⣾⡿⣟⣿⡽⣞⡯⡾⣽⣺⢿⣺⡾⣾⣿⣳⣳⢕⡧⣗⣯⢿⡽⣯⢿⣺⣗⣟⣞⣷\r\n"
			+ "⣽⢯⣷⣻⣞⣯⣟⡷⣻⡽⣿⡿⣾⢽⣻⣞⡿⣾⡿⣽⣞⣷⣻⡽⣯⢷⣻⣞⣿⣻⣟⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣟⣯⣿⣿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣯⡷⣟⣟⡾⣽⣗⡿⣽⣺⣞⣟⣿⣻⣿⢾⣯⢷⣯⡫⣗⡯⣷⣻⡽⣟⣷⣻⣞⡷⡯\r\n"
			+ "⣯⢿⣺⣗⡷⣗⣯⣟⡷⣻⣽⣿⣟⣯⡷⣿⢽⡷⣿⣟⣾⣳⢯⡿⡽⣯⢷⣻⣞⣷⣻⣿⣿⣿⣿⣿⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣟⣿⣽⣻⣟⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢿⣟⣿⡿⣷⣻⣽⢾⡯⣷⣗⣯⣗⣷⣻⣞⣷⣟⣿⣻⣽⣟⣾⢽⣳⢯⣗⣯⢿⣽⣺⣞⡾⡽⡯\r\n"
			+ "⡿⣽⣳⢯⡯⣿⣺⣳⢿⢽⣞⣿⣿⡽⣯⣟⣯⡿⣽⣷⣻⣞⣯⢿⡽⣽⢯⢷⣳⣟⣾⣻⣿⣿⣟⣿⣿⣿⣿⣿⣿⣻⣽⣿⣿⣯⣿⣿⣿⣟⣯⣷⣿⣯⢿⣿⣿⣿⣿⡿⣿⣻⣽⣿⣾⣿⣿⣿⣿⣻⣞⣯⢿⣻⣷⣻⣾⣺⢾⣵⣻⣞⣷⣻⣽⢷⣿⢽⣻⣺⢽⢾⢽⣻⣞⡷⣯⢯⢯⢯\r\n"
			+ "⡽⣗⡿⡽⣯⢷⢯⣯⢿⡽⡾⣽⣾⣿⣟⡾⣯⡿⣽⣿⢾⡽⣾⢯⢿⢽⡽⣯⢷⣻⢾⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣻⣗⣿⡾⣿⣿⣿⣿⣽⣿⣿⣿⣿⣿⣿⣿⣿⣯⣿⣷⣳⢯⢯⣗⢷⣳⣳⣫⢟⣾⣻⣞⣿⣽⢿⣯⣿⡽⣽⢾⣫⣯⣻⡺⡮⡿⡽⣯⢿⢽\r\n"
			+ "⣽⢯⢯⡿⡽⡯⣟⡾⡯⡿⡽⣯⣿⣿⣯⣿⣻⣿⢽⣾⡿⣯⣟⣟⡿⣽⡽⣽⢯⡯⣟⣿⣻⣿⣿⣿⣿⣿⢿⣿⣾⣿⣿⣿⣿⣟⣯⣿⣿⣿⣽⣯⣿⣟⣿⣿⣿⣿⣿⣿⣿⢿⣟⣿⣽⣿⣾⣿⣯⣷⢯⢯⢷⢽⣝⢾⣺⣺⢽⣺⢾⣯⡷⣟⣿⣷⣻⣯⡯⣟⣗⢷⣳⡯⡿⡽⣯⢯⡯⣟\r\n"
			+ "⡿⡽⡯⣯⢿⡽⡯⡿⣽⣻⡽⣗⣿⣻⣿⡾⣿⣯⣿⣽⣿⣟⣾⡽⣯⢷⣻⡽⣽⣽⣻⢾⣿⣿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⣻⣿⣿⣿⣿⣿⣷⢿⣾⣯⣿⣿⣿⣿⣿⣷⣿⣿⣿⣿⣿⣿⡿⣯⣿⣿⢯⣿⢽⣳⡽⣽⣺⣞⣽⡺⣿⣯⢿⣟⣿⣽⣻⣿⡿⣽⣞⣯⣿⣿⡯⣿⢽⡯⣟⣗\r\n"
			+ "⣿⢽⡯⣯⢷⣻⡽⣯⢷⢯⡯⣷⢯⣿⣿⣿⢿⣿⣺⣽⣿⣽⡾⣯⣟⣯⣷⣻⣳⣗⣯⢿⡾⣿⣿⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢿⣻⡿⣾⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣟⣷⣿⣿⣿⣻⣯⢿⣻⣽⢯⣷⣳⣗⣗⡯⣿⡾⣿⣻⣟⣯⣿⣿⡿⣯⡷⣗⡿⣿⣿⡯⣯⢿⣯⣯");



	System.out.println("\nCheck");





			choice = in.nextLine();
			switch(choice)
			{
				case "n": clearScreen();
				System.out.print("	-----Adding Employee-----	\n");
				System.out.println("Enter name of employee: ");
				String name = in.nextLine();
				System.out.println("Enter either: Hourly (h) or Salary (s): ");
				payChoice = in.nextLine();
				switch(payChoice)	//nested Switch case to be allow for choice option security
					{
					case "h": System.out.print("Enter hourly wage: ");
					double wage = in.nextDouble();
					in.nextLine();
					//fmt.format(wage);
					HourlyEmployee newHEmployee = new HourlyEmployee(name, wage);
					Employees.add(newHEmployee);
					fmt.format(wage);
					break;

					case "s": System.out.println("Enter salary: ");	
					double wage2 = in.nextDouble();
					in.nextLine();
					//fmt.format(wage2);
					SalariedEmployee newSEmployee = new SalariedEmployee(name, wage2);
					Employees.add(newSEmployee);
					fmt.format(wage2);
					break;

					default:	//default incase neither 's' or 'h' is inputted
					System.out.println("Your choice did not match 'h' or 's'");
					break;
					}
					printEmployees();
					break;

				case "c": clearScreen();
				System.out.print("	-----Compute Paychecks-----	\n");
				for(int i = 0; i < Employees.size(); i++)
				{
					System.out.print("Enter hours worked by " + Employees.get(i).getName() + ": ");
					double hours = in.nextDouble();
					in.nextLine();
					System.out.println("Pay: " +  (fmt.format(Employees.get(i).computeWage(hours))));
				}
				break;

				case "r": clearScreen();
				System.out.print("	-----Pay Increase(%)-----	\n");
				System.out.println("Enter percentage pay increase: ");
				double percentage = in.nextDouble();
				in.nextLine();
				for(int i = 0; i < Employees.size(); i++)
				{
					Employees.get(i).increaseWage(percentage);
				}
				System.out.println("New Wages: ");
				System.out.println("-----------");
				printEmployees();
				break;

				case "l": clearScreen();
				System.out.print("	-----Pay Decrease(%)-----	\n");
				System.out.print("Enter percentage pay decrease: ");
				double percentage2 = in.nextDouble();
				in.nextLine();
				while (percentage2 >= 100)
				{
					System.out.println("You cannot lower wages by " + percentage2 + "%");
					System.out.println("Enter new percentage pay decrease: (<100%)");
					percentage2 = in.nextDouble();
				}
				for(int i = 0; i < Employees.size(); i++)
				{
					Employees.get(i).decreaseWage(percentage2);
				}
				System.out.println("New Wages: ");
				System.out.println("-----------");
				printEmployees();
				break;

				case "p": clearScreen();
				System.out.print("	-----Employee Records-----	\n");
				printEmployees();
				break;

				case "d": downloadData();
				break;

				case "u": uploadData();
				//System.out.println("TEST");
				break;

				case "q":System.out.println("Have a nice day");
				x = 1;
				break;

				default: /*clearScreen();*/
				System.out.println("Your choice did not match any of the given commands");
				break;
				//There are 8 switches total. The first is to create a new employee that adds it to the ArrayList, the next allows you to compute their wages, then the wage can either be increased or lowered, the Arraylist can be printed with 'p' even though the previous method prints it anyway it is still here, then it will allow for all the input to be downloaded and encrypted which I find to be interesting. The files can be uploaded and then finally q sets x to one which breaks the while loop ending the program.
			}
		}
	}


}
