
public class Simulator_tool {

	public static int[] readBallPaths(String[] ballpaths, int s) {
		int[] slots = slots(s);
		for (int i = 0; i < ballpaths.length; i++) {
			int rightCount = 0;
			for (int j = 0; j < ballpaths[i].length(); j++) {
				if (ballpaths[i].charAt(j) == 'R') {
					rightCount++;
				}
			}
			slots[rightCount]++; 
		}
		return slots;
	}

	public static int[] slots(int s) {
		return new int[s];
	}

	public static String[] ballpaths(int b, int s) {
		String[] ballpaths = new String[b];

		for (int ball = 0; ball < b; ball++) {
			StringBuilder path = new StringBuilder();

			for (int way = 1; way < s; way++) {
				int random = (int) (Math.random() * 2);
//				System.out.print((int)(Math.random()*2)); //[MK_DEBUGGING]
 
				if (random == 0) {
					path.append("L");
				} else {
					path.append("R");
				}
			}

			ballpaths[ball] = path.toString();
//			System.out.println("");//[MK_DEBUGGING]
		}

		return ballpaths;
	}
}
