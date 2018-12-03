
public class Simulator {
	public static void runSimulation(int b, int s) {
		String[] ballpaths = Simulator_tool.ballpaths(b, s);
		int[] slots = Simulator_tool.readBallPaths(ballpaths, s);

		// display paths
		for (String path : ballpaths) {
			System.out.println(path);
		}

		System.out.println();

		// display slots histogram
		String emptySlotsString = "";
		for (int i = 0; i < slots.length; i++) {
			emptySlotsString += "*";
		}
		for (int i = slots.length - 1; i > 0; i--) {
			String output = "";
			for (int j = 0; j < slots.length; j++) {
				if (slots[j] == i) {
					output += "O";
					slots[j]--;
				} else {
					output += "*";
				}
			}
			if (!output.equals(emptySlotsString)) {
				System.out.println(output);
			}
		}
	}

}
