import java.io.*;
abstract class Employee implements Serializable
{
	protected String name;
	protected double wage;
	public Employee (String name, double wage)
	{
		this.name = name;
		this.wage = wage;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String newName)
	{
		name = newName;
	}
	public double getWage()
	{
		return wage;
	}
	public void setWage(double newWage)
	{
		wage = newWage;
	}
	public abstract double computeWage (double hours);
	//no need for curly brackets since its an abstract method
	public void increaseWage(double percentage)
	{
		wage *= 1 + (percentage / 100);
		setWage(wage);
	}
	public void decreaseWage(double percentage)
	{
		wage *= 1 - (percentage /100);
		setWage(wage);
	}
}
