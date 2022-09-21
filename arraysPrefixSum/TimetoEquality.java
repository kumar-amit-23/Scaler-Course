package arraysPrefixSum;

public class TimetoEquality {
	public int solve(int[] A) {
		int max = Integer.MIN_VALUE;

		for (int num : A) {
			max = (num > max) ? num : max;
		}
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			A[i] = max - A[i];
			sum += A[i];
		}

		return sum;
	}

}
