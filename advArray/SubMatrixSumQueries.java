package advArray;

public class SubMatrixSumQueries {
	public int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
		int[][] prefixSum = new int[A.length][A[0].length];

		int n = A.length;
		int m = A[0].length;
		int mod = 1000000007;
		// cal for every row
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (j == 0) {
					prefixSum[i][j] = prefixSum[i][j] + A[i][j];
				} else {
					prefixSum[i][j] = (prefixSum[i][j] % mod + prefixSum[i][j - 1] % mod + A[i][j] % mod) % mod;
				}
			}
		}

		// cal for every coloumn
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < m; j++) {
				prefixSum[i][j] = (prefixSum[i][j] % mod + prefixSum[i - 1][j] % mod) % mod;
			}
		}

		int ans[] = new int[B.length];
		for (int q = 0; q < B.length; q++) {

			int x1 = B[q] - 1;
			int y1 = C[q] - 1;
			int x2 = D[q] - 1;
			int y2 = E[q] - 1;

			if (x1 == 0 && y1 == 0) {
				ans[q] = (prefixSum[x2][y2]) % mod;
			} else if (x1 == 0 && y1 != 0) {
				ans[q] = (prefixSum[x2][y2] - prefixSum[x2][y1 - 1]) % mod;
			} else if (x1 != 0 && y1 == 0) {
				ans[q] = (prefixSum[x2][y2] - prefixSum[x1 - 1][y2]) % mod;
			} else {
				ans[q] = (prefixSum[x2][y2] - prefixSum[x2][y1 - 1] - prefixSum[x1 - 1][y2] + prefixSum[x1 - 1][y1 - 1])
						% mod;
			}

		}

		return ans;

	}

}
