package arraysPrefixSum;

public class ProductArrayPuzzle {
	public int[] solve(int[] A) {
		int prod = 1;

		for (int num : A)
			prod *= num;

		for (int i = 0; i < A.length; i++) {
			A[i] = prod / A[i];
		}

		return A;
	}

}
