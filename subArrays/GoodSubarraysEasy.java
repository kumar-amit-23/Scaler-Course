package subArrays;

public class GoodSubarraysEasy {
	public int solve(int[] A, int B) {
		int ans = 0;
		for (int i = 0; i < A.length; i++) {
			int count = 1;
			int sum = 0;
			for (int j = i; j < A.length; j++) {
				sum += A[j];
				if (count % 2 == 1 && sum > B || count % 2 == 0 && sum < B) {
					ans++;
				}
				count++;
			}
		}

		return ans;
	}

}
