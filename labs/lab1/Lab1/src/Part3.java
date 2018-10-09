//PROF SOLUTION
//import java.util.Scanner;
//
//public class Part3 {
//	public static void main(String[] args) {
//		Scanner input = new Scanner(System.in);	// Create a new Scanner object.
//		final double MONTHLY_INTEREST_RATE = 0.00417;	// Initialize constant value
//
//		// Prompt the user to enter a montly saving amount
//		System.out.print("Enter the monthly saving amount: ");
//		double savingAmount = input.nextDouble();
//
//		// Compute first month account value
//		double total = 100 * (1 + MONTHLY_INTEREST_RATE);
//		// Compute second month account value
//		total = (100 + total) * (1 + MONTHLY_INTEREST_RATE);
//		// Compute third month account value
//		total = (100 + total) * (1 + MONTHLY_INTEREST_RATE);
//		// Compute forth month account value
//		total = (100 + total) * (1 + MONTHLY_INTEREST_RATE);
//		// Compute fifth month account value
//		total = (100 + total) * (1 + MONTHLY_INTEREST_RATE);
//		// Compute sixth month account value
//		total = (100 + total) * (1 + MONTHLY_INTEREST_RATE);
//
//		// Display result
//		System.out.println("After the sixth month, the account value is " + total);
//	}
//}

import java.util.Scanner;

public class Part3 {

	public static void sixMonthReport(double savingAmount, double MONTHLY_INTEREST_RATE) {
		double result = 0;
		// System.out.println("result from sixMonthReport function: " + result);
		// System.out.println("MONTHLY_INTEREST_RATE from sixMonthReport function: " +
		// MONTHLY_INTEREST_RATE);

		for (int i = 0; i < 6; i++) {
			result = (result + savingAmount) * (1 + MONTHLY_INTEREST_RATE);

		}

		System.out.println("After the sixth month, the account value is $" + result);
	}

	public static void main(String[] args) {
		double savingAmount = 0;
		final double MONTHLY_INTEREST_RATE = 0.00417;
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter the monthly saving amount: ");
			savingAmount = sc.nextDouble();
			if (savingAmount == 0) {
				sc.close();
				break;
			}
			sixMonthReport(savingAmount, MONTHLY_INTEREST_RATE);
		}
	}
}