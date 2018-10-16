import java.util.Scanner;

public class PartB {

	static final int ID = 0;
	static final int LOAN = 1;
	static double[][][] mBanks;

	// 1st: bank number
	// 2nd: number of banks i give loan
	// 3rd: id of bank who i give laon

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = 0;
		int limit = 0;
		System.out.print("Enter the number of banks(enter any character to exit): ");
		while (sc.hasNextInt()) {
			n = sc.nextInt(); // n = No of Banks
			while (n > 0) {

				System.out.print("Enter minimum limit: ");
				limit = sc.nextInt();
				mBanks = new double[n][][];

				System.out.println(
						"---------------------------------Example START---------------------------------------------");
				System.out.printf("%-5s%-5s%-5s%-5s%-5s%-5s%-5s\n", "bank # |", "balance |", "Loaned# |", "Bank ID |",
						"Amounts |", "Bank ID |", "Amounts |");
				System.out.printf("%-7d|%8.2f|%8d|", 1, 200.0, 2);
				System.out.printf("%8.0f|%8.2f|", 2.0, 73.0);
				System.out.printf("%8.0f|%8.2f|\n\n", 1.0, 130.0);
				System.out.println(
						"----------------------------------EXAMPLE END----------------------------------------------");

				for (int i = 0; i < mBanks.length; i++) {
					System.out.print("Enter bank #" + i + " > ");
					double balance = sc.nextDouble();
					int numBanks = sc.nextInt();
					mBanks[i] = new double[++numBanks][2];
					mBanks[i][0][0] = balance;

					for (int bank = 1; bank < mBanks[i].length; bank++) {
						mBanks[i][bank][ID] = sc.nextDouble();
						mBanks[i][bank][LOAN] = sc.nextDouble();
					}

				}
				System.out.println("");
				displayMatrix(mBanks);
				boolean[] unsafeIndex = scanBanks(mBanks, limit);

				for (int i = 0; i < unsafeIndex.length; i++) {
					System.out.println("Bank# " + i + " unsafe: " + unsafeIndex[i]);
				}
				// sc.close();
				break;
			}
		}

	}

	public static boolean[] scanBanks(double[][][] m, int limit) {

		boolean[] indexUnsafeBanks = new boolean[m.length];
		double total;
		boolean isSafe = false;

		while (!isSafe) {
			isSafe = true;
			for (int banks = 0; banks < m.length; banks++) {
				total = m[banks][0][0];
				for (int LoanedBanks = 1; LoanedBanks < m[banks].length; LoanedBanks++) {
					int index = (int) m[banks][LoanedBanks][ID];
					if (!indexUnsafeBanks[index])
						total += m[banks][LoanedBanks][LOAN];
				}

				if (total < limit && !indexUnsafeBanks[banks]) {
					indexUnsafeBanks[banks] = true;
					isSafe = false;
				}
			}
		}
		return indexUnsafeBanks;
	}

	public static void displayMatrix(double[][][] m) {

		System.out.printf("%-5s%-5s%-5s%-5s%-5s%-5s%-5s\n", "bank # |", "balance |", "Loaned# |", "Bank ID |",
				"Amounts |", "Bank ID |", "Amounts |");
		for (int banks = 0; banks < m.length; banks++) {
			System.out.printf("%-7d|%8.2f|%8d|", banks, m[banks][0][0], m[banks].length - 1);

			for (int LoanedBanks = 1; LoanedBanks < m[banks].length; LoanedBanks++) {
				System.out.printf("%8.0f|%8.2f|", m[banks][LoanedBanks][ID], m[banks][LoanedBanks][LOAN]);
			}
			System.out.println("");
		}
	}

}