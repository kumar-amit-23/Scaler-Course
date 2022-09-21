package subArrays;

public class CountingSubarraysEasy {
	public int solve(int[] A, int B) {
		int count = 0;

		for (int i = 0; i < A.length; i++) {
			int sum = 0;
			for (int j = i; j < A.length; j++) {
				sum += A[j];
				if (sum < B)
					count++;
			}
		}

		return count;
	}

}
