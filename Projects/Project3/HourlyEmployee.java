import java.io.*;
import java.text.DecimalFormat;
class HourlyEmployee extends Employee implements Serializable
{
	public static DecimalFormat fmt = new DecimalFormat("#######.##");
	private String name;
	private double wage;
	public HourlyEmployee(String name, double wage)
	{
		super(name, wage);
		this.wage = wage;
		this.name = name;
	}
	public double computeWage(double hours)
	{
		if(hours <= 40)
		{
			return (double)hours * wage;
		}
		else
		{
			return (double)(40 * wage) + ((hours - 40) * (1.5 * wage));
		}
	}
	public String toString()
	{
		return ("NAME: " + getName() + "\nWAGE: $ " +fmt.format(getWage()) + " /hour");
	}
}




