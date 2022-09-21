package subArrays;

public class Subarraywithleastaverage {
	public int solve(int[] A, int B) {
		int min = 0;

		int sum = 0;
		for (int i = 0; i < B; i++)
			sum += A[i];
		min = sum;

		int start_index = 0;

		for (int i = B; i < A.length; i++) {
			sum = sum + A[i] - A[i - B];

			if (sum < min) {
				min = sum;
				start_index = i - B + 1;
			}
		}

		return start_index;
	}

}
