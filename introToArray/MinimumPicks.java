package introToArray;

public class MinimumPicks {
	public int solve(int[] A) {

		int min_odd = Integer.MAX_VALUE;
		int max_even = Integer.MIN_VALUE;

		for (int i = 0; i < A.length; i++) {
			if (A[i] % 2 == 0) {
				max_even = Math.max(max_even, A[i]);
			} else {
				min_odd = Math.min(min_odd, A[i]);
			}
		}

		return max_even - min_odd;
	}

}
