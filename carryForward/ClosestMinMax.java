package carryForward;

public class ClosestMinMax {
	public int solve(int[] A) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int num : A) {
			max = Math.max(num, max);
			min = Math.min(min, num);
		}

		int imin = -1;
		int imax = -1;
		int ans = A.length;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == min)
				imin = i;
			else if (A[i] == max)
				imax = i;

			if (imax >= 0 && imin >= 0) {
				int val = Math.abs(imin - imax) + 1;
				ans = Math.min(val, ans);
			}
		}

		return ans;
	}
}
