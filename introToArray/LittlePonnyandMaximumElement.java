package introToArray;

public class LittlePonnyandMaximumElement {
	public int solve(int[] A, int B) {
		int count = 0;
		boolean flag = false;

		for (int num : A) {
			if (num > B) {
				count++;
			}

			if (num == B) {
				flag = true;
			}
		}

		if (flag) {
			return count;
		}

		return -1;
	}

}
