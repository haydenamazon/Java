public class CheckingAccount extends Account {

	private int checksWritten;	

	public CheckingAccount (double initialBalance)
	{
		super(initialBalance);
		this.checksWritten = 0;
	}
	public int getChecksWritten()
	{
		return checksWritten;
	}
	public void writeCheck(double amount)
	{
		withdraw(amount);
		checksWritten++;
	}
}
