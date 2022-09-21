package arraysPrefixSum;

public class RangeSumQuery {
	public long[] rangeSum(int[] A, int[][] B) {

		long[] prefixsum = new long[A.length];

		prefixsum[0] = A[0];

		for (int i = 1; i < A.length; i++) {
			prefixsum[i] = A[i] + prefixsum[i - 1];
		}

		long[] ans = new long[B.length];

		for (int i = 0; i < B.length; i++) {

			int low = B[i][0] - 1;
			int high = B[i][1] - 1;

			long sum = 0;

			if (low == 0) {
				sum = prefixsum[high];
			} else {
				sum = prefixsum[high] - prefixsum[low - 2];
			}

			ans[i] = sum;

		}

		return ans;
	}

}
