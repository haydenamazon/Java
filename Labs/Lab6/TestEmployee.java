public class TestEmployee
{
	public static void main(String[] args)
	{
		String first = "Morris";
		String last = "Brown";
		double salary = 40000;
		int byear = 1980;
		int bmonth = 3;
		int bday = 8;
		int hyear = 2021;
		int hmonth = 2;
		int hday = 5;
		Date birthDate = new Date(byear, bmonth, bday);
		Date employment = new Date(hyear, hmonth, hday);
		Employee personal = new Employee(first, last, salary, birthDate, employment);
		System.out.print(personal.toString());
	}
}
			
