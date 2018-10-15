import java.util.Scanner;

public class MainMenu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("**********************[Hangman Game]************************");
		System.out.println("Press 1 to run game with randomly generated word.");
		System.out.println("Press 2 to run game by reading the word from the text file.");
		System.out.print("Enter your choice: ");

		while (sc.hasNextInt()) {
			int userChoice = sc.nextInt();
			if (userChoice == 1) {
				PartA.runPartA();
			} else if (userChoice == 2) {
				PartB.runPartB();
			}

		}
		sc.close();
	}
}
