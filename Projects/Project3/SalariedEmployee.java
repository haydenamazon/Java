import java.io.*;
import java.text.DecimalFormat;
class SalariedEmployee extends Employee implements Serializable
{
	public static DecimalFormat fmt = new DecimalFormat("######.##");
	private String name;
	private double wage;
	public SalariedEmployee(String name, double wage)
	{
		super(name, wage);
		this.wage = wage;
		this.name = name;
	}
	public double computeWage(double hours)
	{
		double salinHour = wage / 52 / 40;
		return salinHour * 40;
	}
	public void setSalary(double newWage)
	{
	//	wage = newWage;
	}
	public String toString()
	{
		return("NAME: " + getName() + "\nSALARY: $ " + fmt.format(getWage()) + " /year");
	}
}
