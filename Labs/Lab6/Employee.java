public class Employee extends Person
{
	private double salary;
	private Date employment;
	
	public Employee(String lastName, String firstName, double salary, Date birthDate, Date employment)
	{
	super(lastName,firstName,birthDate);
	this.salary = salary;
	this.employment = employment;
	}
	public double getSalary()
	{
		return salary;
	}
	public Date getEmployment()
	{
		return employment;
	}
	public void setSalary(double salary)
	{
		this.salary = salary;
	}
	public void setEmployment(Date employment)
	{
		this.employment = employment;
	}
	public String toString()
	{
		return("name: " + getLastName() + ", " + getFirstName() + "\nSalary = " + salary + "\nBirthday = " + getBirthDate().toString() + "\nHired = " + employment.toString());
	}
}
