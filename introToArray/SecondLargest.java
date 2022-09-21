package introToArray;

import java.util.Arrays;

public class SecondLargest {
	public int solve(int[] A) {
		if (A.length == 1) {
			return -1;
		}

		Arrays.sort(A);
		int val = A[A.length - 2];

		return val;
	}

}
