//import java.util.Scanner;
//
//public class Part2 {
//	public static void main(String[] args) {
//		Scanner input = new Scanner(System.in);		// Create new Scanner object
//
//		// Prompt the user to enter a number between 0 and 1000.
//		System.out.print("Enter a number between 0 and 1000: ");
//		int number = input.nextInt();
//
//		// Compute the sum of the digits in the integer.
//		int lessThan10 = number % 10;		// Extract the digit less than 10
//		number /= 10;							// Remove the extracted digit
//		int tens = number % 10;				// Extract the digit between 10 to 99
//		number /= 10;							// Remove the extracted digit
//		int hundreds = number % 10;		// Extract the digit between 100 to 999
//		number /= 10;							// Remove the extracted digit
//		int sum = hundreds + tens + lessThan10;	
//
//		// Display results
//		System.out.println("The sum of the digits is " + sum);
//	}
//}

import java.util.Scanner;

public class Part2 {
	public static void main(String[] args) {

		while (true) {
			Scanner sc = new Scanner(System.in);
			int userNum = 0;
			System.out.println("----------------------------------------------");
			System.out.print("Enter a number between 0 and 1000(0 to exit): ");
			
			userNum = sc.nextInt();
			if (userNum == 0) {
				sc.close();
				System.out.println("-------------END OF PROGRAM-------------------");
				break;
			}
			
			int lessThan10 = userNum % 10;
			System.out.println("lessThan10: " + lessThan10);
			userNum /= 10;
			int tens = userNum % 10;
			System.out.println("tens: " + tens);
			userNum /= 10;
			int hundreds = userNum % 10;
			System.out.println("hundres: " + hundreds);
			userNum /= 10;
			int sum = lessThan10 + tens + hundreds;
			System.out.println("SUM: " + sum);
		}
		
	}
}