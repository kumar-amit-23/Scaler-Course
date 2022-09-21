package interviewProblems;

public class ChristmasTrees {

	public int solve2(int[] A, int[] B) {
		int cost = Integer.MAX_VALUE;

		for (int i = 1; i < A.length - 1; i++) {

			int minleft = Integer.MAX_VALUE;
			int minright = Integer.MAX_VALUE;

			for (int j = i - 1; j >= 0; j--) {
				if (A[j] < A[i]) {
					minleft = Math.min(B[j], minleft);
				}
			}

			for (int k = i + 1; k < A.length; k++) {
				if (A[k] > A[i]) {
					minright = Math.min(minright, B[k]);
				}
			}

			if (minleft != Integer.MAX_VALUE && minright != Integer.MAX_VALUE) {
				cost = Math.min(minleft + minright + B[i], cost);
			}
		}

		if (cost != Integer.MAX_VALUE) {
			return cost;
		}

		return -1;
	}

}
