package introToArray;

public class ReversetheArray {
	public int[] solve(final int[] A) {
		int left = 0;
		int right = A.length - 1;

		while (left < right) {
			int temp = A[left];
			A[left] = A[right];
			A[right] = temp;
			left++;
			right--;
		}

		return A;
	}
}
