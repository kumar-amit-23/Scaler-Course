package arraysPrefixSum;

//Question -> Count ways to make sum of odd and even indexed elements 
//equal by removing an array element
public class CountWays {

	public int solve(int[] A) {
		int[] prefixodd = new int[A.length];
		int[] prefixeven = new int[A.length];
		prefixeven[0] = A[0];
		prefixodd[0] = 0;
		for (int i = 1; i < A.length; i++) {
			if (i % 2 == 0) {
				prefixeven[i] = A[i] + prefixeven[i - 1];
				prefixodd[i] = prefixodd[i - 1];
			} else {
				prefixodd[i] = A[i] + prefixodd[i - 1];
				prefixeven[i] = prefixeven[i - 1];
			}
		}

		int count = 0;
		int oddsum = 0;
		int evensum = 0;
		for (int i = 0; i < A.length; i++) {
			if (i == 0) {
				oddsum = prefixeven[A.length - 1] - prefixeven[i];
				evensum = prefixodd[A.length - 1] - prefixodd[i];
			} else {
				oddsum = prefixodd[i - 1] + prefixeven[A.length - 1] - prefixeven[i];
				evensum = prefixeven[i - 1] + prefixodd[A.length - 1] - prefixodd[i];
			}

			if (oddsum == evensum) {
				count++;
			}
		}

		return count;
	}

}
