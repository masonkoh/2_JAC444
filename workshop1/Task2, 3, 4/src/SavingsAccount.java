public class SavingsAccount extends Account
{

	protected double OVERDRAFT_LIMIT = 0;

	public SavingsAccount(int id, double balance)
	{
		super(id, balance); // parent class is Account. it's calling constructor from Account class
	}

	// is it like inheritance?
	@Override
	public void withdraw(double amount)
	{

		double tempBalance = getBalance();
		if (tempBalance - amount >= OVERDRAFT_LIMIT)
		{
			super.withdraw(amount);
		}
	}

	@Override
	public String toString()
	{
		return "SavingsAccount{" + "Balance=" + getBalance() + '}';
	}
}