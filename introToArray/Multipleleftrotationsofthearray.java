package introToArray;

public class Multipleleftrotationsofthearray {

	public int[][] solve(int[] A, int[] B) {

		int[][] ans = new int[B.length][A.length];

		for (int i = 0; i < B.length; i++) {
			int r = B[i] % A.length;
			int[] arr = new int[A.length];

			for (int k = 0; k < arr.length; k++) {
				arr[k] = A[k];
			}

			// reverse the array
			reverseArray(arr, 0, arr.length - 1);
			int n = arr.length;
			// split reverse the array
			reverseArray(arr, 0, n - r - 1);
			reverseArray(arr, n - r, arr.length - 1);

			for (int j = 0; j < arr.length; j++) {
				ans[i][j] = arr[j];
			}
		}

		return ans;

	}

	public void reverseArray(int[] arr, int left, int right) {
		while (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}

}
