package carryForward;

public class Bulbs {
	public int bulbs(int[] A) {

		int change = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0 && change % 2 == 0) {
				change++;
			} else if (A[i] == 1 && change % 2 == 1) {
				change++;
			}
		}

		return change;
	}
}
