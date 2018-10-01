public class CheckingAccount extends Account
{

	protected double OVERDRAFT_LIMIT = -100;

	public CheckingAccount(int id, double balance)
	{
		super(id, balance); // parent class is Account. it's calling constructor from Account class
	}

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
		return "CheckingAccount{" + "Balance=" + getBalance() + '}';
	}
}