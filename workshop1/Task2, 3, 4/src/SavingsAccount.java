public class SavingsAccount extends Account {

	public static void main(String[] args) {

		SavingsAccount save1 = new SavingsAccount(1122, 500);
		save1.setAnnualInterestRate(0.04);
		System.out.println("SAVING ACC STEP 1: " + save1.getBalance());
		save1.withdraw(100);
		System.out.println("SAVING ACC STEP 2: " + save1.getBalance());
		save1.withdraw(500);
		System.out.println("SAVING ACC STEP 3: " + save1.getBalance());
	}

	protected double OVERDRAFT_LIMIT = 0;

	public SavingsAccount(int id, double balance) {
		super(id, balance); // parent class is Account. it's calling constructor from Account class
	}

	// is it like inheritance?
	@Override
	public void withdraw(double amount) {

		double tempBalance = getBalance();	
		if (tempBalance - amount >= OVERDRAFT_LIMIT) {
			System.out.println("\n good withdraw\n");
			super.withdraw(amount);
		}
	}

	@Override
	public String toString() {
		return "SavingsAccount{" + "Balance=" + getBalance() + '}';
	}
}