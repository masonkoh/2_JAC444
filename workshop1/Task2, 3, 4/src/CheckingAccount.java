public class CheckingAccount extends Account {
	public static void main(String[] args) {

		CheckingAccount chek1 = new CheckingAccount(0, 100);
		System.out.println("CHEQ ACC STEP 1: " + chek1.getBalance());
		chek1.withdraw(50);
		System.out.println("CHEQ ACC STEP 2: " + chek1.getBalance());
		chek1.withdraw(100);
		System.out.println("CHEQ ACC STEP 3: " + chek1.getBalance());
		chek1.withdraw(100);
		System.out.println("CHEQ ACC STEP 4: " + chek1.getBalance());
	}

	protected double OVERDRAFT_LIMIT = -100;

	public CheckingAccount(int id, double balance) {
		super(id, balance); // parent class is Account. it's calling constructor from Account class
	}

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
		return "CheckingAccount{" + "Balance=" + getBalance() + '}';
	}
}