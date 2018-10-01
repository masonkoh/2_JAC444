import java.util.Scanner;
import java.io.IOException;

public class TestProgram_ATM {
	static Scanner input = new Scanner(System.in); // DONT FORGET TO CLOSE

	public static void main(String[] args) {
		Account[] accounts = new Account[10];
		for (int i = 0; i < 10; i++) { 
			accounts[i] = new Account(i, 100.0);
		}
		System.out.print("Enter an id(1 - 10) ");
		int id = input.nextInt();

		if (id < 1 || id > 10) {
			id = incorrectId(id);
		}
		// default value for user balance is $100

		accounts[id - 1].setBalance(100);

		while (true) {
			menuDisplay();
			System.out.println("Enter a choice: ");
			int choice = input.nextInt();

			if (choice == 4) {
				System.out.print("Enter an id(1 - 10) ");
				id = input.nextInt();

				if (id < 1 || id > 10) {
					id = incorrectId(id);
				}
			}
			performChoice(id, choice, accounts);
		}
	}

	public static int incorrectId(int id) {
		while (id < 1 || id > 10) {
			System.out.println("Incorecct ID type" + "\n" + "Enter an id(1 - 10): ");
			id = input.nextInt();
			System.out.println();
		}
		return id;
	}

	public static void performChoice(int id, int choice, Account[] accounts) {
		switch (choice) {
		case 1:
			System.out.printf("The balance is $%.1f%n", accounts[id - 1].getBalance());
			break;
		case 2:
			System.out.print("Enter the amount to withdraw: ");
			accounts[id - 1].withdraw(input.nextDouble());
			break;
		case 3:
			System.out.print("Enter the amount to deposit: ");
			accounts[id - 1].deposit(input.nextDouble());
			break;
		default:
			break;
		}
	}

	public static void menuDisplay() {
		System.out.println("\nMain menu");
		System.out.println("1: Check Balance");
		System.out.println("2: Withdraw");
		System.out.println("3: Deposit");
		System.out.println("4: Exit");

	}
}