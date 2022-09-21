package introToArray;

import java.util.Scanner;

public class RotationGame {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}

		int r = scn.nextInt();
		r = r % n;

		// reverse the array
		reverseArray(arr, 0, n - 1);

		// split reverse the array
		reverseArray(arr, 0, r - 1);
		reverseArray(arr, r, n - 1);

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		scn.close();
	}

	public static void reverseArray(int[] arr, int left, int right) {
		while (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			right--;
			left++;
		}
	}
}
