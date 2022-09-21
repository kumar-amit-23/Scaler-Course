package binarySearch;

public class RotatedSortedArraySearch {

	public static int rotated(int[] A) {
		int low = 0;
		int high = A.length - 1;
		int n = A.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (A[mid] > A[n]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return low - 1;
	}

	public static int findElement(int[] A, int r, int key) {
		int low = 0;
		int high = A.length - 1;
		int n = A.length;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int indx = (mid + r) % n;

			if (A[indx] <= key) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		int indxx = low - 1;

		int ans = (indxx + r) % n;

		if (A[ans] == key) {
			return ans;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A = {};
		int k = rotated(A);
		int B = 1;
		System.out.println(findElement(A, k, B));

	}

}
