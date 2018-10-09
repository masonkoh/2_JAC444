//PROF SOLUTION
//public class Part1 {
//	public static void main(String[] args) {
//		System.out.println("Population projection");
//		System.out.println("Current population: 312032486");
//		System.out.println("One birth every 7 seconds.");
//		System.out.println("One death every 13 seconds.");
//		System.out.println("One new immigrant every 45 seconds.");
//		System.out.println("Yearly Population projection formula: ");
//		System.out.println("Current population + ((births per year)");
//		System.out.println("                   - (deaths per year)");
//		System.out.println("                   + (new immigrants per year))");
//		System.out.println("                   * year.");
//		System.out.println("Year 1 projection: ");
//		System.out.println(312032486 + (((31536000 / 7)
//									 - (31536000 / 13)
//									 + (31536000 / 45)) * 1));
//		System.out.println("Year 2 projection: ");
//		System.out.println(312032486 + (((31536000 / 7)
//									 - (31536000 / 13)
//									 + (31536000 / 45)) * 2));
//		System.out.println("Year 3 projection: ");
//		System.out.println(312032486 + (((31536000 / 7)
//									 - (31536000 / 13)
//									 + (31536000 / 45)) * 3));
//		System.out.println("Year 4 projection: ");
//		System.out.println(312032486 + (((31536000 / 7)
//									 - (31536000 / 13)
//									 + (31536000 / 45)) * 4));
//		System.out.println("Year 5 projection: ");
//		System.out.println(312032486 + (((31536000 / 7)
//									 - (31536000 / 13)
//									 + (31536000 / 45)) * 5));
//	}
//}

public class Part1 {

	public static void yearlyReport(long currentPop) {
		System.out.println("year +0: " + currentPop);
		long[] year = new long[5];
		year[0] = currentPop + ((31536000 / 7) - (31536000 / 13) + (31536000 / 45));
		year[1] = currentPop + (((31536000 / 7) - (31536000 / 13) + (31536000 / 45)) * 2);
		year[2] = currentPop + (((31536000 / 7) - (31536000 / 13) + (31536000 / 45)) * 3);
		year[3] = currentPop + (((31536000 / 7) - (31536000 / 13) + (31536000 / 45)) * 4);
		year[4] = currentPop + (((31536000 / 7) - (31536000 / 13) + (31536000 / 45)) * 5);

		for (int i = 0; i < 5; i++) {
			System.out.println("Year " + (i + 1) + ": " + year[i]);
		}

	}

	public static void main(String[] args) {
		long currentPop = 312032486;
		System.out.println("Current population is " + currentPop);
		yearlyReport(currentPop);
	}
}