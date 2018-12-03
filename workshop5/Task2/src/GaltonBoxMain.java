
/*
  The bean machine, also known as a quincunx or the Galton box, is a device
  for statistics experiments named after English scientist Sir Francis Galton.
  It consists of an upright board with evenly spaced nails (or pegs) in a
  triangular form. Balls are dropped from the opening of the board. Every time
  a ball hits a nail, it has a 50% chance of falling to the left or to the
  right. The piles of balls are accumulated in the slots at the bottom of the
  board.
  Write a progrom that simulates the bean machine. Your program should prompt
  the user to enter the number of the balls and the number of the slots in the
  machine. Simulate the falling of each ball by printing its path. Display the
  final buildup of the balls in the slots in histogram.
*/

import java.util.Scanner;

public class GaltonBoxMain {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of balls to drop: ");
		int numberOfBalls = input.nextInt();
		System.out.print("Enter the number of slots in the bean machine: ");
		int numberOfSlots = input.nextInt();

		Simulator.runSimulation(numberOfBalls, numberOfSlots);
	}

}